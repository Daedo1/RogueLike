package Window;

import UI.Button;
import java.awt.*;
import javax.swing.*;

import java.awt.event.*;
import Assets.*;

import java.util.List;
import java.util.ArrayList;

import Assets.Heros.*;
import UI.*;

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

    
        toolTipLayer = new JPanel();
        toolTipLayer.setOpaque(false);
        layers.add(toolTipLayer, JLayeredPane.MODAL_LAYER);
      
        setLayeredPane(layers);

        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setVisible(true);
        setFullScreen(fullScreen);
        addMouseListener(this);

        setLayout(null);

    }

    public static void update() {
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

        int width = (int) background.getPreferredSize().getWidth();
        int height = (int) background.getPreferredSize().getHeight();

        layers.setBounds(0, 0, width, height);
        setSize(width, height);

        layers.add(background, JLayeredPane.DEFAULT_LAYER);
        background.setBounds(0, 0, width, height);
        toolTipLayer.setBounds(0, 0, width, height);


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
