package MODEL;

import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.math.Vector2;

public class player_movement implements movement {
    private float playerXPosition;
    private float playerYPosition;
    private static final int gravity = -15;
    private Vector2 position;
    private Vector2 velocity;


    private boolean moveLeft,moveRight,moveUp,moveDown;

    public Vector2 getPlayerPosition(){
        return position;
    }

    public Vector2 getPlayerVelocity(){return velocity;}

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

    /*public Character(int x, int y, String smurf){
        position = new Vector2(x, y);
        velocity = new Vector2(0, 0);
    }*/


    public void update(float dt) {
        velocity.add(0, gravity);
        velocity.scl(dt);
        position.add(0, velocity.y);

        velocity.scl(1 / dt); //dt är står för deltatime alltså har med tidsuppfattning att göra
    }
    public Vector2 getPosition(){
        return position;

    }



    @Override
    public void setPlayerPosition(int playerXPosition, int playerYPosition){
        position = new Vector2(playerXPosition, playerYPosition);
        velocity = new Vector2(0, 0);
    }

    public void updatePlayerPosition() {
        if(moveLeft){
            this.playerXPosition -= 31;
        }
        if(moveRight){
            this.playerXPosition += 31;
        }
        if(moveUp){
            if(velocity.y == 0){
                velocity.y = 250;
            }
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

