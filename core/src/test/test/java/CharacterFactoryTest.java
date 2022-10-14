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
    public void characterFactoryTest(){
        Vector2 vector2 = new Vector2(0,0);
        World world = new World(vector2,false);
        Character character = new Character("sanic",world,1,vector2);
        CharacterFactory characterFactory = new CharacterFactory();
        characterFactory.getCharacter(0,world,vector2);
        characterFactory.getCharacter(1,world,vector2);
        characterFactory.getCharacter(2,world,vector2);
        characterFactory.getCharacter(3,world,vector2);
        character = characterFactory.getCharacter(0,world,vector2);

        assertTrue(character.getNameOfCharacter() == "sanic");

    }


}
