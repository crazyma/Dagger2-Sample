package com.beibeilab.dagger2sample.model7;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created by david on 2017/12/28.
 */
@Module
public class Car7Module {
    @Provides
    @Singleton
    Car7 provideCar7(@Wheel7Module.YokohamaWheel Wheel7 wheel7){
        return new Car7(wheel7);
    }

}
