package com.mygdx.game.actors.panels;


import com.mygdx.game.GameB;

/**
 * Created by Sergey on 05.10.2016.
 */

public class Cell extends AbstractPanel {

    public static final float LENGTH = 35;

    public Cell() {
        texture = GameB.atlas.findRegion("grayPanel");
        setSize(LENGTH, LENGTH);
    }
}
