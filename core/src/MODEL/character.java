package MODEL;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Vector2;
//import com.badlogic.gdx.math.Vector3;

public class character{

    private static final int gravity = -15; //tog bort final ifall man i framtiden vill göra en power-up som förändrar gravitation.
    private Vector2 position; // "gravity" kanske inte ens bör vara i karaktär klassen.
    private Vector2 velocity;
    private Texture characterImage;

    private int currentHealthPoints;

    private int characterXPosition;
    public int getCharacterXPosition() {
        return characterXPosition;
    }
    private int characterYPosition;
    public int getCharacterYPosition() {
        return characterYPosition;
    }

    public character(int x, int y){
        position = new Vector2(x, y);
        velocity = new Vector2(0, 0);
        characterImage = new Texture("smurf.png");
    }
    public void update(float dt) {
        velocity.add(0, gravity);
        velocity.scl(dt);
        position.add(0, velocity.y);

        velocity.scl(1 / dt); //dt är står för deltatime alltså har med tidsuppfattning att göra
    }
    public Vector2 getPosition(){
        return position;

    }

    public Texture getCharacterImage(){
        return characterImage;
        }
    public void jump(){
        if(velocity.y == 0){//man kan enbart hoppa om man står på marken
        velocity.y = 250;
        }
    }

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
