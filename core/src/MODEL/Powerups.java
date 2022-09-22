package MODEL;

import com.badlogic.gdx.math.Rectangle;

public class Powerups {

    private Rectangle rectangle;

    public Powerups() {
        rectangle.set((float) (Math.random()*1280), (float) (Math.random()*720), 16, 16);
    }

    private void CollisionAction(Object player){
        //decide action of collision
    }
}
