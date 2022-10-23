import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.World;
import model.Character;
import org.junit.Test;


import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;


public class CharacterTest {
    @Test
    public void testingCharacterGetters() {
        Vector2 vector = new Vector2(0,0);
        World world = new World(vector,false);
        Character character = new Character("Test",world,100,vector);
        character.getPlayerMovement();
        assertEquals("Test", character.getNameOfCharacter());
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

    @Test
    public void testingCharacterLives() {
        Vector2 vector = new Vector2(0,0);
        World world = new World(vector,false);
        Character character = new Character("Test",world,100,vector);
        character.gotHit(100);
        character.gotHit(100);
        character.gotHit(100);
        character.gotHit(100);
        assertTrue(character.getLives() == 0);

    }

    @Test
    public void testingPunchingGetter() {
        Vector2 vector = new Vector2(0,0);
        World world = new World(vector,false);
        Character character = new Character("Test",world,100,vector);
        character.punching(true);
        assertTrue(character.isPunching());

    }


    @Test
    public void testingPunchingLogicLookingRight() {
    Vector2 vector = new Vector2(0,0);
    Vector2 character1Position = new Vector2(50,50);
    Vector2 character2Position = new Vector2(51,50);
    World world = new World(vector,false);
    Character character1 = new Character("Test",world,100,character1Position);
    Character character2 = new Character("Test",world,100,character2Position);
    character1.punch(character2);
    assertTrue(character2.getHpprocent() != 1 );

    }

    @Test
    public void testingPunchingLogicLookingLeft() {
        Vector2 vector = new Vector2(0,0);
        Vector2 character1Position = new Vector2(50,50);
        Vector2 character2Position = new Vector2(49,50);
        World world = new World(vector,false);
        Character character1 = new Character("Test",world,100,character1Position);
        Character character2 = new Character("Test",world,100,character2Position);
        character1.getPlayerMovement().moveLeft(true);
        character1.punch(character2);
        assertTrue(character2.getHpprocent() != 1 );

    }

    @Test
    public void testJump(){
        Vector2 vector = new Vector2(0,0);
        Vector2 character1Position = new Vector2(0,0);
        World world = new World(vector,false);
        Character character1 = new Character("Test",world,100,character1Position);
        character1.getPlayerMovement().moveUp(true);
        character1.getPlayerMovement().updatePlayerPosition();
        assertTrue(character1.getPlayerMovement().getBody().getPosition() != vector);

    }

    @Test
    public void testMovement(){
        Vector2 vector = new Vector2(0,0);
        Vector2 character1Position = new Vector2(0,0);
        World world = new World(vector,false);
        Character character1 = new Character("Test",world,100,character1Position);
        character1.getPlayerMovement().moveRight(true);
        character1.getPlayerMovement().updatePlayerPosition();
        character1.getPlayerMovement().moveDown(true);
        character1.getPlayerMovement().updatePlayerPosition();
        character1.getPlayerMovement().moveUp(true);
        character1.getPlayerMovement().updatePlayerPosition();
        character1.getPlayerMovement().moveLeft(true);
        character1.getPlayerMovement().updatePlayerPosition();
        assertTrue(character1.getPlayerMovement().isLookingLeft());

    }

}
