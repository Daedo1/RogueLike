package Assets;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.util.*;

import Window.*;
import Window.Window;


public class Entity extends Sprite implements MouseListener, Selectable {
    
    private static final String FILE = "src/Images/blueknight.png";

    private String name;
    private Map<String, Integer> stats;
    private boolean selectable;

    public Entity() {
        super(FILE);
        name = "default_name";
        stats = new HashMap<>();
        stats.put("health", 0);
        stats.put("maxHealth", 0);
        stats.put("attack", 0);
        stats.put("magic", 0);
        stats.put("defense", 0);
        stats.put("speed", 0);
        setSelectable(true); 
        addMouseListener(this);
    }

    public Entity(String file, String name, Map<String, Integer> stats) {
        super(file); 
        this.name = name;
        this.stats = stats;
        setSelectable(true); 
        addMouseListener(this);
    }

    public Entity(String file, String name, int health, int maxHealth, int attack,
                        int magic, int defense, int speed) {
        this(file, name, Map.of(
                "health", health,
                "maxHealth", maxHealth,
                "attack", attack,
                "magic", magic,
                "defense", defense,
                "speed", speed
        )); 
    }


    public void setSelectable(boolean selectable) {
        this.selectable = selectable;

        if (!this.selectable) {
            setAlpha(1.0f);
            repaint();
        }
    }

    public boolean getSelectable() {
        return selectable;
    }

    public void setSelected(boolean selected) {
        if (selected) {
            Window.getWindow().setSelection(this);
        }

        else {
            setAlpha(1.0f);
            repaint();
        }
    }

    public void mousePressed(MouseEvent e) {
        setSelected(true);
    }

    public void mouseClicked(MouseEvent e) {

    }

    public void mouseReleased(MouseEvent e) {

    }

    public void mouseEntered(MouseEvent e) {
        if (!selectable) {
            return;
        }
        setAlpha(ALPHA);
        repaint();

    }

    public void mouseExited(MouseEvent e) {
        if (!selectable) {
            return;
        }
        if (Window.getWindow().getSelection() == this) {
            return;
        }


        setAlpha(1.0f);
        repaint();

        
    }


    public String toString() {
        String text = "<html>";
        text += name + "<br>";
        text += "Health: " + stats.get("health") + "/" + stats.get("maxHealth") + "<br>";
        text += "Attack: " + stats.get("attack") + "<br>";
        text += "Defense: " + stats.get("defense") + "<br>";
        text += "Magic: " + stats.get("magic") + "<br>";
        text += "Speed: " + stats.get("speed") + "<br>";
        text += "</html>";
        return text;
    }
}
