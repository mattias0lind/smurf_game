package com.States;

import MODEL.Character;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class FrameBoard {
    private Texture healthMeter, healthMeterBG, board;
    private Texture heart1, heart2;
    private BitmapFont font;

    public FrameBoard(){
        board = new Texture(ImagePaths.FRAMEBOARD.label);
        healthMeter = new Texture(ImagePaths.HEALTHMETER.label);
        healthMeterBG = new Texture(ImagePaths.HEALTHMETERBACKGROUND.label);
        heart1 = new Texture(ImagePaths.THREEHEART.label);
        heart2 = new Texture(ImagePaths.THREEHEART.label);
        font = new BitmapFont();
    }


    public void heartState(int points1, int points2){
        if(points1 == 3){
            heart1 = new Texture(ImagePaths.THREEHEART.label);
        }
        if(points1 == 2){
            heart1 = new Texture(ImagePaths.TWOHEART.label);
        }
        if(points1 == 1){
            heart2 = new Texture(ImagePaths.ONEHEART.label);
        }
        if(points2 == 3){
            heart2 = new Texture(ImagePaths.THREEHEART.label);
        }
        if(points2 == 2){
            heart2 = new Texture(ImagePaths.TWOHEART.label);
        }
        if(points2 == 1){
            heart2 = new Texture(ImagePaths.ONEHEART.label);
        }

    }

    private void hearts(SpriteBatch sb) {
        sb.draw(heart1, 50, 650, 100, 40);
        sb.draw(heart2, 1080, 650, 100, 40);

        //Player1
        //sb.draw(redHeart, 50, 657, 32, 32);
        //sb.draw(redHeart, 84, 657, 32, 32);
        //sb.draw(redHeart, 118, 657, 32, 32);

        //Player2
        //sb.draw(redHeart, 1080, 657, 32, 32);
        //sb.draw(redHeart, 1114, 657, 32, 32);
        //sb.draw(redHeart, 1148, 657, 32, 32);
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

        sb.draw(healthMeterBG,hmx1, hmy, width, height);
        sb.draw(healthMeterBG,hmx2, hmy, width, height);
        sb.draw(healthMeter,hmx1, hmy, width*ch1.getHpprocent(), height);
        sb.draw(healthMeter,hmx2, hmy, width*ch2.getHpprocent(),height);

        CharSequence hpText1 = Math.round(ch1.getHpprocent()*100)+"%";
        CharSequence hpText2 =  Math.round(ch2.getHpprocent()*100)+"%";

        font.draw(sb, hpText1, 85, 706);
        font.draw(sb, hpText2, 1113, 706);

    }

    private void drawPlayerNames(SpriteBatch sb){
        CharSequence nameText1 = ("Player 1");
        CharSequence nameText2 = ("Player 2");

        font.draw(sb, nameText1, 170, 705);
        font.draw(sb, nameText2, 1020, 705);}

    public void drawBoard(SpriteBatch sb, Character ch1, Character ch2){
        board(sb);
        healthMeter(sb,ch1,ch2);
        drawPlayerNames(sb);
        hearts(sb);
    }
    public void dispose() {
        board.dispose();
        healthMeterBG.dispose();
        healthMeter.dispose();
        heart1.dispose();
        heart2.dispose();
    }
}
