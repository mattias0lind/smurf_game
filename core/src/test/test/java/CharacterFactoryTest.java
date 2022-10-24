import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.World;
import model.Character;
import model.CharacterFactory;
import org.testng.annotations.Test;

import static org.junit.Assert.assertEquals;


public class CharacterFactoryTest {


    @Test
    public void testNameCollectionListLength() {
        CharacterFactory names = new CharacterFactory();
        assertEquals( 4,names.getLength());
    }

    @Test
    public void testNameCollectionForSmurfCharacter() {
        CharacterFactory names = new CharacterFactory();
        assertEquals("smurf",names.getCharacterName(0));

    }

    @Test
    public void testNameCollectionForEvilSmurfCharacter() {
        CharacterFactory names = new CharacterFactory();
        assertEquals("evilSmurf",names.getCharacterName(1));
    }

    @Test
    public void testNameCollectionForLillaMYCharacter() {
        CharacterFactory names = new CharacterFactory();
        assertEquals("lillamy",names.getCharacterName(2));
    }

    @Test
    public void testNameCollectionForSanicCharacter() {
        CharacterFactory names = new CharacterFactory();
        assertEquals("sanic",names.getCharacterName(3));
    }




  @Test
    public void testGetCharacter() {
        CharacterFactory names = new CharacterFactory();
        Vector2 vector = new Vector2(0,0);
        World world = new World(vector,false);
        Character character = names.createCharacter(0, world, vector);
        assertEquals("smurf",character.getNameOfCharacter());
    }



}
