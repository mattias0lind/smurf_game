package MODEL;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Vector2;
//import com.badlogic.gdx.math.Vector3;

public class character{

    private int gravity = -15; //tog bort final ifall man i framtiden vill göra en power-up som förändrar gravitation.
    private Vector2 position; // kanske inte ens bör vara i karaktär klassen.
    private Vector2 velocity;
    private Texture characterImage;

    public character(int x, int y){
        position = new Vector2(x, y);
        velocity = new Vector2(0, 0);
        this.characterImage = characterImage;
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
}
