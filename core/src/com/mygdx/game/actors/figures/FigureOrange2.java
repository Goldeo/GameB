package com.mygdx.game.actors.figures;

import com.mygdx.game.actors.panels.Field;
import com.mygdx.game.actors.panels.Panel;

/**
 * Created by Sergey on 05.10.2016.
 */

public class FigureOrange2 extends Figure {

    public FigureOrange2(Field field) {
        super(field);
        for (int i = 0; i < 3; ++i) {
            panel = new Panel(Panel.Color.ORANGE);
            panel.setPosition(PADDING_Y, i * PANEL_SPACING + PADDING_Y);
            panel.setActions(i, 0);
            addActor(panel);
        }

        width = Panel.LENGTH + 2 * PADDING_Y;
        height = 3 * Panel.LENGTH + 2 * SPACING + 2 * PADDING_Y;
        setSize(width, height);
    }

}
