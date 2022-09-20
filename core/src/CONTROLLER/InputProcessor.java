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

    public void setSprite(Sprite sprite) {
        this.sprite = sprite;
    }

    public boolean getIsMovingRight(){
        return isMovingRight;
    }



    @Override
    public boolean keyDown(int i) {
        if((i == Input.Keys.A)){
            player.updatePlayerPosition();
        }else if(i == Input.Keys.D){
            sprite.translateX(5f);
        }
        else if(i == Input.Keys.W){
            sprite.translateY(5f);
            return true;
        }
        else if(i == Input.Keys.S){
            sprite.translateY(-5f);
            return true;
        }
        return false;
    }

    @Override
    public boolean keyUp(int i) {
        if(i == Input.Keys.A){
            isMovingRight = false;
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
