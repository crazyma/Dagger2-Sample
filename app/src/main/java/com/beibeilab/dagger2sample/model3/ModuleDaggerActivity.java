package com.beibeilab.dagger2sample.model3;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.beibeilab.dagger2sample.R;

import javax.inject.Inject;

/**
 使用 @Module 來向 @Component 提供 依賴的對象

 可以使用在
 1. 依賴對象是 abstract class
 2. 依賴對象是第三方Class，無法添加 @Inject
 */
public class ModuleDaggerActivity extends AppCompatActivity {

    @Inject
    Car3 car3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sample);

        DaggerModuleDaggerActivityComponent.create().inject(this);

        ((TextView)findViewById(R.id.textView)).setText(car3.getWheelInfo());
    }
}
