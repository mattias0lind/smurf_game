/*

package com.States;


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
import MODEL.Character;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.EventListener;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.Touchable;

public class playState extends abstractState {
    private Character smurf;
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
        private Sprite healthMeter = new Sprite (new Texture ("evilSmurfCard.png"));

        @Override
        public void setBounds(float x, float y, float width, float height) {
            super.setBounds(SmurfTesting.getX(), SmurfTesting.getY(), SmurfTesting.getWidth(), SmurfTesting.getHeight());
            super.setBounds(healthMeter.getX(), healthMeter.getY(), healthMeter.getWidth(), healthMeter.getHeight());
        }

        @Override
        public void setTouchable(Touchable touchable) {
            super.setTouchable(touchable);
        }

        @Override
        public void draw(Batch batch, float alpha){
            SmurfTesting.draw(batch);
            healthMeter.draw(batch);
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


package com.States;


import CONTROLLER.InputProcessor;
import MODEL.Character;
import com.CharacterFactory;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.*;

import java.util.Objects;

public class PlayState extends AbstractState {
    private Texture characterOneSprite,characterOneSpriteLeft,currentCharacterOne,characterOneSpritePunchLeft;
    private Texture characterTwoSprite,characterTwoSpriteLeft,characterTwoSpritePunch,currentCharacterTwo,characterTwoSpritePunchLeft;
    private Texture greyHeartsBackground;
    private Texture redHeart1, redHeart2, redHeart3, redHeart4,redHeart5,redHeart6;
    private Texture characterSelectionBackground;
    private Texture characterOneSpritePunch;
    private World world = new World(new Vector2(0,-100), true);
    private Box2DDebugRenderer debugRenderer = new Box2DDebugRenderer();
    private OrthographicCamera gameCame = new OrthographicCamera();
    private InputProcessor inputProcessor = new InputProcessor();
    private Texture backgroundTexture;
    private Texture moonStone;
    private int fff;


    private Texture groundMoon;
    private Sprite backgroundSprite;
    private int x,i,j;

    private Character characterOne;
    private Character characterTwo;
    private CharacterFactory characterFactory = new CharacterFactory();

    private Music menuMusic;

    private BitmapFont HpFont;

    private String score;

    private FrameBoard frameboard;


    public PlayState(GameStateManager gsm, String characterNameOne , String characterNameTwo){
        super(gsm);
        this.characterOne = Objects.requireNonNull(characterFactory.getCharacter(characterNameOne, world));
        this.characterTwo = Objects.requireNonNull(characterFactory.getCharacter(characterNameTwo, world));

        menuMusic = Gdx.audio.newMusic(Gdx.files.internal("piano_beat.mp3"));
        menuMusic.setLooping(true);
        menuMusic.play();


        //Char 1
        characterOneSprite = new Texture(characterOne.getNameOfCharacter() + ".png");
        characterOneSpriteLeft = new Texture(characterOne.getNameOfCharacter() + "LookLeft.png");
        characterOneSpritePunch = new Texture(characterOne.getNameOfCharacter() + "PunchRight.png");
        characterOneSpritePunchLeft = new Texture(characterOne.getNameOfCharacter() + "PunchLeft.png");

        //char 2
        characterTwoSprite = new Texture(characterTwo.getNameOfCharacter() + ".png");
        characterTwoSpriteLeft = new Texture(characterTwo.getNameOfCharacter() + "LookLeft.png");
        characterTwoSpritePunch = new Texture(characterTwo.getNameOfCharacter() + "PunchRight.png");
        characterTwoSpritePunchLeft = new Texture(characterTwo.getNameOfCharacter() + "PunchLeft.png");

        frameboard = new FrameBoard();

        greyHeartsBackground = new Texture(ImagePaths.THREEGREYHEARTS.label);
        redHeart1 = new Texture(ImagePaths.REDHEART.label);
        redHeart2 = new Texture(ImagePaths.REDHEART.label);
        redHeart3 = new Texture(ImagePaths.REDHEART.label);
        redHeart4 = new Texture(ImagePaths.REDHEART.label);
        redHeart5 = new Texture(ImagePaths.REDHEART.label);
        redHeart6 = new Texture(ImagePaths.REDHEART.label);
        moonStone = new Texture("moonStone.png");
        groundMoon = new Texture(ImagePaths.MOONGROUND.label);
        HpFont = new BitmapFont();



        inputProcessor.logic(characterOne.getPlayerMovement(), characterTwo.getPlayerMovement());
        inputProcessor.punchLogic(characterOne,characterTwo);
        Gdx.input.setInputProcessor(inputProcessor);
        createBody();
        createMapElement(240, 158, 56, 16);
        createMapElement(410, 238, 56, 16);
        backgroundTexture = new Texture("BackgroundMap.png");
        backgroundSprite = new Sprite(backgroundTexture);



    }

    @Override
    public void handleInput() {


    }

    private Texture getSpriteChar1(){

        if(x < 1){
            currentCharacterOne = characterOneSprite;
        }
        if(inputProcessor.getRightPlayer1()){
            currentCharacterOne = characterOneSprite ;
        }
        else if(inputProcessor.getLeftPlayer1()){
            currentCharacterOne = characterOneSpriteLeft;
        }
        if(inputProcessor.isIfPlayer1_punched()){

            if(inputProcessor.getLeftPlayer1()){
                currentCharacterOne = characterOneSpritePunchLeft;
            }else{
                currentCharacterOne = characterOneSpritePunch;
            }
        }





        return currentCharacterOne;
    }

    private Texture getSpriteChar2(){

        if(x < 1){
            currentCharacterTwo = characterTwoSprite;
            x++;
        }

        if(inputProcessor.getRightPlayer2()){
            currentCharacterTwo = characterTwoSprite ;
        }
        else if(inputProcessor.getLeftPlayer2()){
            currentCharacterTwo = characterTwoSpriteLeft;
        }
        if(inputProcessor.isIfPlayer2_punched()){

            if(inputProcessor.getLeftPlayer2()){
                currentCharacterTwo = characterTwoSpritePunchLeft;
            }else{
                currentCharacterTwo = characterTwoSpritePunch;
            }
        }

        return currentCharacterTwo;
    }



        //COMMENT
    private void createBody(){
        BodyDef bodyDef = new BodyDef();
        bodyDef.type = BodyDef.BodyType.StaticBody;
        bodyDef.position.set(640,-20);
        Body body;
        body = world.createBody(bodyDef);
        FixtureDef fixtureDef = new FixtureDef();
        PolygonShape polygonShape = new PolygonShape();
        polygonShape.setAsBox(1280,100);
        fixtureDef.shape = polygonShape;
        fixtureDef.density = 0.1f;
        body.createFixture(fixtureDef);
    }

    private void createMapElement(int posX, int posY, int width, int height){
        BodyDef bodyDef = new BodyDef();
        bodyDef.type = BodyDef.BodyType.StaticBody;
        bodyDef.position.set(posX,posY);
        Body body;
        body = world.createBody(bodyDef);
        FixtureDef fixtureDef = new FixtureDef();
        PolygonShape polygonShape = new PolygonShape();
        polygonShape.setAsBox(width,height);
        fixtureDef.shape = polygonShape;
        fixtureDef.density = 0.1f;
        fixtureDef.friction = 0.0f;
        body.createFixture(fixtureDef);
    }

    @Override
    public void update(float dt) {
        characterOne.getPlayerMovement().updatePlayerPosition();
        characterTwo.getPlayerMovement().updatePlayerPosition();
        world.step(1/60f,6,2);
    }

    public void drawStone(SpriteBatch sb) {
        sb.draw(moonStone, 200, 140, 160, 100);
        sb.draw(moonStone, 370, 220, 160, 100);
        sb.draw(groundMoon, 0,0,1280,110);
    }

    private void drawHearts(SpriteBatch sb) {
        sb.draw(greyHeartsBackground, 50, 650, 100, 40);
        sb.draw(greyHeartsBackground, 1080, 650, 100, 40);
        sb.draw(redHeart1, 50, 657, 32, 32);
        sb.draw(redHeart2, 84, 657, 32, 32);
        sb.draw(redHeart3, 118, 657, 32, 32);
        sb.draw(redHeart4, 1080, 657, 32, 32);
        sb.draw(redHeart5, 1114, 657, 32, 32);
        sb.draw(redHeart6, 1148, 657, 32, 32);
    }

    private void drawCharacters(SpriteBatch sb){
        sb.draw(getSpriteChar1(),characterOne.getPlayerMovement().getBody().getPosition().x,characterOne.getPlayerMovement().getBody().getPosition().y);
        sb.draw(getSpriteChar2(),characterTwo.getPlayerMovement().getBody().getPosition().x,characterTwo.getPlayerMovement().getBody().getPosition().y);
    }

    @Override
    public void render(SpriteBatch sb) {
        update((float) 0.016);

        sb.begin();
        sb.draw(backgroundSprite,0,0);
        drawCharacters(sb);
        frameboard.drawBoard(sb,characterOne,characterTwo);
        drawHearts(sb);
        drawStone(sb);
        sb.end();

        if (characterOne.getHpprocent()== 0 || (characterTwo.getHpprocent()==0)){
            if(characterOne.getHpprocent()==0){
                this.i =i+1;
                if (i==1){redHeart3.dispose();}
                if (i==2){redHeart2.dispose();}
                if(i==3){redHeart1.dispose();gsm.set(new EndGameState(gsm, 0));}
                characterOne.restoreHP();
            }else{
                this.j =j+1;
                if (j==1){redHeart6.dispose();}
                if (j==2){redHeart5.dispose();}
                if(j==3){redHeart4.dispose();
                    gsm.set(new EndGameState(gsm, 1));}
                characterTwo.restoreHP();}


        }

    }

    @Override
    public void dispose() {
        characterSelectionBackground.dispose();
        characterOneSprite.dispose();
        characterTwoSprite.dispose();
        frameboard.dispose();
    }
}

