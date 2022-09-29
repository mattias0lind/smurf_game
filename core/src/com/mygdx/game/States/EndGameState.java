package com.mygdx.game.States;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

import java.util.Objects;

public class EndGameState extends abstractState{
    private Texture winner1Texture,winner2Texture;
    private Sprite winner1Sprite,winner2Sprite;
    private int i;

    protected EndGameState(gameStateManager gsm,int i) {
        super(gsm);
        winner1Sprite = new Sprite(winner1Texture = new Texture("game_over_screen_player_1.png"));
        winner2Sprite = new Sprite(winner2Texture = new Texture("game_over_screen_player_2.png"));
        this.i = Objects.requireNonNull(i);



    }

    @Override
    public void handleInput() {
        if(Gdx.input.isKeyJustPressed(Input.Keys.ANY_KEY)){
            gsm.set(new menuState(gsm));
            dispose();

        }

    }

    @Override
    public void update(float dt) {

    }

    @Override
    public void render(SpriteBatch db) {
        handleInput();
        db.begin();
        handleInput();
        if(i == 0){
            db.draw(winner2Sprite,0,0);
        }else{
            db.draw(winner1Sprite,0,0);
        }
        db.end();

    }

    @Override
    public void dispose() {

    }
}
