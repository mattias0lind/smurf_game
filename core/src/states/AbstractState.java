package states;

import com.badlogic.gdx.graphics.OrthographicCamera;

abstract class AbstractState implements IState {
    protected OrthographicCamera cam;
    protected GameStateManager gsm;


    protected AbstractState(GameStateManager gsm) { //This is the parental class to all states. It has a few attributes
        this.gsm = gsm;                            //      which are inherited and used by all the sub states.
        cam = new OrthographicCamera();
    }

}
