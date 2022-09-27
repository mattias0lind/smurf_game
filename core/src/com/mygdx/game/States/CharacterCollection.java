package com.mygdx.game.States;

import java.util.*;

public class CharacterCollection {

    private List<String> allCharacters = new ArrayList<String>();


    public CharacterCollection(){
        allCharacters.add("smurf");
        allCharacters.add("evilSmurf");
    }

    public String getCharacter(int index){return allCharacters.get(index);}

    public int getLength(){return allCharacters.size();}
}
