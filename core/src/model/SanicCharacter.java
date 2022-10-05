package model;

import com.badlogic.gdx.physics.box2d.World;

/**
 * The class SanicCharacter is used to declare values such as name and health points to the Sanic character
 */
public class SanicCharacter extends Character{
    public SanicCharacter(World world) {
        super("sanic", world, 100);
    }
}
