package MODEL;

import com.badlogic.gdx.math.Rectangle;

public abstract class Powerups {

    private Rectangle rectangle;

    public Powerups() {
        rectangle.set((float) (Math.random()*1280), (float) (Math.random()*720), 16, 16);
    }

    public void CollisionAction(CharacterREAL player){
        //decide action of collision
    }
}
