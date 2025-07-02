package Window;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;


import Assets.*;
import Assets.Entity;
import Assets.Heros.*;
import Assets.Enemies.*;
import Assets.Moves.*;

import java.util.List;

public class Battle extends Window {


    private BattleCharacterText characterText;
    private MoveManager moveManager;


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
        characterPanel.add(new Knight());
        characterPanel.add(new Ranger());

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
        JPanel enemyPanel = new JPanel();
        enemyPanel.setOpaque(false);

        enemyPanel.add(new Skeleton());

        // Adding All panels to rightPanel 
        rightPanel.add(enemyPanel);


        background.add(leftPanel);
        background.add(rightPanel);
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

    public MoveManager getMoveManager() {
        return moveManager;
    }

}
