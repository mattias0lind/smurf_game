package model;

import com.badlogic.gdx.physics.box2d.FixtureDef;
import com.badlogic.gdx.physics.box2d.Body;
import com.badlogic.gdx.physics.box2d.BodyDef;
import com.badlogic.gdx.physics.box2d.PolygonShape;
import com.badlogic.gdx.physics.box2d.World;


public class StaticMapElements {
    private World world;
    private BodyDef bodyDef;
    private Body body;
    private FixtureDef fixtureDef;
    private PolygonShape polygonShape;

    private final int posX, posY, width, height;

    public StaticMapElements(World world, int posX, int posY, int width, int height) {

        this.world = world;
        this.bodyDef = new BodyDef();
        bodyDef.type = BodyDef.BodyType.StaticBody;
        bodyDef.position.set(posX, posY);
        this.body = world.createBody(bodyDef);
        this.fixtureDef = new FixtureDef();
        this.polygonShape = new PolygonShape();
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
    public int getPosX() {return posX;}
    public int getPosY() {return posY;}
    public int getWidth() {return width;}
    public int getHeight() {return height;}
}