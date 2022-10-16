package model;

import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.World;

import java.util.Objects;


/** Character class, used to handle all things necessary for a character
 *
 */
public class Character {
    private final PlayerMovement playerMovement;
    private final String name;
    private boolean punching = false;

    private float hp;
    private final float maxHp;
    private int lives;



    /**Constructor for character used in game.
     *
     * @param nameOfCharacter name of character, used in selection and image processing
     * @param world World is used to place the physcial body in the world, creates physics relation
     * @param hp sets the amount of healthpoints a character has
     * @param startPosition initialises position at start of game
     */
    public Character(String nameOfCharacter, World world, float hp, Vector2 startPosition) {
        this.name = Objects.requireNonNull(nameOfCharacter);
        this.playerMovement = new PlayerMovement(world, startPosition);
        this.lives = 3;
        this.hp = hp;
        this.maxHp = hp;
    }


    /** getter for name, used in drawing of textures
     *
     * @return returns name of character
     */
    public String getNameOfCharacter() {
        return this.name;
    }

    /**getter for playermovement, stores all physical properties as well as logic for movement. used to access it
     *
     * @return returns the object
     */
    public PlayerMovement getPlayerMovement() {
        return playerMovement;
    }



    /** has punch logic. compares position and deals damage with local variable. calls gotHit method of second character
     *
     * @param character takes other character as parameter so compare position and deal damage
     */
    public void punch(Character character) {
        float yDiff = character.getPlayerMovement().getBody().getPosition().y - playerMovement.getBody().getPosition().y;
        float xDiff = character.getPlayerMovement().getBody().getPosition().x - playerMovement.getBody().getPosition().x;

        if (-20 <= yDiff && yDiff <= 20){
            float attackDamage = 10;
            if (0 <= xDiff && xDiff <= 64 && playerMovement.isMovingRight()){
                character.gotHit(attackDamage);
            }
            if (-64 <= xDiff && xDiff <= 0 && playerMovement.isMovingLeft()){
                character.gotHit(attackDamage);
            }
        }

    }

    /** used when displaying sprites, sets punch.
     *
     * @param t true or false
     */
    public void punching(Boolean t){
        punching = t;
    }

    /** checks if punching to know what sprite to display.
     *
     * @return returns true or false punching
     */
    public boolean isPunching(){
        return punching;
    }

    /** used in combination with health powerup to restore hp
     *
     */
    public void restoreHP() {
        hp = maxHp;
    }

    /** gives percent of hp left
     *
     * @return returns float in percent for display
     */
    public float getHpprocent() {
       return hp/maxHp;
    }

    /** deals damage to player along with handling logic for lives and what happens when
     * hp gets to 0
     *
     * @param attackDamage what is used when subtracting damage
     */
    public void gotHit(float attackDamage) {
        hp = hp - attackDamage;
        if (hp < 0 || hp == 0) {restoreHP(); lives = lives - 1;}
        if(lives < 0){lives = 0;}
    }


    /**
     * @return returns amount of lives left
     */
    public int getLives(){return lives;}



}


