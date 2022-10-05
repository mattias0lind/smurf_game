package model;

import java.util.Objects;

public class HealthBar {
    private float hp;
    private final float maxHp;


    public HealthBar(float hp) {
        this.hp = Objects.requireNonNull(hp);
        this.maxHp = Objects.requireNonNull(hp);
    }

    public void looseHP(float damage) {
        hp = hp - damage;
        if (hp < 0)
            hp = 0;
    }

    public float getHpProcentage() {
        return hp / maxHp;
    }


    public void maxHP() {
        hp = maxHp;
    } //HP återställs till max hp
}
