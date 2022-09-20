package CONTROLLER;


import MODEL.player_movement;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.g2d.Sprite;

/*Hanterar inputs */
public class InputProcessor implements com.badlogic.gdx.InputProcessor {
    private Sprite sprite;
    private boolean isMovingRight = false;
    private InputProcessor inputProcessor;
    private player_movement player;
    public boolean getIsMovingRight(){
        return isMovingRight;
    }


    public void logic(player_movement player){
        this.player = player;
    }

    @Override
    public boolean keyDown(int i) {
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
