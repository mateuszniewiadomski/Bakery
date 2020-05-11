package bakery.main;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
public class Window extends JFrame implements ActionListener {

    public Window() {
        setSize(1000, 600);
        setTitle("Bakery Management");
        setResizable(true);
        setLocationRelativeTo(null);
        sqlQueries q = new sqlQueries();
        q.connect();
        q.checkPassword("admin", "admin");
        q.checkPassword("admin", "placek");
        q.newAccount("admin", "elo");
        q.newAccount("elo", "elo");
    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }
}
