這是 [Dagger 2](https://github.com/google/dagger) 的使用筆記，參考了 [這篇文章](https://www.jianshu.com/p/24af4c102f62) 進行實作

## 相依關係
使用 `Car` & `Wheel` 兩種 class 當作範例
其相依關係是：

```
Activity -> Car -> Wheel
```


## Basic: 最簡單的實作
使用 `@Inject` & `@Component`

> 使用 Constructor Injection
``` java
public class Wheel2 {

    @Inject
    public Wheel2() {}

    public String getBrand(){
        return "Bridgestone";
    }

}
```

> 使用 Constructor Injection 建立 與 **Wheel** 的相依性
``` java
public class Car2 {

    private Wheel2 wheel2;

    @Inject
    public Car2(Wheel2 wheel2) {
        this.wheel2 = wheel2;
    }

    public String getWheelInfo(){
        return "friction : " + wheel2.getBrand();
    }

}
```

> 建立 Component
``` java
@Component
public interface BasicDaggerActivityComponent {
    // 指定 inject 的 target Activity
    void inject(BasicDaggerActivity activity);
}
```

> 在 Activity 啟用
``` java
public class BasicDaggerActivity extends AppCompatActivity {

    @Inject
    Car2 car2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        ...

        DaggerBasicDaggerActivityComponent.create().inject(this);
        // DaggerBasicDaggerActivityComponent 是依據 Component 建立出來的，需要先編譯過才會做出來
    }
}
```

## 使用 Module 管理
用 Module 可以解決以下的問題
1. 依賴對象是 abstract class
2. 依賴對象是第三方Class，無法添加 `@Inject`
3. 此範例是用 Module 管理 **Wheel** 的相依性， **Car** 維持原樣

### 相依的對象 Wheel (沒有使用 **@Inject** Annotation)
``` java
//    我們要相依的對象是 abstract class
public abstract class Wheel3 {
    public abstract String getBrand();
}

/*****************************/

//    實作 wheel 的 class 範例
public class Goodyear extends Wheel3 {
    @Override
    public String getBrand() {
        return "Goodyear";
    }
}
```

### Module
會直接定義該 Mudule 所使用的 instance
``` java
@Module
public class Wheel3Module {
    @Provides
    Wheel3 provideWheel3() {
        //    在這裡確切的定義 instance
        return new Goodyear();
    }
}
```

### 相依的對象 Car (使用 **@Inject**)
``` java
public class Car3 {
    private Wheel3 wheel3;

    @Inject
    public Car3(Wheel3 wheel3) {
        this.wheel3 = wheel3;
    }

    public String getWheelInfo(){
        return "Brand: " + wheel3.getBrand();
    }
}
```

> Component
``` java
// 要指定使用哪個 modules
@Component(modules = Wheel3Module.class)
public interface ModuleDaggerActivityComponent {
    void inject(ModuleDaggerActivity activity);
}
```

> Activity 啟用
``` java
public class ModuleDaggerActivity extends AppCompatActivity {

    @Inject
    Car3 car3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        ...    

        DaggerModuleDaggerActivityComponent.create().inject(this);
    }
}

```

## 加入 Qualifier 進行管理
- 如果有相依的 abstract class 有數個子類，可以用 Qualifier 進行管理
- 同時，將 Car 也交由 Module 進行管理

### Wheel
``` java
public abstract class Wheel4 {
    public abstract String getBrand();
}

/*   第一個 child class    */
public class Michelin extends Wheel4 {
    @Override
    public String getBrand() {
        return "Michelin";
    }
}

/*   第二個 child class    */
public class Maxxis extends Wheel4{
    @Override
    public String getBrand() {
        return "Maxxis";
    }
}
```

### Module of Wheel
針對不同的子類設定 method，讓相依對象自行決定要使用哪個子類
``` java
@Module
public class Wheel4Module {

    @Provides
    @MaxxisWheel
    Wheel4 provideMaxxis() {
        return new Maxxis();
    }

    @Provides
    @MichelinWheel
    Wheel4 provideMichelin() {
        return new Michelin();
    }

    @Qualifier
    @Retention(RetentionPolicy.RUNTIME)
    public @interface MaxxisWheel {}

    @Qualifier
    @Retention(RetentionPolicy.RUNTIME)
    public @interface MichelinWheel {}

}
```

### Car
``` java
public class Car4 {
    private Wheel4 wheel4;

    public Car4(Wheel4 wheel4) {
        this.wheel4 = wheel4;
    }

    public String getWheelInfo(){
        return "Brand: " + wheel4.getBrand();
    }
}
```
### Module of Car
``` java
@Module
public class Car4Module {

    /*    利用 Annotation 指定 相依的子類    */
    @Provides
    Car4 provideCar4(@Wheel4Module.MichelinWheel Wheel4 wheel4){
        return new Car4(wheel4);
    }

}

```

### Component
記得要 include 所有的 `module`
``` java
@Component(modules = {Wheel4Module.class, Car4Module.class})
public interface QualifierDaggerActivityComponent {
    void inject(QualifierDaggerActivity activity);
}
```

### Activity
``` java
@Inject
Car4 car4;

@Override
protected void onCreate(Bundle savedInstanceState) {
    ...

    DaggerQualifierDaggerActivityComponent.create().inject(this);

}
```

## 將每個 Module 包成 Component
將每個 Module 包成 Component，直接使用 Component 之間的 dependencies。其優點是
 1. 可以獨立使用各個 Component，也可以建立相依
 2. 可以明確的顯示相依性

### Skip
Wheel & Car class 基本上沒有變動，以下就不重複寫

### module of Wheel
``` java
@Module
public class Wheel5Module {

    @Provides
    @DunlopWheel
    public Wheel5 provideDunlop() {
        return new Dunlop();
    }

    @Provides
    @PirelliWheel
    public Wheel5 providePirelli() {
        return new Pirelli();
    }

    @Qualifier
    @Retention(RetentionPolicy.RUNTIME)
    public @interface DunlopWheel {}

    @Qualifier
    @Retention(RetentionPolicy.RUNTIME)
    public @interface PirelliWheel {}
}
```

### component of Wheel
記得要定義此 component 是管理哪個 Module
``` java
@Component(modules = Wheel5Module.class)
public interface Wheel5Component {
    @Wheel5Module.DunlopWheel
    Wheel5 getDunlopWheel();

    @Wheel5Module.PirelliWheel
    Wheel5 getPirelliWheel();
}
```

### module of Car
``` java
@Module
public class Car5Module {

    /*    用 Annotation 指定相依的子類    */
    @Provides
    public Car5 provideCar5(@Wheel5Module.PirelliWheel Wheel5 wheel5) {
        return new Car5(wheel5);
    }

}
```

### component of Car
可從 Annotaion 看出此 Component 對 WheelComponent 相依
``` java
@Component(modules = Car5Module.class, dependencies = Wheel5Component.class)
public interface Car5Component {
    Car5 getCar5();
}
```

### component of Activity
可從 Annotaion 看出此 Component 對 CarComponent 相依
``` java
@Component(dependencies = Car5Component.class)
public interface ComponentDaggerActivityComponent {
    void inject(ComponentDaggerActivity activity);
}

```

### Activity
Activity 會寫的複雜一點，可以觀察到是一層層的建立 Component 物件，並且放入相依的對象裡
``` java
@Inject
Car5 car5;

@Override
protected void onCreate(Bundle savedInstanceState) {
    DaggerComponentDaggerActivityComponent.builder().car5Component(
            DaggerCar5Component.builder().wheel5Component(
                    DaggerWheel5Component.create()
            ).build()
    ).build().inject(this);

}
```

## 使用 Subcomponent
不使用獨立的 Component，而是使用 Subcomponent，適合的情境是：
1. Component 之間的相依性非常密切
2. Subcomponent 不會單獨使用，而是作為 Component 的延伸
<br />
這裡比較特別的是
感覺是由下而上設定其相依關係
<br />
跟上一個實作的差別，主要在 Component 的設定(Module 就不重複寫了)

### component of Wheel
``` java
@Component(modules = Wheel6Module.class)
public interface Wheel6Component {
    //    需要傳入 car module
    Car6Component plus(Car6Module car6Module);
}
```

### component of Car
使用 `Subcomponent` Annotation
``` java
@Subcomponent(modules = Car6Module.class)
public interface Car6Component {
    SubcomponentDaggerActivityComponent plus();
}
```

### component of Activity
使用 `Subcomponent` Annotation
``` java
@Subcomponent
public interface SubcomponentDaggerActivityComponent {
    void inject(SubcomponentDaggerActivity activity);
}
```

### Activity
``` java
public class SubcomponentDaggerActivity extends AppCompatActivity {

    @Inject
    Car6 car6;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        DaggerWheel6Component.create()
                .plus(new Car6Module())    //    這裡居然自己要 new CarModule!
                .plus()
                .inject(this);

    }
}
```

## 建立 Singleton
相依物件可以重複 new instance，所以如果要製作 Singleton instance，需要特別處理
- 這裡是以 Component 的方式建立相依性
- data class & module 省略

### 說明
通常在 Android Develop 時，會將 Singleton 的設定放在 **Application** 裡，這裡也採用類似的作法
會在 Application 裡面建立 相依對象的 Component
各個 Activity 會從 Application 拿到該 Component instance

### component of Wheel
``` java
@Component(modules = Wheel7Module.class)
public interface Wheel7Component {
    @Wheel7Module.YokohamaWheel
    Wheel7 getYokohamaWheel();
}
```

### component of Car
使用了 `@Singleton`
``` java
@Singleton
@Component(modules = Car7Module.class, dependencies = Wheel7Component.class)
public interface Car7Component {
    Car7 getCar7();
}
```

### Application
``` java
public class App extends Application {

    //   Singleton Component Instance
    private Car7Component car7Component;

    @Override
    public void onCreate() {
        super.onCreate();

        car7Component = DaggerCar7Component.builder().wheel7Component(
                DaggerWheel7Component.create()
        ).build();
    }

    public Car7Component getCar7Component() {
        return car7Component;
    }

    @Scope
    @Retention(RetentionPolicy.RUNTIME)
    public @interface ApplicationScope {}
}
```

### component of Activity
這裡不能用 `@Singleton`，因為 Dagger 規定 @Singleton 不對相依另一個 @Singleton
所以用了自己定義的 Annotation (定義在 Application 裡)
``` java
@App.ApplicationScope
@Component(dependencies = Car7Component.class)
public interface SingletonDaggerActivityComponent {
    void inject(SingletonDaggerActivity activity);
}
```

### Activity
``` java
public class SingletonDaggerActivity extends AppCompatActivity {

    @Inject
    Car7 car7_1;

    @Inject
    Car7 car7_2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        ...

        //    直接使用 Applicaiont 的 Component Instance
        DaggerSingletonDaggerActivityComponent.builder()
                .car7Component(
                        ((App)getApplication()).getCar7Component()
                )
                .build().inject(this);



        Log.d("crazyma","car7_1 : " + car7_1);
        Log.d("crazyma","car7_2 : " + car7_2);
    }
}
```
