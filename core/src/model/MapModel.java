package model;

import com.badlogic.gdx.physics.box2d.World;

import java.util.Objects;

public class MapModel{
    private final GroundFloor groundFloor;
    private final StaticMapElements invisibleWall1,invisibleWall2;
    private final StaticMapElements plattForm1, plattForm2, plattForm3;

    public MapModel(World world){
        world = Objects.requireNonNull(world);
        groundFloor = new GroundFloor(world);
        invisibleWall1 = new StaticMapElements(world, 0, 0, 20, 2000);
        invisibleWall2 = new StaticMapElements(world, 1250, 0, 20, 2000);
        plattForm1 = new StaticMapElements(world,240,158,56,10);
        plattForm2 = new StaticMapElements(world, 410, 200, 56, 10);
        plattForm3 = new StaticMapElements(world, 640, 170, 56, 10);


    }

    public GroundFloor getGroundFloor() {return groundFloor;}

    public StaticMapElements getInvisibleWall1() {return invisibleWall1;}

    public StaticMapElements getInvisibleWall2() {
        return invisibleWall2;
    }

    public StaticMapElements getPlattForm1() {
        return plattForm1;
    }

    public StaticMapElements getPlattForm2() {
        return plattForm2;
    }

    public StaticMapElements getplattForm3() {
        return plattForm3;
    }
}

