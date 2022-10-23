package controller;

import model.Character;
import model.Powerups;

/**
 * Controller used to notify the Model class Powerups about any changes
 */
public class PowerupController {
    private Powerups powerUp = new Powerups();
    /**
     * Restores the players HP to full when they pick up the powerup
     * @param player is passed to tell which player got the powerup
     */

    public void checkIfPlayerGotPowerup(Character player) {
        powerUp.checkIfPlayerGotPowerup(player);
    }

    public boolean checkIfPowerUpIsStillActive(){
        return powerUp.getIsPowerUpActive();
    }
}
