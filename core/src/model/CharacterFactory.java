package model;

import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.World;

import java.util.ArrayList;
import java.util.List;

/**
 * Produces a character based on choice of user
 */
public class CharacterFactory {

    private final List<String> allCharacterNames = new ArrayList<>();

    /**
     * Constructor, can add new names if desired
     */
    public CharacterFactory(){
        allCharacterNames.add("smurf");
        allCharacterNames.add("evilSmurf");
        allCharacterNames.add("lillamy");
        allCharacterNames.add("sanic");
    }

    /**
     * @param count which character to pull from list
     * @param world initialise in world
     * @param startPosition the starting position, used in character
     * @return returns character object
     */
    public Character createCharacter(int count, World world, Vector2 startPosition){
        return new Character(allCharacterNames.get(count), world,100, startPosition);
    }


    /**Used when displaying choice
     *
     * @param index specify which character name it should return from place in list
     * @return name of character
     */
    public String getCharacterName(int index){return allCharacterNames.get(index);}

    /**Used in selectionstate
     *
     * @return length of list
     */
    public int getLength(){return allCharacterNames.size();}
}