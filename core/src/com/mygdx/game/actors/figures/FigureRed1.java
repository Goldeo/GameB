package com.mygdx.game.actors.figures;

import com.mygdx.game.actors.panels.Field;
import com.mygdx.game.actors.panels.Panel;

/**
 * Created by Sergey on 05.10.2016.
 */

public class FigureRed1 extends Figure {

    public FigureRed1(Field field) {
        super(field);
        for (int i = 0; i < 5; ++i) {
            panel = new Panel(Panel.Color.RED, i * PANEL_SPACING, PADDING_Y);
            panel.setActions(0, i);
            addActor(panel);
        }

        width = 5 * Panel.LENGTH + 4 * Figure.SPACING;
        height = Panel.LENGTH + 2 * PADDING_Y;
        setSize(width, height);
    }

}
