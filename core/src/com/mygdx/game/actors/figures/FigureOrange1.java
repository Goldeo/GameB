package com.mygdx.game.actors.figures;

import com.mygdx.game.actors.panels.Panel;

/**
 * Created by Sergey on 05.10.2016.
 */

public class FigureOrange1 extends Figure {

    public FigureOrange1() {
        for (int i = 0; i < 3; ++i) {
            panel = new Panel(Panel.Color.ORANGE);
            panel.setPosition(i * PANEL_SPACING, PADDING_Y);
            panel.setActions(0, i);
            addActor(panel);
        }

        width = 3 * Panel.LENGTH + 2 * Figure.SPACING;
        height = Panel.LENGTH + 2 * PADDING_Y;
        setSize(width, height);
    }

}