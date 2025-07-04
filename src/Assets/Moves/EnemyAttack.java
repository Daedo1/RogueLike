package Assets.Moves;

import Window.*;
import Assets.*;
import Assets.Battle.*;

public class EnemyAttack extends Attack {
    
    public EnemyAttack() {
        super();
    }

    public void displayOptions() {
        for (Entity hero : Battle.getHeros()) {
            hero.attackTarget();
        }
    }

    public void resetOptions() {
        for (Entity hero : Battle.getHeros()) {
            hero.removeTarget();
        }
    }

}
