package com.mygdx.game.States;


import MODEL.EvilSmurfCharacter;
import MODEL.SmurfCharacter;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import MODEL.CharacterREAL;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.World;

public class CharacterSelectionState extends abstractState{
    private Texture characterCard1;
    private Texture characterCard2;
    private Texture characterSelectionBackground;
    private World world = new World(new Vector2(-10,0), true);

    private CharacterREAL smurf1 = new SmurfCharacter(world);
    private CharacterREAL smurf2 = new EvilSmurfCharacter(world);

    public CharacterSelectionState(gameStateManager gsm){
        super(gsm);
        characterSelectionBackground = new Texture("VSBattlesBackground.png");
        characterCard1 = new Texture(smurf1.getNameOfCharacter() + "Card.png");
        characterCard2 = new Texture(smurf2.getNameOfCharacter() + "Card.png");
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
        sb.draw(characterSelectionBackground,0,0,1280,720);
        sb.draw(characterCard1, 750,500, 135,135);
        sb.draw(characterCard2, 600,500, 135,135);
        sb.end();
    }

    @Override
    public void dispose() {
        characterSelectionBackground.dispose();
        characterCard1.dispose();
        characterCard2.dispose();

    }
}
