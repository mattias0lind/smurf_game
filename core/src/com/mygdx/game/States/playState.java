package com.mygdx.game.States;

import CONTROLLER.InputProcessor;
import MODEL.Character;
import MODEL.SmurfCharacter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class playState extends abstractState {
    private SmurfCharacter smurf;
    private InputProcessor inputProcessor = new InputProcessor();


    public playState(gameStateManager gsm){
    super(gsm);
    smurf = new SmurfCharacter(200,200);
    //cam.setToOrtho(false, Smurf_Game.gameWidth / 2, Smurf_Game.gameHeigth / 2);

    }

    @Override
    public void handleInput() {
        Gdx.input.setInputProcessor(inputProcessor);


    }

    @Override
    public void update(float dt) {
        handleInput();
        //smurf.update(dt);
    }

    @Override
    public void render(SpriteBatch sb) {
        //sb.setProjectionMatrix(cam.combined);
        sb.begin();
        sb.end();
    }

    @Override
    public void dispose(){

    }
}
