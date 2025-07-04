package Assets;

import java.util.*;

public class Enemy extends Entity {
    

    public Enemy() {
        super();
    }

    public Enemy(String file, String name, Map<String, Integer> stats) {
        super(file, name, stats);
    }

    public Enemy(String file, String name, int health, int maxHealth, int attack,
                    int magic, int defense, int speed) {
        super(file, name, health, maxHealth, attack, magic, defense, speed);
    }
}
