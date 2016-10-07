package com.mygdx.game.actors.figures;

import com.mygdx.game.actors.panels.Panel;

/**
 * Created by Sergey on 05.10.2016.
 */

public class FigureRed1 extends Figure {

    public FigureRed1() {
        super();
        add(new Panel(Panel.Color.RED)).spaceRight(SPACING);
        add(new Panel(Panel.Color.RED)).spaceRight(SPACING);
        add(new Panel(Panel.Color.RED)).spaceRight(SPACING);
        add(new Panel(Panel.Color.RED)).spaceRight(SPACING);
        add(new Panel(Panel.Color.RED)).spaceRight(SPACING);
    }

}
