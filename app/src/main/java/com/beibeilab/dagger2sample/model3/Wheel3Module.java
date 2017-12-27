package com.beibeilab.dagger2sample.model3;

import dagger.Module;
import dagger.Provides;

/**
 * Created by david on 2017/12/27.
 */

@Module
public class Wheel3Module {

    @Provides
    Wheel3 provideWheel3() {
        return new Goodyear();
    }

}
