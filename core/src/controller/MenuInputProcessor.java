package CONTROLLER;


public class MenuInputProcessor extends CONTROLLER.InputProcessor {



    @Override
    public boolean touchDown(int screenX, int screenY, int pointer, int whichmenubutton) {
        if((((screenY>300)&&(screenY<400))&&((screenX>430)&&(screenX<850)))&&(whichmenubutton == 0)){
            return true;
        }


        else if((((screenY>500)&&(screenY<635))&&((screenX>420)&&(screenX<850)))&&(whichmenubutton == 1)){
            return true;
        }

        else{
            return false;
        }


    }
}
