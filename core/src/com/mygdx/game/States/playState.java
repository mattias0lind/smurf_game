package com.mygdx.game.States;

import CONTROLLER.InputProcessor;
import MODEL.Character;
import MODEL.SmurfCharacter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.World;

public class playState extends abstractState {
    private SmurfCharacter smurf;
    private InputProcessor inputProcessor = new InputProcessor();
    private World world = new World(new Vector2(0,-10), true);


    public playState(gameStateManager gsm){
        super(gsm);
        smurf = new SmurfCharacter(world);
        smurf.SetInitialPosition(200,200);
    //cam.setToOrtho(false, Smurf_Game.gameWidth / 2, Smurf_Game.gameHeigth / 2);

    }

    private void PopulateWorld(){

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
