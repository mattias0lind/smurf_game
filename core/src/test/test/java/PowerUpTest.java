import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.World;
import model.Character;
import model.Powerups;
import org.junit.Test;


import static org.junit.Assert.assertTrue;

public class PowerUpTest {
    @Test
    public void powerUpTest(){
        Powerups powerUp = new Powerups("Test");
        Vector2 vector2 = new Vector2(250,250);
        Vector2 vectorWrongPos = new Vector2(0,0);
        World world = new World(vector2,false);
        Character character = new Character("Test",world,1,vector2);
        Character character2 = new Character("TestingWrongPos",world,1,vectorWrongPos);
        powerUp.CollisionAction(character);
        powerUp.CollisionAction(character2);
        assertTrue(powerUp.getName() == "Test");
    }

}
