package view;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import model.MapModel;
import model.StaticMapElements;

import java.util.Objects;


/**
 * Class used to set up map objects and render graphics of the map
 */
public class MoonMap {
    private final Texture moonStone = new Texture(ImagePaths.MOONSTONE.label);
    private final Texture groundFloor = new Texture(ImagePaths.MOONGROUND.label);
    private boolean powerUpBoolean;

    private static final Texture healthPowerup = new Texture(ImagePaths.HEALTHPOWERUP.label);

    /**
     * Boolean to check if the powerup still exists on the map
     */


    private final Texture backgroundTexture;
    private final Sprite backgroundSprite;
    private final MapModel mapModel;

    /**
     * The constructor for the class
     * @param mapModel the map model to be used
     */
    public MoonMap(MapModel mapModel){
        this.mapModel = Objects.requireNonNull(mapModel);
        backgroundTexture = new Texture(ImagePaths.BACKGROUND.label);
        backgroundSprite = new Sprite(backgroundTexture);
    }

    private void drawPlatforms(SpriteBatch sb){

        for (StaticMapElements platform : mapModel.getPlatForms()){
            sb.draw(moonStone, platform.getPosX()-40,platform.getPosY()-18,platform.getWidth()+104,platform.getHeight()+84);
        }
    }


    /**
     * Draws the elements of the map. The background, platforms and the floor are always drawn. The
     * powerup is only drawn if it has not been picked up yet.
     * @param sb the sprite batch
     */
    public void drawMap(SpriteBatch sb){
        sb.draw(backgroundSprite,0,0);

        drawPlatforms(sb);

        sb.draw(groundFloor, 0, mapModel.getGroundFloor().getPosY(),mapModel.getGroundFloor().getWidth(),mapModel.getGroundFloor().getHeight()+30);
        if(powerUpBoolean) {
            sb.draw(healthPowerup, 430, mapModel.getPlatForms().get(2).getPosY()+70);
        }


    }

    public void drawPowerUp(boolean t){
            powerUpBoolean = t;

    }

    /** Disposes all the textures created by this class */
    public void dispose(){
        moonStone.dispose();
        groundFloor.dispose();
        backgroundTexture.dispose();
    }
}