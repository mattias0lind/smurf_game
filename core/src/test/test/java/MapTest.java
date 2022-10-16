import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.World;
import model.MapModel;
import model.StaticMapElements;
import org.junit.Test;


import static org.junit.Assert.assertTrue;

public class MapTest {

    @Test
    public void testMapCreator() {
        Vector2 position = new Vector2();
        World world = new World(position,false);
        MapModel mapModel = new MapModel(world);
        StaticMapElements mapElements = new StaticMapElements(world,100,100,100,100);
        mapModel.getGroundFloor();
        mapModel.getPlatForms().get(3);
        mapModel.getPlatForms().get(2);
        mapModel.getPlatForms().get(1);
        mapModel.getInvisibleWall().get(1);
        mapModel.getInvisibleWall().get(1);
        assertTrue(mapElements.getWidth()+mapElements.getHeight()+mapElements.getPosY()+mapElements.getPosX() == 400);
    }




}
