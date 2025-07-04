package Assets.Battle;

import Assets.*;

public class TargetBorderAttack extends TargetBorder {
    private static final String FILE = "src/Images/attackOption.png";

    public TargetBorderAttack(Entity target) {
        super(FILE, target);
    }
}
