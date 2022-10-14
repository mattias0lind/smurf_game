package view;


import com.badlogic.gdx.audio.Sound;
import controller.GameController;
import controller.RoundTimer;
import model.*;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.*;
import model.Character;

import java.util.Objects;

public class PlayState extends AbstractState {


    private final World world = new World(new Vector2(0,-50), true);



    private final Character characterOne;
    private final Character characterTwo;
    private float playerOneLastKnownHP;
    private float playerTwoLastKnownHP;
    private final Sound robloxSound = Gdx.audio.newSound(Gdx.files.internal(ImagePaths.HITSOUND.label));
    private Music menuMusic = Gdx.audio.newMusic(Gdx.files.internal(ImagePaths.GAMESOUND.label));

    private static final Vector2 startPosition1 = new Vector2 (100,100);
    private static final Vector2 startposition2 = new Vector2 (1100, 100);


    private final FrameBoard frameboard;
    private final MoonMap map;


    private RoundTimer roundTimer;

    private final DrawCharacterSprite drawCharactersSprite1;
    private final DrawCharacterSprite drawCharactersSprite2;


    public PlayState(GameStateManager gsm, int count1 , int count2){
        super(gsm);
        CharacterFactory characterFactory = new CharacterFactory();
        this.characterOne = Objects.requireNonNull(characterFactory.getCharacter(count1, world, startPosition1));
        this.characterTwo = Objects.requireNonNull(characterFactory.getCharacter(count2, world, startposition2));

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

        //TODO detta kan bryta mot MVC
        gameController.movementLogic(characterOne.getPlayerMovement(), characterTwo.getPlayerMovement());
        gameController.punchLogic(characterOne,characterTwo);

        roundTimer = new RoundTimer();

    }

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
        if(characterOne.getHealthBar().getLives() == 0){
            dispose();
            gsm.set(new EndGameState(gsm, 0));
        }
        if(characterTwo.getHealthBar().getLives() == 0){dispose(); gsm.set(new EndGameState(gsm, 1));}
    }

    private void startGameMusic() {
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


        float deltaTime = Gdx.graphics.getDeltaTime();

        roundTimer.RoundTimer(deltaTime,characterOne,characterTwo);



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
    }



    @Override
    public void dispose() {
        map.dispose();
        frameboard.dispose();
        menuMusic.dispose();
        robloxSound.dispose();

    }
}

