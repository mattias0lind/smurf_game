package model;

import com.badlogic.gdx.physics.box2d.World;

import java.util.ArrayList;
import java.util.List;


/** A class for accessing all objects in map.
 *
 */
public class MapModel{
    private final StaticMapElements groundFloor;
    private final StaticMapElements invisibleWall1,invisibleWall2;
    private final StaticMapElements plattForm1, plattForm2, plattForm3;
    List<StaticMapElements> platForms = new ArrayList<>();
    List<StaticMapElements> invisibleWall = new ArrayList<>();

    /**
     * Method used to add static objects to the game
     * @param world passed as to initialise created objects in simulated world
     */
    public MapModel(World world){
        groundFloor = new StaticMapElements(world, 640, -20, 1280, 100);
        invisibleWall1 = new StaticMapElements(world, 0, 0, 20, 2000);
        invisibleWall2 = new StaticMapElements(world, 1250, 0, 20, 2000);
        plattForm1 = new StaticMapElements(world,240,158,56,10);
        plattForm2 = new StaticMapElements(world, 410, 200, 56, 10);
        plattForm3 = new StaticMapElements(world, 640, 170, 56, 10);

        platForms.add((plattForm1));
        platForms.add((plattForm2));
        platForms.add((plattForm3));
        invisibleWall.add(invisibleWall1);
        invisibleWall.add(invisibleWall2);




    }

    /**
     * @return list of platforms with type staticmapelement
     */
    public List<StaticMapElements> getPlatForms() {return platForms;}

    /**
     * @return list of invisible walls with type staticmapelement
     */
    public List<StaticMapElements> getInvisibleWall() {return invisibleWall;}

    /**
     * @return ground floor
     */
    public StaticMapElements getGroundFloor() {return groundFloor;}



}

