package MODEL;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.physics.box2d.World;

public class SmurfCharacter extends Character {
    public Sprite sprite;
    public SmurfCharacter(World world) {
        super("Smurf", world, 100);
    }

}
