package Assets;

import java.awt.*;
import javax.swing.*;

import java.util.*;


public class Character extends Sprite {
    
    private static final String FILE = "src/Images/blueknight.png";

    private String name;
    private Map<String, Integer> stats;


    private JLabel textLabel;

    public Character() {
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

        textLabel = new JLabel();

        add(textLabel);


        updateLabel();
    }

    public Character(String file, String name, Map<String, Integer> stats) {
        super(file); 
        this.name = name;
        this.stats = stats;
        setSelectable(true); 
    }

    public void updateLabel() {
        textLabel.setText(this.toString());
    }

    public String toString() {
        String text = "<html>";
        text += "Health: " + stats.get("health") + "/" + stats.get("maxHealth") + "<br>";
        text += "Attack: " + stats.get("attack") + "<br>";
        text += "Defense: " + stats.get("defense") + "<br>";
        text += "Magic: " + stats.get("magic") + "<br>";
        text += "Speed: " + stats.get("speed") + "<br>";
        text += "</html>";
        return text;
    }
}
