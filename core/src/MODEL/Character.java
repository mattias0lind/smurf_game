package MODEL;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Vector2;

public abstract class Character {

        private static final int gravity = -15; //tog bort final ifall man i framtiden vill göra en power-up som förändrar gravitation.
        private Vector2 position; // "gravity" kanske inte ens bör vara i karaktär klassen.
        private Vector2 velocity;
        private String characterName;

    public Character(int x, int y, String characterName){
            position = new Vector2(x, y);
            velocity = new Vector2(0, 0);
            this.characterName = characterName;
        }
        public void update(float dt) {
            velocity.add(0, gravity);
            velocity.scl(dt);
            position.add(0, velocity.y);

            velocity.scl(1 / dt); //dt är står för deltatime alltså har med tidsuppfattning att göra
        }
        public Vector2 getPosition(){
            return position;

        }
        public String getName() {
            return characterName;
        }

        public void jump(){
            if(velocity.y == 0){//Character only able to jump from the ground. Kanske kan vara bättre
            velocity.y = 250;  // om man har någonslags kollison == True för att motverka eventuella buggar
        }

    }
}
