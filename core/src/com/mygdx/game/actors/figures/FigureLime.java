package com.mygdx.game.actors.figures;

import com.mygdx.game.actors.panels.Panel;
import com.mygdx.game.screens.PlayScreen;

/**
 * Created by Sergey on 05.10.2016.
 */

public class FigureLime extends Figure {

    public FigureLime(PlayScreen screen) {
        super(screen);
        for (int i = 0; i < 2; ++i)
            for (int j = 0; j < 2; ++j) {
                panel = new Panel(screen, Panel.Color.LIME, i * PANEL_SPACING, j * PANEL_SPACING + PADDING_Y);
                panel.setActions(j, i);
                addActor(panel);
            }

        width = 2 * Panel.LENGTH + Figure.SPACING;
        height = 2 * Panel.LENGTH + Figure.SPACING + 2 * PADDING_Y;
        setSize(width, height);
    }

}
