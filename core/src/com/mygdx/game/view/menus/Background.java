package com.mygdx.game.view.menus;

import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.mygdx.game.GameB;
import com.mygdx.game.view.screens.GameScreen;

/**
 * Created by Sergey on 12.06.2017.
 */

public class Background extends Actor {
    protected GameScreen screen;
    protected transient TextureAtlas atlas;
    protected TextureRegion texture;

    public Background(GameScreen screen) {
        this.screen = screen;
        atlas = screen.getGame().getAssetManager().get(GameB.ATLAS_PATH, TextureAtlas.class);
        texture = atlas.findRegion("bg_menu");
        setSize(GameB.WIDTH, GameB.HEIGHT);
    }

    @Override
    public void draw(Batch batch, float parentAlpha) {
        batch.draw(texture, getX(), getY(), getWidth(), getHeight());
    }
}
