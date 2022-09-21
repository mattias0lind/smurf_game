package MODEL;

import CONTROLLER.InputProcessor;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Vector2;
//import com.badlogic.gdx.math.Vector3;

public class Character{
    private int currentHealthPoints;
    private int characterXPosition;
    private player_movement playerMovement = new player_movement();
    private String name;


    public Character(String nameOfCharacter){
        this.name = nameOfCharacter;
    }

    public void SetInitialPosition(int x, int y){
        playerMovement.setPlayerPosition(x,y);
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


