package model;

import java.util.*;

public class CharacterNameCollection {

    private final List<String> allCharacterNames = new ArrayList<>();


    public CharacterNameCollection(){
        allCharacterNames.add("smurf");
        allCharacterNames.add("evilSmurf");
        allCharacterNames.add("lillamy");
        allCharacterNames.add("sanic");
    }

    public String getCharacter(int index){return allCharacterNames.get(index);}

    public int getLength(){return allCharacterNames.size();}
}
