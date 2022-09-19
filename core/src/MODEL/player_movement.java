package MODEL;

public class player_movement implements movement {
    private int playerXPosition;
    private int playerYPosition;

    public int getPlayerXPosition(){
        return playerXPosition;
    }

    public int getPlayerYPosition(){
        return playerYPosition;
    }

    @Override
    public void updatePlayerPosition(int playerXPosition, int playerYPosition) {
        this.playerXPosition = playerXPosition;
        this.playerYPosition = playerYPosition;
    }

}

