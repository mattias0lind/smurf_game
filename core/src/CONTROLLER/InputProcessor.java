package CONTROLLER;


import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.mygdx.game.MyGdxGame;

/*Hanterar inputs */
public class InputProcessor implements com.badlogic.gdx.InputProcessor {
    private Sprite sprite;
    private boolean movingRight = false;

    public void setSprite(Sprite sprite) {
        this.sprite = sprite;
    }

    @Override
    public boolean keyDown(int i) {
        if(i == Input.Keys.A){
            sprite.translateX(-1f);
            return true;
        }else if(i == Input.Keys.D){
            sprite.translateX(1f);
        }
        else if(i == Input.Keys.W){
            sprite.translateY(1f);
        }
        else if(i == Input.Keys.S){
            sprite.translateY(-1f);
        }


        return false;
    }

    @Override
    public boolean keyUp(int i) {
        if(i == Input.Keys.D){
            sprite.translateX(0);
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
