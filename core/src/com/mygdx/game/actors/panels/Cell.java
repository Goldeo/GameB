package com.mygdx.game.actors.panels;

import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.mygdx.game.GameB;

/**
 * Created by Sergey on 05.10.2016.
 */

public class Cell extends AbstractPanel {
    public static final float LENGTH = 38;
    private Field field;
    private boolean isFull = false;

    public Field getField() {
        return field;
    }

    public boolean isFull() {
        return isFull;
    }

    public void setFull(boolean full) {
        isFull = full;
    }

    public Actor getPanel() {
        if (getChildren().first() != null)
            return getChildren().first();
        else
            return null;
    }

    public Cell(Field field) {
        super(field.getScreen());
        this.field = field;
        texture = atlas.findRegion("grayPanel");
        setSize(LENGTH, LENGTH);
    }

    @Override
    public void setRectangleBounds() {
        rectangleBounds.set(getAbsX(), getAbsY(), getWidth(), getHeight());
    }

    @Override
    public float getAbsX() {
        return getField().getX() + getX();
    }

    @Override
    public float getAbsY() {
        return getField().getY() + getY();
    }

    @Override
    public void draw(Batch batch, float parentAlpha) {
        batch.draw(texture, getX(), getY(), getWidth(), getHeight());
        super.draw(batch, parentAlpha);
    }
}
