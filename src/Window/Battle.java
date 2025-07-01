package Window;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

import Assets.Character;

public class Battle extends Window implements MouseListener {
    
    public static Character selection; 


    public Battle() {
        setBg("src/Images/bg.png");

        JPanel background = getBg();

        JPanel panel = new JPanel();
        panel.setOpaque(false);

        panel.add(new Character());

        background.add(panel);
    }



    public void mousePressed(MouseEvent e) {

    }

    public void mouseClicked(MouseEvent e) {

    }

    public void mouseReleased(MouseEvent e) {

    }

    public void mouseEntered(MouseEvent e) {

    }
    public void mouseExited(MouseEvent e) {

    }

}
