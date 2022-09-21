package MODEL;

public class HealthBar {
    private float HP; // HP i procent
    private final float maxHP; // Maximalt HP


    public HealthBar (float HP) {
        this.HP = HP;
        this.maxHP = HP;
    }

    public void looseHP (float damage){ //skada i procent)
        HP = HP-damage;
        if (HP < 0)
            HP = 0;
    }
    public void maxHP(){
        HP = maxHP;
    } //HP återställs till max hp



}
