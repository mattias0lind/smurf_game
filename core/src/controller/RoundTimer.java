package controller;


import model.Character;

import java.util.Objects;

public class RoundTimer{
    private float time = 10;


    public float RoundTimer(float timer,Character character1, Character character2){
        Objects.requireNonNull(character1);
        Objects.requireNonNull(character2);

        time -= timer;
        System.out.println(time);

        if(time < 0){
            if (character1.getHpprocent() > character2.getHpprocent()) {
                character2.gotHit(100);
                character1.restoreHP();
            }
            else if(character1.getHpprocent() < character2.getHpprocent()){
                character1.gotHit(100);
                character2.restoreHP();
            }
            else {
                character1.restoreHP();
                character2.restoreHP();
            }
            time = 10;
        }
        return time;


    }

}
