package com.mygdx.game.actors.figures;

import com.badlogic.gdx.math.Rectangle;
import com.mygdx.game.actors.panels.Field;
import com.mygdx.game.actors.panels.Panel;

/**
 * Created by Sergey on 05.10.2016.
 */

public class FigureBlue3 extends Figure {

    public FigureBlue3(Field field) {
        super(field);
        panel = new Panel(Panel.Color.BLUE);
        panel.setPosition(0, PADDING_Y);
        panel.setActions(0, 0);
        addActor(panel);

        panel = new Panel(Panel.Color.BLUE);
        panel.setPosition(PANEL_SPACING, PADDING_Y);
        panel.setActions(0, 1);
        addActor(panel);

        panel = new Panel(Panel.Color.BLUE);
        panel.setPosition(2 * PANEL_SPACING, PADDING_Y);
        panel.setActions(0, 2);
        addActor(panel);

        panel = new Panel(Panel.Color.BLUE);
        panel.setPosition(2 * PANEL_SPACING, PANEL_SPACING + PADDING_Y);
        panel.setActions(1, 2);
        addActor(panel);

        panel = new Panel(Panel.Color.BLUE);
        panel.setPosition(2 * PANEL_SPACING, 2 * PANEL_SPACING + PADDING_Y);
        panel.setActions(2, 2);
        addActor(panel);

        width = 3 * Panel.LENGTH + 2 * Figure.SPACING;
        height = 3 * Panel.LENGTH + 2 * Figure.SPACING + 2 * PADDING_Y;
        setSize(width, height);
    }

}
