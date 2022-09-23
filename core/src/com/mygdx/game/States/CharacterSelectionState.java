package com.mygdx.game.States;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import MODEL.Character;


public class CharacterSelectionState extends abstractState{
    private Texture characterCard1;
    private Texture characterCard2;

    private Character smurf1 = new Character(200,0,"smurf");
    private Character smurf2 = new Character(200,200,"evilSmurf");

    public CharacterSelectionState(gameStateManager gsm){
        super(gsm);
        characterCard1 = new Texture(smurf1.getCharacterName() + "Card.png");
        characterCard2 = new Texture(smurf2.getCharacterName() + "Card.png");
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
        sb.draw(characterCard1, 0,590, 130,130);
        sb.draw(characterCard2, 150,590, 130,130);
        sb.end();
    }

    @Override
    public void dispose() {

    }
}
