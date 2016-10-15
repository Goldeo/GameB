package com.mygdx.game.actors.panels;

import com.mygdx.game.GameB;

/**
 * Created by Sergey on 05.10.2016.
 */

public class Cell extends AbstractPanel {

    public static final float LENGTH = 38;
    private boolean isFull = false;

    public Cell() {
        texture = GameB.atlas.findRegion("grayPanel");
        setSize(LENGTH, LENGTH);
    }

    public boolean isFull() {
        return isFull;
    }

    public void setFull(boolean full) {
        isFull = full;
    }

    @Override
    public void setRectangleBounds() {
        rectangleBounds.set(getAbsX(), getAbsY(), getWidth(), getHeight());
    }

    @Override
    public float getAbsX() {
        return getParent().getX() + getX();
    }

    @Override
    public float getAbsY() {
        return getParent().getY() + getY();
    }
}
