package MODEL;

public class player_movement implements movement {
    private int playerXPosition;
    private int playerYPosition;
    private boolean moveLeft,moveRight,moveUp,moveDown;

    public int getPlayerXPosition(){
        return playerXPosition;
    }

    public int getPlayerYPosition(){return playerYPosition;}

    @Override
    public void setPlayerPosition(int playerXPosition, int playerYPosition){
        this.playerXPosition = playerXPosition;
        this.playerYPosition = playerYPosition;
    }

    public void updatePlayerPosition() {
        if(moveLeft){
            this.playerXPosition -= 31;
        }
        if(moveRight){
            this.playerXPosition += 31;
        }
        if(moveUp){
            this.playerYPosition += 31;
        }
        if(moveDown){
            this.playerYPosition -=31;
        }

    }


    public void moveLeft(){

    }

}

