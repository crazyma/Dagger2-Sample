package com.beibeilab.dagger2sample.model;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.beibeilab.dagger2sample.R;

public class NormalActivity extends AppCompatActivity {

    Car car;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sample);

        Wheel wheel = new Wheel();
        car = new Car(wheel);

        ((TextView)findViewById(R.id.textView)).setText(car.getWheelInfo());
    }
}
