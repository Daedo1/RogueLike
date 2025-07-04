package Assets.Battle;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

import Assets.*;
import Assets.Moves.*;

import Window.*;
import Window.Window;

public class TargetBorder extends Sprite implements MouseListener {
    
    private Entity target;

    public TargetBorder(String file, Entity target) {
        super(file);

        addMouseListener(this);
        this.target = target;


    } 



    public void mousePressed(MouseEvent e) {

        Entity user = (Entity) Window.getWindow().getSelection();
        Move move = Battle.getMoveManager().getMoveSelection(); 

        move.use(user, target); 


    }

    public void mouseClicked(MouseEvent e) {

    }

    public void mouseReleased(MouseEvent e) {

    }

    public void mouseEntered(MouseEvent e) {
        setAlpha(ALPHA);
        repaint();
    }

    public void mouseExited(MouseEvent e) {
        setAlpha(1.0f);
        repaint();
    }
}
