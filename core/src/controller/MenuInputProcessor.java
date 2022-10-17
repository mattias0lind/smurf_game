package controller;


/**
 * A class used to check if the play button or quit button was pressed in the MenuState
 */
public class MenuInputProcessor extends InputProcessor {

    /**
     * Method used to check if either button was pressed
     * @param screenX The x coordinate, origin is in the upper left corner
     * @param screenY The y coordinate, origin is in the upper left corner
     * @param pointer the pointer for the event.
     * @param whichmenubutton the button
     * @return true if the button was pressed
     */
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
