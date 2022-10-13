package view;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.physics.box2d.World;
import model.MapModel;
import view.ImagePaths;

import java.util.Objects;

public class MoonMap {
    private final Texture moonStone = new Texture(ImagePaths.MOONSTONE.label);
    private final Texture groundFloor = new Texture(ImagePaths.MOONGROUND.label);

    public static final Texture speedPowerUp = new Texture(ImagePaths.SPEEDPOWERUP.label);
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
        sb.draw(speedPowerUp, 430, mapModel.getPlattForm2().getPosY()+43);
    }

    public void dispose(){
        moonStone.dispose();
        groundFloor.dispose();
        backgroundTexture.dispose();
    }
}