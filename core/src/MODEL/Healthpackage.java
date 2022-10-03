package MODEL;

public class Healthpackage extends Powerups {
    private String name;

    public Healthpackage() {
        super("healthPackage");
    }

    @Override
    public void CollisionAction(Character player) {
        player.restoreHP();
    }
}
