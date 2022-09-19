package com.mygdx.game.States;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public interface Istate {
    void handleInput();

    void update(float dt);

    void render(SpriteBatch db);
}
