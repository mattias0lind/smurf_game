package com.mygdx.game.States;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;

import java.util.Stack;

public class gameStateManager {
    private Stack<gameState> states;

    public gameStateManager(){
        states = new Stack<gameState>();
    }

    public void push(gameState state){
        states.push(state);
    }

    public void pop(){
        states.pop();
    }

    public void set(gameState state){
        states.pop();
        states.push(state);
    }

    public void update(float dt){
        states.peek().update(dt);
    }

    public void render(SpriteBatch sb){
        states.peek().render(sb);
    }
}
