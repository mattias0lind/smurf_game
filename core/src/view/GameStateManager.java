package view;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;

import java.util.Stack;

/**
 * Class used to handle the logic of switching between states
 */
public class GameStateManager {
    private final Stack<AbstractState> states;

    /**
     * Constructor for the class. Creates a new stack for game states
     */
    public GameStateManager() {
        states = new Stack<>();
    }

    /**
     * Pushes a new state on top of the stack
     * @param state the next state of the game
     */
    public void push(AbstractState state) {
        states.push(state);
    }

    /**
     * Pops the state on top of the stack from the stack
     */
    public void pop() {
        states.pop();
    }

    /**
     * Sets a new state for the game by popping the current and pushing the new state
     * to the top of the stack
     * @param state The state to be set
     */
    public void set(AbstractState state) {
        states.pop();
        states.push(state);
    }

    /**
     * Checks the state at the top of the stack and updates the application accordingly
     * @param dt Delta Time
     */
    public void update(float dt) {
        states.peek().update(dt);
    }

    /**
     * Checks the state at the top of the stack and renders accordingly
     * @param sb the spritebatch
     */
    public void render(SpriteBatch sb) {
        states.peek().render(sb);
    }
}
