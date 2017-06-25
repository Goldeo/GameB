package com.mygdx.game.view.panels;

import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.mygdx.game.GameB;
import com.mygdx.game.view.screens.GameScreen;

/**
 * Created by Sergey on 05.10.2016.
 */

public abstract class AbstractPanel extends Actor {
    protected GameScreen screen;
    protected TextureAtlas atlas;
    protected TextureRegion texture;
    protected Rectangle rectangleBounds = new Rectangle();
    protected int row;
    protected int column;

    public AbstractPanel(GameScreen screen) {
        this.screen = screen;
        atlas = screen.getGame().getAssetManager().get(GameB.ATLAS_PATH, TextureAtlas.class);
    }

    protected int getColumn() {
        return column;
    }

    protected void setColumn(int column) {
        this.column = column;
    }

    protected int getRow() {
        return row;
    }

    protected  void setRow(int row) {
        this.row = row;
    }

    protected Rectangle getRectangleBounds() {
        return rectangleBounds;
    }

    public abstract void setRectangleBounds();
    public abstract float getAbsX();
    public abstract float getAbsY();
}
