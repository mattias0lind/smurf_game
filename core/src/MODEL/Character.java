package MODEL;

import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.World;


public class Character{
    private int currentHealthPoints;
    private int characterXPosition;
    private player_movement playerMovement;
    private String name;



    public Character(String nameOfCharacter, World world)
    {
        this.name = nameOfCharacter;
        this.playerMovement = new player_movement(world);
    }

    public void SetInitialPosition(int x, int y){
        playerMovement.setPlayerPosition(x,y);
    }

    public Vector2 getPosition(){
       return playerMovement.getPlayerPosition();
    }


    public void gotHit() {
        //Later add what type of hit it was//
        /*Assume hit = -10hp
         * Highlight the hit graphically
         * /
        currentHealthPoints = currentHealthPoints - 10;
        checkIfStillAlive();
    }

    private void checkIfStillAlive() {
        if (currentHealthPoints <= 0) {
            / If not alive then update HealthBar
            Reset the game round
             */
    }
}


