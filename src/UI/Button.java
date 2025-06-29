package UI;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

import Assets.Sprite;

public abstract class Button extends Sprite implements MouseListener {
    
    private static final String FILE = "src/Images/button.png";


    private static final float ALPHA = 0.9f;


    private JLabel textLabel;
    private String text; 

    public Button(String text) {
        super(FILE);

        textLabel = new JLabel();
        add(textLabel);
        this.text = text;
        textLabel.setText(this.text);
        textLabel.setOpaque(false);

        addMouseListener(this);
    }

    public abstract void action();

    public void mousePressed(MouseEvent e) {

    }

    public void mouseClicked(MouseEvent e) {
        action();
    }

    public void mouseReleased(MouseEvent e) {

    }
    
    public void mouseEntered(MouseEvent e) {
        setAlpha(ALPHA);
        repaint();
    }

    public void mouseExited(MouseEvent e) {
        setAlpha(1.0f);
        repaint();
    }




}
