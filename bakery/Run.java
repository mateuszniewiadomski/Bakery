package bakery;
import bakery.main.Window;
import javax.swing.*;

public class Run {

    public static void main(String[] args) {
        Window app = new Window();
        app.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        app.setVisible(true);
    }
}
