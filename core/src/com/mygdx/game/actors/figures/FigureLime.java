package com.mygdx.game.actors.figures;

import com.mygdx.game.actors.panels.Field;
import com.mygdx.game.actors.panels.Panel;

/**
 * Created by Sergey on 05.10.2016.
 */

public class FigureLime extends Figure {

    public FigureLime(Field field) {
        super(field);
        for (int i = 0; i < 2; ++i)
            for (int j = 0; j < 2; ++j) {
                panel = new Panel(Panel.Color.LIME, i * PANEL_SPACING, j * PANEL_SPACING + PADDING_Y);
                panel.setActions(j, i);
                addActor(panel);
            }

        width = 2 * Panel.LENGTH + Figure.SPACING;
        height = 2 * Panel.LENGTH + Figure.SPACING + 2 * PADDING_Y;
        setSize(width, height);
    }

}
