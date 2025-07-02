package Assets.Enemies;

import Assets.*;

public class Skeleton extends Enemy {
    private static final String FILE = "src/Images/skeleton.png";

    public Skeleton() {
        super(FILE, "skeletons", 0, 0, 0, 0, 0, 0);
    }
}
