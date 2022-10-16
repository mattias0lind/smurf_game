package view;

import com.badlogic.gdx.graphics.OrthographicCamera;

abstract class AbstractState implements IState {
    protected final GameStateManager gsm;


    protected AbstractState(GameStateManager gsm) {
        this.gsm = gsm;
    }

    public void update(float dt){handleInput();}

}
