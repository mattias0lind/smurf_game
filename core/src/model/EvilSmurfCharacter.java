package model;

import com.badlogic.gdx.physics.box2d.World;

/**
 * The class EvilSmurfCharacter is used to declare values such as name and health points to the Evil Smurf character
 */
public class EvilSmurfCharacter extends Character {
    public EvilSmurfCharacter(World world) {
        super("evilsmurf", world, 120);
    }
}
