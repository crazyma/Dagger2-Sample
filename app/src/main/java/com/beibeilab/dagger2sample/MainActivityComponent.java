package com.beibeilab.dagger2sample;

import dagger.Component;

/**
 * Created by david on 2017/12/27.
 */

@Component
public interface MainActivityComponent {
    void inject(MainActivity activity);
}
