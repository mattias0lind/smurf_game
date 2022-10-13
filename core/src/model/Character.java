package model;

import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.World;

import java.util.Objects;


public abstract class Character {
    private final PlayerMovement playerMovement;
    private final String name;
    private final HealthBar healthBar;
    private boolean punching = false;

    //TODO Ifall vi vill ha ljudet så måste det lösas i view.
    //Sound robloxSound = Gdx.audio.newSound(Gdx.files.internal(ImagePaths.HITSOUND.label));


    public Character(String nameOfCharacter, World world, float hp, Vector2 startPosition) {
        this.name = Objects.requireNonNull(nameOfCharacter);
        this.playerMovement = Objects.requireNonNull(new PlayerMovement(world, startPosition));
        this.healthBar = Objects.requireNonNull(new HealthBar(hp));
    }



    public String getNameOfCharacter() {
        return this.name;
    }

    public PlayerMovement getPlayerMovement() {
        return playerMovement;
    }

    public HealthBar getHealthBar(){return healthBar;}

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

    public void punching(Boolean t){
        punching = t;
    }

    public boolean charactersCurrentDirection(){
        return playerMovement.getMoveLeft();
    }

    public boolean getIsPunching(){
        return punching;
    }

    public void restoreHP() {
        healthBar.maxHP();
    }

    public float getHpprocent() {
        return healthBar.getHpPercentage();
    }

    public void gotHit(float attackDamage) {
        healthBar.loseHP(attackDamage);
    }
}


