package com.mygdx.game.view.panels;

import com.badlogic.gdx.graphics.g2d.Batch;

/**
 * Created by Sergey on 05.10.2016.
 */

public class Cell extends AbstractPanel {
    public static final float LENGTH = 38;
    private Field field;
    private Panel panel;
    private boolean isFull = false;

    public Field getField() {
        return field;
    }

    public boolean isFull() {
        return isFull;
    }

    public void setPanel(Panel panel) {
        this.panel = panel;
        if (panel != null) isFull = true;
            else isFull = false;
        field.addActor(panel);
        panel.setPosition(getX(), getY());
    }

    public Panel getPanel() {
        return panel;
    }

    public void clearCell() {
        panel.delete();
        isFull = false;
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
