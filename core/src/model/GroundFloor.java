package model;

import com.badlogic.gdx.physics.box2d.*;
import model.StaticMapElements;

public class GroundFloor extends StaticMapElements {
    public GroundFloor(World world) {
        super(world, 640, -20, 1280, 100);
    }
}