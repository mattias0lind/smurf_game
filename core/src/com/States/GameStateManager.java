package com.States;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;

import java.util.Stack;

public class GameStateManager {
    private Stack<AbstractState> states;

    public GameStateManager() {
        states = new Stack<AbstractState>();
    }

    public void push(AbstractState state) {
        states.push(state);
    }

    public void pop() {
        states.pop();
    }

    public void set(AbstractState state) {
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
