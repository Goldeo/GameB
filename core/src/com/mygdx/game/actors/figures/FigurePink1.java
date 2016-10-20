package com.mygdx.game.actors.figures;

import com.mygdx.game.actors.panels.Panel;
import com.mygdx.game.screens.PlayScreen;

/**
 * Created by Sergey on 05.10.2016.
 */

public class FigurePink1 extends Figure {

    public FigurePink1(PlayScreen screen) {
        super(screen);
        for (int i = 0; i < 4; ++i) {
            panel = new Panel(screen, Panel.Color.PINK, i * PANEL_SPACING, PADDING_Y);
            panel.setActions(0, i);
            addActor(panel);
        }

        width = 4 * Panel.LENGTH + 3 * Figure.SPACING;
        height = Panel.LENGTH + 2 * PADDING_Y;
        setSize(width, height);
    }

}
