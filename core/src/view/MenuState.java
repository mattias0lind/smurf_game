package view;

import controller.MenuInputProcessor;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class MenuState extends AbstractState {
    private final Texture menuBackground,playButton,quitButton;
    private final MenuInputProcessor menuInputProcessor = new MenuInputProcessor() ;

    /** Menustate constructor, images are collected from ENUM class ImagePaths and then assigned. */
    public MenuState(GameStateManager gsm) {
        super(gsm);
        menuBackground = new Texture(ImagePaths.STARTBACKGROUND.label);
        playButton = new Texture(ImagePaths.PLAYBUTTON.label);
        quitButton = new Texture(ImagePaths.QUITBUTTON.label);
        Gdx.input.setInputProcessor(menuInputProcessor);

    }

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


    @Override
    public void render(SpriteBatch sb) {
        sb.begin();
        sb.draw(menuBackground, 0, 0, 1280, 720);
        sb.draw(playButton, (1280 / 2) - (playButton.getWidth() / 2), 280);
        sb.draw(quitButton, (1280 / 2) - (quitButton.getWidth() / 2), -220);
        sb.end();
    }

    @Override
    public void dispose() {
        menuBackground.dispose();
        playButton.dispose();
        quitButton.dispose();
    }
}
