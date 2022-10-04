package model;

import java.util.Objects;

public class HealthBar {
    private float HP;
    private final float maxHP;


    public HealthBar(float HP) {
        this.HP = Objects.requireNonNull(HP);
        this.maxHP = Objects.requireNonNull(HP);
    }

    public void looseHP(float damage) {
        HP = HP - damage;
        if (HP < 0)
            HP = 0;
    }

    public float getHpProcentage() {
        return HP / maxHP;
    }


    public void maxHP() {
        HP = maxHP;
    } //HP återställs till max hp
}
