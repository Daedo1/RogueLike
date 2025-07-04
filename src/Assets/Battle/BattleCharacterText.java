package Assets.Battle;

import java.awt.*;
import javax.swing.*;

import Assets.Entity;
import Assets.Sprite;

public class BattleCharacterText extends Sprite {
    
    private static final String FILE = "src/Images/battle_character_text.png";


    private JLabel text;

    public BattleCharacterText() {
        super(FILE);

        setOpaque(false);

        text = new JLabel();
        text.setOpaque(false);

        add(text);

    }   

    public void setCharacter(Entity c) {
        text.setText(c.toString());
    }  


    public void clear() {
        text.setText("");
    }




}
