package com.mygdx.game.States;


import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import MODEL.Character;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.World;

public class CharacterSelectionState extends abstractState{
    private Texture characterCard1;
    private Texture characterCard2;
    private World world = new World(new Vector2(-10,0), true);

    private Character smurf1 = new Character("smurf", world);
    private Character smurf2 = new Character("evilSmurf", world);

    public CharacterSelectionState(gameStateManager gsm){
        super(gsm);
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
        sb.draw(characterCard1, 0,590, 130,130);
        sb.draw(characterCard2, 150,590, 130,130);
        sb.end();
    }

    @Override
    public void dispose() {

    }
}
