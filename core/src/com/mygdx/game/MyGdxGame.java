package com.mygdx.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;

import com.badlogic.gdx.graphics.GL20;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.physics.box2d.Box2D;
import com.badlogic.gdx.utils.ScreenUtils;
import com.States.gameStateManager;
import com.States.menuState;

public class MyGdxGame extends ApplicationAdapter {
    private SpriteBatch batch;
    private gameStateManager gsm;

    @Override
    public void create() {
        Box2D.init();
        batch = new SpriteBatch();
        gsm = new gameStateManager();
        ScreenUtils.clear(1, 0, 0, 1);
        gsm.push(new menuState(gsm));


    }

    @Override
    public void render() {
        //Gdx.input.setInputProcessor(inputProcessor);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        gsm.update(Gdx.graphics.getDeltaTime());
        gsm.render(batch);
    }

    @Override
    public void dispose() {
        batch.dispose();

    }

}
