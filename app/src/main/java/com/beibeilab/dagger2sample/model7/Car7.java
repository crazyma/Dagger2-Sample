package com.beibeilab.dagger2sample.model7;

/**
 * Created by david on 2017/12/28.
 */

public class Car7 {
    Wheel7 wheel7;

    public Car7(Wheel7 wheel7) {
        this.wheel7 = wheel7;
    }

    public String getWheelInfo(){
        return "brand: " + wheel7.getBrand();
    }
}
