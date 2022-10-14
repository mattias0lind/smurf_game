package model;

import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.World;

import java.util.Objects;


public class Character {
    private final PlayerMovement playerMovement;
    private final String name;
    private final HealthBar healthBar;
    private boolean punching = false;


    /**
     *
     * @param nameOfCharacter
     * @param world
     * @param hp
     * @param startPosition
     */
    public Character(String nameOfCharacter, World world, float hp, Vector2 startPosition) {
        this.name = Objects.requireNonNull(nameOfCharacter);
        this.playerMovement = new PlayerMovement(world, startPosition);
        this.healthBar = new HealthBar(hp);
    }


    /**
     *
     * @return
     */
    public String getNameOfCharacter() {
        return this.name;
    }

    /**
     *
     * @return
     */
    public PlayerMovement getPlayerMovement() {
        return playerMovement;
    }

    /**
     *
     * @return
     */
    public HealthBar getHealthBar(){return healthBar;}

    /**
     *
     * @param character
     */
    public void punch(Character character) {
        float yDiff = character.getPlayerMovement().getBody().getPosition().y - playerMovement.getBody().getPosition().y;
        float xDiff = character.getPlayerMovement().getBody().getPosition().x - playerMovement.getBody().getPosition().x;

        if (-20 <= yDiff && yDiff <= 20){
            float attackDamage = 10;
            if (0 <= xDiff && xDiff <= 64 && playerMovement.getMoveRight()){
                character.gotHit(attackDamage);
            }
            if (-64 <= xDiff && xDiff <= 0 && playerMovement.getMoveLeft()){
                character.gotHit(attackDamage);
            }
        }

    }

    /**
     *
     * @param t
     */
    public void punching(Boolean t){
        punching = t;
    }

    /**
     *
     * @return
     */
    public boolean charactersCurrentDirection(){
        return playerMovement.getMoveLeft();
    }

    /**
     *
     * @return
     */
    public boolean getIsPunching(){
        return punching;
    }

    /**
     *
     */
    public void restoreHP() {
        healthBar.maxHP();
    }

    /**
     *
     * @return
     */
    public float getHpprocent() {
        return healthBar.getHpPercentage();
    }

    /**
     *
     * @param attackDamage
     */
    public void gotHit(float attackDamage) {
        healthBar.loseHP(attackDamage);
    }
}


