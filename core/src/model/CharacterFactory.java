package model;

import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.World;

public class CharacterFactory {

    private Vector2 playerPosition;

    public Character getCharacter(String characterName, World world, Vector2 playerPosition){

        if(characterName.equalsIgnoreCase("smurf") ){
            return new SmurfCharacter(world, playerPosition);

        } else if(characterName.equalsIgnoreCase("evilSmurf") ){
            return new EvilSmurfCharacter(world, playerPosition);

        } else if(characterName.equalsIgnoreCase("lillamy") ){
            return new LillaMyCharacter(world, playerPosition);
        } else if(characterName.equalsIgnoreCase("sanic")){
            return new SanicCharacter(world, playerPosition);
        }


        return null;
    }
}

