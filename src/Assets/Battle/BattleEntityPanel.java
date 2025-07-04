package Assets.Battle;

import java.util.*;
import java.util.List;

import javax.swing.*;

import Assets.Entity;
import Assets.Sprite;

import java.awt.*;


public class BattleEntityPanel extends Sprite {
    private static final String FILE = "src/Images/battleentitypanel.png";


    private List<Entity> entities;

    public BattleEntityPanel(List<Entity> entities) {
        super(FILE);
        this.entities = entities;

        for (Entity entity : entities) {
            add(entity);
        }
    }

    public List<Entity> getEntities() {
        return entities;
    }



}
