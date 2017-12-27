package com.beibeilab.dagger2sample.model2;

import javax.inject.Inject;

/**
 * Created by david on 2017/12/27.
 */

public class Car2 {

    private Wheel2 wheel2;

    @Inject
    public Car2(Wheel2 wheel2) {
        this.wheel2 = wheel2;
    }

    public String getWheelInfo(){
        return "friction : " + wheel2.getFriction();
    }

}
