package Window;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;


import Assets.*;
import Assets.Entity;
import Assets.Heros.*;

public class Battle extends Window {


    private BattleCharacterText characterText;

    public Battle() {
        setBg("src/Images/bg.png");


        characterText = new BattleCharacterText();

        JPanel background = getBg();

        JPanel panel = new JPanel();
        panel.setOpaque(false);

        panel.add(new Ranger());
        panel.add(new Knight());
        panel.add(new Rogue());

        JPanel textPanel = new JPanel();
        textPanel.setOpaque(false);
        textPanel.add(characterText);

        background.add(panel);
        background.add(textPanel);

    }

    public void setSelection(Selectable selection) {
        super.setSelection(selection);

        if (selection instanceof Entity) {
            Entity c = (Entity) selection;
            characterText.setCharacter(c);

        }

    }   

    public void resetSelection() {
        super.resetSelection();

        characterText.clear();
    }

}
