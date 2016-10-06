package com.mygdx.game.actors.figures;


import com.mygdx.game.actors.panels.Panel;

/**
 * Created by Sergey on 05.10.2016.
 */

public class Figure1 extends Figure {

    public Figure1() {
        super();
        add(new Panel(Panel.Color.LIME)).spaceRight(2);
        add(new Panel(Panel.Color.LIME)).spaceRight(2);
        row().spaceTop(2);
        add(new Panel(Panel.Color.LIME)).spaceRight(2);
        columnDefaults(1);
        add(new Panel(Panel.Color.LIME)).spaceRight(2);
    }

}
