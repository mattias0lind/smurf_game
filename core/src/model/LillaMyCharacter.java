package model;

import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.physics.box2d.World;

/**
 * The class LillaMyCharacter is used to declare values such as name and health points to the LillaMY character
 */
public class LillaMyCharacter extends Character {

    public Sprite sprite;

    public LillaMyCharacter(World world) {
        super("lillamy", world, 100);
    }


}
