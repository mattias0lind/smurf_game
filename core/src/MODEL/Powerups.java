package MODEL;

import com.badlogic.gdx.math.Rectangle;

import java.util.Objects;

public abstract class Powerups {

    private Rectangle rectangle;
    private String name;

    public Powerups(String name) {
        rectangle.set((float) (Math.random() * 1280), (float) (Math.random() * 720), 16, 16);
        this.name = Objects.requireNonNull(name);
    }

    public String getName() {
        return name;
    }

    public void CollisionAction(CharacterREAL player) {
    }
    //decide action of collision
}
