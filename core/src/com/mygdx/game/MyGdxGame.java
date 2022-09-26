package com.mygdx.game;
import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;

import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;

import com.badlogic.gdx.graphics.GL20;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.ScreenUtils;
import com.mygdx.game.States.gameStateManager;
import com.mygdx.game.States.menuState;

public class MyGdxGame extends ApplicationAdapter {
	private SpriteBatch batch;
	private gameStateManager gsm;

	@Override
	public void create () {
		batch = new SpriteBatch();
		gsm = new gameStateManager();
		ScreenUtils.clear(1, 0, 0, 1);
		gsm.push(new menuState(gsm));
		//inputProcessor.logic(player,player2);

	}

	@Override
	public void render () {
		//Gdx.input.setInputProcessor(inputProcessor);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		gsm.update(Gdx.graphics.getDeltaTime());
		gsm.render(batch);
	}
	
	@Override
	public void dispose () {
		batch.dispose();

	}

}
