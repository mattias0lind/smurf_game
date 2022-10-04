package controller;


import model.Character;
import model.Player_Movement;
import com.badlogic.gdx.Input;

/**
 * Class for handling Keyboard inputs that controlls the model.
 * Class uses Event handling for processing inputs.
 * */
public class InputProcessor implements com.badlogic.gdx.InputProcessor {
    private final boolean isMovingRight = false;
    private boolean isMovingLeft = false;
    private InputProcessor inputProcessor;
    private Player_Movement player, player2;
    private Character player1_punch, player2_punch;

    public boolean getIsMovingRight() {
        return isMovingRight;
    }

    private boolean ifPlayer1_punched, ifPlayer2_punched;
    private boolean leftPlayer1,rightPlayer1,leftPlayer2,rightPlayer2;

    /**
     * Takes Character 1 and Character 2 and their respective Player_Movement class as parameters
     * which allows controller to update their respective movement.
     * */
    public void movementLogic(Player_Movement player, Player_Movement player2) {
        this.player = player;
        this.player2 = player2;
    }

    /**
     * Takes Character 1 and Character 2 as parameters so their respective punch method can be called when appropriate.
     */
    public void punchLogic(Character player1_punch, Character player2_punch) {
        this.player1_punch = player1_punch;
        this.player2_punch = player2_punch;

    }

    /** Check if player 1 is turned left. */
    public boolean getLeftPlayer1(){
        return leftPlayer1;
    }

    /** Check if player 1 is turned right. */

    public boolean getRightPlayer1(){
     return rightPlayer1;
    }

    /** Check if player 2 is turned left. */
    public boolean getLeftPlayer2(){
        return leftPlayer2;
    }

    /**Check if player 2 is turned right. */
    public boolean getRightPlayer2(){
        return rightPlayer2;
    }


    /** Event handler if key was pressed down.  */
    @Override
    public boolean keyDown(int i) {
        if ((i == Input.Keys.LEFT)) {
            player2.moveLeft(true);
            leftPlayer2 = true;
            rightPlayer2 = false;

        }
        if (i == Input.Keys.RIGHT) {
            player2.moveRight(true);
            rightPlayer2 = true;
            leftPlayer2 = false;
        }
        if (i == Input.Keys.UP) {
            player2.moveUp(true);
        }
        if (i == Input.Keys.DOWN) {player2.moveDown(true);}

        if ((i == Input.Keys.A)) {
            player.moveLeft(true);
            isMovingLeft = true;
            rightPlayer1 = false;
            leftPlayer1 = true;
        }
        if (i == Input.Keys.D) {
            player.moveRight(true);
            leftPlayer1 = false;
            rightPlayer1 = true;
        }
        if (i == Input.Keys.W) {player.moveUp(true);}
        if (i == Input.Keys.S) {player.moveDown(true);}

        if (i == Input.Keys.F) {
            player1_punch.punch(player2_punch);
            ifPlayer1_punched = true;

        }

        if (i == Input.Keys.M) {
            player2_punch.punch(player1_punch);
            ifPlayer2_punched = true;

        }
        return true;
    }


    /** Event handler to check if the pressed down key is now up. */
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
            ifPlayer1_punched = false;

        }


        if (i == Input.Keys.A) {
            //player.getBody().setLinearVelocity(0, player.getBody().getLinearVelocity().y);
            isMovingLeft = false;
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
            ifPlayer2_punched = false;
        }
        return true;
    }

    /** Checks if player 1 pressed the F key.
     * F key in keyDown sets this boolean to true.
     * F key in keyUp sets this boolean to false.*/
    public boolean isIfPlayer1_punched() {
        return ifPlayer1_punched;
    }

    /** Checks if player 2 pressed the M key.
     * F key in keyDown sets this boolean to true.
     * F key in keyUp sets this boolean to false.*/
    public boolean isIfPlayer2_punched() {
        return ifPlayer2_punched;
    }

    @Override
    public boolean keyTyped(char c) {
        return false;
    }

    @Override
    public boolean touchDown(int i, int i1, int i2, int i3) {
        return false;
    }

    @Override
    public boolean touchUp(int i, int i1, int i2, int i3) {
        return false;
    }

    @Override
    public boolean touchDragged(int i, int i1, int i2) {
        return false;
    }

    @Override
    public boolean mouseMoved(int i, int i1) {
        return false;
    }

    @Override
    public boolean scrolled(float v, float v1) {
        return false;
    }
}
