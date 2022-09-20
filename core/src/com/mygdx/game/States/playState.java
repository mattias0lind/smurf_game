package com.mygdx.game.States;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.mygdx.game.Smurf_Game;

public class playState extends abstractState {
    private Texture smurf;

    public playState(gameStateManager gsm){
    super(gsm);
    smurf = new Texture("smurf.png");
    //cam.setToOrtho(false, Smurf_Game.gameWidth / 2, Smurf_Game.gameHeigth / 2);

    }

    @Override
    public void handleInput() {

    }

    @Override
    public void update(float dt) {

    }

    @Override
    public void render(SpriteBatch sb) {
        //sb.setProjectionMatrix(cam.combined);
        sb.begin();
        sb.draw(smurf,0,0);
        sb.end();
    }

    @Override
    public void dispose(){

    }
}
