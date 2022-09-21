package MODEL;

public class Attack {
    private int HP;
    private final int maxHP;
    private int StandardAttackDamage = 10;
    private boolean isAlive;

    private int playerCordX;

    private int playerCordY;

    public void doHit(Player currentPlayer){
        /*
        Assume there is a maximum of one enemy player around
        Check the positions left, right, up and down
         */
        Player enemyPlayer;
        for (int x=-1; x<2; x++) {
            for (int y=-1; y<2; y++) {
                if (x==0 && y==0) {
                    continue;
                }
                enemyPlayer = getPlayerAt(playerCordX + x, playerCordY + y);
                if(enemyPlayer != null) {
                    enemyPlayer.gotHit();
                }
            }
        }
    }

    /*
    Method to be later implemented in the the class called "Gameboard", not here
     */
    private Player getPlayerAt(int x, int y) {
        return null;
        /*
        To be implemented, check if there is a player at x,y coordinates
         */

    }

    /*
    Implement a method called isAlive that checks hp of player

    Call the method punch(), if there is no enemy around only the Graphics will be initiated

    When the method punch() is called, check if there are nearby enemies that can be damaged

    If there are enemies around, decrease their health based on the attack received and in the Graphics
    highlight the punch


    Create a method called beingHit(), decrease health points and then check if still alive. If not
    alive then reset the round and award 1 point to the winning player

     */

    public void takeDamage (){
        HP = HP-StandardAttackDamage;
        if (HP < 0)
            isAlive = false;
    }


    private void attack() {


    }




    /*
    Lägg till riktning på spelaren
    Position
    Kolla om den lever
    Hur attackerar man?
     */
}
