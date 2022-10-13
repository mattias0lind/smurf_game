package model;

import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.World;

/**
 * The class LillaMyCharacter is used to declare values such as name and health points to the LillaMY character
 */
public class LillaMyCharacter extends Character {



    public LillaMyCharacter(World world, Vector2 position) {
        super("lillamy", world, 50, position);
    }


}
