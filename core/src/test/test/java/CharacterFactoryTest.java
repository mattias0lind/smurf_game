import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.World;
import model.Character;
import model.CharacterFactory;
import org.testng.annotations.Test;
import static org.junit.Assert.assertTrue;


public class CharacterFactoryTest {


    @Test
    public void testNameCollectionListLength() {
        CharacterFactory names = new CharacterFactory();
        assertTrue(names.getLength() == 4);  // The logical check
    }

    @Test
    public void testNameCollection() {
        CharacterFactory names = new CharacterFactory();
        assertTrue(names.getCharacterName(0) == "smurf");
        assertTrue(names.getCharacterName(1) == "evilSmurf");
        assertTrue(names.getCharacterName(2) == "lillamy");
        assertTrue(names.getCharacterName(3) == "sanic");
    }

    @Test
    public void testGetCharacter() {
        CharacterFactory names = new CharacterFactory();
        Vector2 vector = new Vector2(0,0);
        World world = new World(vector,false);
        Character character =names.getCharacter(0,world,vector);
        assertTrue(character.getNameOfCharacter() == "smurf");
    }



}
