package model;

public class HealthPackage extends Powerups {
    private String name;

    public HealthPackage() {
        super("healthPackage");
    }

    @Override
    public void CollisionAction(Character player) {
        player.restoreHP();
    }
}
