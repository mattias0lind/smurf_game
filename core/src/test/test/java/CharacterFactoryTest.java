import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.World;
import model.Character;
import model.CharacterFactory;
import model.CharacterNameCollection;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class CharacterFactoryTest {


    @Test
    public void testNameCollectionListLength() {
        CharacterNameCollection names = new CharacterNameCollection();
        assertTrue(names.getLength() == 4);  // The logical check
    }

    @Test
    public void testNameCollection() {
        CharacterNameCollection names = new CharacterNameCollection();
        assertTrue(names.getCharacter(0) == "smurf");
        assertTrue(names.getCharacter(1) == "evilSmurf");
        assertTrue(names.getCharacter(2) == "lillamy");
        assertTrue(names.getCharacter(3) == "sanic");
    }

    @Test
    public void characterFactoryTest(){
        Vector2 vector2 = new Vector2(0,0);
        World world = new World(vector2,false);
        Character character = new Character("sanic",world,1,vector2);
        CharacterFactory characterFactory = new CharacterFactory();
        characterFactory.getCharacter("smurf",world,vector2);
        characterFactory.getCharacter("evilSmurf",world,vector2);
        characterFactory.getCharacter("lillamy",world,vector2);
        characterFactory.getCharacter("broken",world,vector2);
        character = characterFactory.getCharacter("sanic",world,vector2);

        assertTrue(character.getNameOfCharacter() == "sanic");

    }


}
