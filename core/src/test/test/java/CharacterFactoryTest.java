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


}
