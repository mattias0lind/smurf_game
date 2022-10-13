package model;

import com.badlogic.gdx.physics.box2d.Contact;
import com.badlogic.gdx.physics.box2d.ContactImpulse;
import com.badlogic.gdx.physics.box2d.Manifold;

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
