package com.mygdx.game.States;


import MODEL.Character;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class playState extends abstractState {
    private Character smurf;

    public playState(gameStateManager gsm){
    super(gsm);
    smurf = new Character(200,200,"smurf");
    //cam.setToOrtho(false, Smurf_Game.gameWidth / 2, Smurf_Game.gameHeigth / 2);

    }

    @Override
    public void handleInput() {
        //if(Gdx.input.isKeyPressed(62))
        //smurf.jump();
    }

    @Override
    public void update(float dt) {
        //handleInput();
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
