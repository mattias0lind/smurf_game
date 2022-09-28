package com.mygdx.game.States;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;

import java.util.Stack;

public class gameStateManager {
    private Stack<abstractState> states;

    public gameStateManager() {
        states = new Stack<abstractState>();
    }

    public void push(abstractState state) {
        states.push(state);
    }

    public void pop() {
        states.pop();
    }

    public void set(abstractState state) {
        states.pop();
        states.push(state);
    }

    public void update(float dt) {
        states.peek().update(dt);
    }

    public void render(SpriteBatch sb) {
        states.peek().render(sb);
    }
}
