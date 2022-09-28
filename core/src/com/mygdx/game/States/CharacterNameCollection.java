package com.mygdx.game.States;

import java.util.*;

public class CharacterNameCollection {

    private List<String> allCharacters = new ArrayList<String>();


    public CharacterNameCollection(){
        allCharacters.add("smurf");
        allCharacters.add("evilSmurf");
        allCharacters.add("lillamy");
    }

    public String getCharacter(int index){return allCharacters.get(index);}

    public int getLength(){return allCharacters.size();}
}
