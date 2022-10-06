package states;

import CONTROLLER.CharacterSelectionInputProcessor;
import CONTROLLER.MenuInputProcessor;
import model.CharacterNameCollection;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.World;

import java.util.concurrent.TimeUnit;

import static states.ImagePaths.CLOUDS;

public class CharacterSelectionState extends AbstractState {

    private Texture cardSlot1;
    private Texture cardSlot2;
    private final Texture characterSelectionBackground;
    private int slotCounter1 = 0;
    private int slotCounter2 = 0;

    private final Texture leftArrow1;
    private final Texture rightArrow1;
    private final Texture playButton;
    private final CharacterSelectionInputProcessor characterSelectionInputProcessor = new CharacterSelectionInputProcessor();




    private final CharacterNameCollection allCharacterNames = new CharacterNameCollection();

    public CharacterSelectionState(GameStateManager gsm){
        super(gsm);
        Gdx.input.setInputProcessor(characterSelectionInputProcessor);
        characterSelectionBackground = new Texture(CLOUDS.label);

        cardSlot1 = new Texture(allCharacterNames.getCharacter(slotCounter1) + "Card.png");
        cardSlot2 = new Texture(allCharacterNames.getCharacter(slotCounter2) + "Card.png");

        leftArrow1 = new Texture(ImagePaths.LEFTARROW.label);
        rightArrow1 = new Texture(ImagePaths.RIGHTARROW.label);

        playButton = new Texture(ImagePaths.PLAYBUTTON.label);



    }

    /** Delay was added because computers iterate too fast through our list with characters. */
    @Override
    public void handleInput() {

        try {
            TimeUnit.MILLISECONDS.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

            if(Gdx.input.isTouched()){

            if(characterSelectionInputProcessor.touchDown(Gdx.input.getX(), Gdx.input.getY(), 0,0)){
                gsm.set(new PlayState(gsm, allCharacterNames.getCharacter(slotCounter1), allCharacterNames.getCharacter(slotCounter2)));
                dispose();
            }
            else if (characterSelectionInputProcessor.touchDown(Gdx.input.getX(), Gdx.input.getY(), 0,1)){
                if (slotCounter1 == 0)
                    slotCounter1 = allCharacterNames.getLength();
                slotCounter1 = (slotCounter1 - 1) % allCharacterNames.getLength();
                cardSlot1 = new Texture(allCharacterNames.getCharacter(slotCounter1) + "Card.png");
            }

            else if(characterSelectionInputProcessor.touchDown(Gdx.input.getX(), Gdx.input.getY(), 0,2)){
                slotCounter1 = (slotCounter1 + 1) % allCharacterNames.getLength();
                cardSlot1 = new Texture (allCharacterNames.getCharacter(slotCounter1) + "Card.png");
            }

            else if(characterSelectionInputProcessor.touchDown(Gdx.input.getX(), Gdx.input.getY(), 0,3)){
                if(slotCounter2 == 0)
                    slotCounter2 = allCharacterNames.getLength();
                slotCounter2 = (slotCounter2 - 1) % allCharacterNames.getLength();
                cardSlot2 = new Texture(allCharacterNames.getCharacter(slotCounter2) + "Card.png");

            }

            else if(characterSelectionInputProcessor.touchDown(Gdx.input.getX(), Gdx.input.getY(), 0,4)){
                slotCounter2 = (slotCounter2 + 1) % allCharacterNames.getLength();
                cardSlot2 = new Texture(allCharacterNames.getCharacter(slotCounter2) + "Card.png");
            }}
    }



    @Override
    public void update(float dt) {
        handleInput();
    }

    @Override
    public void render(SpriteBatch sb) {

        sb.begin();
        sb.draw(characterSelectionBackground,0,0,1280,720);
        sb.draw(cardSlot1, 150,330, 135,135);
        sb.draw(cardSlot2, 1020,330, 135,135);
        sb.draw(leftArrow1, 100, 375, 32, 32);
        sb.draw(rightArrow1, 300, 375, 32, 32);
        sb.draw(leftArrow1, 970, 375, 32, 32);
        sb.draw(rightArrow1, 1170, 375, 32, 32);

        sb.draw(playButton, (1280 / 2)-(playButton.getWidth() / 2), 30);
        sb.end();
    }

    @Override
    public void dispose() {
        characterSelectionBackground.dispose();
        cardSlot1.dispose();
        cardSlot2.dispose();
        leftArrow1.dispose();
        rightArrow1.dispose();
        playButton.dispose();

    }
}
