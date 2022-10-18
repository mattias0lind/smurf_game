package controller;

import model.Character;
import model.Powerups;

/**
 * Controller used to notify the Model class Powerups about any changes
 */
public class PowerupController {
    /**
     * Restores the players HP to full when they pick up the powerup
     * @param player is passed to tell which player got the powerup
     */
    public static void playerGotHpPowerup(Character player) {
        Powerups.playerGotHpPwrup = true;
        player.restoreHP();
    }

}
