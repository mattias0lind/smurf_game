package states;

import com.badlogic.gdx.graphics.OrthographicCamera;

abstract class AbstractState implements IState {
    protected OrthographicCamera cam;
    protected GameStateManager gsm;


    protected AbstractState(GameStateManager gsm) {
        this.gsm = gsm;
        cam = new OrthographicCamera();
    }

}
