package model;

import com.badlogic.gdx.math.Rectangle;

import java.util.Objects;

public class Powerups {

    private Rectangle rectangle;
    private final String name;

    public Powerups(String name) {
       // rectangle.set((float) (Math.random() * 1280), (float) (Math.random() * 720), 16, 16);
        this.name = Objects.requireNonNull(name);
    }

    public String getName() {
        return name;
    }

    public void CollisionAction(Character player) {
        CheckIfPlayerGotPowerup(player);
    }

    public static boolean CheckIfPlayerGotPowerup(Character player) {
        if(player.getPlayerMovement().getBody().getPosition().x > 400 && player.getPlayerMovement().getBody().getPosition().x < 450){
            if(player.getPlayerMovement().getBody().getPosition().y > 230 && player.getPlayerMovement().getBody().getPosition().y < 250) {
                return true;
            }
        }
        return false;
    }




}
