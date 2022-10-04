package MODEL;

import com.States.ImagePaths;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.World;

import java.util.Objects;


public abstract class Character {
    private Player_Movement playerMovement;
    private String name;
    private HealthBar healthBar;
    private float attackDamage = 10;

    Sound robloxSound = Gdx.audio.newSound(Gdx.files.internal(ImagePaths.HITSOUND.label));


    public Character(String nameOfCharacter, World world, float hp) {
        this.name = Objects.requireNonNull(nameOfCharacter);
        this.playerMovement = Objects.requireNonNull(new Player_Movement(world));
        this.healthBar = Objects.requireNonNull(new HealthBar(hp));
    }



    public String getNameOfCharacter() {
        return this.name;
    }

    public Player_Movement getPlayerMovement() {
        return playerMovement;
    }

    public void punch(Character character) {
        Rectangle rectangle = new Rectangle();
        if (playerMovement.getBody().getLinearVelocity().x >= 0) {
            rectangle.set(playerMovement.getBody().getPosition().x + 16, playerMovement.getBody().getPosition().y, 64, 64);
        }
        if (playerMovement.getBody().getLinearVelocity().x <= 0) {
            rectangle.set(playerMovement.getBody().getPosition().x - 64, playerMovement.getBody().getPosition().y, 64, 64);
        }
        if (rectangle.contains(character.getPlayerMovement().getBody().getPosition().x, character.getPlayerMovement().getBody().getPosition().y)) {
            character.gotHit(this.attackDamage);
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

    }
}


