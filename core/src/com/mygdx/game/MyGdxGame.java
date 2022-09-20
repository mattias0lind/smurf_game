package com.mygdx.game;

import CONTROLLER.InputProcessor;
import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.ScreenUtils;

public class MyGdxGame extends ApplicationAdapter {
	SpriteBatch batch;
	Texture img;
	Sprite sprite;
	
	@Override
	public void create () {
		batch = new SpriteBatch();
		img = new Texture("badlogic.jpg");
		sprite = new Sprite(img);


	}

	@Override
	public void render () {
		InputProcessor inputProcessor = new InputProcessor();
		Gdx.input.setInputProcessor(inputProcessor);
		inputProcessor.setSprite(sprite);
		ScreenUtils.clear(1, 0, 0, 1);
		batch.begin();
		batch.draw(sprite,sprite.getX(),sprite.getY());
		batch.end();
	}
	
	@Override
	public void dispose () {
		batch.dispose();
		img.dispose();
	}
}
