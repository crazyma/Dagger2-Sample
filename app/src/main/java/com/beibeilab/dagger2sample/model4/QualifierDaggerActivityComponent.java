package com.beibeilab.dagger2sample.model4;

import dagger.Component;

/**
 * Created by david on 2017/12/28.
 */
@Component(modules = Wheel4Module.class)
public interface QualifierDaggerActivityComponent {
    void inject(QualifierDaggerActivity activity);
}
