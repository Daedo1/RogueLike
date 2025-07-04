package Assets.Moves;

import Assets.*;

import java.util.*;
import java.util.List;

import Window.Window;
import Window.*;

import Assets.Battle.*;

public class Attack extends Move {

    private static final String FILE = "src/Images/attack.png";

    public Attack() {
        super(FILE);
    }

    public void use(Entity user, Entity target) {

        Map<String, Integer> userStats = user.getStats();
        //Map<String, Integer> targetStats = target.getStats();

        target.assignDamage(userStats.get("attack"), 0);

        Battle.getMoveManager().resetSelection();
        TurnManager.changeTurn();

    }   

    public void displayOptions() {
        for (Entity enemy : Battle.getEnemies()) {
            enemy.attackTarget();
        }
    }

    public void resetOptions() {

        for (Entity enemy : Battle.getEnemies()) {
            enemy.removeTarget();
        }
    }
}
