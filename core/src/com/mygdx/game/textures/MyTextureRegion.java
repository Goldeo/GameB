package com.mygdx.game.textures;

import com.badlogic.gdx.graphics.g2d.TextureRegion;

/**
 * Created by Sergey on 11.10.2016.
 */

public class MyTextureRegion extends TextureRegion {

    public MyTextureRegion clone() throws CloneNotSupportedException {
        return (MyTextureRegion) super.clone();
    }
}
