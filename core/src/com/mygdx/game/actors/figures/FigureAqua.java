package com.mygdx.game.actors.figures;

import com.mygdx.game.actors.panels.*;

/**
 * Created by Sergey on 05.10.2016.
 */

public class FigureAqua extends Figure {

    public FigureAqua() {
        for (int i = 0; i < 3; ++i)
            for (int j = 0; j < 3; ++j) {
                panel = new Panel(Panel.Color.AQUA);
                panel.setPosition(i * PANEL_SPACING, j * PANEL_SPACING + PADDING_Y);
                panel.setActions(j, i);
                addActor(panel);
            }

        width = 3 * Panel.LENGTH + 2 * Figure.SPACING;
        height = 3 * Panel.LENGTH + 2 * Figure.SPACING + 2 * PADDING_Y;
        setSize(width, height);
    }

}
