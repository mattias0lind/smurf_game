package controller;

import com.badlogic.gdx.Input;
import model.Character;
import model.PlayerMovement;

public class GameController extends controller.InputProcessor {
    private PlayerMovement player, player2;
    private Character player1_punch, player2_punch;


    public void movementLogic(PlayerMovement player, PlayerMovement player2) {
        this.player = player;
        this.player2 = player2;
    }


    public void punchLogic(Character player1_punch, Character player2_punch) {
        this.player1_punch = player1_punch;
        this.player2_punch = player2_punch;

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
            player1_punch.punch(player2_punch);
            player1_punch.punching(true);

        }

        if (i == Input.Keys.M) {
            player2_punch.punch(player1_punch);
            player2_punch.punching(true);


        }
        return true;
    }



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
            player1_punch.punching(false);

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

            player2_punch.punching(false);
        }
        return true;
    }
}
