package com.mygdx.game.actors.figures;

import com.mygdx.game.actors.panels.PanelMoving;
import com.mygdx.game.actors.panels.Panel;

/**
 * Created by Sergey on 05.10.2016.
 */

public class FigureBlue1 extends Figure {

    public FigureBlue1() {
        Panel panel = new PanelMoving(Panel.Color.BLUE);
        panel.setPosition(2 * PANEL_LENGTH, 0);
        addActor(panel);

        panel = new PanelMoving(Panel.Color.BLUE);
        panel.setPosition(2 * PANEL_LENGTH, PANEL_LENGTH);
        addActor(panel);

        panel = new PanelMoving(Panel.Color.BLUE);
        panel.setPosition(2 * PANEL_LENGTH, 2 * PANEL_LENGTH);
        addActor(panel);

        panel = new PanelMoving(Panel.Color.BLUE);
        panel.setPosition(PANEL_LENGTH, 0);
        addActor(panel);

        panel = new PanelMoving(Panel.Color.BLUE);
        panel.setPosition(0, 0);
        addActor(panel);

        setBounds(getX(), getY(), 64, 64);
    }

}
