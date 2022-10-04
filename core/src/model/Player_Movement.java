package model;


import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.*;

import java.util.Objects;

public class Player_Movement implements IMovement {

    private final Vector2 position = new Vector2(100, 400);
    private final BodyDef bodyDef = new BodyDef();
    private final Body body;


    private boolean moveLeft, moveRight, moveUp, moveDown;

    public Player_Movement(World world) {
        world = Objects.requireNonNull(world);

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

    public void updatePlayerPosition(){

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

