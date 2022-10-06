package states;

import com.badlogic.gdx.physics.box2d.*;

public class GroundFloor extends StaticMapElements {
    public GroundFloor(World world) {
        super(world, 640, -20, 1280, 100);
    }
}