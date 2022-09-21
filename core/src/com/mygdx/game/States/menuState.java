package com.mygdx.game.States;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.mygdx.game.MyGdxGame;

public class menuState extends abstractState {
    private Texture background;
    private Texture playButton;

    public menuState(gameStateManager gsm) {
        super(gsm);
        background = new Texture("smurfgame.png");
        playButton = new Texture("playbutton.png");
    }

    @Override
    public void handleInput() {
        if(Gdx.input.justTouched()){
            gsm.set(new playState(gsm));
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
        sb.draw(background, 0,0, MyGdxGame.gameWidth, MyGdxGame.gameHeigth);
        sb.draw(playButton, (MyGdxGame.gameWidth / 2)-(playButton.getWidth() / 2), MyGdxGame.gameHeigth / 4);
        sb.end();
    }

    @Override
    public void dispose(){
        background.dispose();
        playButton.dispose();
    }
}
