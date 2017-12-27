package com.beibeilab.dagger2sample.model4;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.beibeilab.dagger2sample.R;

import javax.inject.Inject;

/**
 使用 Module + Qualifier 來分辨繼承自同一個 parent class 的 Inject
 */
public class QualifierDaggerActivity extends AppCompatActivity {

    @Inject
    Car4 car4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sample);

        DaggerQualifierDaggerActivityComponent.create().inject(this);

        ((TextView)findViewById(R.id.textView)).setText(car4.getWheelInfo());
    }
}
