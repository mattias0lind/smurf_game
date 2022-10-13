package model;

import com.badlogic.gdx.math.Rectangle;

import java.util.Objects;

public abstract class Powerups {

    private Rectangle rectangle;
    private final String name;

    public Powerups(String name) {
        rectangle.set((float) (Math.random() * 1280), (float) (Math.random() * 720), 16, 16);
        this.name = Objects.requireNonNull(name);
    }

    public String getName() {
        return name;
    }

    public void CollisionAction(Character player) {
    }

    public static boolean CheckIfPlayerGotPowerup(Character player) {
        if(player.getPlayerMovement().getBody().getPosition().x > 200 && player.getPlayerMovement().getBody().getPosition().x < 500){
            if(player.getPlayerMovement().getBody().getPosition().y > 200 && player.getPlayerMovement().getBody().getPosition().y < 500) {
                return true;
            }
        }
        return false;
    }



    //decide action of collision
}
