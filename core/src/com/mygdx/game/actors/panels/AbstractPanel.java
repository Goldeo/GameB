package com.mygdx.game.actors.panels;

import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.scenes.scene2d.Group;

/**
 * Created by Sergey on 05.10.2016.
 */

public abstract class AbstractPanel extends Group {

    TextureRegion texture;
    Rectangle rectangleBounds = new Rectangle();
    int row;
    int column;

    int getColumn() {
        return column;
    }

    void setColumn(int column) {
        this.column = column;
    }

    int getRow() {
        return row;
    }

    void setRow(int row) {
        this.row = row;
    }

    Rectangle getRectangleBounds() {
        return rectangleBounds;
    }

    public abstract void setRectangleBounds();
    public abstract float getAbsX();
    public abstract float getAbsY();
}
