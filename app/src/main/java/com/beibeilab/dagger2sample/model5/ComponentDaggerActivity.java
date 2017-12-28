package com.beibeilab.dagger2sample.model5;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.beibeilab.dagger2sample.R;

import javax.inject.Inject;

/**
 將每個 Module 包成 Component，直接使用 Component 之間的 dependencies

 這個優點是
 1. 可以獨立使用各個 Component，也可以建立相依
 2. 可以明確的顯示相依性
 */
public class ComponentDaggerActivity extends AppCompatActivity {

    @Inject
    Car5 car5;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sample);

        DaggerComponentDaggerActivityComponent.builder().car5Component(
                DaggerCar5Component.builder().wheel5Component(
                        DaggerWheel5Component.create()
                ).build()
        ).build().inject(this);

        ((TextView)findViewById(R.id.textView)).setText(car5.getWheelInfo());
    }
}
