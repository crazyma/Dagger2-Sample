package com.beibeilab.dagger2sample;

import android.app.Application;

import com.beibeilab.dagger2sample.model7.Car7Component;
import com.beibeilab.dagger2sample.model7.DaggerCar7Component;
import com.beibeilab.dagger2sample.model7.DaggerWheel7Component;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

import javax.inject.Scope;

/**
 * Created by david on 2017/12/28.
 */

public class App extends Application {

    private Car7Component car7Component;

    @Override
    public void onCreate() {
        super.onCreate();
        car7Component = DaggerCar7Component.builder().wheel7Component(
                DaggerWheel7Component.create()
        ).build();
    }

    public Car7Component getCar7Component() {
        return car7Component;
    }

    @Scope
    @Retention(RetentionPolicy.RUNTIME)
    public @interface ApplicationScope {}
}
