package com.beibeilab.dagger2sample.model5;

import dagger.Component;

/**
 * Created by david on 2017/12/28.
 */
@Component(modules = Wheel5Module.class)
public interface Wheel5Component {
    @Wheel5Module.DunlopWheel
    Wheel5 getDunlopWheel();

    @Wheel5Module.PirelliWheel
    Wheel5 getPirelliWheel();
}
