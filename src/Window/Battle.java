package Window;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;


import Assets.*;
import Assets.Battle.*;
import Assets.Heros.*;
import Assets.Enemies.*;
import Assets.Moves.*;

import java.util.List;
import java.util.ArrayList;

public class Battle extends Window {


    private BattleCharacterText characterText;
    private MoveManager moveManager;

    private BattleEntityPanel heroPanel;
    private BattleEntityPanel enemyPanel;


    public Battle() {
        setBg("src/Images/bg.png");


        
        JPanel background = getBg();
        background.setLayout(new BoxLayout(background, BoxLayout.X_AXIS));

        // * Left Side
        JPanel leftPanel = new JPanel();
        leftPanel.setOpaque(false);
        leftPanel.setLayout(new BoxLayout(leftPanel, BoxLayout.Y_AXIS));
    
        // ** CharacterPanel
        JPanel characterPanel = new JPanel();
        characterPanel.setOpaque(false);

        List<Entity> heros = new ArrayList<>();
        heros.add(new Knight());
        heros.add(new Ranger());


        heroPanel = new BattleEntityPanel(heros);
        characterPanel.add(heroPanel);

        // ** CharacterTextPanel
        characterText = new BattleCharacterText();

        JPanel characterTextPanel = new JPanel();
        characterTextPanel.setOpaque(false);
        characterTextPanel.add(characterText);

        moveManager = new MoveManager();

        characterTextPanel.add(moveManager);

        // Adding All panels to LeftPanel
        leftPanel.add(characterPanel);
        leftPanel.add(Box.createRigidArea(new Dimension(0, 10)));
        leftPanel.add(characterTextPanel);


        // * Right side
        JPanel rightPanel = new JPanel();
        rightPanel.setOpaque(false);

        rightPanel.setLayout(new BoxLayout(rightPanel, BoxLayout.Y_AXIS));


        // ** Enemy Panel
        JPanel enemyJPanel = new JPanel();
        enemyJPanel.setOpaque(false);

        List<Entity> enemies = new ArrayList<>();
        enemies.add(new Skeleton());

        enemyPanel = new BattleEntityPanel(enemies);

        enemyJPanel.add(enemyPanel);

        // Adding All panels to rightPanel 
        rightPanel.add(enemyJPanel);


        background.add(leftPanel);
        background.add(rightPanel);

        TurnManager.init(heros, enemies);

    }

    public void setSelection(Selectable selection) {
        super.setSelection(selection);

        if (selection instanceof Entity) {
            Entity c = (Entity) selection;
            characterText.setCharacter(c);
            moveManager.add(c.getMoves());
        }

    }   

    public void resetSelection() {
        super.resetSelection();
        characterText.clear();
        moveManager.clear();
    }

    public static MoveManager getMoveManager() {
        
        Window currWindow = Window.getWindow();

        if (!(currWindow instanceof Battle)) {
            throw new IllegalStateException("Not a battle");
        }

        Battle battle = (Battle) currWindow;

        return battle.moveManager;
    }

    public static List<Entity> getHeros() {
        Window currWindow = Window.getWindow();

        if (!(currWindow instanceof Battle)) {
            throw new IllegalStateException("Not a battle");
        }

        Battle battle = (Battle) currWindow;


        return battle.heroPanel.getEntities();
    }

    public static List<Entity> getEnemies() {
        Window currWindow = Window.getWindow();

        if (!(currWindow instanceof Battle)) {
            throw new IllegalStateException("Not a battle");
        }

        Battle battle = (Battle) currWindow;


        return battle.enemyPanel.getEntities();
    }

    public static void removeEntity(Entity entity) {

        Window currWindow = Window.getWindow();

        if (!(currWindow instanceof Battle)) {
            throw new IllegalStateException("Not a battle");
        }

        Battle battle = (Battle) currWindow;

        if (Battle.getHeros().contains(entity)) {
            battle.heroPanel.remove(entity);
            battle.heroPanel.repaint();
        }

        else {
            battle.enemyPanel.remove(entity);
            battle.enemyPanel.repaint();
        }
    }

}
