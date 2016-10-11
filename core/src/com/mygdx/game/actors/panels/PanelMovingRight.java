package com.mygdx.game.actors.panels;

/**
 * Created by Sergey on 11.10.2016.
 */

public class PanelMovingRight extends Panel {

    public PanelMovingRight(Color color) {
        super(color);
        moveByActionDec.setAmountX(-column * MOVE_AMOUNT );
        moveByActionDec.setDuration(0.2f);

        moveByActionInc.setAmountX(row * MOVE_AMOUNT);
        moveByActionInc.setDuration(0.2f);

        sizeByActionDec.setAmount(-SIZE_AMOUNT, -SIZE_AMOUNT);
        sizeByActionDec.setDuration(0.2f);

        sizeByActionInc.setAmount(SIZE_AMOUNT, SIZE_AMOUNT);
        sizeByActionInc.setDuration(0.2f);
    }

}
