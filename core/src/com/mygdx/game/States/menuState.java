package com.mygdx.game.States;

import MODEL.GameScreen;
import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.mygdx.game.MyGdxGame;
import org.w3c.dom.Text;

public class menuState extends abstractState {
    private Texture menuBackground;
    private Texture playButton;
    private Texture quitButton;

    public menuState(gameStateManager gsm) {
        super(gsm);
        menuBackground = new Texture("smurf_game_background.png");
        playButton = new Texture("play_text.png");
        quitButton = new Texture("Quitknapp.png");
    }

    @Override
    public void handleInput() {
        if(Gdx.input.justTouched()){
            System.out.println("x: " + Gdx.input.getX() + " y: " + Gdx.input.getY());
            if(Gdx.input.getX() > (1280 / 2)-(playButton.getWidth() / 2)
                    && Gdx.input.getX() < (1280 / 2)-(playButton.getWidth() / 2) + playButton.getWidth()
                    && Gdx.input.getY() < 440
                    && Gdx.input.getY() > 330){
                gsm.set(new CharacterSelectionState(gsm));
                dispose();
            } else {
                if (Gdx.input.getX() > 418
                        && Gdx.input.getX() < 862
                        && Gdx.input.getY() < 633
                        && Gdx.input.getY() > 525){
                    System.out.println("Thanks for playing! The game is now shutting down :(");
                    System.exit(0);
                }
            }
        }
    }

    @Override
    public void update(float dt) {
        //System.out.println("Handle input to be called: " + dt);
        handleInput();
    }

    @Override
    public void render(SpriteBatch sb) {
        sb.begin();
        sb.draw(menuBackground, 0,0, 1280, 720);
        sb.draw(playButton, (1280 / 2)-(playButton.getWidth() / 2), 280);
        sb.draw(quitButton, (1280 / 2)-(quitButton.getWidth() / 2), -220);
        sb.end();
    }

    @Override
    public void dispose(){
        menuBackground.dispose();
        playButton.dispose();
        quitButton.dispose();
    }
}
