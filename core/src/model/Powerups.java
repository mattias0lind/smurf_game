package model;

/**
 * Powerup class, used to handle the logic for powerups
 */
public class Powerups {

    /**
     * Restores the players HP to full when they pick up the powerup
     * @param player is passed to tell which player got the powerup
     */
    public static void playerGotHpPowerup(Character player) {
        player.restoreHP();
    }

    /**
     * Checks if a player is at the powerup and returns a boolean, true if the player is at the powerup
     * @param player is passed to check which player is at the powerup
     */
    public static boolean checkIfPlayerGotPowerup(Character player) {
            if(player.getPlayerMovement().getBody().getPosition().x > 400 && player.getPlayerMovement().getBody().getPosition().x < 450){
                if(player.getPlayerMovement().getBody().getPosition().y > 230 && player.getPlayerMovement().getBody().getPosition().y < 250) {
                    return true;
                }
            }
        return false;
    }




}
