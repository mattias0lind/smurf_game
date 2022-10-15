/*package model;

import java.util.Objects;

public class HealthBar {
    private float hp;
    private final float maxHp;
    private int lives;


    public HealthBar(float hp) {
        this.hp = Objects.requireNonNull(hp);
        this.maxHp = Objects.requireNonNull(hp);
        this.lives = 3;
    }


    public void loseHP(float damage) {
        hp = hp - damage;
        if (hp < 0 || hp == 0) {maxHP(); lives = lives - 1;}
            if(lives < 0){lives = 0;}
    }


    public int getLives(){return lives;}
    public float getHpPercentage() {return hp / maxHp;}



    public void maxHP() {
        hp = maxHp;
    }
}*/
