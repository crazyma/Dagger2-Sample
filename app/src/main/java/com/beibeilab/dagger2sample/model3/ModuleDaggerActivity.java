package com.beibeilab.dagger2sample.model3;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.beibeilab.dagger2sample.R;

import javax.inject.Inject;

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
