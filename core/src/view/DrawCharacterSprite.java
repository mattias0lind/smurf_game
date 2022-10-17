package view;


import com.badlogic.gdx.graphics.Texture;
import model.Character;

/**
 * Class used for the logic of drawing characters. Contains logic on what sprite to draw based
 * on factors like direction.
 */
public class DrawCharacterSprite {
    private final Character character;
    private final Texture characterSpriteRight;
    private final Texture characterSpriteLeft;
    private final Texture characterSpritePunchLeft;
    private final Texture characterSpritePunchRight;

    /**
     * Method used to define what character that is supposed to be drawn
     * @param character the character you want to draw
     */
    DrawCharacterSprite( Character character){
        this.character = character;
        this.characterSpriteRight = new Texture(character.getNameOfCharacter() + ".png");
        this.characterSpriteLeft = new Texture(character.getNameOfCharacter() + "LookLeft.png");
        this.characterSpritePunchRight = new Texture(character.getNameOfCharacter() + "PunchRight.png");
        this.characterSpritePunchLeft = new Texture(character.getNameOfCharacter() + "PunchLeft.png");

    }


    /**
     * Method used to decide what sprite is supposed to be drawn based on what the character is doing
     * @return returns the sprite that is supposed to be drawn
     */
    public Texture getCharacterSprite(){
        if(character.getPlayerMovement().isLookingLeft()){
            if(character.isPunching()){
             return characterSpritePunchLeft;
            }
            return characterSpriteLeft;

        }else{
            if(character.isPunching()){
                return characterSpritePunchRight;}
            return characterSpriteRight;}



    }

}
