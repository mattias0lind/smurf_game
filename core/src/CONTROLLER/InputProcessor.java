package CONTROLLER;


import MODEL.CharacterREAL;
import MODEL.Player_Movement;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.g2d.Sprite;

/*Hanterar inputs */
public class InputProcessor implements com.badlogic.gdx.InputProcessor {
    private Sprite sprite;
    private boolean isMovingRight = false;
    private InputProcessor inputProcessor;
    private Player_Movement player,player2;
    private CharacterREAL player1_punch,player2_punch;
    public boolean getIsMovingRight(){
        return isMovingRight;
    }
    private boolean ifPlayer1_punched,ifPlayer2_punched;

    public void logic(Player_Movement player, Player_Movement player2){
        this.player = player;
        this.player2 = player2;
    }

    public void punchLogic(CharacterREAL player1_punch, CharacterREAL player2_punch){
        this.player1_punch = player1_punch;
        this.player2_punch = player2_punch;

    }

    @Override
    public boolean keyDown(int i) {
        ifPlayer1_punched = false;
        if((i == Input.Keys.LEFT)){
            player2.getBody().setLinearVelocity(-20,player2.getBody().getLinearVelocity().y);
        }
        if(i == Input.Keys.RIGHT){
            player2.getBody().setLinearVelocity(20,player2.getBody().getLinearVelocity().y);
        }
        if(i == Input.Keys.UP){
            if (player2.getBody().getLinearVelocity().y == 0){
                player2.getBody().applyLinearImpulse(0, 80f, player2.getBody().getPosition().x, player2.getBody().getPosition().y, true);
            }
        }
        if(i == Input.Keys.DOWN){
            player2.getBody().setLinearVelocity(0,-20);
        }

        if((i == Input.Keys.A)){
            player.getBody().setLinearVelocity(-20,player.getBody().getLinearVelocity().y);
        }
        if(i == Input.Keys.D){
            player.getBody().setLinearVelocity(20,player.getBody().getLinearVelocity().y);
        }
        if(i == Input.Keys.W){
            if (player.getBody().getLinearVelocity().y == 0){
                player.getBody().applyLinearImpulse(0, 80f, player2.getBody().getPosition().x, player2.getBody().getPosition().y, true);
            }
        }
        if(i == Input.Keys.S){
            player.getBody().setLinearVelocity(0,-20);
        }

        if(i == Input.Keys.F){
            player1_punch.punch(player2_punch);
            ifPlayer1_punched = true;

        }

        if(i == Input.Keys.M){
            player2_punch.punch(player1_punch);
            ifPlayer2_punched = true;

        }
        return false;
    }

    @Override
    public boolean keyUp(int i) {
        if((i == Input.Keys.LEFT)){
            player2.moveLeft(false);
        }else if(i == Input.Keys.RIGHT){
            player2.moveRight(false);
        }
        else if(i == Input.Keys.UP){
            player2.moveUp(false);
        }
        else if(i == Input.Keys.DOWN){
            player2.moveDown(false);
        }
        if(i == Input.Keys.F){
            ifPlayer1_punched = false;

        }



        if(i == Input.Keys.A){
            player.moveLeft(false);
        }else if(i == Input.Keys.D){
            player.moveRight(false);
        }
        else if(i == Input.Keys.W){
            player.moveUp(false);
        }
        else if(i == Input.Keys.S){
            player.moveDown(false);
        }
        if(i == Input.Keys.M){
            ifPlayer2_punched = false;

        }
        return false;
    }

    public boolean isIfPlayer1_punched() {
        return ifPlayer1_punched;
    }

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
