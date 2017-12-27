package com.beibeilab.dagger2sample.model2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.beibeilab.dagger2sample.R;

import javax.inject.Inject;

public class BasicDaggerActivity extends AppCompatActivity {

    @Inject
    Car2 car2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sample);

        DaggerBasicDaggerActivityComponent.create().inject(this);

        ((TextView)findViewById(R.id.textView)).setText(car2.getWheelInfo());
    }
}
