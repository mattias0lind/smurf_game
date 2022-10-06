package states;


import CONTROLLER.InputProcessor;
import model.Character;
import model.CharacterFactory;
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
    private Texture characterOneSpritePunch;
    private World world = new World(new Vector2(0,-50), true);

    private InputProcessor inputProcessor = new InputProcessor();
    private Texture backgroundTexture;
    private Texture moonStone = new Texture(ImagePaths.MOONSTONE.label);

    private Texture groundMoon = new Texture(ImagePaths.MOONGROUND.label);
    private Sprite backgroundSprite;

    private int x, i = 3,j = 3;

    private Character characterOne;
    private Character characterTwo;
    private CharacterFactory characterFactory = new CharacterFactory();

    private Music menuMusic;

    private FrameBoard frameboard;


    public PlayState(GameStateManager gsm, String characterNameOne , String characterNameTwo){
        super(gsm);
        this.characterOne = Objects.requireNonNull(characterFactory.getCharacter(characterNameOne, world));
        this.characterTwo = Objects.requireNonNull(characterFactory.getCharacter(characterNameTwo, world));

        startGameMusic();

        //Char 1
        createCharacterOneSprites();

        //char 2
        createCharacterTwoSprites();

        frameboard = new FrameBoard();

        inputProcessor.movementLogic(characterOne.getPlayerMovement(), characterTwo.getPlayerMovement());
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

    private void startGameMusic() {
        menuMusic = Gdx.audio.newMusic(Gdx.files.internal("piano_beat.mp3"));
        menuMusic.setLooping(true);
        menuMusic.play();
    }

    private void createCharacterOneSprites() {
        characterOneSprite = new Texture(characterOne.getNameOfCharacter() + ".png");
        characterOneSpriteLeft = new Texture(characterOne.getNameOfCharacter() + "LookLeft.png");
        characterOneSpritePunch = new Texture(characterOne.getNameOfCharacter() + "PunchRight.png");
        characterOneSpritePunchLeft = new Texture(characterOne.getNameOfCharacter() + "PunchLeft.png");
    }

    private void createCharacterTwoSprites() {
        characterTwoSprite = new Texture(characterTwo.getNameOfCharacter() + ".png");
        characterTwoSpriteLeft = new Texture(characterTwo.getNameOfCharacter() + "LookLeft.png");
        characterTwoSpritePunch = new Texture(characterTwo.getNameOfCharacter() + "PunchRight.png");
        characterTwoSpritePunchLeft = new Texture(characterTwo.getNameOfCharacter() + "PunchLeft.png");
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
        drawStone(sb);
        sb.end();

        if (characterOne.getHpprocent()== 0 || (characterTwo.getHpprocent()==0)){
            if(characterOne.getHpprocent()==0){
                this.i =i-1;
                if(i==0){
                    gsm.set(new EndGameState(gsm, 0));
                    dispose();
                }
                frameboard.heartState(i,j);
                characterOne.restoreHP();
            }else{
                this.j =j-1;
                if(j==0){
                    gsm.set(new EndGameState(gsm, 1));
                    dispose();
                }
                frameboard.heartState(i,j);
                characterTwo.restoreHP();}



        }

    }

    @Override
    public void dispose() {
        characterOneSprite.dispose();
        characterTwoSprite.dispose();
        frameboard.dispose();
        menuMusic.dispose();
        
    }
}

