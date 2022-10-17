package controller;


public class MenuInputProcessor extends InputProcessor {

    @Override
    public boolean touchDown(int screenX, int screenY, int pointer, int whichmenubutton) {
        if((((screenY>300)&&(screenY<400))&&((screenX>430)&&(screenX<850)))&&(whichmenubutton == 0)){
            return true;
        }


        else{
            return (((screenY > 500) && (screenY < 635)) && ((screenX > 420) && (screenX < 850))) && (whichmenubutton == 1);
        }


    }
}
