package MODEL;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Sound;
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

    Sound robloxSound = Gdx.audio.newSound(Gdx.files.internal("roblox.mp3"));


    public CharacterREAL(String nameOfCharacter, World world, float hp) {
        this.name = nameOfCharacter;
        this.playerMovement = new Player_Movement(world);
        this.healthBar = new HealthBar(hp);
    }

    public void SetInitialPosition(float x, float y) {
        playerMovement.setPlayerPosition(x, y);
    }

    public Vector2 getPosition() {
        return playerMovement.getPlayerPosition();
    }

    public String getNameOfCharacter() {
        return this.name;
    }

    public Player_Movement getPlayerMovement() {
        return playerMovement;
    }

    public void punch(CharacterREAL character) {
        Rectangle rectangle = new Rectangle();
        if (playerMovement.getBody().getLinearVelocity().x >= 0) {
            rectangle.set(playerMovement.getBody().getPosition().x + 16, playerMovement.getBody().getPosition().y, 64, 64);
        }
        if (playerMovement.getBody().getLinearVelocity().x <= 0) {
            rectangle.set(playerMovement.getBody().getPosition().x - 64, playerMovement.getBody().getPosition().y, 64, 64);
        }
        if (rectangle.contains(character.getPlayerMovement().getBody().getPosition().x, character.getPlayerMovement().getBody().getPosition().y)) {
            character.gotHit(AttackDamage);
            if (character.getHpprocent() <= 0.5){
                character.getPlayerMovement().getBody().applyForceToCenter(10000000,0,true);
            }
            robloxSound.play(1.0f);
        }
        //perform punch animation
    }

    public void restoreHP() {
        healthBar.maxHP();
    }

    public float getHpprocent() {
        return healthBar.getHpProcentage();
    }

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


