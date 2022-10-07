package model;

import com.badlogic.gdx.math.Vector2;
import states.ImagePaths;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.physics.box2d.World;

import java.util.Objects;


public abstract class Character {
    private final PlayerMovement playerMovement;
    private final String name;
    private final HealthBar healthBar;
    private final Vector2 position;
    private final float attackDamage = 10;

    Sound robloxSound = Gdx.audio.newSound(Gdx.files.internal(ImagePaths.HITSOUND.label));


    public Character(String nameOfCharacter, World world, float hp, Vector2 position) {
        this.position = position;
        this.name = Objects.requireNonNull(nameOfCharacter);
        this.playerMovement = Objects.requireNonNull(new PlayerMovement(world, this.position));
        this.healthBar = Objects.requireNonNull(new HealthBar(hp));
    }



    public String getNameOfCharacter() {
        return this.name;
    }

    public PlayerMovement getPlayerMovement() {
        return playerMovement;
    }

    public void punch(Character character) {
        Rectangle rectangle = new Rectangle();
        if (playerMovement.getMoveRight()) {
            rectangle.set(playerMovement.getBody().getPosition().x + 16, playerMovement.getBody().getPosition().y, 64, 64);
        }
        else if (playerMovement.getMoveLeft()) {
            rectangle.set(playerMovement.getBody().getPosition().x - 64, playerMovement.getBody().getPosition().y, 64, 64);
        }
        if (rectangle.contains(character.getPlayerMovement().getBody().getPosition().x, character.getPlayerMovement().getBody().getPosition().y)) {
            character.gotHit(this.attackDamage);
            robloxSound.play(1.0f);
        }
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


