package com.mygdx.game.States;

import MODEL.CharacterREAL;
import MODEL.EvilSmurfCharacter;
import MODEL.LillaMyCharacter;
import MODEL.SmurfCharacter;
import com.badlogic.gdx.physics.box2d.World;

public class CharacterFactory {

    public CharacterREAL getCharacter(int index, World world){

        if(index == 0){
            return new SmurfCharacter(world);

        } else if(index == 1){
            return new EvilSmurfCharacter(world);

        } else if(index == 2){
            return new LillaMyCharacter(world);
        }

        return null;
    }
}

