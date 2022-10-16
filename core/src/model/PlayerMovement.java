package model;


import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.Body;
import com.badlogic.gdx.physics.box2d.BodyDef;
import com.badlogic.gdx.physics.box2d.FixtureDef;
import com.badlogic.gdx.physics.box2d.World;
import com.badlogic.gdx.physics.box2d.PolygonShape;


/**
 * Class for initialising physics and handle movement for character
 */
public class PlayerMovement {

    private final Body body;

    private boolean moveLeft, moveRight, moveUp, moveDown, lookingLeft;

    /**constructor for creating movement and physics for character.
     *
     * @param world passed as parameter to initialize body in world, box2d
     * @param startPosition initalises starting position in world
     */
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


    /**
     * @return return box2d body. used to modify its physical properties
     */
    public Body getBody() {
        return body;
    }


    /**
     * modifies position of body, calls on every step of game and decided by controller
     */
    public void updatePlayerPosition() {
        float speed = 100;
        if (moveLeft) {
            if (body.getLinearVelocity().x >= -speed) {
                this.body.applyForceToCenter(-100, 0, true);
            }
        }
        if (moveRight) {
            if (body.getLinearVelocity().x <= speed) {
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

    /**
     * @param t sets moveleft to t. decides movement from controller
     */
    public void moveLeft(boolean t) {
        moveLeft = t;
        lookingLeft = true;

    }

    /**
     * @param t sets moveleft to t. decides movement from controller
     */
    public void moveRight(boolean t) {
        moveRight = t;
        lookingLeft = false;

    }

    /**
     * @param t sets moveleft to t. decides movement from controller
     */
    public void moveUp(boolean t) {
        moveUp = t;

    }

    /**
     * @param t sets moveleft to t. decides movement from controller
     */
    public void moveDown(boolean t) {
        moveDown = t;

    }

    /** used in punching to decide where to punch
     * @return returns state of right movement
     */
    public boolean isMovingRight() {
        return moveRight;
    }

    /**used in punching to decide where to punch
     * @return returns state of left movement
     */
    public boolean isMovingLeft() {
        return moveLeft;
    }

    /** helps in drawing direction of texture
     * @return state of looking
     */
    public boolean isLookingLeft() {
        return lookingLeft;
    }


}

