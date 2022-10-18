package model;

import controller.PowerupController;
import view.MoonMap;

/**
 * Powerup class, used to handle the logic for powerups
 */
public class Powerups {

    /**
     * Bool for checking if the powerup has been picked up
     */
    public static boolean playerGotHpPwrup = false;
    /**
     * Checks if a player is at the powerup and returns a boolean, true if the player is at the powerup
     * @param player is passed to check if that player is at the powerup
     */
    public static boolean checkIfPlayerGotPowerup(Character player) {
            if(!playerGotHpPwrup && player.getPlayerMovement().getBody().getPosition().x > 400 && player.getPlayerMovement().getBody().getPosition().x < 450){
                if(player.getPlayerMovement().getBody().getPosition().y > 230 && player.getPlayerMovement().getBody().getPosition().y < 250) {
                    return true;
                }
            }
        return false;
    }




}
