package com.beibeilab.dagger2sample.model4;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

import javax.inject.Qualifier;

import dagger.Module;
import dagger.Provides;

/**
 * Created by david on 2017/12/28.
 */
@Module
public class Wheel4Module {

    @Provides
    @MaxxisWheel
    Wheel4 provideMaxxis() {
        return new Maxxis();
    }

    @Provides
    @MichelinWheel
    Wheel4 provideMichelin() {
        return new Michelin();
    }

    @Qualifier
    @Retention(RetentionPolicy.RUNTIME)
    public @interface MaxxisWheel {}

    @Qualifier
    @Retention(RetentionPolicy.RUNTIME)
    public @interface MichelinWheel {}

}
