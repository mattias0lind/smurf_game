package MODEL;

import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.maps.tiled.TmxMapLoader;
import com.badlogic.gdx.maps.tiled.renderers.OrthogonalTiledMapRenderer;

public class TileMapHelper {

    private TiledMap tiledMap;

    public void TiledMapHelper() {
    }

    public OrthogonalTiledMapRenderer setupMap() {
        tiledMap = new TmxMapLoader().load("Maps/Test_bana_klar..tmx");
        return new OrthogonalTiledMapRenderer(tiledMap);
    }


}

