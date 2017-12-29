package com.beibeilab.dagger2sample.model4;

/**
 * Created by david on 2017/12/28.
 */

public class Car4 {
    private Wheel4 wheel4;

    public Car4(Wheel4 wheel4) {
        this.wheel4 = wheel4;
    }

    public String getWheelInfo(){
        return "Brand: " + wheel4.getBrand();
    }
}
