package view;


import com.badlogic.gdx.graphics.Texture;
import model.Character;

public class DrawCharacterSprite {
    private final Character character;
    private final Texture characterSpriteRight;
    private final Texture characterSpriteLeft;
    private final Texture characterSpritePunchLeft;
    private final Texture characterSpritePunchRight;
    private Texture currentCharacterSprite;

    DrawCharacterSprite( Character character){
        this.character = character;
        this.characterSpriteRight = new Texture(character.getNameOfCharacter() + ".png");
        this.characterSpriteLeft = new Texture(character.getNameOfCharacter() + "LookLeft.png");
        this.characterSpritePunchRight = new Texture(character.getNameOfCharacter() + "PunchRight.png");
        this.characterSpritePunchLeft = new Texture(character.getNameOfCharacter() + "PunchLeft.png");

    }


    public Texture getCharacterSprite(){
        if(character.getPlayerMovement().getlookingLeft()){
            if(character.getIsPunching()){
             return characterSpritePunchLeft;
            }
            return characterSpriteLeft;

        }else{
            if(character.getIsPunching()){return characterSpritePunchRight;}return characterSpriteRight;}



    }

}
