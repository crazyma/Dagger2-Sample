package com.beibeilab.dagger2sample.model5;

/**
 * Created by david on 2017/12/28.
 */

public class Car5 {
    private Wheel5 wheel5;

    public Car5(Wheel5 wheel5) {
        this.wheel5 = wheel5;
    }

    public String getWheelInfo() {
        return wheel5.getBrand();
    }
}
