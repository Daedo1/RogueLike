package Window;

import UI.Button;
import java.awt.*;
import javax.swing.*;

import java.awt.event.*;
import Assets.*;

import java.util.List;
import java.util.ArrayList;

import Assets.Heros.*;

public class Window extends JFrame implements MouseListener {
    
    protected final String TITLE = "RogueLike";

    private static GraphicsDevice device = GraphicsEnvironment.getLocalGraphicsEnvironment().getScreenDevices()[0];
    private static boolean fullScreen = false;
    
    private static Window window = null;


    private JLayeredPane layers;
    private JPanel toolTipLayer;
    private Sprite background;
    private Selectable selection;


    protected Window() {

        layers = new JLayeredPane();
        background = null;
        selection = null;

        setTitle(TITLE);
        setResizable(false);

        /* 
        add(layers);
        toolTipLayer = new JPanel();
        layers.add(toolTipLayer);
        toolTipLayer.add(new Knight());
        toolTipLayer.setLayout(null);
        toolTipLayer.setBounds(0, 0, 1000, 1000);
        setLayout(null);
        */

        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setVisible(true);
        setFullScreen(fullScreen);
        addMouseListener(this);
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


    public void setSelection(Selectable selection) {
        this.selection = selection;
    }

    public Selectable getSelection() {
        return this.selection;
    }

    public void resetSelection() {
        if (selection == null) {
            return;
        }

        this.selection.setSelected(false);
        this.selection = null;
    }

    public void mousePressed(MouseEvent e) {
        if (selection == null) {
            return;
        }
        
        resetSelection();
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
