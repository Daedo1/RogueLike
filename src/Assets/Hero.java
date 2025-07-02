package Assets;

import java.util.*;

// Similar to a character except able to carry equipment
// 
public class Hero extends Entity {
    
    public Hero() {
        super();
    }

    public Hero(String file, String name, Map<String, Integer> stats) {
        super(file, name, stats);
    }

    public Hero(String file, String name, int health, int maxHealth, int attack,
                int magic, int defense, int speed) {
        super(file, name, health, maxHealth, attack, magic, defense, speed);
    }




}
