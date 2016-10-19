package com.mygdx.game.actors.figures;

import com.mygdx.game.actors.panels.Panel;
import com.mygdx.game.screens.PlayScreen;

/**
 * Created by Sergey on 05.10.2016.
 */

public class FigureBlue1 extends Figure {

    public FigureBlue1(PlayScreen screen) {
        super(screen);
        panel = new Panel(Panel.Color.BLUE, 2 * PANEL_SPACING, PADDING_Y);
        panel.setActions(0, 2);
        addActor(panel);

        panel = new Panel(Panel.Color.BLUE, PANEL_SPACING, PADDING_Y);
        panel.setActions(0, 1);
        addActor(panel);

        panel = new Panel(Panel.Color.BLUE, 0, PADDING_Y);
        panel.setActions(0, 0);
        addActor(panel);

        panel = new Panel(Panel.Color.BLUE, 0, PANEL_SPACING + PADDING_Y);
        panel.setActions(1, 0);
        addActor(panel);

        panel = new Panel(Panel.Color.BLUE, 0, 2 * PANEL_SPACING + PADDING_Y);
        panel.setActions(2, 0);
        addActor(panel);

        width = 3 * Panel.LENGTH + 2 * Figure.SPACING;
        height = 3 * Panel.LENGTH + 2 * Figure.SPACING + 2 * PADDING_Y;
        setSize(width, height);
    }

}
