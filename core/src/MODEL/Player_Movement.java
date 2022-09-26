package MODEL;

import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.*;

public class Player_Movement implements IMovement {

    private Vector2 position = new Vector2(0,0);
    private BodyDef bodyDef = new BodyDef();
    private Body body;

    private boolean moveLeft,moveRight,moveUp,moveDown;

    public Player_Movement(World world) {
        this.bodyDef.type = BodyDef.BodyType.DynamicBody;
        bodyDef.position.set(position);
        body = world.createBody(bodyDef);
        FixtureDef fixtureDef = new FixtureDef();
        PolygonShape polygonShape = new PolygonShape();
        polygonShape.setAsBox(16,16);
        fixtureDef.shape = polygonShape;
        body.createFixture(fixtureDef);
    }

    public Vector2 getPlayerPosition(){
        return position;
    }


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

    public Body getBody(){
        return body;
    }





    public void update(float dt) {
        updatePlayerPosition();
    }
    public Vector2 getPosition(){
        return position;

    }



    @Override
    public void setPlayerPosition(int playerXPosition, int playerYPosition){
        position.set(playerXPosition, playerYPosition);
    }

    public void updatePlayerPosition() {
        if(moveLeft){
            this.body.setLinearVelocity(-2,0);
        }
        if(moveRight){
            this.body.setLinearVelocity(2,0);
        }
        if(moveUp){
            if(body.getLinearVelocity().y == 0){
                body.applyLinearImpulse(10,0, position.x, position.y, true);
            }
        }
        if(moveDown){
            this.body.setLinearVelocity(0,-2);
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

