package com.mygdx.game.States;

import com.badlogic.gdx.graphics.OrthographicCamera;
//import com.badlogic.gdx.math.Vector3; import för musen

public abstract class gameState implements Istate {
    protected OrthographicCamera cam;
    //protected Vector3 mouse; Behövs väl inte i den abstrakta klassen, mus kanske inte behövs alls?
    protected gameStateManager gsm;
    protected gameState(gameStateManager gsm){
        this.gsm = gsm;
        cam = new OrthographicCamera();
        //mouse = new Vector3();
    }
}
