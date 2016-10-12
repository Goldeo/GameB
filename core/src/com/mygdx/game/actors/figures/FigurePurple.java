package com.mygdx.game.actors.figures;

import com.mygdx.game.actors.panels.Panel;

/**
 * Created by Sergey on 05.10.2016.
 */

public class FigurePurple extends Figure {

    public FigurePurple() {
        panel = new Panel(Panel.Color.PURPLE);
        panel.setPosition(PADDING_Y, PADDING_Y);
        panel.setActions(0, 0);
        addActor(panel);

        width = Panel.LENGTH + 2 * PADDING_Y;
        height = Panel.LENGTH + 2 * PADDING_Y;
        setSize(width, height);
    }

}
