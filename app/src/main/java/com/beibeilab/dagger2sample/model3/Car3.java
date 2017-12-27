package com.beibeilab.dagger2sample.model3;

import javax.inject.Inject;

/**
 * Created by david on 2017/12/27.
 */

public class Car3 {
    private Wheel3 wheel3;

    @Inject
    public Car3(Wheel3 wheel3) {
        this.wheel3 = wheel3;
    }

    public String getWheelInfo(){
        return "Brand: " + wheel3.getBrand();
    }
}
