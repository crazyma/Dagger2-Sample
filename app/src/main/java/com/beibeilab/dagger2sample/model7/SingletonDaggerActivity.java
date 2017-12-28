package com.beibeilab.dagger2sample.model7;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import com.beibeilab.dagger2sample.App;
import com.beibeilab.dagger2sample.R;

import javax.inject.Inject;

/**
 嘗試實作 Singleton Dagger
 這個方法感覺比較偷雞一點
 為了測試
 所以在 MainActivity 也製作對 Car7 的相依關係
 */
public class SingletonDaggerActivity extends AppCompatActivity {

    @Inject
    Car7 car7_1;

    @Inject
    Car7 car7_2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sample);

        DaggerSingletonDaggerActivityComponent.builder()
                .car7Component(
                        ((App)getApplication()).getCar7Component()
                )
                .build().inject(this);

        ((TextView)findViewById(R.id.textView)).setText(car7_1.getWheelInfo());

        Log.d("crazyma","car7_1 : " + car7_1);
        Log.d("crazyma","car7_2 : " + car7_2);
    }
}
