package com.mygdx.game.States;

import com.badlogic.gdx.graphics.OrthographicCamera;

public abstract class abstractState implements Istate {
    protected OrthographicCamera cam;
    protected gameStateManager gsm;


    protected abstractState(gameStateManager gsm){
        this.gsm = gsm;
        cam = new OrthographicCamera();
    }

}
