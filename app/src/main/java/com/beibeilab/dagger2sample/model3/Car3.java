package com.beibeilab.dagger2sample.model3;

/**
 * Created by david on 2017/12/27.
 */

public class Car3 {
    private Wheel3 wheel3;

    public Car3(Wheel3 wheel3) {
        this.wheel3 = wheel3;
    }

    public String getWheelInfo(){
        return "friction: " + wheel3.getFriction();
    }
}
