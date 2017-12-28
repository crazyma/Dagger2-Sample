package com.beibeilab.dagger2sample.model6;

import dagger.Subcomponent;

/**
 * Created by david on 2017/12/28.
 */
@Subcomponent(modules = Car6Module.class)
public interface Car6Component {
    SubcomponentDaggerActivityComponent plus();
}
