package com.mygdx.game.actors.figures;

import com.mygdx.game.actors.panels.Panel;

/**
 * Created by Sergey on 05.10.2016.
 */

public class FigureBlue2 extends Figure {

    public FigureBlue2() {
        Panel panel = new Panel(Panel.Color.BLUE);
        panel.setPosition(0, PADDING_Y);
        panel.setActions(0, 0);
        addActor(panel);

        panel = new Panel(Panel.Color.BLUE);
        panel.setPosition(0, PANEL_SPACING + PADDING_Y);
        panel.setActions(1, 0);
        addActor(panel);

        panel = new Panel(Panel.Color.BLUE);
        panel.setPosition(0, 2 * PANEL_SPACING + PADDING_Y);
        panel.setActions(2, 0);
        addActor(panel);

        panel = new Panel(Panel.Color.BLUE);
        panel.setPosition(PANEL_SPACING, 2 * PANEL_SPACING + PADDING_Y);
        panel.setActions(2, 1);
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