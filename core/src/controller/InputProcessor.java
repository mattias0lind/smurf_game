package controller;

/**
 * Class used to define general methods that subclasses will inherit and override
 */
public class InputProcessor implements com.badlogic.gdx.InputProcessor {

    /**
     * For when a key is pressed
     * @param i the key
     * @return false
     */
    @Override
    public boolean keyDown(int i) {
        return false;
    }

    /**
     * For when a key is released
     * @param i the key
     * @return false
     */
    @Override
    public boolean keyUp(int i) {
        return false ;
    }

    /**
     * For when a key is typed
     * @param c The character
     * @return false
     */
    @Override
    public boolean keyTyped(char c) {
        return false;
    }

    /**
     * If a mouse button was pressed somewhere or if a key was pressed
     * @param i The x coordinate, origin is in the upper left corner
     * @param i1 The y coordinate, origin is in the upper left corner
     * @param i2 the pointer for the event.
     * @param i3 the button
     * @return false
     */
    @Override
    public boolean touchDown(int i, int i1, int i2, int i3) {
        return false;
    }

    /**
     * If a mouse button or finger was lifted
     * @param i placeholder
     * @param i1 placeholder
     * @param i2 the pointer for the event.
     * @param i3 the button
     * @return false
     */
    @Override
    public boolean touchUp(int i, int i1, int i2, int i3) {
        return false;
    }

    /**
     * Method for when the mouse is moved and something is pressed down
     * @param i placeholder
     * @param i1 placeholder
     * @param i2 the pointer for the event.
     * @return false
     */
    @Override
    public boolean touchDragged(int i, int i1, int i2) {
        return false;
    }

    /**
     * Method for when the mouse is moved but nothing is pressed
     * @param i placeholder
     * @param i1 placeholder
     * @return false
     */
    @Override
    public boolean mouseMoved(int i, int i1) {
        return false;
    }


    /**
     * Method for when the mouse is used to scroll the screen
     * @param v the horizontal scroll amount, negative or positive depending on the direction the wheel was scrolled.
     * @param v1 the vertical scroll amount, negative or positive depending on the direction the wheel was scrolled.
     * @return false
     */
    @Override
    public boolean scrolled(float v, float v1) {
        return false;
    }
}
