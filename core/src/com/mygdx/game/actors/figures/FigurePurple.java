package com.mygdx.game.actors.figures;

import com.mygdx.game.actors.panels.Panel;
import com.mygdx.game.screens.PlayScreen;

/**
 * Created by Sergey on 05.10.2016.
 */

public class FigurePurple extends Figure {

    public FigurePurple(PlayScreen screen) {
        super(screen);
        panel = new Panel(screen, Panel.Color.PURPLE, BIG_PADDING, BIG_PADDING);
        panel.setRowAndColumn(0, 0);
        addActor(panel);

        setSize(1, 1, BIG_PADDING, BIG_PADDING);
    }

}
