package Window;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

import Assets.Character;

public class Battle extends Window {


    public Battle() {
        setBg("src/Images/bg.png");

        JPanel background = getBg();

        JPanel panel = new JPanel();
        panel.setOpaque(false);

        panel.add(new Character());

        background.add(panel);

    }


}
