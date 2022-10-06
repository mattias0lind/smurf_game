package model;

import java.util.Objects;

public class HealthBar {
    private float hp;
    private final float maxHp;

    /** Constructor for health. */
    public HealthBar(float hp) {
        this.hp = Objects.requireNonNull(hp);
        this.maxHp = Objects.requireNonNull(hp);
    }

    /** Called when you want your player to lose HP depending on the damage taken. */
    public void loseHP(float damage) {
        damage = Objects.requireNonNull(damage);
        hp = hp - damage;
        if (hp < 0)
            hp = 0;
    }


    public float getHpPercentage() {
        return hp / maxHp;
    }


    /** Restores your character HP to max. */
    public void maxHP() {
        hp = maxHp;
    }
}
