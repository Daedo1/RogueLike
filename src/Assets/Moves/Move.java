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

    public abstract void use(Entity user, Entity target);

    public abstract void displayOptions();

    public abstract void resetOptions();

    public void setSelected(boolean selected) {

        if (selected) {
            Battle.getMoveManager().setMoveSelection(this);
        }   

        else {  
            resetOptions();
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
        Battle.getMoveManager().resetSelection();
        setSelected(true);
        displayOptions();

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

        if (Battle.getMoveManager().getMoveSelection() == this) {
            return;
        }

        setAlpha(1.0f);
        repaint();
    }

}

