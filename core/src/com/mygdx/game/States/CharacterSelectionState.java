package com.mygdx.game.States;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

import java.util.ArrayList;
import java.util.List;

public class CharacterSelectionState extends abstractState{
    private Texture characterCard1;
    private Texture characterCard2;
    private Texture characterCard3;
    private Texture cardslot1;
    private Texture cardslot2;
    private Texture characterSelectionBackground;
    private List<Texture> characterCards = new ArrayList<Texture>();
    private int slotcounter1 = 1;
    private int slotcounter2 = 2;

    private Texture leftArrow1;
    private Texture rightArrow1;
    private Texture leftArrow2;
    private Texture rightArrow2;

    private Texture playButton;
    private CharacterCollection characters = new CharacterCollection();

    public CharacterSelectionState(gameStateManager gsm){
        super(gsm);
        characterSelectionBackground = new Texture("moln.png");
        characterCard1 = new Texture(characters.getCharacter(0) + "Card.png");
        characterCard2 = new Texture(characters.getCharacter(1) + "Card.png");
        characterCard3 = new Texture(characters.getCharacter(2) + "Card.png");
        cardslot1 = characterCard3;
        cardslot2 = characterCard1;
        characterCards.add(characterCard1);
        characterCards.add(characterCard2);
        characterCards.add(characterCard3);

        leftArrow1 = new Texture("leftArrow.png");
        rightArrow1 = new Texture("rightArrow.png");
        leftArrow2 = new Texture("leftArrow.png");
        rightArrow2 = new Texture("rightArrow.png");

        playButton = new Texture("play_text.png");

    }

    @Override
    public void handleInput() {
        if(Gdx.input.justTouched()){
            System.out.println("x: " + Gdx.input.getX() + " y: " + Gdx.input.getY());
            if(Gdx.input.getX() > 417
                    && Gdx.input.getX() < 860
                    && Gdx.input.getY() < 683
                    && Gdx.input.getY() > 580){
                gsm.set(new playState(gsm, characters.getCharacter(slotcounter1), characters.getCharacter(slotcounter2)));
                dispose();
            }
            if(Gdx.input.getX() > 68
                    && Gdx.input.getX() < 132
                    && Gdx.input.getY() < 340
                    && Gdx.input.getY() > 310) {
                cardslot1 = characterCards.get(slotcounter1);
                if (slotcounter1 == 0)
                    slotcounter1 = characterCards.size();
                slotcounter1 = (slotcounter1 - 1) % characters.getLength();
            }
            if(Gdx.input.getX() > 299
                    && Gdx.input.getX() < 330
                    && Gdx.input.getY() < 340
                    && Gdx.input.getY() > 310) {
                cardslot1 = characterCards.get(slotcounter1);
                slotcounter1 = (slotcounter1 + 1) % characters.getLength();
            }
            if(Gdx.input.getX() > 970
                    && Gdx.input.getX() < 1000
                    && Gdx.input.getY() < 340
                    && Gdx.input.getY() > 310) {
                cardslot2 = characterCards.get(slotcounter2);
                if (slotcounter2 == 0)
                    slotcounter2 = characterCards.size();
                slotcounter2 = (slotcounter2 - 1) % characters.getLength();
            }
            if(Gdx.input.getX() > 1168
                    && Gdx.input.getX() < 1200
                    && Gdx.input.getY() < 340
                    && Gdx.input.getY() > 310) {
                cardslot2 = characterCards.get(slotcounter2);
                slotcounter2 = (slotcounter2 + 1) % 2;
            }
        }
    }


    @Override
    public void update(float dt) {
        handleInput();
    }

    @Override
    public void render(SpriteBatch sb) {

        sb.begin();
        sb.draw(characterSelectionBackground,0,0,1280,720);
        sb.draw(cardslot1, 150,330, 135,135);
        sb.draw(cardslot2, 1020,330, 135,135);
        sb.draw(leftArrow1, 100, 375, 32, 32);
        sb.draw(rightArrow1, 300, 375, 32, 32);
        sb.draw(leftArrow1, 970, 375, 32, 32);
        sb.draw(rightArrow1, 1170, 375, 32, 32);

        sb.draw(playButton, (1280 / 2)-(playButton.getWidth() / 2), 30);
        sb.end();
    }

    @Override
    public void dispose() {
        characterSelectionBackground.dispose();
        cardslot1.dispose();
        cardslot2.dispose();
        leftArrow1.dispose();
        rightArrow1.dispose();
        leftArrow2.dispose();
        rightArrow2.dispose();
        playButton.dispose();

    }
}
