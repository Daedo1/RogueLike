package UI;

import Window.*;


public class Play extends Button {
    

    public Play() {
        super("Play");
    }

    public void action() {
        Window.setWindow(new Battle());
    }
}
