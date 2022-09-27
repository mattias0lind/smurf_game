/*

package com.mygdx.game.States;


import CONTROLLER.InputProcessor;
import MODEL.SmurfCharacter;
import MODEL.TileMapHelper;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.maps.tiled.renderers.OrthogonalTiledMapRenderer;
import com.badlogic.gdx.physics.box2d.World;
import MODEL.CharacterREAL;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.EventListener;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.Touchable;

public class playState extends abstractState {
    private CharacterREAL smurf;
    private World world;

    private OrthogonalTiledMapRenderer orthogonalTiledMapRenderer;
    private TileMapHelper tileMapHelper;
    private Stage stage;
    private InputProcessor inputProcessor = new InputProcessor();
    private SpriteBatch batch;
    private Texture texture;
    private Sprite sprite;

    public playState(gameStateManager gsm){
    super(gsm);

    }

    public class MyActor extends Actor {

        private Sprite SmurfTesting = new Sprite (new Texture("smurf.png"));

        @Override
        public void setBounds(float x, float y, float width, float height) {
            super.setBounds(SmurfTesting.getX(), SmurfTesting.getY(), SmurfTesting.getWidth(), SmurfTesting.getHeight());
        }

        @Override
        public void setTouchable(Touchable touchable) {
            super.setTouchable(touchable);
        }

        @Override
        public void draw(Batch batch, float alpha){
            SmurfTesting.draw(batch);
        }

        @Override
        public boolean addListener(EventListener listener) {
            return super.addListener(listener);
        }
    }

    private void create(){
        stage = new Stage();
        MyActor myActor = new MyActor();
        stage.addActor(myActor);
        Gdx.input.setInputProcessor(stage);
        stage.addActor(myActor);

        this.tileMapHelper = new TileMapHelper();
        this.orthogonalTiledMapRenderer = tileMapHelper.setupMap();

    }

    @Override
    public void handleInput() {
        Gdx.input.setInputProcessor(inputProcessor);
    }

    @Override
    public void update(float dt) {
        handleInput();
    }

    @Override
    public void render(SpriteBatch sb) {
        create();
        Gdx.gl.glClearColor(1, 1, 1, 1);
        stage.act(Gdx.graphics.getDeltaTime());
        stage.draw();
        sb.begin();
        sb.end();
    }

    @Override
    public void dispose(){
        stage.dispose();
        batch.dispose();
        texture.dispose();

    }
}
*/


package com.mygdx.game.States;


import CONTROLLER.InputProcessor;
import MODEL.EvilSmurfCharacter;
import MODEL.SmurfCharacter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import MODEL.CharacterREAL;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.Box2D;
import com.badlogic.gdx.physics.box2d.Box2DDebugRenderer;
import com.badlogic.gdx.physics.box2d.World;
import com.badlogic.gdx.utils.ScreenUtils;

public class playState extends abstractState{
    private Texture characterCard1;
    private Texture characterCard2;
    private Texture characterSelectionBackground;
    private World world = new World(new Vector2(0,0), true);
    private Box2DDebugRenderer debugRenderer = new Box2DDebugRenderer();
    private OrthographicCamera gameCame = new OrthographicCamera();
    private InputProcessor inputProcessor = new InputProcessor();

    private CharacterREAL smurf1 = new SmurfCharacter(world);
    private CharacterREAL smurf2 = new EvilSmurfCharacter(world);

    public playState(gameStateManager gsm){
        super(gsm);
        characterSelectionBackground = new Texture("VSBattlesBackground.png");
        characterCard1 = new Texture(smurf1.getNameOfCharacter() + "Card.png");
        characterCard2 = new Texture(smurf2.getNameOfCharacter() + "Card.png");
        inputProcessor.logic(smurf1.getPlayerMovement(), smurf2.getPlayerMovement());
        Gdx.input.setInputProcessor(inputProcessor);
    }

    @Override
    public void handleInput() {


    }




    @Override
    public void update(float dt) {
        handleInput();
        world.step(1/60f,6,2);
    }

    @Override
    public void render(SpriteBatch sb) {
        System.out.println(smurf2.getPosition().x);
        update((float) 0.016);
        sb.begin();
        sb.draw(characterCard1,smurf2.getPlayerMovement().getBody().getPosition().x,smurf2.getPlayerMovement().getBody().getPosition().y);
        sb.end();


    }

    @Override
    public void dispose() {
        characterSelectionBackground.dispose();
        characterCard1.dispose();
        characterCard2.dispose();

    }
}

