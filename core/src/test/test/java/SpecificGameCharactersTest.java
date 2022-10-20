import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.World;

import model.Character;
import org.junit.Test;


import static org.junit.Assert.assertTrue;

public class SpecificGameCharactersTest {

  /*  @Test
    public void testSmurfCharacter() {
        Vector2 position = new Vector2();
        World world = new World(position,false);
        Character smurf = new Character("smurf",world,100,position);
        assertTrue(smurf.getNameOfCharacter() == "Smurf");
    }*/

    @Test
    public void testSanicCharacter() {
        Vector2 position = new Vector2();
        World world = new World(position,false);
        Character sanic = new Character("sanic",world,100 ,position);
        assertTrue(sanic.getNameOfCharacter() == "sanic");
    }

    @Test
    public void testLillayMyCharacter() {
        Vector2 position = new Vector2();
        World world = new World(position,false);
        Character lillamy = new Character("lillamy", world, 100,position);
        assertTrue(lillamy.getNameOfCharacter() == "lillamy");
    }

    @Test
    public void testEvilSmurfCharacter() {
        Vector2 position = new Vector2();
        World world = new World(position,false);
        Character evilsmurf = new Character("evilsmurf",world,100,position);
        assertTrue(evilsmurf.getNameOfCharacter() == "evilsmurf");
    }



}
