package com.mygdx.game.actors.figures;

import com.mygdx.game.actors.panels.Panel;
import com.mygdx.game.screens.PlayScreen;

/**
 * Created by Sergey on 05.10.2016.
 */

public class FigureBlue4 extends Figure {

    public FigureBlue4(PlayScreen screen) {
        super(screen);
        panel = new Panel(Panel.Color.BLUE, 2 * PANEL_SPACING, PADDING_Y);
        panel.setActions(0, 2);
        addActor(panel);

        panel = new Panel(Panel.Color.BLUE, 2 * PANEL_SPACING, PANEL_SPACING + PADDING_Y);
        panel.setActions(1, 2);
        addActor(panel);

        panel = new Panel(Panel.Color.BLUE, 2 * PANEL_SPACING, 2 * PANEL_SPACING + PADDING_Y);
        panel.setActions(2, 2);
        addActor(panel);

        panel = new Panel(Panel.Color.BLUE, PANEL_SPACING, 2* PANEL_SPACING + PADDING_Y);
        panel.setActions(2, 1);
        addActor(panel);

        panel = new Panel(Panel.Color.BLUE, 0, 2 * PANEL_SPACING + PADDING_Y);
        panel.setActions(2, 0);
        addActor(panel);

        width = 3 * Panel.LENGTH + 2 * Figure.SPACING;
        height = 3 * Panel.LENGTH + 2 * Figure.SPACING + 2 * PADDING_Y;
        setSize(width, height);
    }

}
