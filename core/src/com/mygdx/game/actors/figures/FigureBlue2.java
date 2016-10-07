package com.mygdx.game.actors.figures;

import com.mygdx.game.actors.panels.Panel;

/**
 * Created by Sergey on 05.10.2016.
 */

public class FigureBlue2 extends Figure {

    public FigureBlue2() {
        add(new Panel(Panel.Color.BLUE));
        add(new Panel(Panel.Color.BLUE)).spaceLeft(SPACING);
        add(new Panel(Panel.Color.BLUE)).spaceLeft(SPACING);
        row().spaceTop(SPACING);
        add(new Panel(Panel.Color.BLUE)).spaceLeft(SPACING * 20);
        row().spaceTop(SPACING);
        add(new Panel(Panel.Color.BLUE)).spaceLeft(SPACING * 20);
    }

}
