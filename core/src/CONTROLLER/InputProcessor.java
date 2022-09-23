package CONTROLLER;


import MODEL.Player_Movement;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.g2d.Sprite;

/*Hanterar inputs */
public class InputProcessor implements com.badlogic.gdx.InputProcessor {
    private Sprite sprite;
    private boolean isMovingRight = false;
    private InputProcessor inputProcessor;
    private Player_Movement player,player2;
    public boolean getIsMovingRight(){
        return isMovingRight;
    }


    public void logic(Player_Movement player, Player_Movement player2){
        this.player = player;
        this.player2 = player2;
    }

    @Override
    public boolean keyDown(int i) {
        if((i == Input.Keys.LEFT)){
            player2.moveLeft(true);
        }else if(i == Input.Keys.RIGHT){
            player2.moveRight(true);
        }
        else if(i == Input.Keys.UP){
            player2.moveUp(true);
        }
        else if(i == Input.Keys.DOWN){
            player2.moveDown(true);
        }

        if((i == Input.Keys.A)){
            player.moveLeft(true);
        }else if(i == Input.Keys.D){
            player.moveRight(true);
        }
        else if(i == Input.Keys.W){
            player.moveUp(true);
        }
        else if(i == Input.Keys.S){
            player.moveDown(true);
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
        return false;
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
