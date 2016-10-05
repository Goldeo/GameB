package com.mygdx.game.actors.figures;

import com.mygdx.game.actors.panels.*;

/**
 * Created by Sergey on 05.10.2016.
 */

public class Figure2 extends Figure {

    public Figure2() {
        add(new Panel(Panel.Color.AQUA)).spaceRight(2);
        add(new Panel(Panel.Color.AQUA)).spaceRight(2);
        add(new Panel(Panel.Color.AQUA)).spaceRight(2);
        row().spaceTop(2);
        add(new Panel(Panel.Color.AQUA)).spaceRight(2);
        add(new Panel(Panel.Color.AQUA)).spaceRight(2);
        add(new Panel(Panel.Color.AQUA)).spaceRight(2);
        row().spaceTop(2);
        add(new Panel(Panel.Color.AQUA)).spaceRight(2);
        add(new Panel(Panel.Color.AQUA)).spaceRight(2);
        add(new Panel(Panel.Color.AQUA)).spaceRight(2);
    }
}
