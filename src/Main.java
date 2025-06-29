
import Window.*;
import UI.*;
public class Main {
    public static void main(String[] args) {

        Window.setWindow(new Menu());
        Window.getWindow().add(new Quit());
        Window.update();

    }
    
}