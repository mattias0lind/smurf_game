package com.States;

import MODEL.Character;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class FrameBoard {
    private Texture healthMeter, healthMeterBG, board;
    private Texture greyHeartsBG, redHeart1, redHeart2, redHeart3, redHeart4,redHeart5,redHeart6;
    private BitmapFont font;

    public FrameBoard(){
        board = new Texture(ImagePaths.FRAMEBOARD.label);
        healthMeter = new Texture(ImagePaths.HEALTHMETER.label);
        healthMeterBG = new Texture(ImagePaths.HEALTHMETERBACKGROUND.label);
        greyHeartsBG = new Texture(ImagePaths.THREEGREYHEARTS.label);
        redHeart1 = new Texture(ImagePaths.REDHEART.label);
        redHeart2 = new Texture(ImagePaths.REDHEART.label);
        redHeart3 = new Texture(ImagePaths.REDHEART.label);
        redHeart4 = new Texture(ImagePaths.REDHEART.label);
        redHeart5 = new Texture(ImagePaths.REDHEART.label);
        redHeart6 = new Texture(ImagePaths.REDHEART.label);
        font = new BitmapFont();
    }


    private void hearts(SpriteBatch sb) {
        sb.draw(greyHeartsBG, 50, 650, 100, 40);
        sb.draw(greyHeartsBG, 1080, 650, 100, 40);
        sb.draw(redHeart1, 50, 657, 32, 32);
        sb.draw(redHeart2, 84, 657, 32, 32);
        sb.draw(redHeart3, 118, 657, 32, 32);
        sb.draw(redHeart4, 1080, 657, 32, 32);
        sb.draw(redHeart5, 1114, 657, 32, 32);
        sb.draw(redHeart6, 1148, 657, 32, 32);
    }

    private void board(SpriteBatch sb){
        sb.draw(board, -3, 650, 1283, 70);
    }

    private void healthMeter(SpriteBatch sb, Character ch1, Character ch2){
        int width = 100;
        int height = 20;
        int hmx1 = 65;
        int hmx2 = 1080;
        int hmy = 690;

        sb.draw(board, -3, 650, 1283, 70);

        sb.draw(healthMeterBG,hmx1, hmy, width, height);
        sb.draw(healthMeterBG,hmx2, hmy, width, height);
        sb.draw(healthMeter,hmx1, hmy, width*ch1.getHpprocent(), height);
        sb.draw(healthMeter,hmx2, hmy, width*ch2.getHpprocent(),height);

        CharSequence hpText1 = Math.round(ch1.getHpprocent()*100)+"%";
        CharSequence hpText2 =  Math.round(ch2.getHpprocent()*100)+"%";
        CharSequence nameText1 = ("Player 1");
        CharSequence nameText2 = ("Player 2");

        font.draw(sb, hpText1, 85, 706);
        font.draw(sb, hpText2, 1113, 706);
        font.draw(sb, nameText1, 170, 705);
        font.draw(sb, nameText2, 1020, 705);
    }

    public void drawBoard(SpriteBatch sb, Character ch1, Character ch2){
        board(sb);
        healthMeter(sb,ch1,ch2);
        hearts(sb);
    }
    public void dispose() {
        board.dispose();
        healthMeterBG.dispose();
        healthMeter.dispose();
        greyHeartsBG.dispose();
        redHeart1.dispose();
        redHeart2.dispose();
        redHeart3.dispose();
        redHeart4.dispose();
        redHeart5.dispose();
        redHeart6.dispose();
    }
}
