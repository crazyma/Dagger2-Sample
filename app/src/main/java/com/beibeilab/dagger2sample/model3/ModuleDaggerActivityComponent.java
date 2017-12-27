package com.beibeilab.dagger2sample.model3;

import dagger.Component;

/**
 * Created by david on 2017/12/27.
 */

@Component(modules = Wheel3Module.class)
public interface ModuleDaggerActivityComponent {
    void inject(ModuleDaggerActivity activity);
}
