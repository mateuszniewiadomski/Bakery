package bakery.main;

import bakery.hashing.HashPassword;

import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.sql.*;
import java.util.Scanner;

public class sqlQueries extends Component {

    private Connection cn;
    private String url = "jdbc:sqlserver://localhost:1433;databaseName=bakery;";
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

    public void newAccount(String login, String password) {
        String account = "";
        try {
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery("SELECT Account FROM Account WHERE Account = '" + login + "'");
            if (rs.next()) {
                account = rs.getString(1);
            }
            if (!(account.equals(login))) {
                HashPassword hp = new HashPassword();
                String hash = hp.generateHash(password);
                System.out.println(hash);
            }

        } catch (SQLException e) {
            System.out.println(e);
        }
    }

    public boolean checkPassword(String login, String password) {
        String hash = "";
        try {
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery("SELECT Password FROM Account WHERE Account = '" + login + "'");
            if (rs.next()) {
                hash = rs.getString(1);
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        if (hash.equals("")) {
            return false;
        } else {
            HashPassword hp = new HashPassword();
            return hp.checkPassword(password, hash);
        }
    }
}

