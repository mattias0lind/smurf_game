package CONTROLLER;

import java.util.concurrent.TimeUnit;

public class CharacterSelectionInputProcessor extends CONTROLLER.InputProcessor{
    @Override
    public boolean touchDown(int screenX, int screenY, int i2, int whichButton) {

        if((((screenY>580)&&(screenY<683))&&((screenX>417)&&(screenX<860)))&&(whichButton == 0)){
            return true;
        }

        if (((screenY>310)&&(screenY<340))&&((screenX<150)&&(screenX>100))&&(whichButton == 1)){
            return true;
        }

        if (((screenY>310)&&(screenY<340))&&((screenX>299)&&(screenX<330))&&(whichButton == 2)){
            return true;
        }

        if (((screenY>310)&&(screenY<340))&&((screenX<1000)&&(screenX>970))&&(whichButton == 3)){
            return true;
        }

        if (((screenY>310)&&(screenY<340))&&((screenX>1170)&&(screenX<1200))&&(whichButton == 4)){
            return true;
        }
        return false;






       // else if (((screenY>300)&&(screenY<400))&&((screenX>430)&&(screenX<850))&&(whichButton == 1)){}


    }
}
