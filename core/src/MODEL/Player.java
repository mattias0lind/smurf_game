package MODEL;

public class Player {
    private HealthBar healthBar;


    public Player() { //konstruktorn

    }


    private int playerXPosition;

    public int getPlayerXPosition() {
        return playerXPosition;
    }

    private int playerYPosition;

    public int getPlayerYPosition() {
        return playerYPosition;
    }

    private boolean isAlive;

    private int currentHealthPoints;

    public void gotHit() {
        /*Later add what type of hit it was */
        /*Assume hit = -10hp
        * Highlight the hit graphically
        * */
        currentHealthPoints = currentHealthPoints - 10;
        checkIfStillAlive();
    }

    private void checkIfStillAlive() {
        if (currentHealthPoints <= 0) {
            /* If not alive then update HealthBar
            Reset the game round
             */
        }
    }

}
