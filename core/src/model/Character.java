package model;

import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.World;

import java.util.Objects;


public class Character {
    private final PlayerMovement playerMovement;
    private final String name;
    private boolean punching = false;

    private float hp;
    private final float maxHp;
    private int lives;



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
        this.lives = 3;
        this.hp = hp;
        this.maxHp = hp;
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
     * @param character
     */
    public void punch(Character character) {
        final float yDiff = character.getPlayerMovement().getBody().getPosition().y - playerMovement.getBody().getPosition().y;
        final float xDiff = character.getPlayerMovement().getBody().getPosition().x - playerMovement.getBody().getPosition().x;

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
        hp = maxHp;
    }

    public float getHP(){
        return hp;
    }

    /**
     *
     * @return
     */
    public float getHpprocent() {
       return hp/maxHp;
    }

    /**
     *
     * @param attackDamage
     */
    public void gotHit(float attackDamage) {
        hp = hp - attackDamage;
        if (hp < 0 || hp == 0) {maxHP(); lives = lives - 1;}
        if(lives < 0){lives = 0;}
    }

   /* /** Called when you want your player to lose HP depending on the damage taken.
    public void loseHP(float damage) {
        hp = hp - damage;
        if (hp < 0 || hp == 0) {maxHP(); lives = lives - 1;}
        if(lives < 0){lives = 0;}
    }*/


    public int getLives(){return lives;}




    /** Restores your character HP to max. */
    public void maxHP() {
        hp = maxHp;
    }


}


