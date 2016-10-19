package com.mygdx.game.actors.panels;

import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.scenes.scene2d.Group;

/**
 * Created by Sergey on 05.10.2016.
 */

public abstract class AbstractPanel extends Group {

    protected TextureRegion texture;
    protected Rectangle rectangleBounds = new Rectangle();

    public Rectangle getRectangleBounds() {
        return rectangleBounds;
    }

    public abstract void setRectangleBounds();
    public abstract float getAbsX();
    public abstract float getAbsY();
}
