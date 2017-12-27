package com.beibeilab.dagger2sample.model2;

import javax.inject.Inject;

/**
 * Created by david on 2017/12/27.
 */

public class Wheel2 {

    @Inject
    public Wheel2() {}

    private int friction = 2;

    public int getFriction(){
        return friction;
    }

}
