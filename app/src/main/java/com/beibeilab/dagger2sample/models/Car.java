package com.beibeilab.dagger2sample.models;

import android.util.Log;

/**
 * Created by david on 2017/12/27.
 */

public class Car {

    private Wheel wheel;

    public Car(Wheel wheel) {
        this.wheel = wheel;
    }

    public String getWhellInfo(){
        return "friction : " + wheel.getFriction();
    }
}
