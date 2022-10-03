package com.States;

import MODEL.Character;
import MODEL.SmurfCharacter;
import com.badlogic.gdx.physics.box2d.World;

import java.util.ArrayList;
import java.util.List;

public class CharacterCollection {
        private List<Character> allCharacters = new ArrayList<>();

        public CharacterCollection(World world){
            allCharacters.add(new SmurfCharacter(world));
            //allCharacters.add(new EvilSmurfCharacter(world));
            //allCharacters.add(new LillaMyCharacter(world));
        }

        public Character getCharacter(int index){return allCharacters.get(index);}

        public int getLength(){return allCharacters.size();}
    }


