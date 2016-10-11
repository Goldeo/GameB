package com.mygdx.game.actors.panels;

/**
 * Created by Sergey on 11.10.2016.
 */

public class PanelMoving extends Panel {

    public PanelMoving(Color color) {
        super(color);
        moveByActionDec.setAmount(-(column + 1) * MOVE_AMOUNT -row * 2, -(row + 1) * MOVE_AMOUNT -row * 2);
        moveByActionDec.setDuration(0.2f);

        moveByActionInc.setAmount((column + 1) * MOVE_AMOUNT + row * 2, (row + 1) * MOVE_AMOUNT + row * 2);
        moveByActionInc.setDuration(0.2f);

        sizeByActionDec.setAmount(-SIZE_AMOUNT, -SIZE_AMOUNT);
        sizeByActionDec.setDuration(0.2f);

        sizeByActionInc.setAmount(SIZE_AMOUNT, SIZE_AMOUNT);
        sizeByActionInc.setDuration(0.2f);
    }

}
