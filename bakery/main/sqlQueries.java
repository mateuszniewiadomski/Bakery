package bakery.main;

import bakery.hashing.HashPassword;

import javax.swing.*;
import javax.swing.text.Position;
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

    public void newAccount(String Name, String Surname, String Pesel, String BirthDate, String Gender, String Phone, String Street, int HomeNr, String PostalCode, String City, String User, String Password, int Position) {
        try {
            Statement stNA = cn.createStatement();
            HashPassword hp = new HashPassword();
            Password = hp.generateHash(Password);
            Statement stNAPassword = cn.createStatement();
            ResultSet rsPassword = stNAPassword.executeQuery("SELECT Id FROM Account ORDER BY Id DESC");
            int AccountId = 1;
            if (rsPassword.next()) {
                AccountId = rsPassword.getInt(1);
            }
            AccountId = AccountId + 1;
            stNA.executeUpdate("INSERT INTO Account(Id, Account, Password) VALUES (" + AccountId + ",'"+User+"','"+Password+"')");
            Statement stAdres = cn.createStatement();
            ResultSet rsAdres = stAdres.executeQuery("SELECT Id FROM Adres ORDER BY Id DESC");
            int AdresId = 1;
            if (rsAdres.next()) {
                AdresId = rsAdres.getInt(1);
            }
            AdresId = AdresId + 1;
            Statement stEmployee = cn.createStatement();
            stAdres.executeUpdate("INSERT INTO Adres (Id, Street, Nr_Home, PostalCode, City) VALUES ("+AdresId+",'"+ Street +"',"+ HomeNr +",'"+ PostalCode +"','"+ City +"')");
            Statement stE = cn.createStatement();
            ResultSet rsE = stE.executeQuery("SELECT Id FROM Employee ORDER BY Id DESC");
            int EmployeeId = 1;
            if (rsE.next()) {
                EmployeeId = rsE.getInt(1);
            }
            EmployeeId = EmployeeId + 1;
            stEmployee.executeUpdate("INSERT INTO Employee (Id, Id_Adres, Id_Position, Name, Surname, Pesel, BirthDate, Gender, PhoneNumber, Id_Account) " +
                    "VALUES ("+EmployeeId+","+AdresId+","+(Position+1)+",'"+Name+"','"+Surname+"','"+Pesel+"','"+BirthDate+"','"+Gender+"','"+Phone+"',"+AccountId+")");
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

    public String[] fillcbPosition() {
        try {
            Statement st = cn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            ResultSet rs = st.executeQuery("SELECT PositionName FROM Position ORDER BY Id");
            rs.last();
            int rows = rs.getRow();
            rs.first();
            String[] s = new String[rows];
            for (int i = 0; i < rows; i++) {
                s[i] = rs.getString(1);
                rs.next();
            }
            return s;
        } catch (SQLException e) {
            System.err.println(e);
        }
        return null;
    }

    public boolean userExists(String s) {
        String x = "";
        try {
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery("SELECT Account FROM Account WHERE Account = '" + s + "'");
            if (rs.next()) {
                x = rs.getString(1);
            }
            if (x.equals("")) {
                return false;
            } else {
                return true;
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return true;
    }

    public int setUserId(String login) {
        int id = 0;
        try {
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery("SELECT Employee.Id FROM Employee INNER JOIN Account ON Account.Id = Employee.Id_Account WHERE Account.Account = '"+login+"'");
            if (rs.next()) {
                id = rs.getInt(1);
            }
        } catch (SQLException e) {
            System.err.println(e);
        }
        return id;
    }

    public String getNameHome(int Id) {
        String s = "";
        try {
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery("SELECT Name FROM Employee WHERE Id = "+Id);
            if (rs.next()) {
                s = rs.getString(1);
            }
        } catch (SQLException e) {
            System.err.println(e);
        }
        return s;
    }

    public String getPicture(String dbo, int id) {
        String s = "";
        try {
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery("SELECT ImageURL FROM "+dbo+" WHERE Id = "+id);
            if (rs.next()) {
                s = rs.getString(1);
            }
        } catch (SQLException e) {
            System.err.println(e);
        }
        if (s == null) {
            s = "default.jpg";
        }
        return s;
    }

    public String getAdres1(int id) {
        String s = "";
        try {
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery("SELECT Street, Nr_Home FROM Adres INNER JOIN Employee ON Employee.Id_Adres = Adres.Id WHERE Employee.Id = "+id);
            if (rs.next()) {
                s = rs.getString(1) + " " + rs.getString(2);
            }
        } catch (SQLException e) {
            System.err.println(e);
        }
        return s;
    }

    public String getAdres2(int id) {
        String s = "";
        try {
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery("SELECT City, PostalCode FROM Adres INNER JOIN Employee ON Employee.Id_Adres = Adres.Id WHERE Employee.Id = "+id);
            if (rs.next()) {
                s = rs.getString(1) + " " + rs.getString(2);
            }
        } catch (SQLException e) {
            System.err.println(e);
        }
        return s;
    }
}

