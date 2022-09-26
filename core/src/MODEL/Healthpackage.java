package MODEL;

public class Healthpackage extends Powerups{

    public Healthpackage(){
        super();
    }
    @Override
    public void CollisionAction(CharacterREAL player){
        player.restoreHP();
    }
}
