package com.mygdx.game.actors.figures;

import com.mygdx.game.actors.panels.Panel;

/**
 * Created by Sergey on 05.10.2016.
 */

public class FigureRed2 extends Figure {

    public FigureRed2() {
        super();
        add(new Panel(Panel.Color.RED));
        row().spaceTop(SPACING);
        add(new Panel(Panel.Color.RED));
        row().spaceTop(SPACING);
        add(new Panel(Panel.Color.RED));
        row().spaceTop(SPACING);
        add(new Panel(Panel.Color.RED));
        row().spaceTop(SPACING);
        add(new Panel(Panel.Color.RED));
    }

}
