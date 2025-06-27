package UI;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class Button extends JButton implements ActionListener {
    

    public Button() {
        setText("ih");
        addActionListener(this);
    }


    public void actionPerformed(ActionEvent e) {
        System.exit(0);
    }
}
