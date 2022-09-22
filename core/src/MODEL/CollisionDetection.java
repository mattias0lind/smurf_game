package MODEL;

import com.badlogic.gdx.math.Rectangle;

public class CollisionDetection {

    public boolean IsTouching(Rectangle rectangle1, Rectangle rectangle2){
        return rectangle1.overlaps(rectangle2);
    }
}
