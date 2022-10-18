package controller;

import com.badlogic.gdx.Input;
import model.Character;
import model.PlayerMovement;

/**
 * Class used to check for player input
 */
public class GameController extends InputProcessor {
    private PlayerMovement player1Movement, player2Movement;
    private Character player1, player2;


    /**
     * Method used to to set class attributes using players movement
     * @param player1Movement Player 1 movement
     * @param player2Movement Player 2 movement
     */
    public void movementLogic(PlayerMovement player1Movement, PlayerMovement player2Movement) {
        this.player1Movement = player1Movement;
        this.player2Movement = player2Movement;
    }


    /**
     * Method used to set class attributes using players punching
     * @param player1 Player 1 punching
     * @param player2 Player 2 punching
     */
    public void punchLogic(Character player1, Character player2) {
        this.player1 = player1;
        this.player2 = player2;

    }



    /** Event handler if key was pressed down.  */
    @Override
    public boolean keyDown(int i) {
        if ((i == Input.Keys.LEFT)) {
            player2Movement.moveLeft(true);


        }
        if (i == Input.Keys.RIGHT) {
            player2Movement.moveRight(true);
        }
        if (i == Input.Keys.UP) {
            player2Movement.moveUp(true);
        }
        if (i == Input.Keys.DOWN) {player2Movement.moveDown(true);}

        if ((i == Input.Keys.A)) {
            player1Movement.moveLeft(true);


        }
        if (i == Input.Keys.D) {
            player1Movement.moveRight(true);

        }
        if (i == Input.Keys.W) {player1Movement.moveUp(true);}
        if (i == Input.Keys.S) {player1Movement.moveDown(true);}

        if (i == Input.Keys.F) {
            player1.punch(player2);
            player1.punching(true);

        }

        if (i == Input.Keys.M) {
            player2.punch(player1);
            player2.punching(true);


        }
        return true;
    }


    /** Event handler if key is not pressed down.  */
    @Override
    public boolean keyUp(int i) {
        if ((i == Input.Keys.LEFT)) {
            player2Movement.moveLeft(false);
        }if (i == Input.Keys.RIGHT) {
            player2Movement.moveRight(false);
        }if (i == Input.Keys.UP) {
            player2Movement.moveUp(false);
        }if (i == Input.Keys.DOWN) {
            player2Movement.moveDown(false);
        }
        if (i == Input.Keys.F) {
            player1.punching(false);

        }


        if (i == Input.Keys.A) {


            player1Movement.moveLeft(false);

        }if (i == Input.Keys.D) {
            player1Movement.moveRight(false);
        }
        if(i == Input.Keys.W){
            player1Movement.moveUp(false);
        }if (i == Input.Keys.S) {
            player1Movement.moveDown(false);
        }
        if (i == Input.Keys.M) {

            player2.punching(false);
        }
        return true;
    }
}
