package com.mygdx.game.actors.panels;


import com.mygdx.game.GameB;

/**
 * Created by Sergey on 05.10.2016.
 */

public class Cell extends AbstractPanel {

    public Cell() {
        length = 40;
        texture = GameB.atlas.findRegion("grayPanel");
        setSize(length, length);
    }

}
