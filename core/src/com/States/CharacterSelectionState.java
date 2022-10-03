package com.States;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.World;

import static com.States.ImagePaths.CLOUDS;

public class CharacterSelectionState extends abstractState{

    private Texture cardSlot1;
    private Texture cardSlot2;
    private Texture characterSelectionBackground;
    private int slotCounter1 = 0;
    private int slotCounter2 = 0;

    private Texture leftArrow1;
    private Texture rightArrow1;
    private Texture playButton;



    private World world = new World(new Vector2(0,-30), true);
    private CharacterNameCollection allCharacterNames = new CharacterNameCollection();

    public CharacterSelectionState(gameStateManager gsm){
        super(gsm);
        characterSelectionBackground = new Texture(CLOUDS.label);
        cardSlot1 = new Texture(allCharacterNames.getCharacter(slotCounter1) + "Card.png");
        cardSlot2 = new Texture(allCharacterNames.getCharacter(slotCounter2) + "Card.png");;


        leftArrow1 = new Texture(ImagePaths.LEFTARROW.label);
        rightArrow1 = new Texture(ImagePaths.RIGHTARROW.label);

        playButton = new Texture(ImagePaths.PLAYBUTTON.label);

    }

    @Override
    public void handleInput() {
        if(Gdx.input.justTouched()){
            System.out.println("x: " + Gdx.input.getX() + " y: " + Gdx.input.getY());
            if(Gdx.input.getX() > 417
                    && Gdx.input.getX() < 860
                    && Gdx.input.getY() < 683
                    && Gdx.input.getY() > 580){
                System.out.println(slotCounter1);
                gsm.set(new playState(gsm, allCharacterNames.getCharacter(slotCounter1), allCharacterNames.getCharacter(slotCounter2)));
                dispose();
            }
        if(Gdx.input.getX() > 68
           && Gdx.input.getX() < 132
           && Gdx.input.getY() < 340
           && Gdx.input.getY() > 310) {
                if (slotCounter1 == 0)
                    slotCounter1 = allCharacterNames.getLength();
                    slotCounter1 = (slotCounter1 - 1) % allCharacterNames.getLength();
                    cardSlot1 = new Texture(allCharacterNames.getCharacter(slotCounter1) + "Card.png");
            }
            if(Gdx.input.getX() > 299
                    && Gdx.input.getX() < 330
                    && Gdx.input.getY() < 340
                    && Gdx.input.getY() > 310) {
                slotCounter1 = (slotCounter1 + 1) % allCharacterNames.getLength();
                cardSlot1 = new Texture (allCharacterNames.getCharacter(slotCounter1) + "Card.png");
            }
            if(Gdx.input.getX() > 970
                    && Gdx.input.getX() < 1000
                    && Gdx.input.getY() < 340
                    && Gdx.input.getY() > 310) {
                if (slotCounter2 == 0)
                    slotCounter2 = allCharacterNames.getLength();
                    slotCounter2 = (slotCounter2 - 1) % allCharacterNames.getLength();
                cardSlot2 = new Texture(allCharacterNames.getCharacter(slotCounter2) + "Card.png");
            }
            if(Gdx.input.getX() > 1168
                    && Gdx.input.getX() < 1200
                    && Gdx.input.getY() < 340
                    && Gdx.input.getY() > 310) {
                slotCounter2 = (slotCounter2 + 1) % allCharacterNames.getLength();
                cardSlot2 = new Texture(allCharacterNames.getCharacter(slotCounter2) + "Card.png");
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
        sb.draw(cardSlot1, 150,330, 135,135);
        sb.draw(cardSlot2, 1020,330, 135,135);
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
        cardSlot1.dispose();
        cardSlot2.dispose();
        leftArrow1.dispose();
        rightArrow1.dispose();
        playButton.dispose();

    }
}
