package model;

import com.badlogic.gdx.physics.box2d.World;

public class SanicCharacter extends Character{
    public SanicCharacter(World world) {
        super("sanic", world, 200);
    }
}
