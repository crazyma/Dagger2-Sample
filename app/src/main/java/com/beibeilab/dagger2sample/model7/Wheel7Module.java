package com.beibeilab.dagger2sample.model7;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

import javax.inject.Qualifier;

import dagger.Module;
import dagger.Provides;

/**
 * Created by david on 2017/12/28.
 */
@Module
public class Wheel7Module {
    @Provides
    @YokohamaWheel
    Wheel7 provideYokohama(){
        return new Yokohama();
    }

    @Qualifier
    @Retention(RetentionPolicy.RUNTIME)
    public @interface YokohamaWheel {}
}
