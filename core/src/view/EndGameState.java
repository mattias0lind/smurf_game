package view;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;


public class EndGameState extends AbstractState {
    private final Texture winner1Texture;
    private final Texture winner2Texture;
    private final Sprite winner1Sprite;
    private final Sprite winner2Sprite;
    private final int numberOfPlayerThatWon ;


    protected EndGameState(GameStateManager gsm, int numberOfPlayerThatWon) {
        super(gsm);
        winner1Sprite = new Sprite(winner1Texture = new Texture("game_over_screen_player_1.png"));
        winner2Sprite = new Sprite(winner2Texture = new Texture("game_over_screen_player_2.png"));
        this.numberOfPlayerThatWon = numberOfPlayerThatWon;




    }

    @Override
    public void handleInput() {
        if(Gdx.input.isKeyJustPressed(Input.Keys.ANY_KEY) || Gdx.input.isTouched() ){
            gsm.set(new MenuState(gsm));
            dispose();

        }

    }

    @Override
    public void update(float dt) {

    }

    @Override
    public void render(SpriteBatch db) {
        handleInput();
        db.begin();
        handleInput();
        if(numberOfPlayerThatWon == 0){
            db.draw(winner2Sprite,0,0);
        }else{
            db.draw(winner1Sprite,0,0);
        }
        db.end();

    }

    @Override
    public void dispose() {
        winner1Texture.dispose();
        winner2Texture.dispose();

    }
}
