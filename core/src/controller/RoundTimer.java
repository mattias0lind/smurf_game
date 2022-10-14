package controller;


import model.Character;

public class RoundTimer{
    private float Time = 30;
    Character character1,character2;

    public void RoundTimer(float Timer,Character character1, Character character2){
        Time -= Timer;
        System.out.println(Time);

        if(Time < 0){
            if(character1.getHpprocent() > character2.getHpprocent()){
                character2.gotHit(100);
            }else{
                character1.gotHit(100);
            }


            Time = 30 ;
        }



    }

}
