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
                panel = new Panel(screen, Panel.Color.LIME, i * PANEL_WIDTH + MEDIUM_PADDING, j * PANEL_WIDTH + BIG_PADDING);
                panel.setActions(j, i);
                addActor(panel);
            }

        setSize(2, 2, MEDIUM_PADDING, BIG_PADDING);
    }

}
