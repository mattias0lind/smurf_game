package view;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import model.MapModel;

import java.util.Objects;

public class MoonMap {
    private final Texture moonStone = new Texture(ImagePaths.MOONSTONE.label);
    private final Texture groundFloor = new Texture(ImagePaths.MOONGROUND.label);

    public static final Texture healthPowerup = new Texture(ImagePaths.HEALTHPOWERUP.label);

    public static Boolean powerUpExists = true;

    private final Texture backgroundTexture;
    private final Sprite backgroundSprite;
    private final MapModel mapModel;

    public MoonMap(MapModel mapModel){
        this.mapModel = Objects.requireNonNull(mapModel);
        backgroundTexture = new Texture(ImagePaths.BACKGROUND.label);
        backgroundSprite = new Sprite(backgroundTexture);
    }

    public void drawMap(SpriteBatch sb){
        sb.draw(backgroundSprite,0,0);
        sb.draw(moonStone, mapModel.getPlattForm1().getPosX()-40,mapModel.getPlattForm1().getPosY()-18, mapModel.getPlattForm1().getWidth()+104,mapModel.getPlattForm1().getHeight()+84);
        sb.draw(moonStone, mapModel.getPlattForm2().getPosX()-40,mapModel.getPlattForm2().getPosY()-18, mapModel.getPlattForm2().getWidth()+104,mapModel.getPlattForm2().getHeight()+84);
        sb.draw(moonStone, mapModel.getplattForm3().getPosX()-40,mapModel.getplattForm3().getPosY()-18, mapModel.getplattForm3().getWidth()+104,mapModel.getplattForm3().getHeight()+84);
        sb.draw(groundFloor, 0, mapModel.getGroundFloor().getPosY(),mapModel.getGroundFloor().getWidth(),mapModel.getGroundFloor().getHeight()+30);
        sb.draw(healthPowerup, 430, mapModel.getPlattForm2().getPosY()+43);
    }

    public void redrawPowerupRemoved(SpriteBatch sb){
        sb.draw(moonStone, 430, mapModel.getPlattForm2().getPosY()+43);
    }

    public void dispose(){
        moonStone.dispose();
        groundFloor.dispose();
        backgroundTexture.dispose();
    }
}