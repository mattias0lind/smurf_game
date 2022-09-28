/*package com.mygdx.game.States;

import java.util.*;

public class CharacterNameCollection {

    private List<String> allCharacterNames = new ArrayList<String>();


    public CharacterNameCollection(){
        allCharacterNames.add("smurf");
        allCharacterNames.add("evilSmurf");
        allCharacterNames.add("lillamy");
    }

    public String getCharacter(int index){return allCharacterNames.get(index);}

    public int getLength(){return allCharacterNames.size();}
}
*/

//denna klass användes innan i characterSelectionState men vi använder nu en uppdaterad version där listan
//innehåller hela karaktärsobjekt och inte bara namnen. Den nya klassen heter CharacterCollection