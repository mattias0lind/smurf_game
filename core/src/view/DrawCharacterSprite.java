package view;


import com.badlogic.gdx.graphics.Texture;
import model.Character;

public class DrawCharacterSprite {
    private final Character character;
    private final Texture characterSpriteRight;
    private final Texture characterSpriteLeft;
    private final Texture characterSpritePunchLeft;
    private final Texture characterSpritePunchRight;

    DrawCharacterSprite( Character character){
        this.character = character;
        this.characterSpriteRight = new Texture(character.getNameOfCharacter() + ".png");
        this.characterSpriteLeft = new Texture(character.getNameOfCharacter() + "LookLeft.png");
        this.characterSpritePunchRight = new Texture(character.getNameOfCharacter() + "PunchRight.png");
        this.characterSpritePunchLeft = new Texture(character.getNameOfCharacter() + "PunchLeft.png");

    }


    public Texture getCharacterSprite(){
        if(character.getPlayerMovement().isLookingLeft()){
            if(character.isPunching()){
             return characterSpritePunchLeft;
            }
            return characterSpriteLeft;

        }else{
            if(character.isPunching()){return characterSpritePunchRight;}return characterSpriteRight;}



    }

}
