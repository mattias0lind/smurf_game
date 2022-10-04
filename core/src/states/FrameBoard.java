package states;

import model.Character;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class FrameBoard {
    /** A class that draws the top frameboard above the screen */

    private Texture healthMeter, healthMeterBG, board;
    private Texture heart1, heart2;
    private final BitmapFont font;


    public FrameBoard(){
        board = new Texture(ImagePaths.FRAMEBOARD.label);
        healthMeter = new Texture(ImagePaths.HEALTHMETER.label);
        healthMeterBG = new Texture(ImagePaths.HEALTHMETERBACKGROUND.label);
        heart1 = new Texture(ImagePaths.THREEHEART.label);
        heart2 = new Texture(ImagePaths.THREEHEART.label);
        font = new BitmapFont();}


    private void hearts(SpriteBatch sb) {
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
        CharSequence nameText1 = ("Player 1");
        CharSequence nameText2 = ("Player 2");

        font.draw(sb, nameText1, 170, 705);
        font.draw(sb, nameText2, 1020, 705);}

    public void heartState(int numberOfHearts1, int numberOfHearts2){
        /** Changes the texture for number of hearts that will show.

        Number of hearts for Player 1 */

        if(numberOfHearts1 == 3){heart1 = new Texture(ImagePaths.THREEHEART.label);}
        if(numberOfHearts1 == 2){heart1 = new Texture(ImagePaths.TWOHEART.label);}
        if(numberOfHearts1 == 1){heart1 = new Texture(ImagePaths.ONEHEART.label);}

        /** Number of Hearts for Player 2 */

        if(numberOfHearts2 == 3){heart2 = new Texture(ImagePaths.THREEHEART.label);}
        if(numberOfHearts2 == 2){heart2 = new Texture(ImagePaths.TWOHEART.label);}
        if(numberOfHearts2 == 1){heart2 = new Texture(ImagePaths.ONEHEART.label);}

        if(numberOfHearts2 == 0){heart2 = new Texture(ImagePaths.THREEGREYHEARTS.label);}
        if(numberOfHearts2 == 0){heart2 = new Texture(ImagePaths.THREEGREYHEARTS.label);}}

    public void drawBoard(SpriteBatch sb, Character ch1, Character ch2){
        /** Draw out the top frame board with all the information */

        board(sb);
        healthMeter(sb, ch1,ch2);
        drawPlayerNames(sb);
        hearts(sb);}

    public void dispose() {
        /** Disposes all the textures created by this class */

        board.dispose();
        healthMeterBG.dispose();
        healthMeter.dispose();
        heart1.dispose();
        heart2.dispose();}
}
