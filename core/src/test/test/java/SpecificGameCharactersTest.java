import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.World;

import model.EvilSmurfCharacter;
import model.LillaMyCharacter;
import model.SanicCharacter;
import model.SmurfCharacter;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class SpecificGameCharactersTest {

    @Test
    public void testSmurfCharacter() {
        Vector2 position = new Vector2();
        World world = new World(position,false);
        SmurfCharacter smurf = new SmurfCharacter(world,position);
        assertTrue(smurf.getNameOfCharacter() == "Smurf");
    }

    @Test
    public void testSanicCharacter() {
        Vector2 position = new Vector2();
        World world = new World(position,false);
        SanicCharacter sanic = new SanicCharacter(world,position);
        assertTrue(sanic.getNameOfCharacter() == "sanic");
    }

    @Test
    public void testLillayMyCharacter() {
        Vector2 position = new Vector2();
        World world = new World(position,false);
        LillaMyCharacter lillamy = new LillaMyCharacter(world,position);
        assertTrue(lillamy.getNameOfCharacter() == "lillamy");
    }

    @Test
    public void testEvilSmurfCharacter() {
        Vector2 position = new Vector2();
        World world = new World(position,false);
        EvilSmurfCharacter evilsmurf = new EvilSmurfCharacter(world,position);
        assertTrue(evilsmurf.getNameOfCharacter() == "evilsmurf");
    }



}
