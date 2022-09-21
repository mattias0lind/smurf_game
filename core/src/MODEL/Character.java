package MODEL;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Vector2;
//import com.badlogic.gdx.math.Vector3;

public class Character{
    private int currentHealthPoints;
    private int characterXPosition;
    private Vector2 position;
    private Vector2 velocity;


    public Character(int x, int y, String smurf){
        position = new Vector2(x, y);
        velocity = new Vector2(0, 0);
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


