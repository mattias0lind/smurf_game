package view;


import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import controller.GameController;
import controller.PowerupController;
import controller.RoundTimer;
import model.*;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.*;
import model.Character;

import java.util.Objects;

/**
 * The PlayState is the second state in the program and is accessed by pressing "Play"
 * in the previous state.
 * The class is used to update the game and render dynamic graphics
 */
public class PlayState extends AbstractState {

    private final World world = new World(new Vector2(0,-50), true);

    private final Character characterOne;
    private final Character characterTwo;
    private float playerOneLastKnownHP;
    private float playerTwoLastKnownHP;

    private final Sound robloxSound = Gdx.audio.newSound(Gdx.files.internal(ImagePaths.HITSOUND.label));
    private Music menuMusic = Gdx.audio.newMusic(Gdx.files.internal(ImagePaths.GAMESOUND.label));

    private static final Vector2 START_POSITION_1 = new Vector2 (100,100);
    private static final Vector2 STARTPOSITION_2 = new Vector2 (1100, 100);


    private final FrameBoard frameboard;
    private final MoonMap map;
    private final BitmapFont font;


    private RoundTimer roundTimer;
    private PowerupController powerupController;

    private final DrawCharacterSprite drawCharactersSprite1;
    private final DrawCharacterSprite drawCharactersSprite2;

    /**
     * Constructor used to set up a CharacterSelectionState
     * @param gsm the GameStateManager to handle logic of states
     * @param count1 Character 1
     * @param count2 Character 2
     * The method sets up characters, the sound, the map, the frame board and some more
     */
    public PlayState(GameStateManager gsm, int count1 , int count2){
        super(gsm);
        CharacterFactory characterFactory = new CharacterFactory();
        this.characterOne = Objects.requireNonNull(characterFactory.createCharacter(count1, world, START_POSITION_1));
        this.characterTwo = Objects.requireNonNull(characterFactory.createCharacter(count2, world, STARTPOSITION_2));

        startGameMusic();
        playerOneLastKnownHP = characterOne.getHpprocent();
        playerTwoLastKnownHP = characterTwo.getHpprocent();


        drawCharactersSprite1 = new DrawCharacterSprite(characterOne);
        drawCharactersSprite2 = new DrawCharacterSprite(characterTwo);


        frameboard = new FrameBoard();
        MapModel basicMap = new MapModel(world);
        map = new MoonMap(basicMap);
        GameController gameController = new GameController();
        Gdx.input.setInputProcessor(gameController);


        gameController.movementLogic(characterOne.getPlayerMovement(), characterTwo.getPlayerMovement());
        gameController.punchLogic(characterOne,characterTwo);

        roundTimer = new RoundTimer();

        powerupController = new PowerupController();

        font = new BitmapFont();
    }

    /**
     * Method used to update the players position, health and total lives
     * If a character has lost all three lives then the PlayState is disposed and a new
     * EndGameState is instantiated.
     */
    @Override
    public void handleInput() {
        characterOne.getPlayerMovement().updatePlayerPosition();
        characterTwo.getPlayerMovement().updatePlayerPosition();
        if(playerOneLastKnownHP < characterOne.getHpprocent()){playerOneLastKnownHP = 110;}
        if(playerTwoLastKnownHP < characterTwo.getHpprocent()){playerTwoLastKnownHP = 110;}
        if(playerOneLastKnownHP > characterOne.getHpprocent() || playerTwoLastKnownHP > characterTwo.getHpprocent()){
            playerOneLastKnownHP = characterOne.getHpprocent();
            playerTwoLastKnownHP = characterTwo.getHpprocent();
            robloxSound.play();
        }
        if(characterOne.getLives() == 0){
            dispose();
            gsm.set(new EndGameState(gsm, 0));
        }
        if(characterTwo.getLives() == 0){dispose(); gsm.set(new EndGameState(gsm, 1));}
    }

    private void startGameMusic() {
        menuMusic.setLooping(true);
        menuMusic.play();
    }

    /**
     * Method used to update the game
     * @param dt Delta Time, the amount of time simulated
     */
    @Override
    public void update(float dt) {
        handleInput();
        world.step(dt,6,2);
        powerupController.checkIfPlayerGotPowerup(characterOne);
        powerupController.checkIfPlayerGotPowerup(characterTwo);

    }


    private void drawTimer(SpriteBatch sb,float time){
        int intTime = Math.round(time);
        CharSequence timer = String.valueOf(intTime);
        font.draw(sb,timer,635,690);


    }


    private void drawCharacters(SpriteBatch sb){
        sb.draw(drawCharactersSprite1.getCharacterSprite(), characterOne.getPlayerMovement().getBody().getPosition().x,characterOne.getPlayerMovement().getBody().getPosition().y);
        sb.draw(drawCharactersSprite2.getCharacterSprite(), characterTwo.getPlayerMovement().getBody().getPosition().x,characterTwo.getPlayerMovement().getBody().getPosition().y);
    }

    /**
     * Method used to dynamically draw graphical elements of the map
     * Draws the Timer, Frameboard, Characters and if the PowerUp has been picked up acts accordingly.
     * @param sb the spritebatch
     */
    @Override
    public void render(SpriteBatch sb) {

        float deltaTime = Gdx.graphics.getDeltaTime();
        update(deltaTime);

        float time = roundTimer.roundTimer(deltaTime, characterOne, characterTwo);


        sb.begin();
        map.drawPowerUp(powerupController.checkIfPowerUpIsStillActive());
        map.drawMap(sb);
        frameboard.drawBoard(sb,characterOne,characterTwo);
        drawTimer(sb, time);
        drawCharacters(sb);
        sb.end();
    }


    /**
     * Disposes of the drawn elements in the current state when called.
     */
    @Override
    public void dispose() {
        map.dispose();
        frameboard.dispose();
        menuMusic.dispose();
        robloxSound.dispose();

    }
}

