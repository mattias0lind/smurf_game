package model;

import com.badlogic.gdx.physics.box2d.*;

/**
 * Predefined extension of its parent, will always be the same regardless of map.
 */
public class GroundFloor extends StaticMapElements {
    /**
     * @param world is passed as to create initialise physics
     */
    public GroundFloor(World world) {
        super(world, 640, -20, 1280, 100);
    }
}