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


package com.mygdx.game.States;


import CONTROLLER.InputProcessor;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import MODEL.CharacterREAL;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.*;

import java.util.Objects;

public class playState extends abstractState{
    private Texture characterOneSprite,characterOneSpriteLeft,currentCharacterOne;
    private Texture characterTwoSprite,characterTwoSpriteLeft,characterTwoSpritePunch,currentCharacterTwo;
    private Texture healthMeter, healthMeterBG;
    private Texture greyHeartsBackground;
    private Texture redHeart;
    private Texture characterSelectionBackground;
    private Texture characterOneSpritePunch;
    private World world = new World(new Vector2(0,-30), true);
    private Box2DDebugRenderer debugRenderer = new Box2DDebugRenderer();
    private OrthographicCamera gameCame = new OrthographicCamera();
    private InputProcessor inputProcessor = new InputProcessor();
    private Texture backgroundTexture;
    private Sprite backgroundSprite;
    private int x,i;

    private CharacterREAL characterOne;
    private CharacterREAL characterTwo;
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
        characterOneSpriteLeft = new Texture(characterOne.getNameOfCharacter() +"_look_left.png");
        characterOneSpritePunch = new Texture("punching_smurf.png");

        //char 2
        characterTwoSprite = new Texture(characterTwo.getNameOfCharacter() + ".png");
        characterTwoSpriteLeft = new Texture("smurf_look_left.png");
        characterTwoSpritePunch = new Texture("punching_smurf.png");

        healthMeter = new Texture("healthMeter.png");
        healthMeterBG = new Texture("healthmeterbackground.png");
        greyHeartsBackground = new Texture("3greyHearts.png");
        redHeart = new Texture("redHeart.png");
        HpFont = new BitmapFont();



        inputProcessor.logic(characterOne.getPlayerMovement(), characterTwo.getPlayerMovement());
        inputProcessor.punchLogic(characterOne,characterTwo);
        Gdx.input.setInputProcessor(inputProcessor);
        createBody();
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
        else if(inputProcessor.isIfPlayer1_punched()){
            currentCharacterOne = characterOneSpritePunch;
            
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
        else if(inputProcessor.isIfPlayer2_punched()){
            currentCharacterTwo = characterTwoSpritePunch;
        }

        return currentCharacterTwo;
    }




    private void createBody(){
        BodyDef bodyDef = new BodyDef();
        bodyDef.type = BodyDef.BodyType.StaticBody;
        bodyDef.position.set(640,20);
        Body body;
        body = world.createBody(bodyDef);
        FixtureDef fixtureDef = new FixtureDef();
        PolygonShape polygonShape = new PolygonShape();
        polygonShape.setAsBox(1280,100);
        fixtureDef.shape = polygonShape;
        fixtureDef.density = 0.1f;
        body.createFixture(fixtureDef);
    }


    @Override
    public void update(float dt) {
        world.step(1/60f,6,2);
    }

    private void drawHealthMeters(SpriteBatch sb){
        sb.draw(healthMeterBG,50, 690, 100, 20);
        sb.draw(healthMeterBG,1080, 690, 100, 20);
        sb.draw(healthMeter,50, 690, 100*characterOne.getHpprocent(), 20);
        sb.draw(healthMeter,1080, 690, 100*characterTwo.getHpprocent(), 20);


        CharSequence hpText1 = Math.round(characterOne.getHpprocent()*100)+"%";
        CharSequence hpText2 =  Math.round(characterTwo.getHpprocent()*100)+"%";
        CharSequence nameText1 = ("Player 1");
        CharSequence nameText2 = ("Player 2");

        HpFont.draw(sb, hpText1, 85, 706);
        HpFont.draw(sb, hpText2, 1113, 706);
        HpFont.draw(sb, nameText1, 160, 705);
        HpFont.draw(sb, nameText2, 1020, 705);



    }

    private void drawHearts(SpriteBatch sb) {
        sb.draw(greyHeartsBackground, 50, 650, 100, 40);
        sb.draw(greyHeartsBackground, 1080, 650, 100, 40);
        sb.draw(redHeart, 50, 657, 32, 32);
        sb.draw(redHeart, 84, 657, 32, 32);
        sb.draw(redHeart, 118, 657, 32, 32);

        sb.draw(redHeart, 1080, 657, 32, 32);
        sb.draw(redHeart, 1114, 657, 32, 32);
        sb.draw(redHeart, 1148, 657, 32, 32);
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
        drawHealthMeters(sb);
        drawHearts(sb);
        sb.end();
        if( (characterOne.getHpprocent() == 0) || (characterTwo.getHpprocent() == 0) ){
            if(characterOne.getHpprocent() == 0){
                i = 0;
            }else{
                i = 1;
            }
            gsm.set(new EndGameState(gsm, i));

        }
    }

    @Override
    public void dispose() {
        characterSelectionBackground.dispose();
        characterOneSprite.dispose();
        characterTwoSprite.dispose();
        healthMeter.dispose();

    }
}

