package com.mygdx.game.actors.figures;

import com.mygdx.game.actors.panels.Panel;

/**
 * Created by Sergey on 05.10.2016.
 */

public class Figure3 extends Figure {

    public Figure3() {
        add(new Panel(Panel.Color.BLUE)).spaceRight(2);
        add(new Panel(Panel.Color.BLUE)).spaceRight(2);
        add(new Panel(Panel.Color.BLUE)).spaceRight(2);
        row().spaceTop(2);
        add(new Panel(Panel.Color.BLUE)).spaceRight(2);
        row().spaceTop(2);
        add(new Panel(Panel.Color.BLUE)).spaceRight(2);
    }

}
