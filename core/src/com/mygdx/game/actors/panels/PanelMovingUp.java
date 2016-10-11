package com.mygdx.game.actors.panels;

/**
 * Created by Sergey on 11.10.2016.
 */

public class PanelMovingUp extends Panel {

    public PanelMovingUp(Color color) {
        super(color);
        moveByActionDec.setAmountY(-(row + 1) * MOVE_AMOUNT + (row * 2));
        moveByActionDec.setDuration(0.2f);

        moveByActionInc.setAmountY((row + 1) * MOVE_AMOUNT + (row * 2));
        moveByActionInc.setDuration(0.2f);

        sizeByActionDec.setAmount(-SIZE_AMOUNT, -SIZE_AMOUNT);
        sizeByActionDec.setDuration(0.2f);

        sizeByActionInc.setAmount(SIZE_AMOUNT, SIZE_AMOUNT);
        sizeByActionInc.setDuration(0.2f);
    }

}
