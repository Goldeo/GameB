package com.mygdx.game.actors.panels;

import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.mygdx.game.GameB;

/**
 * Created by Sergey on 05.10.2016.
 */

public class Cell extends AbstractPanel {

    public static final float LENGTH = 38;
    private Field field;
    private int row;
    private int column;

    public Actor getPanel() {
        if (getChildren().first() != null)
            return getChildren().first();
        else
            return null;
    }

    public int getColumn() {
        return column;
    }

    public void setColumn(int column) {
        this.column = column;
    }

    public int getRow() {
        return row;
    }

    public void setRow(int row) {
        this.row = row;
    }

    public Field getField() {
        return field;
    }

    public Cell(Field field) {
        this.field = field;
        texture = GameB.atlas.findRegion("grayPanel");
        setSize(LENGTH, LENGTH);
    }

    public boolean isFull() {
        return (getChildren().size > 0);
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
