package com.beibeilab.dagger2sample.model5;

import dagger.Component;

/**
 * Created by david on 2017/12/28.
 */
@Component(modules = Car5Module.class, dependencies = Wheel5Component.class)
public interface Car5Component {
    Car5 getCar5();
}
