package model;

import java.util.Objects;

public class HealthBar {
    private float hp;
    private final float maxHp;
    private int lives;

    /** Constructor for health. */
    public HealthBar(float hp) {
        this.hp = Objects.requireNonNull(hp);
        this.maxHp = Objects.requireNonNull(hp);
        this.lives = 3;
    }

    /** Called when you want your player to lose HP depending on the damage taken. */
    public void loseHP(float damage) {
        damage = Objects.requireNonNull(damage);
        hp = hp - damage;
        if (hp < 0 || hp == 0) {maxHP(); lives = lives - 1;}
            if(lives < 0){lives = 0;}
    }


    public int getLives(){return lives;}
    public float getHpPercentage() {return hp / maxHp;}


    /** Restores your character HP to max. */
    public void maxHP() {
        hp = maxHp;
    }
}
