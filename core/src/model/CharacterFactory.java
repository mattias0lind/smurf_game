package model;

import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.World;

import java.util.ArrayList;
import java.util.List;

public class CharacterFactory {

    private final List<String> allCharacterNames = new ArrayList<>();

    public CharacterFactory(){
        allCharacterNames.add("smurf");
        allCharacterNames.add("evilSmurf");
        allCharacterNames.add("lillamy");
        allCharacterNames.add("sanic");
    }

    public Character getCharacter(int count, World world, Vector2 playerPosition){
        return new Character(allCharacterNames.get(count), world,100, playerPosition);
    }


    public String getCharacterName(int index){return allCharacterNames.get(index);}

    public int getLength(){return allCharacterNames.size();}
}