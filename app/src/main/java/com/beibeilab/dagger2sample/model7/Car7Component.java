package com.beibeilab.dagger2sample.model7;

import javax.inject.Singleton;

import dagger.Component;

/**
 * Created by david on 2017/12/28.
 */
@Singleton
@Component(modules = Car7Module.class, dependencies = Wheel7Component.class)
public interface Car7Component {
    Car7 getCar7();
}
