package com.beibeilab.dagger2sample.model4;

import dagger.Module;
import dagger.Provides;

/**
 * Created by david on 2017/12/29.
 */
@Module
public class Car4Module {

    @Provides
    Car4 provideCar4(@Wheel4Module.MichelinWheel Wheel4 wheel4){
        return new Car4(wheel4);
    }

}
