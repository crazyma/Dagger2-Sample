package com.beibeilab.dagger2sample.model5;

import com.beibeilab.dagger2sample.model.Wheel;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

import javax.inject.Qualifier;

import dagger.Module;
import dagger.Provides;

/**
 * Created by david on 2017/12/28.
 */
@Module
public class Wheel5Module {

    @Provides
    @DunlopWheel
    public Wheel5 provideDunlop() {
        return new Dunlop();
    }

    @Provides
    @PirelliWheel
    public Wheel5 providePirelli() {
        return new Pirelli();
    }

    @Qualifier
    @Retention(RetentionPolicy.RUNTIME)
    public @interface DunlopWheel {}

    @Qualifier
    @Retention(RetentionPolicy.RUNTIME)
    public @interface PirelliWheel {}
}
