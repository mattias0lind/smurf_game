package controller;


import model.Character;

public class RoundTimer{
    private float Time = 10;
    Character character1,character2;

    public void RoundTimer(float Timer,Character character1, Character character2){
        Time -= Timer;

        if(Time < 10){



            Time = 10;
        }



    }

}
