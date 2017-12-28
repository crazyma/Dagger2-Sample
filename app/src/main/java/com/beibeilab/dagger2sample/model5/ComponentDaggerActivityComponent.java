package com.beibeilab.dagger2sample.model5;

import dagger.Component;

/**
 * Created by david on 2017/12/28.
 */
@Component(dependencies = Car5Component.class)
public interface ComponentDaggerActivityComponent {
    void inject(ComponentDaggerActivity activity);
}
