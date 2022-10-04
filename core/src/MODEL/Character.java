package MODEL;

import com.States.ImagePaths;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.physics.box2d.World;

import java.util.Objects;


public abstract class Character {
    private final Player_Movement playerMovement;
    private final String name;
    private final HealthBar healthBar;
    private final float attackDamage = 10;

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
        return healthBar.getHpProcentage();
    }

    public void gotHit(float attackDamage) {
        healthBar.looseHP(attackDamage);

    }
}


