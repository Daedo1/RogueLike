package Assets;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.util.*;
import java.util.List;

import Window.*;
import Window.Window;

import Assets.Moves.*;

import Assets.Battle.*;


public class Entity extends Sprite implements MouseListener, Selectable {
    
    private static final String FILE = "src/Images/blueknight.png";

    private String name;
    private Map<String, Integer> stats;
    private boolean selectable;
    private List<Move> moves;
    private TargetBorder target;

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
        addMouseListener(this);

        moves = new ArrayList<>();
        target = null;

    }

    public Entity(String file, String name, int health, int maxHealth, int attack, int magic,
                    int defense, int speed) {
        super(file);
        this.name = name;
        stats = new HashMap<>();
        
        stats.put("health", health);
        stats.put("maxHealth", maxHealth);
        stats.put("attack", attack);
        stats.put("magic", magic);
        stats.put("defense", defense);
        stats.put("speed", speed);

        addMouseListener(this);

        moves = new ArrayList<>();
        moves.add(new Attack());
        moves.add(new Pass());
    }



    public Entity(String file, String name, Map<String, Integer> stats) {
        this(file, name, stats.get("health"), stats.get("maxHealth"), stats.get("attack"),
                    stats.get("magic"), stats.get("defense"), stats.get("speed"));
    }

    public void addMove(Move move) {
        moves.add(move);
    }

    public List<Move> getMoves() {
        return moves;
    }

    public Map<String, Integer> getStats() {
        return stats;
    }


    // Type of Attack where 0 - physical
    // 1 - magic attack
    // 2 - speed attack
    public void assignDamage(int damage, int type) {
        String usedModifier;

        if (type == 0) {
            usedModifier = "defense";
        }

        else if (type == 1) {
            usedModifier = "magic";
        }

        else {
            usedModifier = "speed";
        }


        int actualDamage = damage - stats.get(usedModifier);

        if (actualDamage <= 0) {
            actualDamage = 1;
        }

        stats.put("health", stats.get("health") - actualDamage);

        if (stats.get("health") <= 0) {
            Battle.removeEntity(this);
        }



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
        if (!selectable) {
            return;
        }


        Window.getWindow().resetSelection();
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

    public void attackTarget() {
        target = new TargetBorderAttack(this);
        addCenter(target);
        repaint();

    }

    public void removeTarget() {
        if (target == null) {
            throw new IllegalStateException("Attempted to remove target that is not initialized");
        }

        remove(target);
        target = null;

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
