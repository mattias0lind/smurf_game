package MODEL;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Vector3;

public class character{

    private static final int gravity = -15;
    private Vector3 position;
    private Vector3 velocity;
    private Texture characterImage;

    public character(int x, int y){
        position = new Vector3(x, y, 0);
        velocity = new Vector3(0, 0, 0);
        characterImage = new Texture("insert smurf photo here!");
    }
    public void update(float dt){
        velocity.add(0, gravity, 0);
        velocity.scl(dt);
        position.add(0, velocity.y, 0);

        velocity.scl(1/dt); //dt är står för deltatime alltså har med tidsuppfattning att göra
    }
}
