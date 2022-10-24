import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.World;
import model.MapModel;
import model.StaticMapElements;
import org.junit.Test;


import static org.junit.Assert.assertEquals;

public class MapTest {

    @Test
    public void testStaticMapElements() {
        Vector2 position = new Vector2();
        World world = new World(position,false);

        StaticMapElements mapElements = new StaticMapElements(world,100,100,100,100);
        assertEquals(400,mapElements.getWidth()+mapElements.getHeight()+mapElements.getPosY()+mapElements.getPosX());
    }

    @Test
    public void testPlatFormCreator(){
        Vector2 position = new Vector2();
        World world = new World(position,false);
        MapModel mapModel = new MapModel(world);
        assertEquals(3,mapModel.getPlatForms().size());

    }

    @Test
    public void testGroundFloorCreator(){
        Vector2 position = new Vector2();
        World world = new World(position,false);
        MapModel mapModel = new MapModel(world);
       assertEquals(1380,mapModel.getGroundFloor().getWidth() + mapModel.getGroundFloor().getHeight());

    }

    @Test
    public void testInvisibleWallCreator(){
        Vector2 position = new Vector2();
        World world = new World(position,false);
        MapModel mapModel = new MapModel(world);
        assertEquals(2,mapModel.getInvisibleWall().size());
    }




}
