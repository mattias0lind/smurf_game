package com.mygdx.game.States;

import MODEL.character;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class playState extends abstractState {
    private character smurf;

    public playState(gameStateManager gsm){
    super(gsm);
    smurf = new character(200, 200);
    //cam.setToOrtho(false, Smurf_Game.gameWidth / 2, Smurf_Game.gameHeigth / 2);

    }

    @Override
    public void handleInput() {

    }

    @Override
    public void update(float dt) {
    handleInput();
    smurf.update(dt);
    }

    @Override
    public void render(SpriteBatch sb) {
        //sb.setProjectionMatrix(cam.combined);
        sb.begin();
        sb.draw(smurf.getCharacterImage(), smurf.getPosition().x, smurf.getPosition().y);
        sb.end();
    }

    @Override
    public void dispose(){

    }
}
