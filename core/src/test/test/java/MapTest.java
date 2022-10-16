import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.World;
import model.MapModel;
import model.StaticMapElements;
import org.junit.Test;


import static org.junit.Assert.assertTrue;

public class MapTest {

    @Test
    public void testStaticMapElements() {
        Vector2 position = new Vector2();
        World world = new World(position,false);
        MapModel mapModel = new MapModel(world);
        StaticMapElements mapElements = new StaticMapElements(world,100,100,100,100);
        assertTrue(mapElements.getWidth()+mapElements.getHeight()+mapElements.getPosY()+mapElements.getPosX() == 400);
    }

    @Test
    public void testPlatFormCreator(){
        Vector2 position = new Vector2();
        World world = new World(position,false);
        MapModel mapModel = new MapModel(world);
        assertTrue(mapModel.getPlatForms().size() == 3 );

    }

    @Test
    public void testGroundFloorCreator(){
        Vector2 position = new Vector2();
        World world = new World(position,false);
        MapModel mapModel = new MapModel(world);
       assertTrue(mapModel.getGroundFloor().getWidth() + mapModel.getGroundFloor().getHeight() == 1380);

    }

    @Test
    public void testInvisibleWallCreator(){
        Vector2 position = new Vector2();
        World world = new World(position,false);
        MapModel mapModel = new MapModel(world);
        assertTrue(mapModel.getInvisibleWall().size() == 2 );
    }




}
