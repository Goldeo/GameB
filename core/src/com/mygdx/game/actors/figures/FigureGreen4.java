package com.mygdx.game.actors.figures;

import com.badlogic.gdx.math.Rectangle;
import com.mygdx.game.actors.panels.Field;
import com.mygdx.game.actors.panels.Panel;

/**
 * Created by Sergey on 05.10.2016.
 */

public class FigureGreen4 extends Figure {

    public FigureGreen4(Field field) {
        super(field);
        panel = new Panel(Panel.Color.GREEN, PANEL_SPACING, PADDING_Y);
        panel.setActions(0, 1);
        addActor(panel);

        panel = new Panel(Panel.Color.GREEN, PANEL_SPACING, PANEL_SPACING + PADDING_Y);
        panel.setActions(1, 1);
        addActor(panel);

        panel = new Panel(Panel.Color.GREEN, 0, PANEL_SPACING + PADDING_Y);
        panel.setActions(1, 0);
        addActor(panel);

        width = 2 * Panel.LENGTH + Figure.SPACING;
        height = 2 * Panel.LENGTH + Figure.SPACING + 2 * PADDING_Y;
        setSize(width, height);
    }

}
