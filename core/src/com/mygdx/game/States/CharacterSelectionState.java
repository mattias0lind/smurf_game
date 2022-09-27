package com.mygdx.game.States;


import MODEL.EvilSmurfCharacter;
import MODEL.SmurfCharacter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import MODEL.CharacterREAL;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.World;

public class CharacterSelectionState extends abstractState{
    private Texture characterCard1;
    private Texture characterCard2;
    private Texture cardslot1;
    private Texture cardslot2;
    private Texture characterSelectionBackground;

    private Texture leftArrow;

    private Texture rightArrow;

    private Texture playButton;
    private World world = new World(new Vector2(-10,0), true);

    private CharacterREAL smurf1 = new SmurfCharacter(world);
    private CharacterREAL smurf2 = new EvilSmurfCharacter(world);

    public CharacterSelectionState(gameStateManager gsm){
        super(gsm);
        characterSelectionBackground = new Texture("moln.png");
        characterCard1 = new Texture(smurf1.getNameOfCharacter() + "Card.png");
        characterCard2 = new Texture(smurf2.getNameOfCharacter() + "Card.png");
        cardslot1 = characterCard1;
        cardslot2 = characterCard2;
        leftArrow = new Texture("leftArrow.png");
        rightArrow = new Texture("rightArrow.png");
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
                gsm.set(new playState(gsm));
                dispose();
            }
            if(Gdx.input.getX() > 68
                    && Gdx.input.getX() < 132
                    && Gdx.input.getY() < 407
                    && Gdx.input.getY() > 320) {
                cardslot1 = characterCard2;
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
        sb.draw(leftArrow, 100, 375, 32, 32);
        sb.draw(rightArrow, 300, 375, 32, 32);
        sb.draw(playButton, (1280 / 2)-(playButton.getWidth() / 2), 30);
        sb.end();
    }

    @Override
    public void dispose() {
        characterSelectionBackground.dispose();
        cardslot1.dispose();
        cardslot2.dispose();
        leftArrow.dispose();
        rightArrow.dispose();
        playButton.dispose();

    }
}
