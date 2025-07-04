package Assets.Enemies;

import Assets.*;
import Assets.Moves.*;

// Basic magic-based enemy
public class Skeleton extends Enemy {
    private static final String FILE = "src/Images/skeleton.png";

    public Skeleton() {
        super(FILE, "skeleton", 10, 10, 8, 6, 4, 6);
        addMove(new EnemyAttack());
    }
}
