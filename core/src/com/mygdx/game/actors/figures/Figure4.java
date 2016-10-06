package com.mygdx.game.actors.figures;

import com.mygdx.game.actors.panels.AbstractPanel;
import com.mygdx.game.actors.panels.Panel;

/**
 * Created by Sergey on 05.10.2016.
 */

public class Figure4 extends Figure {

    public Figure4() {
        add(new Panel(Panel.Color.RED)).spaceRight(2);
        add(new Panel(Panel.Color.RED)).spaceRight(2);
        add(new Panel(Panel.Color.RED)).spaceRight(2);
        add(new Panel(Panel.Color.RED)).spaceRight(2);
        add(new Panel(Panel.Color.RED)).spaceRight(2);
    }

}
