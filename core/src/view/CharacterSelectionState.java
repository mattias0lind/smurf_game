package view;

import com.badlogic.gdx.Input;
import controller.CharacterSelectionInputProcessor;
import model.CharacterFactory;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

import java.util.concurrent.TimeUnit;

import static view.ImagePaths.CLOUDS;

/**
 * The CharacterSelectionState is the second state in the program and is accessed by pressing "Play"
 * in the previous state.
 * The class is used to choose what character each player wants to play with
 */
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
    private final CharacterFactory characterNames = new CharacterFactory();

    /**
     * Constructor used to set up a CharacterSelectionState
     * @param gsm the GameStateManager to handle logic of states
     */
    public CharacterSelectionState(GameStateManager gsm){
        super(gsm);
        Gdx.input.setInputProcessor(characterSelectionInputProcessor);
        characterSelectionBackground = new Texture(CLOUDS.label);

        cardSlot1 = new Texture(characterNames.getCharacterName(slotCounter1) + "Card.png");
        cardSlot2 = new Texture(characterNames.getCharacterName(slotCounter2) + "Card.png");

        leftArrow1 = new Texture(ImagePaths.LEFTARROW.label);
        rightArrow1 = new Texture(ImagePaths.RIGHTARROW.label);

        playButton = new Texture(ImagePaths.PLAYBUTTON.label);



    }


    /**
     * Handles player input based on where on the screen the player clicked.
     * If the player pressed "Play" then the current state is disposed and a new PlayState is instantiated
     * with the two characters chosen.
     * If one of the arrows is pressed then another character is displayed in the corresponding CardSlot
     */
    @Override
    public void handleInput() {

        try {
            TimeUnit.MILLISECONDS.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        if(Gdx.input.isKeyJustPressed(Input.Keys.ANY_KEY) || Gdx.input.isTouched() ){

            if(characterSelectionInputProcessor.touchDown(Gdx.input.getX(), Gdx.input.getY(), 0,0)){
                gsm.set(new PlayState(gsm, slotCounter1, slotCounter2));
                dispose();
            }
            else if (characterSelectionInputProcessor.touchDown(Gdx.input.getX(), Gdx.input.getY(), 0,1)){
                if (slotCounter1 == 0){
                    slotCounter1 = characterNames.getLength();
                }
                slotCounter1 = (slotCounter1 - 1) % characterNames.getLength();
                cardSlot1 = new Texture(characterNames.getCharacterName(slotCounter1) + "Card.png");
            }

            else if(characterSelectionInputProcessor.touchDown(Gdx.input.getX(), Gdx.input.getY(), 0,2)){
                slotCounter1 = (slotCounter1 + 1) % characterNames.getLength();
                cardSlot1 = new Texture (characterNames.getCharacterName(slotCounter1) + "Card.png");
            }

            else if(characterSelectionInputProcessor.touchDown(Gdx.input.getX(), Gdx.input.getY(), 0,3)){
                if(slotCounter2 == 0){
                    slotCounter2 = characterNames.getLength();
                }
                slotCounter2 = (slotCounter2 - 1) % characterNames.getLength();
                cardSlot2 = new Texture(characterNames.getCharacterName(slotCounter2) + "Card.png");

            }

            else if(characterSelectionInputProcessor.touchDown(Gdx.input.getX(), Gdx.input.getY(), 0,4)){
                slotCounter2 = (slotCounter2 + 1) % characterNames.getLength();
                cardSlot2 = new Texture(characterNames.getCharacterName(slotCounter2) + "Card.png");
            }}
    }


    /**
     * Draws the graphical elements that are shown during the Character selection state
     * @param sb the spritebatch
     */
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

    /**
     * Disposes of the drawn elements in the current state when called.
     */
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
