package test;
import MODEL.Character;
import MODEL.movement;
import MODEL.player_movement;
import com.badlogic.gdx.math.Vector2;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class movementTesting {
    @Test
    public void testStartingPlayerPosition(){
        Character player = new Character("Smurf");
        player.SetInitialPosition(200,200);
        Vector2 vector = player.getPosition();
        assertTrue(vector.x == 200);
        assertTrue(vector.y == 200);

    }

}
