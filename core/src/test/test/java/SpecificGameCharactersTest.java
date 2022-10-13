import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.World;

import model.SmurfCharacter;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class SpecificGameCharactersTest {
    @Test
    public void testSmurfCharacter() {
        Vector2 position = new Vector2();
        World world = new World(position,false);
        SmurfCharacter smurf = new SmurfCharacter(world,position);
        assertTrue(smurf.charactersCurrentDirection() == false);  // The logical check
    }


}
