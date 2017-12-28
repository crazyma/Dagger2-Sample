package com.beibeilab.dagger2sample.model6;

import dagger.Module;
import dagger.Provides;

/**
 * Created by david on 2017/12/28.
 */
@Module
public class Car6Module {

    @Provides
    public Car6 provideCar6(@Wheel6Module.DunlopWheel Wheel6 wheel6) {
        return new Car6(wheel6);
    }

}
