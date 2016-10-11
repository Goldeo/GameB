package com.mygdx.game.actors.panels;

/**
 * Created by Sergey on 11.10.2016.
 */

public class PanelNotMoving extends Panel {

    public PanelNotMoving(Color color) {
        super(color);

        sizeByActionDec.setAmount(-10, -10);
        sizeByActionDec.setDuration(0.2f);

        sizeByActionInc.setAmount(10, 10);
        sizeByActionInc.setDuration(0.2f);
    }

}
