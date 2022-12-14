import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.World;
import model.Character;
import model.Powerups;
import org.junit.Test;

import static org.junit.Assert.*;

public class PowerUpTest {


    @Test
    public void powerUpIfAlreadyUsedTest(){
        Powerups powerUp = new Powerups();
        Vector2 vector2 = new Vector2(420,240);
        World world = new World(vector2,false);
        Character character = new Character("Test",world,100,vector2);
        character.gotHit(50);
        powerUp.checkIfPlayerGotPowerup(character);
        assertFalse(powerUp.getIsPowerUpActive());
    }

    @Test
    public void powerUpCollisionTest(){
        Powerups powerUp = new Powerups();
        Vector2 vector2 = new Vector2(420,240);
        World world = new World(vector2,false);
        Character character = new Character("Test",world,100,vector2);
        character.gotHit(50);
        powerUp.checkIfPlayerGotPowerup(character);
        assertEquals(1,character.getHpprocent(),0);


    }

    @Test
    public void powerUpTestPositionWrongPosition(){
        Powerups powerUp = new Powerups();
        Vector2 vectorWrongPos = new Vector2(0,0);
        World world = new World(vectorWrongPos,false);
        Character character2 = new Character("TestingWrongPos",world,100,vectorWrongPos);
        character2.gotHit(50);
        powerUp.checkIfPlayerGotPowerup(character2);
        assertEquals(0.5,character2.getHpprocent(),0);

    }


}
