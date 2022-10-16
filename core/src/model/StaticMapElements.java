package model;

import com.badlogic.gdx.physics.box2d.FixtureDef;
import com.badlogic.gdx.physics.box2d.Body;
import com.badlogic.gdx.physics.box2d.BodyDef;
import com.badlogic.gdx.physics.box2d.PolygonShape;
import com.badlogic.gdx.physics.box2d.World;


/**
 * class for creating a static object in world.
 */
public class StaticMapElements {

    private final int posX, posY, width, height;

    /**
     * @param world Box2D world, creates instance of static object in this world. initialises physics
     * @param posX position x coordinate
     * @param posY position y coordinate
     * @param width self-explanatory
     * @param height self-explanatory
     */
    public StaticMapElements(World world, int posX, int posY, int width, int height) {

        BodyDef bodyDef = new BodyDef();
        bodyDef.type = BodyDef.BodyType.StaticBody;
        bodyDef.position.set(posX, posY);
        Body body = world.createBody(bodyDef);
        FixtureDef fixtureDef = new FixtureDef();
        PolygonShape polygonShape = new PolygonShape();
        polygonShape.setAsBox(width, height);
        fixtureDef.shape = polygonShape;
        fixtureDef.density = 0.1f;
        fixtureDef.friction = 0.0f;
        body.createFixture(fixtureDef);

        this.posX = posX;
        this.posY = posY;
        this.width = width;
        this.height = height;

    }

    /*
    getters for position and dimensions of mapobject
     */
    public int getPosX() {return posX;}
    public int getPosY() {return posY;}
    public int getWidth() {return width;}
    public int getHeight() {return height;}
}