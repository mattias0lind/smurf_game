package model;

import com.badlogic.gdx.math.Rectangle;
import view.MoonMap;

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

   /* public boolean CheckIfPLayerGotPowerup(Character player) {
        if(player.getPlayerMovement().getBody().getPosition().x == 430){
            if (player.getPlayerMovement().getBody().getPosition().y == 400) {
                return true;
            }
        }
        return false;
    }

    */
    //decide action of collision
}
