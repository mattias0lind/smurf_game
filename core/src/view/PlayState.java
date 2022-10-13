package view;


import com.badlogic.gdx.audio.Sound;
import controller.GameController;
import controller.InputProcessor;
import model.*;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.*;
import model.Character;

import java.util.Objects;

import static java.lang.Boolean.TRUE;

public class PlayState extends AbstractState {


    private World world = new World(new Vector2(0,-50), true);

    private GameController gameController = new GameController();
    private int i = 3,j = 3;

    private Character characterOne;
    private Character characterTwo;
    private CharacterFactory characterFactory = new CharacterFactory();
    private float playerOneLastKnownHP;
    private float playerTwoLastKnownHP;
    private Sound robloxSound = Gdx.audio.newSound(Gdx.files.internal(ImagePaths.HITSOUND.label));
    private Music menuMusic = Gdx.audio.newMusic(Gdx.files.internal(ImagePaths.GAMESOUND.label));

    private static final Vector2 startPosition1 = new Vector2 (100,100);
    private static final Vector2 startposition2 = new Vector2 (1100, 100);


    private FrameBoard frameboard;
    private MapModel basicMap;
    private MoonMap map;

    private DrawCharacterSprite drawCharactersSprite1;
    private DrawCharacterSprite drawCharactersSprite2;

    public PlayState(GameStateManager gsm, String characterNameOne , String characterNameTwo){
        super(gsm);
        this.characterOne = Objects.requireNonNull(characterFactory.getCharacter(characterNameOne, world, startPosition1));
        this.characterTwo = Objects.requireNonNull(characterFactory.getCharacter(characterNameTwo, world, startposition2));

        startGameMusic();
        playerOneLastKnownHP = characterOne.getHpprocent();
        playerTwoLastKnownHP = characterTwo.getHpprocent();


        drawCharactersSprite1 = new DrawCharacterSprite(characterOne);
        drawCharactersSprite2 = new DrawCharacterSprite(characterTwo);


        frameboard = new FrameBoard();
        basicMap = new MapModel(world);
        map = new MoonMap(basicMap);
        Gdx.input.setInputProcessor(gameController);

        //TODO detta kan bryta mot MVC
        gameController.movementLogic(characterOne.getPlayerMovement(), characterTwo.getPlayerMovement());
        gameController.punchLogic(characterOne,characterTwo);



    }

    @Override
    public void handleInput() {
        characterOne.getPlayerMovement().updatePlayerPosition();
        characterTwo.getPlayerMovement().updatePlayerPosition();
        if(playerOneLastKnownHP == 0 || playerTwoLastKnownHP == 0){
            playerOneLastKnownHP = 100;
            playerTwoLastKnownHP = 100;
            robloxSound.play();
        }
        if(playerOneLastKnownHP > characterOne.getHpprocent() || playerTwoLastKnownHP > characterTwo.getHpprocent()){
            playerOneLastKnownHP = characterOne.getHpprocent();
            playerTwoLastKnownHP = characterTwo.getHpprocent();
        }
    }

    private void startGameMusic() {
        menuMusic = Gdx.audio.newMusic(Gdx.files.internal("piano_beat.mp3"));
        menuMusic.setLooping(true);
        menuMusic.play();
    }




    @Override
    public void update(float dt) {
        handleInput();
        world.step(dt,6,2);
    }




    private void drawCharacters(SpriteBatch sb){
        sb.draw(drawCharactersSprite1.getCharacterSprite(), characterOne.getPlayerMovement().getBody().getPosition().x,characterOne.getPlayerMovement().getBody().getPosition().y);
        sb.draw(drawCharactersSprite2.getCharacterSprite(), characterTwo.getPlayerMovement().getBody().getPosition().x,characterTwo.getPlayerMovement().getBody().getPosition().y);
    }

    @Override
    public void render(SpriteBatch sb) {
        update((float) 0.016);

        if(Powerups.CheckIfPlayerGotPowerup(characterOne)) {
            MoonMap.speedPowerUp.dispose();
        }

        if(Powerups.CheckIfPlayerGotPowerup(characterTwo)) {
            MoonMap.speedPowerUp.dispose();
        }

        sb.begin();
        map.drawMap(sb);
        frameboard.drawBoard(sb,characterOne,characterTwo);
        drawCharacters(sb);
        sb.end();

        if(characterOne.getHealthBar().getLives() == 0){gsm.set(new EndGameState(gsm, 0));}
        if(characterTwo.getHealthBar().getLives() == 0){gsm.set(new EndGameState(gsm, 1));}

    }

    @Override
    public void dispose() {
        map.dispose();
        frameboard.dispose();
        menuMusic.dispose();
        robloxSound.dispose();

    }
}

