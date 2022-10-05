package states;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class MenuState extends AbstractState {
    private final Texture menuBackground;
    private final Texture playButton;
    private final Texture quitButton;

    public MenuState(GameStateManager gsm) {//MenuState constructor, here we create the states textures.
        super(gsm);                        //We use our Enum class ImagePaths to tell the textures which png to use
        menuBackground = new Texture(ImagePaths.STARTBACKGROUND.label);//and where it's stored.
        playButton = new Texture(ImagePaths.PLAYBUTTON.label);
        quitButton = new Texture(ImagePaths.QUITBUTTON.label);
    }

    @Override
    public void handleInput() {//This method tells the program what happens when you interact with the GUI.
        if (Gdx.input.justTouched()) {//The if statements sets borders for the play button and quit button which is used
            System.out.println("x: " + Gdx.input.getX() + " y: " + Gdx.input.getY());//to know what happens when these
            if (Gdx.input.getX() > (1280 / 2) - (playButton.getWidth() / 2)             //are pressed.
                    && Gdx.input.getX() < (1280 / 2) - (playButton.getWidth() / 2) + playButton.getWidth()
                    && Gdx.input.getY() < 440
                    && Gdx.input.getY() > 330) {
                gsm.set(new CharacterSelectionState(gsm));
                dispose();
            } else {
                if (Gdx.input.getX() > 418
                        && Gdx.input.getX() < 862
                        && Gdx.input.getY() < 633
                        && Gdx.input.getY() > 525) {
                    System.out.println("Thanks for playing! The game is now shutting down :(");
                    System.exit(0);
                }
            }
        }
    }

    @Override
    public void update(float dt) {
        handleInput();
    }//the update method calls upon handleInput method when the user
                                                    //interacts with the games GUI.
    @Override
    public void render(SpriteBatch sb) {
        sb.begin();                                                 //the render method draws all designated textures
        sb.draw(menuBackground, 0, 0, 1280, 720);   //and sets their borders.
        sb.draw(playButton, (1280 / 2) - (playButton.getWidth() / 2), 280);
        sb.draw(quitButton, (1280 / 2) - (quitButton.getWidth() / 2), -220);
        sb.end();
    }

    @Override
    public void dispose() { //dispose tells the program to undraw all textures(menuBackground, playButton and so on).
        menuBackground.dispose();//this so that new things can be drawn onto the game canvas rather than on top of
        playButton.dispose();//the already drawn textures.
        quitButton.dispose();
    }
}
