package Assets.Battle;

import java.util.*;

import Window.Window;
import Window.*;

import Assets.*;

public class TurnManager {
    

    private static List<Entity> turns;

    private TurnManager() { 
        
    }


    public static void init(List<Entity> heros, List<Entity> enemies) {
        turns = new ArrayList<>();

        turns.addAll(heros);
        turns.addAll(enemies);
        sortTurnOrder();


        changeTurn();
    }  


    public static void changeTurn() {
        Entity currentTurn = turns.remove(0);
        turns.get(turns.size() - 1).setSelectable(false);
        turns.add(currentTurn);
        currentTurn.setSelectable(true);

        Window.getWindow().resetSelection();
    }

    public static void checkWin() {
        if (Battle.getHeros().isEmpty()) {

        }

        else if (Battle.getEnemies().isEmpty()) {

        }
    }

    private static void sortTurnOrder() {
        List<Entity> temp = new ArrayList<>();

        while(!turns.isEmpty()) {

            Entity fastest = turns.get(0);

            for (Entity entity : turns) {
                if (entity.getStats().get("speed") > fastest.getStats().get("speed")) {
                    fastest = entity;
                }
            }

            turns.remove(fastest);
            temp.add(fastest);

        }

        turns = temp;
    }

    public static void removeEntity(Entity entity) {
        turns.remove(entity);
    }
}
