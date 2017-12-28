package com.beibeilab.dagger2sample.model5;

import dagger.Module;
import dagger.Provides;

/**
 * Created by david on 2017/12/28.
 */
@Module
public class Car5Module {

    @Provides
    public Car5 provideCar5(@Wheel5Module.PirelliWheel Wheel5 wheel5) {
        return new Car5(wheel5);
    }

}
