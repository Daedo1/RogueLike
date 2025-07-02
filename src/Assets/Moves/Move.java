package Assets.Moves;

import Assets.*;
import java.awt.event.*;
import javax.swing.*;

import java.util.List;

import Window.Window;
import Window.Battle;

public abstract class Move extends Sprite implements Selectable, MouseListener {
    

    private boolean selectable;

    public Move(String file) {
        super(file);
        selectable = true;

        addMouseListener(this);
    }

    public abstract void use(List<Entity> targets);


    public void setSelected(boolean selected) {

        if (selected) {
            getMoveManager().setMoveSelection(this);
            selected = true;
        }   

        else {  
            selected = false;
            setAlpha(1.0f);
            repaint();
        }

    }

    public boolean getSelectable() {
        return selectable;
    }

    public void setSelectable(boolean selectable) {
        this.selectable = selectable;
    }

    public void mousePressed(MouseEvent e) {
        getMoveManager().resetSelection();
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

        if (getMoveManager().getMoveSelection() == this) {
            return;
        }

        setAlpha(1.0f);
        repaint();
    }

    private MoveManager getMoveManager() {
        Window currWindow = Window.getWindow();

        if (!(currWindow instanceof Battle)) {
            throw new IllegalStateException("Not a battle");
        }

        Battle battle = (Battle) currWindow;

        return battle.getMoveManager();
    }
}

