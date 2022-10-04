package MODEL;

import com.badlogic.gdx.physics.box2d.World;

public class CharacterFactory {

    public Character getCharacter(String characterName, World world){

        if(characterName.equalsIgnoreCase("smurf") ){
            return new SmurfCharacter(world);

        } else if(characterName.equalsIgnoreCase("evilSmurf") ){
            return new EvilSmurfCharacter(world);

        } else if(characterName.equalsIgnoreCase("lillamy") ){
            return new LillaMyCharacter(world);
        } else if(characterName.equalsIgnoreCase("sanic")){
            return new SanicCharacter(world);
        }


        return null;
    }
}

