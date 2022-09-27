package MODEL;

import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.World;


public abstract class CharacterREAL {
    private int characterXPosition;
    private Player_Movement playerMovement;
    private String name;
    private HealthBar healthBar;
    private float AttackDamage = 10;



    public CharacterREAL(String nameOfCharacter, World world, float hp)
    {
        this.name = nameOfCharacter;
        this.playerMovement = new Player_Movement(world);
        this.healthBar = new HealthBar(hp);
    }

    public void SetInitialPosition(float x, float y){
        playerMovement.setPlayerPosition(x,y);
    }

    public Vector2 getPosition(){
       return playerMovement.getPlayerPosition();
    }

    public String getNameOfCharacter(){return this.name;}

    public Player_Movement getPlayerMovement(){
        return playerMovement;
    }

    public void punch(CharacterREAL character){
        Rectangle rectangle = new Rectangle();
        if(playerMovement.getBody().getLinearVelocity().x > 0){
            rectangle.set(playerMovement.getPlayerPosition().x+16,playerMovement.getPlayerPosition().y,16,16);
        }
        else if(playerMovement.getBody().getLinearVelocity().x <= 0){
            rectangle.set(playerMovement.getPlayerPosition().x-16,playerMovement.getPlayerPosition().y,16,16);
        }
        if (rectangle.contains(character.getPosition().x, getPosition().y)){
            character.gotHit(AttackDamage);
        }
        //perform punch animation
    }

    public void restoreHP(){
        healthBar.maxHP();
    }

    public float getHpprocent(){return healthBar.getHpProcentage();}

    public void gotHit(float attackDamage) {
        healthBar.looseHP(attackDamage);
        //play sound when hit
        //Later add what type of hit it was//
        /*Assume hit = -10hp
         * Highlight the hit graphically
         * /
        currentHealthPoints = currentHealthPoints - 10;
        checkIfStillAlive();
    }

    private void checkIfStillAlive() {
        if (currentHealthPoints <= 0) {
            / If not alive then update HealthBar
            Reset the game round
             */
    }
}


