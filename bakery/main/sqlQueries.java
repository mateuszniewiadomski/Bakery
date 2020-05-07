package bakery.main;

import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.sql.*;
import java.util.Scanner;

public class sqlQueries extends Component {

    private Connection cn;
    private String url = "jdbc:sqlserver://localhost:1433;databaseName=master;";
    private String user;
    private String password;

    public void connect() {
        try {
            readFile();
            cn = DriverManager.getConnection(url, user, password);
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        } catch (ClassNotFoundException e) {
            System.out.println(e);
            JOptionPane.showMessageDialog(this, "Nie masz sterownika :(", "Błąd", JOptionPane.ERROR_MESSAGE);
        } catch (SQLException e) {
            System.out.println(e);
            JOptionPane.showMessageDialog(this, "Błąd połączenia", "Błąd", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void readFile() {
        try {
            File file = new File("loginInfo.txt");
            Scanner scanner = new Scanner(file);
            user = scanner.nextLine();
            password = scanner.nextLine();
            scanner.close();
        } catch (FileNotFoundException e) {
            System.err.println(e);
        }


    }
}

