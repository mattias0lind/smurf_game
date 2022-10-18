import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.World;
import controller.PowerupController;
import model.Character;
import model.Powerups;
import org.junit.Test;


import static org.junit.Assert.assertTrue;

public class PowerUpTest {


    @Test
    public void powerUpTestCorrectPosition(){
        Powerups powerUp = new Powerups();
        Vector2 vector2 = new Vector2(250,250);
        World world = new World(vector2,false);
        Character character = new Character("Test",world,100,vector2);
        character.gotHit(50);
        PowerupController.playerGotHpPowerup(character);
        assertTrue(character.getHpprocent() == 1);
    }

    @Test
    public void powerUpCollisionTest(){
        Powerups powerUp = new Powerups();
        Vector2 vector2 = new Vector2(250,250);
        World world = new World(vector2,false);
        Character character = new Character("Test",world,100,vector2);
        character.gotHit(50);
        PowerupController.playerGotHpPowerup(character);
        assertTrue(character.getHpprocent() == 1);


    }

    @Test
    public void powerUpTestPositionWrongPosition(){
        Powerups powerUp = new Powerups();
        Vector2 vectorWrongPos = new Vector2(0,0);
        World world = new World(vectorWrongPos,false);
        Character character2 = new Character("TestingWrongPos",world,100,vectorWrongPos);
        character2.gotHit(50);
        PowerupController.playerGotHpPowerup(character2);
        assertTrue(character2.getHpprocent() != 1);

    }


}
