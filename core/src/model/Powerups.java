package model;

import controller.PowerupController;
import view.MoonMap;

/**
 * Powerup class, used to handle the logic for powerups
 */
public class Powerups {
    private boolean isPowerUpActive = true;


    public boolean getIsPowerUpActive(){
        return isPowerUpActive;
    }
    /**
     * Checks if a player is at the powerup and returns a boolean, true if the player is at the powerup
     * @param player is passed to check if that player is at the powerup
     */
    public void checkIfPlayerGotPowerup(Character player) {
            if(isPowerUpActive && player.getPlayerMovement().getBody().getPosition().x > 400 && player.getPlayerMovement().getBody().getPosition().x < 450){
                if(player.getPlayerMovement().getBody().getPosition().y > 230 && player.getPlayerMovement().getBody().getPosition().y < 250) {
                    player.restoreHP();
                    isPowerUpActive = false;
                }
            }

    }




}
