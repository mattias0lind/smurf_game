package MODEL;

public class Attack {
    private int HP;
    //private final int maxHP;
    private int StandardAttackDamage = 10;
    private boolean isAlive;

    public void doHit(Player currentPlayer) {
        Player enemyPlayer;
        for(int x=-1; x<2; x++ ) {
            for(int y=-1; y<2; y++){
                if(x==0 && y==0){
                    continue;
                }
                enemyPlayer = getPlayerAt(currentPlayer.getPlayerXPosition()+x, currentPlayer.getPlayerYPosition()+y);
                if(enemyPlayer != null){
                    enemyPlayer.gotHit();
                }
            }
        }

    }

    private Player getPlayerAt(int x, int y) {
        return null;
        //To be implemented in the gameboard class//
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


    /*public HealthBar (int HP) {
        this.HP = HP;
        this.maxHP = HP;
        this.isAlive = true;
    }*/



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
