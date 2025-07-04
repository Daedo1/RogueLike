package Assets.Moves;

import Assets.*;
import Assets.Battle.*;
import Window.*;

public class Pass extends Move {
    private static final String FILE = "src/Images/pass.png";

    public Pass() {
        super(FILE);
    }

    public void use(Entity user, Entity target) {

    }

    public void displayOptions() {

        Battle.getMoveManager().resetSelection();
        TurnManager.changeTurn();
    }

    public void resetOptions() {

    }
}
