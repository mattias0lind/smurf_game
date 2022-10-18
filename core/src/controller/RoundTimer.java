package controller;

import model.Character;

import java.util.Objects;

/**
 * Class used to count down the time during a round in PlayState.
 */
public class RoundTimer{
    private float time = 15;
    private int char1AmountOfLives = 3;
    private int char2amountOfLives = 3;

    /**
     * Method used to update the timer based on the amount of lives and hp of the two players
     * @param timer The time-difference each time the timer updates
     * @param character1 character 1
     * @param character2 character 2
     * @return returns the time
     */
    public float roundTimer(float timer, Character character1, Character character2){
        Objects.requireNonNull(character1);
        Objects.requireNonNull(character2);

        time -= timer;

        if(character1.getLives() < char1AmountOfLives) {
            char1AmountOfLives = character1.getLives();
            time = 15;
        }else if(character2.getLives() < char2amountOfLives){
            char2amountOfLives = character2.getLives();
            time = 15;
        }

        if(time < 0){
            if (character1.getHpprocent() > character2.getHpprocent()) {
                character2.gotHit(100);
                character1.restoreHP();
            }
            else if(character1.getHpprocent() < character2.getHpprocent()){
                character1.gotHit(100);
                character2.restoreHP();
            }

            time = 15;
        }
        return time;
    }

}
