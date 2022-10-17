package controller;

import com.badlogic.gdx.Input;
import model.Character;
import model.PlayerMovement;

/**
 * Class used to check for player input
 */
public class GameController extends InputProcessor {
    private PlayerMovement player, player2;
    private Character player1Punch, player2Punch;


    /**
     * Method used to to set class attributes using players movement
     * @param player1 Player 1 movement
     * @param player2 Player 2 movement
     */
    public void movementLogic(PlayerMovement player1, PlayerMovement player2) {
        this.player = player1;
        this.player2 = player2;
    }


    /**
     * Method used to set class attributes using players punching
     * @param player1Punch Player 1 punching
     * @param player2Punch Player 2 punching
     */
    public void punchLogic(Character player1Punch, Character player2Punch) {
        this.player1Punch = player1Punch;
        this.player2Punch = player2Punch;

    }



    /** Event handler if key was pressed down.  */
    @Override
    public boolean keyDown(int i) {
        if ((i == Input.Keys.LEFT)) {
            player2.moveLeft(true);


        }
        if (i == Input.Keys.RIGHT) {
            player2.moveRight(true);
        }
        if (i == Input.Keys.UP) {
            player2.moveUp(true);
        }
        if (i == Input.Keys.DOWN) {player2.moveDown(true);}

        if ((i == Input.Keys.A)) {
            player.moveLeft(true);


        }
        if (i == Input.Keys.D) {
            player.moveRight(true);

        }
        if (i == Input.Keys.W) {player.moveUp(true);}
        if (i == Input.Keys.S) {player.moveDown(true);}

        if (i == Input.Keys.F) {
            player1Punch.punch(player2Punch);
            player1Punch.punching(true);

        }

        if (i == Input.Keys.M) {
            player2Punch.punch(player1Punch);
            player2Punch.punching(true);


        }
        return true;
    }


    /** Event handler if key is not pressed down.  */
    @Override
    public boolean keyUp(int i) {
        if ((i == Input.Keys.LEFT)) {
            player2.moveLeft(false);
        }if (i == Input.Keys.RIGHT) {
            player2.moveRight(false);
        }if (i == Input.Keys.UP) {
            player2.moveUp(false);
        }if (i == Input.Keys.DOWN) {
            player2.moveDown(false);
        }
        if (i == Input.Keys.F) {
            player1Punch.punching(false);

        }


        if (i == Input.Keys.A) {


            player.moveLeft(false);

        }if (i == Input.Keys.D) {
            player.moveRight(false);
        }
        if(i == Input.Keys.W){
            player.moveUp(false);
        }if (i == Input.Keys.S) {
            player.moveDown(false);
        }
        if (i == Input.Keys.M) {

            player2Punch.punching(false);
        }
        return true;
    }
}
