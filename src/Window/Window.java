package Window;

import UI.Button;
import java.awt.*;
import javax.swing.*;


import Assets.Sprite;

public class Window extends JFrame {
    
    protected final String TITLE = "RogueLike";


    private static GraphicsDevice device = GraphicsEnvironment.getLocalGraphicsEnvironment().getScreenDevices()[0];
    private static boolean fullScreen = false;
    
    private static Window window = null;


    private Sprite background = null;

    protected Window() {

        setTitle(TITLE);
        setResizable(false);

        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setVisible(true);
        setFullScreen(fullScreen);
    }

    public static void update() {
        window.pack();
        window.setLocationRelativeTo(null);
    }

    public static Window getWindow() {
        if (Window.window == null) {
            throw new IllegalStateException("Window hasn't been initialized");
        }
        
        return window;
    }

    public static void setWindow(Window newWindow) {
        if (window != null) {
            window.dispose();
        }
        
        window = newWindow;
        update();
    } 

    public static void setFullScreen(boolean fullScreen) {
        Window.fullScreen = fullScreen; 

        if (Window.fullScreen) {
            device.setFullScreenWindow(window);
            window.setUndecorated(false);
        }

        else {
            device.setFullScreenWindow(null);
        }
    }

    public Sprite getBg() {
        if (background == null) {
            throw new IllegalStateException("Background has not been set");
        }


        return background;
    }

    public void setBg(String file) {

        background = new Sprite(file);
        add(background);

    }



}
