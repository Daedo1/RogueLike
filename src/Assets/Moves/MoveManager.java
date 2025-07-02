package Assets.Moves;

import java.util.List;
import java.util.ArrayList;
import java.awt.*;
import javax.swing.*;

import Assets.*;

public class MoveManager extends Sprite {
    private static final String FILE = "src/Images/moveManager.png";


    private Move moveSelection;
    private List<Move> moves;

    public MoveManager() {
        super(FILE);
        moveSelection = null;
        moves = new ArrayList<>();
    }

    public void add(List<Move> moves) {
        this.moves = moves;
        
        for (Move move : moves) {
            super.add(move);
        }
    }

    public void clear() {
        for (Move move : moves) {
            remove(move);
        }

        revalidate();
        repaint();

        resetSelection();

    }

    public void resetSelection() {
        if (moveSelection == null) {
            return;
        }

        moveSelection.setSelected(false);
        moveSelection = null;
    }

    public void setMoveSelection(Move moveSelection) {
        this.moveSelection = moveSelection;
    }

    public Move getMoveSelection() {
        return moveSelection;
    }
}
