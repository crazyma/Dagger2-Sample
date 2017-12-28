package com.beibeilab.dagger2sample.model6;

/**
 * Created by david on 2017/12/28.
 */

public class Car6 {
    private Wheel6 wheel6;

    public Car6(Wheel6 wheel6) {
        this.wheel6 = wheel6;
    }

    public String getWheelInfo() {
        return wheel6.getBrand();
    }
}
