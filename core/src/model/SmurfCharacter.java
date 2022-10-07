package model;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.World;

/**
 * The class SmurfCharacter is used to declare values such as name and health points to the Smurf character
 */
public class SmurfCharacter extends Character {
    private Vector2 position;
    public SmurfCharacter(World world, Vector2 position) {
        super("Smurf", world, 100, position);
    }

}
