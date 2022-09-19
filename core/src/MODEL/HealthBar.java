package MODEL;

public class HealthBar {
    private float HP; // procent 1 = 100%
    private final float maxHP; // procent 1 = 100%
    private boolean isAlive;

    public HealthBar (float HP) {
        this.HP = HP;
        this.maxHP = HP;
        this.isAlive = true;
    }

    public float getHP() {
        return HP;
    }

    public void looseHP (float damage){ //skada i procent 1 = 100%
        HP -= damage;
        if (HP < 0)
            isAlive = false;
    }
    public void maxHP(){
        HP = maxHP;
    }


}

/*
View för HP bar

Texture bar;

Bar = new Texture("healthbar.png") (konstruktor)

game.batch.draw(Bar, 0,0, Gdx.graphics.getWidth() * character.currenthealth, 5); (kommer att hamna längst ner på skärmen)
             (bilden)(längst ner)(hela skärmen dock)(gånger 1 som hundra procent)


for (Player, Player: player) eller (for (Character, Character: character) {
    if (character.getHit(float damage)
        character.takedamage(float damage)
}


*/