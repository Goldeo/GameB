package com.mygdx.game.view.figures;

import com.mygdx.game.view.screens.PlayScreen;

/**
 * Created by Sergey on 05.10.2016.
 */

public class FigurePurple extends Figure {

    public FigurePurple(PlayScreen screen) {
        super(screen);
        panel = new com.mygdx.game.view.panels.Panel(screen, com.mygdx.game.view.panels.Panel.Color.PURPLE, BIG_PADDING, BIG_PADDING);
        panel.setRowAndColumn(0, 0);
        addActor(panel);

        setSize(1, 1, BIG_PADDING, BIG_PADDING);
    }

}
