package com.beibeilab.dagger2sample;

import com.beibeilab.dagger2sample.model7.Car7Component;

import dagger.Component;

/**
 * Created by david on 2017/12/28.
 */
@App.ApplicationScope
@Component(dependencies = Car7Component.class)
public interface MainActivityComponent {
    void inject(MainActivity activity);
}
