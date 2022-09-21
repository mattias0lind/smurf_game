package MODEL;

import com.badlogic.gdx.graphics.g2d.Sprite;

public class player_movement implements movement {
    private float playerXPosition;
    private float playerYPosition;
    private boolean moveLeft,moveRight,moveUp,moveDown;

    public float getPlayerXPosition(){
        return playerXPosition;
    }

    public float getPlayerYPosition(){return playerYPosition;}

    public boolean getmoveLeft(){
        return moveLeft;
    }


    public boolean getmoveRight(){
        return moveRight;
    }

    public boolean getmoveDown(){
        return moveDown;
    }

    public boolean getmoveUp(){
        return moveUp;
    }



    @Override
    public void setPlayerPosition(int playerXPosition, int playerYPosition){
        this.playerXPosition = playerXPosition;
        this.playerYPosition = playerYPosition;
    }

    public void updatePlayerPosition() {
        if(moveLeft){
            this.playerXPosition -= 31;
        }
        if(moveRight){
            this.playerXPosition += 31;
        }
        if(moveUp){
            this.playerYPosition += 31;
        }
        if(moveDown){
            this.playerYPosition -=31;
        }

    }

    //TODO glöm inte ta bort view saker från här bara för debugging
    public void moveLeft(boolean t){
        if(t){
            moveLeft = true;
        }else{
            moveLeft = false;
        }

    }

    public void moveRight(boolean t){
        if(t){
            moveRight = true;
        }else{
            moveRight = false;
        }

    }

    public void moveUp(boolean t){
        if(t){
            moveUp = true;
        }else{
            moveUp = false;
        }

    }

    public void moveDown(boolean t){
        if(t){
            moveDown = true;
        }else{
            moveDown = false;
        }

    }



}

