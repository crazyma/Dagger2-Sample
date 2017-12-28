package com.beibeilab.dagger2sample.model7;

import com.beibeilab.dagger2sample.App;

import dagger.Component;

/**
 * Created by david on 2017/12/28.
 */
@App.ApplicationScope
@Component(dependencies = Car7Component.class)
public interface SingletonDaggerActivityComponent {
    void inject(SingletonDaggerActivity activity);
}