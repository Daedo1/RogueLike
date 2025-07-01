package Window;

import UI.*;
import java.awt.*;
import javax.swing.*;

public class Menu extends Window {
    

    public Menu() {

        setBg("src/Images/bg.png");

        JPanel background = getBg();
        JPanel panel = new JPanel();
        background.add(panel);
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        panel.setOpaque(false);

        // Title
        JPanel titlePanel = new JPanel();

        JLabel titleText = new JLabel(TITLE);
        titleText.setFont(new Font("Arial", Font.PLAIN, 44));


        titlePanel.setOpaque(false);
        titlePanel.add(titleText);


        // Buttons

        JPanel buttonPanel = new JPanel();
        buttonPanel.setOpaque(false);

        buttonPanel.setLayout(new BoxLayout(buttonPanel, BoxLayout.Y_AXIS));

        buttonPanel.add(new Play());
        buttonPanel.add(Box.createRigidArea(new Dimension(0, 10)));

        buttonPanel.add(new Quit());


        // Add all component panels to panel
        panel.add(titlePanel);
        panel.add(buttonPanel);



    }


}
