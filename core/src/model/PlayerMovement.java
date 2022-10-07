package model;


import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.*;

import java.util.Objects;

public class PlayerMovement implements IMovement {

    private Vector2 position;
    private final BodyDef bodyDef = new BodyDef();
    private final Body body;


    private boolean moveLeft, moveRight, moveUp, moveDown;

    public PlayerMovement(World world, Vector2 position) {
        world = Objects.requireNonNull(world);

        this.position = position;
        this.bodyDef.type = BodyDef.BodyType.DynamicBody;
        bodyDef.position.set(position);
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
                body.applyLinearImpulse(0, 10000000, position.x, position.y, true);
            }
        }
        if (moveDown) {
            this.body.setLinearVelocity(body.getLinearVelocity().x, -200);
        }

    }
    //TODO glöm inte ta bort view saker från här bara för debugging
    public void moveLeft(boolean t) {
        moveLeft = t;

    }

    public void moveRight(boolean t) {
        moveRight = t;

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


}
