package view;

import controller.MenuInputProcessor;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

/**
 * The MenuState is the first state when the program is started. The class is used
 * to draw the GUI of the menu and to check for simple user input
 */
public class MenuState extends AbstractState {
    private final Texture menuBackground,playButton,quitButton;
    private final MenuInputProcessor menuInputProcessor = new MenuInputProcessor() ;

    /** MenuState constructor, images are collected from ENUM class ImagePaths and then assigned. */
    public MenuState(GameStateManager gsm) {
        super(gsm);
        menuBackground = new Texture(ImagePaths.STARTBACKGROUND.label);
        playButton = new Texture(ImagePaths.PLAYBUTTON.label);
        quitButton = new Texture(ImagePaths.QUITBUTTON.label);
        Gdx.input.setInputProcessor(menuInputProcessor);

    }

    /**
     * A method used to check if the user pressed the Play or Quit buttons.
     * If Play is pressed then the next state is instantiated.
     * If Quit is pressed then the program shuts down
     */
    @Override
    public void handleInput() {
        if(Gdx.input.isTouched()) {
            if (menuInputProcessor.touchDown(Gdx.input.getX(), Gdx.input.getY(), 0, 0)) {
                gsm.set(new CharacterSelectionState(gsm));
                dispose();
            } else if (menuInputProcessor.touchDown(Gdx.input.getX(), Gdx.input.getY(),0,1)) {
                System.exit(0);
            }
        }
    }


    /**
     * Renders the Menu background and the buttons
     * @param sb the spritebatch
     */
    @Override
    public void render(SpriteBatch sb) {
        sb.begin();
        sb.draw(menuBackground, 0, 0, 1280, 720);
        sb.draw(playButton, (1280 / 2) - (playButton.getWidth() / 2), 280);
        sb.draw(quitButton, (1280 / 2) - (quitButton.getWidth() / 2), -220);
        sb.end();
    }

    /**
     * Disposes of the drawn elements in the current state when called.
     */
    @Override
    public void dispose() {
        menuBackground.dispose();
        playButton.dispose();
        quitButton.dispose();
    }
}
