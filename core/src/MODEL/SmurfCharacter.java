package MODEL;
import MODEL.CharacterREAL;
import com.badlogic.gdx.physics.box2d.World;

public class SmurfCharacter extends CharacterREAL {
    public SmurfCharacter(World world) {
        super("Smurf", world, 100);
    }
}
