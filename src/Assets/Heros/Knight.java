package Assets.Heros;

import Assets.*;

// Starts with high damage and high defense
// Medium hp
// Weak to magic attacks
// Low speed
// Simple character with few special skills
public class Knight extends Hero {
    private static final String FILE = "src/Images/blueknight.png";


    public Knight() {
        super(FILE, "blueknight", 15, 15, 15, 3, 10, 3);        
    }

    


}
