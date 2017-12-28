package com.beibeilab.dagger2sample.model6;

import dagger.Component;

/**
 * Created by david on 2017/12/28.
 */
@Component(modules = Wheel6Module.class)
public interface Wheel6Component {
    Car6Component plus(Car6Module car6Module);
}
