package view;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;

/**
 * //Interface for all states, the states "common" methods.
 */
public interface IState {

    /**
     * Method used to tell the class what happens when certain buttons are pressed, used in classes
     * implementing the interface
     */
    void handleInput();

    /**
     * Render draws the textures of a state. Such as a states UI, characters or a stage. Used in classes
     * implementing the interface
     * @param db the spritebatch
     */
    void render(SpriteBatch db);

    /**
     * Dispose is used to erase a states textures. Often used as the current state changes.
     */
    void dispose();
}
