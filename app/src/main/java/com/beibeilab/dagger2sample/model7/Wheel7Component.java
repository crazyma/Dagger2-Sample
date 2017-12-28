package com.beibeilab.dagger2sample.model7;

import dagger.Component;

/**
 * Created by david on 2017/12/28.
 */
@Component(modules = Wheel7Module.class)
public interface Wheel7Component {
    @Wheel7Module.YokohamaWheel
    Wheel7 getYokohamaWheel();
}
