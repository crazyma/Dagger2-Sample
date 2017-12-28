package com.beibeilab.dagger2sample.model6;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

import javax.inject.Qualifier;

import dagger.Module;
import dagger.Provides;

/**
 * Created by david on 2017/12/28.
 */
@Module
public class Wheel6Module {

    @Provides
    @DunlopWheel
    public Wheel6 provideDunlop() {
        return new Dunlop();
    }

    @Provides
    @PirelliWheel
    public Wheel6 providePirelli() {
        return new Pirelli();
    }

    @Qualifier
    @Retention(RetentionPolicy.RUNTIME)
    public @interface DunlopWheel {}

    @Qualifier
    @Retention(RetentionPolicy.RUNTIME)
    public @interface PirelliWheel {}
}
