package MODEL;

public class HealthBar {
    private int HP;
    private final int maxHP;
    private boolean isAlive;

    public HealthBar (int HP) {
        this.HP = HP;
        this.maxHP = HP;
        this.isAlive = true;
    }

    public void takeDamage (int damage){
        HP = HP-damage;
        if (HP < 0)
            isAlive = false;
    }
    public void maxHP(){
        HP = maxHP;
    }



}
