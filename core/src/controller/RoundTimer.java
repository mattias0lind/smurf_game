package controller;


import model.Character;

public class RoundTimer{
    private float Time = 10;
    Character character1,character2;

    public float RoundTimer(float Timer,Character character1, Character character2){
        Time -= Timer;
        System.out.println(Time);

        if(Time < 0){
            if(character1.getHpprocent() > character2.getHpprocent()){
                character2.gotHit(100);
                character1.restoreHP();
            }else{
                character1.gotHit(100);
                character2.restoreHP();
            }


            Time = 10 ;
        }
        return Time;


    }

}
