package model;

public class Powerups {





    public static void collisionAction(Character player) {
        player.restoreHP();
    }

    public static boolean checkIfPlayerGotPowerup(Character player) {
            if(player.getPlayerMovement().getBody().getPosition().x > 400 && player.getPlayerMovement().getBody().getPosition().x < 450){
                if(player.getPlayerMovement().getBody().getPosition().y > 230 && player.getPlayerMovement().getBody().getPosition().y < 250) {
                    return true;
                }
            }
        return false;
    }




}
