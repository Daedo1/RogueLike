package Window;

import UI.*;
import java.awt.*;
import javax.swing.*;

public class Menu extends Window {
    

    public Menu() {

        setBg("src/Images/bg.png");

        JPanel background = getBg();

        // Buttons

        JPanel buttonPanel = new JPanel();
        buttonPanel.setOpaque(false);

        buttonPanel.setLayout(new BoxLayout(buttonPanel, BoxLayout.Y_AXIS));

        buttonPanel.add(new Play());
        buttonPanel.add(Box.createRigidArea(new Dimension(0, 10)));

        buttonPanel.add(new Quit());


        // Add all component panels to background

        background.add(buttonPanel);



    }


}
