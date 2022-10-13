package view;

import com.badlogic.gdx.graphics.OrthographicCamera;

abstract class AbstractState implements IState {
    protected final OrthographicCamera cam;
    protected final GameStateManager gsm;


    protected AbstractState(GameStateManager gsm) { //This is the parental class to all states. It has a few attributes
        this.gsm = gsm;                            //      which are inherited and used by all the sub states.
        cam = new OrthographicCamera();
    }

    public void update(float dt){handleInput();};

}
