package com.mygdx.game;

import CONTROLLER.InputProcessor;
import MODEL.player_movement;
import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.ScreenUtils;

public class MyGdxGame extends ApplicationAdapter {
	private SpriteBatch batch;
	private Texture img;
	public Sprite sprite;
	private int keyPressed;
	private player_movement player = new player_movement();
	private InputProcessor inputProcessor = new InputProcessor();



	@Override
	public void create () {
		batch = new SpriteBatch();
		img = new Texture("badlogic.jpg");
		sprite = new Sprite(img);
		inputProcessor.logic(player);
	}

	@Override
	public void render () {
		Gdx.input.setInputProcessor(inputProcessor);
		if(player.getmoveLeft()){sprite.translateX(-1f);}
		else if(player.getmoveRight()){sprite.translateX(1f);}
		else if(player.getmoveUp()){sprite.translateY(1f);}
		else if(player.getmoveDown()){sprite.translateY(-1f);}
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
