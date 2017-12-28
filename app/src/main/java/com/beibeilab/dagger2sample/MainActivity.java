package com.beibeilab.dagger2sample;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;

import com.beibeilab.dagger2sample.model.NormalActivity;
import com.beibeilab.dagger2sample.model2.BasicDaggerActivity;
import com.beibeilab.dagger2sample.model3.ModuleDaggerActivity;
import com.beibeilab.dagger2sample.model4.QualifierDaggerActivity;
import com.beibeilab.dagger2sample.model5.ComponentDaggerActivity;
import com.beibeilab.dagger2sample.model6.SubcomponentDaggerActivity;
import com.beibeilab.dagger2sample.model7.Car7;
import com.beibeilab.dagger2sample.model7.SingletonDaggerActivity;

import javax.inject.Inject;

public class MainActivity extends AppCompatActivity {

    @Inject
    Car7 car7;

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

        DaggerMainActivityComponent.builder()
                .car7Component(
                        ((App)getApplication()).getCar7Component()
                ).build().inject(this);
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.i("crazyma", "car7(Main): " + car7);
    }

    public void buttonClicked(View view) {
        Intent intent = new Intent();

        switch (view.getId()){
            case R.id.button1:
                intent.setClass(this, NormalActivity.class);
                break;
            case R.id.button2:
                intent.setClass(this, BasicDaggerActivity.class);
                break;
            case R.id.button3:
                intent.setClass(this, ModuleDaggerActivity.class);
                break;
            case R.id.button4:
                intent.setClass(this, QualifierDaggerActivity.class);
                break;
            case R.id.button5:
                intent.setClass(this, ComponentDaggerActivity.class);
                break;
            case R.id.button6:
                intent.setClass(this, SubcomponentDaggerActivity.class);
                break;
            case R.id.button7:
                intent.setClass(this, SingletonDaggerActivity.class);
                break;
            default:
        }

        startActivity(intent);
    }
}
