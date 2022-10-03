package MODEL;

import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.physics.box2d.World;

public class LillaMyCharacter extends Character {

    public Sprite sprite;

    public LillaMyCharacter(World world) {
        super("lillamy", world, 100);
    }


}
