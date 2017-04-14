package com.mygdx.game.managers;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;

/**
 * Created by Sergey on 13.04.2017.
 */
public class Assets {
    private AssetManager assetManager = new AssetManager();

    public static final String atlasPath = "atlases/atlas.pack";
    public static final String skinPath = "skins/uiskin.json";

    public void load() {
        Skin skin = new Skin(Gdx.files.internal(skinPath));
        TextureAtlas atlas = new TextureAtlas(Gdx.files.internal(atlasPath));
        skin.addRegions(atlas);

        assetManager.load(atlasPath, TextureAtlas.class);
        assetManager.load(skinPath, Skin.class);
        assetManager.finishLoading();
    }

    public void dispose() {
        assetManager.dispose();
    }

    public AssetManager getAssetManager() {
        return assetManager;
    }
}
