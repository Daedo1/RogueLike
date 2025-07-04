package Assets.Heros;

import Assets.*;

// Medium Attack but has the ability to ignore defense
// Medium hp and low defense
// High defense against magic
// High speed
// Starts with several special skills
public class Rogue extends Hero {
    private static final String FILE = "src/Images/rogue.png";


    public Rogue() {
        super(FILE, "rogue", 10, 10, 10, 5, 2, 12);
    }
}
