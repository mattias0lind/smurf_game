package com.mygdx.game.States;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.mygdx.game.Smurf_Game;

public class menuState extends gameState{
    private Texture background;
    private Texture playButton;
    public menuState(gameStateManager gsm) {
        super(gsm);
        background = new Texture("smurfgame.png");
        playButton = new Texture("playbutton.png");
    }

    @Override
    public void handleInput() {

    }

    @Override
    public void update(float dt) {

    }

    @Override
    public void render(SpriteBatch sb) {
        sb.begin();
        sb.draw(background, 0,0, Smurf_Game.gameWidth, Smurf_Game.gameHeigth);
        sb.draw(playButton, (Smurf_Game.gameWidth / 2)-(playButton.getWidth() / 2), Smurf_Game.gameHeigth / 2);
    }
}
