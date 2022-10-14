import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.World;
import model.Character;
import org.junit.Test;


import static org.junit.Assert.assertTrue;


public class CharacterTest {
    @Test
    public void testingCharacterGetters() {
        Vector2 vector = new Vector2(0,0);
        World world = new World(vector,false);
        Character character = new Character("Test",world,100,vector);
        character.getPlayerMovement();



        assertTrue(character.getNameOfCharacter() == "Test");  // The logical check
    }

    @Test
    public void testingHP() {
        Vector2 vector = new Vector2(0,0);
        World world = new World(vector,false);
        Character character = new Character("Test",world,100,vector);
        character.gotHit(50);
        character.restoreHP();
        assertTrue(character.getHpprocent() == 1 );


    }

}
