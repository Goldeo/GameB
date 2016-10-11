package com.mygdx.game.actors.figures;

import com.mygdx.game.actors.panels.*;

/**
 * Created by Sergey on 05.10.2016.
 */

public class FigureAqua extends Figure {

    public FigureAqua() {
        Panel panel = new PanelNotMoving(Panel.Color.AQUA);
        panel.setPosition(0, 0);
        panel.setPos(0, 0);
        addActor(panel);

        panel = new PanelMovingRight(Panel.Color.RED);
        panel.setPosition(PANEL_LENGTH, 0);
        panel.setPos(0, 1);
        addActor(panel);

        panel = new PanelMovingRight(Panel.Color.PINK);
        panel.setPosition(2 * PANEL_LENGTH, 0);
        panel.setPos(0, 2);
        addActor(panel);

        panel = new PanelMovingUp(Panel.Color.AQUA);
        panel.setPosition(0, PANEL_LENGTH);
        panel.setPos(1, 0);
        addActor(panel);

        panel = new PanelMoving(Panel.Color.AQUA);
        panel.setPosition(PANEL_LENGTH, PANEL_LENGTH);
        panel.setPos(1, 1);
        addActor(panel);

        panel = new PanelMoving(Panel.Color.AQUA);
        panel.setPosition(2 * PANEL_LENGTH, PANEL_LENGTH);
        panel.setPos(1, 2);
        addActor(panel);

        panel = new PanelMovingUp(Panel.Color.AQUA);
        panel.setPosition(0, 2 * PANEL_LENGTH);
        panel.setPos(2, 0);
        addActor(panel);

        panel = new PanelMoving(Panel.Color.AQUA);
        panel.setPosition(PANEL_LENGTH, 2 * PANEL_LENGTH);
        panel.setPos(2, 1);
        addActor(panel);

        panel = new PanelMoving(Panel.Color.AQUA);
        panel.setPosition(2 * PANEL_LENGTH, 2 * PANEL_LENGTH);
        panel.setPos(2, 2);
        addActor(panel);

        setBounds(getX(), getY(), 64, 64);
    }

}
