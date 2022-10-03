package com.States;

import java.util.*;

public class CharacterNameCollection {

    private List<String> allCharacterNames = new ArrayList<String>();


    public CharacterNameCollection(){
        allCharacterNames.add("smurf");
        allCharacterNames.add("evilSmurf");
        allCharacterNames.add("lillamy");
        allCharacterNames.add("sanic");
    }

    public String getCharacter(int index){return allCharacterNames.get(index);}

    public int getLength(){return allCharacterNames.size();}
}
