package com.States;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public interface IState {
    void handleInput();

    void update(float dt);

    void render(SpriteBatch db);

    void dispose();
}
