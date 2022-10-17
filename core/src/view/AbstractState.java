package view;

/**
 * Class used to define methods and attributes that subclasses can then use and implement
 */
abstract class AbstractState implements IState {

    protected final GameStateManager gsm;

    /**
     * Class attribute gsm
     * @param gsm The GameStateManager to handle logic of states
     */
    protected AbstractState(GameStateManager gsm) {
        this.gsm = gsm;
    }

    /**
     * Method that will update the state
     * @param dt Delta Time
     */
    public void update(float dt){handleInput();}

}
