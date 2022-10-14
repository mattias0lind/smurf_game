package view;

import com.badlogic.gdx.graphics.OrthographicCamera;

abstract class AbstractState implements IState {
    protected final OrthographicCamera cam;
    protected final GameStateManager gsm;


    protected AbstractState(GameStateManager gsm) {
        this.gsm = gsm;
        cam = new OrthographicCamera();
    }

    public void update(float dt){handleInput();}

}
