package model;


import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.Body;
import com.badlogic.gdx.physics.box2d.BodyDef;
import com.badlogic.gdx.physics.box2d.FixtureDef;
import com.badlogic.gdx.physics.box2d.World;
import com.badlogic.gdx.physics.box2d.PolygonShape;


public class PlayerMovement implements IMovement {

    private final Body body;


    private boolean moveLeft, moveRight, moveUp, moveDown, lookingLeft;

    public PlayerMovement(World world, Vector2 startPosition) {

        BodyDef bodyDef = new BodyDef();
        bodyDef.type = BodyDef.BodyType.DynamicBody;
        bodyDef.position.set(startPosition);
        bodyDef.linearDamping = 1.0f;
        body = world.createBody(bodyDef);
        FixtureDef fixtureDef = new FixtureDef();
        PolygonShape polygonShape = new PolygonShape();
        polygonShape.setAsBox(16, 28);

        fixtureDef.shape = polygonShape;
        body.createFixture(fixtureDef);
    }


    public Body getBody() {
        return body;
    }



    @Override
    public void setPlayerPosition(float playerXPosition, float playerYPosition) {
        this.body.setLinearVelocity(playerXPosition, playerYPosition);
    }

    public void updatePlayerPosition() {
        if (moveLeft) {
            if (body.getLinearVelocity().x >= -100) {
                this.body.applyForceToCenter(-100, 0, true);
            }
        }
        if (moveRight) {
            if (body.getLinearVelocity().x <= 100) {
                this.body.applyForceToCenter(100, 0, true);
            }
        }
        if (moveUp) {
            if (body.getLinearVelocity().y == 0) {
                body.applyLinearImpulse(0, 10000000, 0, 0, true);
            }
        }
        if (moveDown) {
            this.body.setLinearVelocity(body.getLinearVelocity().x, -200);
        }

    }
    //TODO glöm inte ta bort view saker från här bara för debugging
    public void moveLeft(boolean t) {
        moveLeft = t;
        lookingLeft = true;

    }

    public void moveRight(boolean t) {
        moveRight = t;
        lookingLeft = false;

    }

    public void moveUp(boolean t) {
        moveUp = t;

    }

    public void moveDown(boolean t) {
        moveDown = t;

    }

    public boolean getMoveRight() {
        return moveRight;
    }

    public boolean getMoveLeft() {
        return moveLeft;
    }
    public boolean getlookingLeft() {
        return lookingLeft;
    }


}

