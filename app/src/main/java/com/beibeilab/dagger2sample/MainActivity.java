package com.beibeilab.dagger2sample;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Toast;

import com.beibeilab.dagger2sample.model.Car;
import com.beibeilab.dagger2sample.model2.Car2;
import com.beibeilab.dagger2sample.model.Wheel;

import javax.inject.Inject;

public class MainActivity extends AppCompatActivity {

    private Car car;

    @Inject
    Car2 car2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

//        normalDI();
        daggerDI();
    }

    private void normalDI(){
        Wheel wheel = new Wheel();
        car = new Car(wheel);

        Toast.makeText(this, car.getWhellInfo(), Toast.LENGTH_SHORT).show();
    }

    private void daggerDI(){
        DaggerMainActivityComponent.create().inject(this);
        String show = car2.getWhellInfo();
        Toast.makeText(MainActivity.this, show, Toast.LENGTH_SHORT).show();
    }

}
