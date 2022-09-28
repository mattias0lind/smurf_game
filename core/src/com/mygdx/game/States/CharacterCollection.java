package com.mygdx.game.States;

import MODEL.CharacterREAL;
import MODEL.EvilSmurfCharacter;
import MODEL.LillaMyCharacter;
import MODEL.SmurfCharacter;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.World;

import java.util.ArrayList;
import java.util.List;

public class CharacterCollection {

        private List<CharacterREAL> allCharacters = new ArrayList<>();


        public CharacterCollection(World world){
            allCharacters.add(new SmurfCharacter(world));
            allCharacters.add(new EvilSmurfCharacter(world));
            allCharacters.add(new LillaMyCharacter(world));
        }

        public CharacterREAL getCharacter(int index){return allCharacters.get(index);}

        public int getLength(){return allCharacters.size();}
    }


