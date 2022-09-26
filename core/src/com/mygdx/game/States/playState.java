package com.mygdx.game.States;


import MODEL.Character;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.World;

public class playState extends abstractState {
    private Character smurf;
    private World world = new World(new Vector2(-10,0),false);

    public playState(gameStateManager gsm){
    super(gsm);
    smurf = new Character("Apa",world);
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
