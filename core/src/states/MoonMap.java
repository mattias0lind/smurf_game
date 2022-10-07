package states;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.physics.box2d.World;
import model.GroundFloor;
import model.StaticMapElements;

public class MoonMap {

    GroundFloor groundFloor1;
    StaticMapElements invisibleWall1,invisibleWall2;
    StaticMapElements moonStone1, moonStone2, moonStone3;

    private final Texture moonStone = new Texture(ImagePaths.MOONSTONE.label);
    private final Texture groundFloor = new Texture(ImagePaths.MOONGROUND.label);
    private final Texture backgroundTexture;
    private final Sprite backgroundSprite;

    public MoonMap(World world){

        backgroundTexture = new Texture(ImagePaths.BACKGROUND.label);
        backgroundSprite = new Sprite(backgroundTexture);

        groundFloor1 = new GroundFloor(world);

        invisibleWall1 = new StaticMapElements(world, 0, 0, 20, 2000);
        invisibleWall2 = new StaticMapElements(world, 1250, 0, 20, 2000);

        moonStone1 = new StaticMapElements(world,240,158,56,16);
        moonStone2 = new StaticMapElements(world, 410, 200, 56, 16);
        moonStone3 = new StaticMapElements(world, 640, 170, 56, 16);

    }

    public void drawMap(SpriteBatch sb){
        sb.draw(backgroundSprite,0,0);
        sb.draw(moonStone, moonStone1.getPosX()-40,moonStone1.getPosY()-18, moonStone1.getWidth()+104,moonStone1.getHeight()+84);
        sb.draw(moonStone, moonStone2.getPosX()-40,moonStone2.getPosY()-18, moonStone2.getWidth()+104,moonStone2.getHeight()+84);
        sb.draw(moonStone, moonStone3.getPosX()-40,moonStone3.getPosY()-18, moonStone3.getWidth()+104,moonStone3.getHeight()+84);
        sb.draw(groundFloor, 0, groundFloor1.getPosY(),groundFloor1.getWidth(),groundFloor1.getHeight()+30);
    }

    public void dispose(){
        moonStone.dispose();
        groundFloor.dispose();
        backgroundTexture.dispose();
    }
}