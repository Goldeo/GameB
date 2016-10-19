package com.mygdx.game.actors.figures;

import com.mygdx.game.actors.panels.Panel;
import com.mygdx.game.screens.PlayScreen;

/**
 * Created by Sergey on 05.10.2016.
 */

public class FigureYellow1 extends Figure {

    public FigureYellow1(PlayScreen screen) {
        super(screen);
        for (int i = 0; i < 2; ++i) {
            panel = new Panel(Panel.Color.YELLOW, i * PANEL_SPACING, PADDING_Y);
            panel.setActions(0, i);
            addActor(panel);
        }

        width = 2 * Panel.LENGTH + Figure.SPACING;
        height = Panel.LENGTH + 2 * PADDING_Y;
        setSize(width, height);
    }

}
