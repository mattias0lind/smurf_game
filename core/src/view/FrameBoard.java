package view;

import model.Character;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

import java.util.ArrayList;
import java.util.List;

/**
 * Class that draws and handles the top frame board above the screen
 */
public class FrameBoard {

    private final Texture healthMeter;
    private final Texture healthMeterBG;
    private final Texture board;
    private Texture heart1, heart2;
    private final BitmapFont font;

    private final List<ImagePaths> heartState = new ArrayList<>();

    /**
     * Constructor for the class FrameBoard. Used to set up a new frame board.
     */
    public FrameBoard(){
        board = new Texture(ImagePaths.FRAMEBOARD.label);
        healthMeter = new Texture(ImagePaths.HEALTHMETER.label);
        healthMeterBG = new Texture(ImagePaths.HEALTHMETERBACKGROUND.label);
        font = new BitmapFont();

        heartState.add(ImagePaths.THREEGREYHEARTS);
        heartState.add(ImagePaths.ONEHEART);
        heartState.add(ImagePaths.TWOHEART);
        heartState.add(ImagePaths.THREEHEART);
        heart1 = new Texture(heartState.get(heartState.size()-1).label);
        heart2 = new Texture(heartState.get(heartState.size()-1).label);
    }


    private void hearts(SpriteBatch sb, Character ch1, Character ch2) {
        heartState(ch1,ch2);
        sb.draw(heart1, 50, 650, 100, 40);
        sb.draw(heart2, 1080, 650, 100, 40);}

    private void board(SpriteBatch sb){sb.draw(board, -3, 650, 1283, 70);}

    private void healthMeter(SpriteBatch sb,Character ch1, Character ch2){
        int width = 100;
        int height = 20;
        int hmx1 = 65;
        int hmx2 = 1080;
        int hmy = 690;

        sb.draw(healthMeterBG,hmx1, hmy, width, height);
        sb.draw(healthMeterBG,hmx2, hmy, width, height);
        sb.draw(healthMeter,hmx1, hmy, width*ch1.getHpprocent(), height);
        sb.draw(healthMeter,hmx2, hmy, width*ch2.getHpprocent(),height);

        CharSequence hpText1 = Math.round(ch1.getHpprocent()*100)+"%";
        CharSequence hpText2 =  Math.round(ch2.getHpprocent()*100)+"%";

        font.draw(sb, hpText1, 85, 706);
        font.draw(sb, hpText2, 1113, 706);}


    private void drawPlayerNames(SpriteBatch sb){
        CharSequence nameText1 = "Player 1";
        CharSequence nameText2 = "Player 2";

        font.draw(sb, nameText1, 170, 705);
        font.draw(sb, nameText2, 1020, 705);}


    /** Changes the texture for number of hearts that will show.*/
    private void heartState(Character ch1, Character ch2){
        heart1 = new Texture(heartState.get(ch1.getLives()).label);
        heart2 = new Texture(heartState.get(ch2.getLives()).label);
    }

    /** Draws out the top frame board with all the information */
    public void drawBoard(SpriteBatch sb, Character ch1, Character ch2){
        board(sb);
        healthMeter(sb, ch1,ch2);
        drawPlayerNames(sb);
        hearts(sb,ch1,ch2);

    }

    /** Disposes all the textures created by this class */
    public void dispose() {
        board.dispose();
        healthMeterBG.dispose();
        healthMeter.dispose();
        heart1.dispose();
        heart2.dispose();}
}
