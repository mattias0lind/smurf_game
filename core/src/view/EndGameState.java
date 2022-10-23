package view;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

/**
 * The EndGameState is the last state of a game and is accessed when a player loses all their lives in
 * the PlayState. The class is used to clearly declare who won the game
 */
public class EndGameState extends AbstractState {
    private final Texture winner1Texture;
    private final Texture winner2Texture;
    private final Sprite winner1Sprite;
    private final Sprite winner2Sprite;
    private final int numberOfPlayerThatWon;


    /**
     * Constructor for the EndGameState
     * @param gsm The GameStateManager to handle logic of states
     * @param numberOfPlayerThatWon the player that won
     */
    protected EndGameState(GameStateManager gsm, int numberOfPlayerThatWon) {
        super(gsm);
        winner1Sprite = new Sprite(winner1Texture = new Texture("game_over_screen_player_1.png"));
        winner2Sprite = new Sprite(winner2Texture = new Texture("game_over_screen_player_2.png"));
        this.numberOfPlayerThatWon = numberOfPlayerThatWon;
    }

    /**
     * If the user clicks anywhere on the screen then the current state is disposed and a new MenuState
     * is instantiated, basically starting the game over
     */
    @Override
    public void handleInput() {
        if(Gdx.input.isTouched() ){
            gsm.set(new MenuState(gsm));
            dispose();
        }

    }

    /**
     * Method used to draw the graphic of the EndGameState
     * @param sb the spritebatch
     */
    @Override
    public void render(SpriteBatch sb) {
        handleInput();
        sb.begin();
        handleInput();
        if(numberOfPlayerThatWon == 0){
            sb.draw(winner2Sprite,0,0);
        }else{
            sb.draw(winner1Sprite,0,0);
        }
        sb.end();

    }

    /**
     * Disposes of the drawn elements in the current state when called.
     */
    @Override
    public void dispose() {
        winner1Texture.dispose();
        winner2Texture.dispose();

    }
}
