package view;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public interface IState {//Interface for all states, the states "common" methods.


    void handleInput(); //This function is used to tell the class what happens when certain buttons are pressed.

    void render(SpriteBatch db);//render draws the textures of a state. Such as a states UI, characters or a stage.

    void dispose();//dispose is used to erase a states textures. Often used as the current state changes.
}
