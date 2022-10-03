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

public class playState extends abstractState{
    private Texture characterOneSprite,characterOneSpriteLeft,currentCharacterOne,characterOneSpritePunchLeft;
    private Texture characterTwoSprite,characterTwoSpriteLeft,characterTwoSpritePunch,currentCharacterTwo,characterTwoSpritePunchLeft;
    private Texture healthMeter, healthMeterBG, frameboard;
    private Texture greyHeartsBackground;
    private Texture redHeart1, redHeart2, redHeart3, redHeart4,redHeart5,redHeart6;
    private Texture characterSelectionBackground;
    private Texture characterOneSpritePunch;
    private World world = new World(new Vector2(0,-30), true);
    private Box2DDebugRenderer debugRenderer = new Box2DDebugRenderer();
    private OrthographicCamera gameCame = new OrthographicCamera();
    private InputProcessor inputProcessor = new InputProcessor();
    private Texture backgroundTexture;
    private Texture moonStone;

    private Texture groundMoon;
    private Sprite backgroundSprite;
    private int x,i,j;

    private Character characterOne;
    private Character characterTwo;
    private CharacterCollection allCharacters1 = new CharacterCollection(world);
    private CharacterCollection allCharacters2 = new CharacterCollection(world);
    private Music menuMusic;

    private BitmapFont HpFont;

    private String score;


    public playState(gameStateManager gsm, int count1, int count2){
        super(gsm);
        this.characterOne = Objects.requireNonNull(allCharacters1.getCharacter(count1));
        this.characterTwo = Objects.requireNonNull(allCharacters2.getCharacter(count2));

        menuMusic = Gdx.audio.newMusic(Gdx.files.internal("piano_beat.mp3"));
        menuMusic.setLooping(true);
        menuMusic.play();

        characterSelectionBackground = new Texture("VSBattlesBackground.png");

        //Char 1
        characterOneSprite = new Texture(characterOne.getNameOfCharacter() + ".png");
        characterOneSpriteLeft = new Texture("smurf_look_left.png");
        characterOneSpritePunch = new Texture("punching_smurf.png");
        characterOneSpritePunchLeft = new Texture("left_punching_smurf.png");

        //char 2
        characterTwoSprite = new Texture(characterTwo.getNameOfCharacter() + ".png");
        characterTwoSpriteLeft = new Texture("smurf_look_left.png");
        characterTwoSpritePunch = new Texture("punching_smurf.png");
        characterTwoSpritePunchLeft = new Texture("left_punching_smurf.png");

        healthMeter = new Texture("healthMeter.png");
        healthMeterBG = new Texture("healthmeterbackground.png");
        frameboard = new Texture("frameboard.png");
        greyHeartsBackground = new Texture("3greyHearts.png");
        redHeart1 = new Texture("redHeart.png");
        redHeart2 = new Texture("redHeart.png");
        redHeart3 = new Texture("redHeart.png");
        redHeart4 = new Texture("redHeart.png");
        redHeart5 = new Texture("redHeart.png");
        redHeart6 = new Texture("redHeart.png");
        moonStone = new Texture("moonStone.png");
        groundMoon = new Texture("groundMoon.png");
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
        world.step(1/60f,6,2);
    }

    public void drawStone(SpriteBatch sb) {
        sb.draw(moonStone, 200, 140, 160, 100);
        sb.draw(moonStone, 370, 220, 160, 100);
        sb.draw(groundMoon, 0,0,1280,110);
    }

    private void drawFrameBoard(SpriteBatch sb) {
        sb.draw(frameboard, -3, 650, 1283, 70);}
    private void drawHealthMeters(SpriteBatch sb){

        int width = 100;
        int height = 20;
        int hmx1 = 65;
        int hmx2 = 1080;
        int hmy = 690;

        sb.draw(healthMeterBG,hmx1, hmy, width, height);
        sb.draw(healthMeterBG,hmx2, hmy, width, height);
        sb.draw(healthMeter,hmx1, hmy, width*characterOne.getHpprocent(), height);
        sb.draw(healthMeter,hmx2, hmy, width*characterTwo.getHpprocent(),height);


        CharSequence hpText1 = Math.round(characterOne.getHpprocent()*100)+"%";
        CharSequence hpText2 =  Math.round(characterTwo.getHpprocent()*100)+"%";
        CharSequence nameText1 = ("Player 1");
        CharSequence nameText2 = ("Player 2");

        HpFont.draw(sb, hpText1, 85, 706);
        HpFont.draw(sb, hpText2, 1113, 706);
        HpFont.draw(sb, nameText1, 170, 705);
        HpFont.draw(sb, nameText2, 1020, 705);



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
        drawFrameBoard(sb);
        drawHealthMeters(sb);
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
        healthMeter.dispose();
        healthMeterBG.dispose();
        frameboard.dispose();
        greyHeartsBackground.dispose();
        redHeart1.dispose();
        redHeart2.dispose();
        redHeart3.dispose();
        redHeart4.dispose();
        redHeart5.dispose();
        redHeart6.dispose();
    }
}

