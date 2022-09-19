package test;
import MODEL.movement;
import MODEL.player_movement;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class movementTesting {
    @Test
    public void testStartingPlayerPosition(){
        player_movement player = new player_movement();
        player.updatePlayerPosition(1,1);
        assertTrue(player.getPlayerXPosition()+player.getPlayerYPosition() == 2);
    }

}
