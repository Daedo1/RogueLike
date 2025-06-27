package Window;

import java.awt.*;
import javax.swing.*;


public class Window extends JFrame {
    
    private final String TITLE = "RogueLike";


    private static Window window = null;

    protected Window() {
        
        setTitle(TITLE);
        setResizable(false);

        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    public Window getWindow() {
        if (Window.window == null) {
            throw new IllegalStateException("Window hasn't been initialized");
        }
        
        return window;
    }



}
