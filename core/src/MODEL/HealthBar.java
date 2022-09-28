package MODEL;

public class HealthBar {
    private float HP;
    private final float maxHP;


    public HealthBar(float HP) {
        this.HP = HP;
        this.maxHP = HP;
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
