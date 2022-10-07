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
    private int x, i = 3,j = 3;

    private Character characterOne;
    private Character characterTwo;
    private CharacterFactory characterFactory = new CharacterFactory();

    private Music menuMusic;


    private FrameBoard frameboard;
    private MoonMap map;

    public PlayState(GameStateManager gsm, String characterNameOne , String characterNameTwo){
        super(gsm);
        this.characterOne = Objects.requireNonNull(characterFactory.getCharacter(characterNameOne, world,new Vector2(100,100)));
        this.characterTwo = Objects.requireNonNull(characterFactory.getCharacter(characterNameTwo, world, new Vector2(1180,100)));

        startGameMusic();

        //Char 1
        createCharacterOneSprites();
        //char 2
        createCharacterTwoSprites();

        frameboard = new FrameBoard();
        map = new MoonMap(world);

        inputProcessor.movementLogic(characterOne.getPlayerMovement(), characterTwo.getPlayerMovement());
        inputProcessor.punchLogic(characterOne,characterTwo);
        Gdx.input.setInputProcessor(inputProcessor);

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


    @Override
    public void update(float dt) {
        characterOne.getPlayerMovement().updatePlayerPosition();
        characterTwo.getPlayerMovement().updatePlayerPosition();
        world.step(1/60f,6,2);
    }


    private void drawCharacters(SpriteBatch sb){
        sb.draw(getSpriteChar1(),characterOne.getPlayerMovement().getBody().getPosition().x,characterOne.getPlayerMovement().getBody().getPosition().y);
        sb.draw(getSpriteChar2(),characterTwo.getPlayerMovement().getBody().getPosition().x,characterTwo.getPlayerMovement().getBody().getPosition().y);
    }

    @Override
    public void render(SpriteBatch sb) {
        update((float) 0.016);

        sb.begin();
        map.drawMap(sb);
        frameboard.drawBoard(sb,characterOne,characterTwo);
        drawCharacters(sb);
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
                    dispose();}
                frameboard.heartState(i,j);
                characterTwo.restoreHP();}}
    }

    @Override
    public void dispose() {
        map.dispose();
        characterOneSprite.dispose();
        characterTwoSprite.dispose();
        frameboard.dispose();
        menuMusic.dispose();
        
    }
}

