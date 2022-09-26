package com.mygdx.game.States;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.mygdx.game.MyGdxGame;

public class menuState extends abstractState {
    private Texture menuBackground;
    private Texture playButton;

    public menuState(gameStateManager gsm) {
        super(gsm);
        menuBackground = new Texture("smurf_game_background.png");
        playButton = new Texture("play_text.png");
    }

    @Override
    public void handleInput() {
        if(Gdx.input.justTouched()){
           gsm.set(new CharacterSelectionState(gsm));
           dispose();
        }
    }

    @Override
    public void update(float dt) {
        handleInput();
    }

    @Override
    public void render(SpriteBatch sb) {
        sb.begin();
        sb.draw(menuBackground, 0,0, 1280, 720);
        sb.draw(playButton, (1280 / 2)-(playButton.getWidth() / 2), 0);
        sb.end();
    }

    @Override
    public void dispose(){
        menuBackground.dispose();
        playButton.dispose();
    }
}
