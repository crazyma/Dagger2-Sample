package com.beibeilab.dagger2sample.model6;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.beibeilab.dagger2sample.R;

import javax.inject.Inject;

/**
 此方法跟 Component 的差異只在於 Component 的定義，Module 沒有變度ㄥ
 感覺有點奇怪，因為好像是由下層 Component 管理 上層 Component 的依賴關係

 適合的情境
 1. 組間之間的關係非常親密
 2.  Subcomponent 只是 Component 的延伸
 */
public class SubcomponentDaggerActivity extends AppCompatActivity {

    @Inject
    Car6 car6;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sample);

        DaggerWheel6Component.create()
                .plus(new Car6Module())
                .plus()
                .inject(this);

        ((TextView)findViewById(R.id.textView)).setText(car6.getWheelInfo());
    }
}
