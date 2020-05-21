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

    public String getSalaryOrPosition(int id, String q) {
        String s = "";
        try {
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery("SELECT "+q+" FROM Position INNER JOIN Employee ON Employee.Id_Position = Position.Id WHERE Employee.Id = "+id);
            if (rs.next()) {
                s = rs.getString(1);
            }
        } catch (SQLException e) {
            System.err.println(e);
        }
        return s;
    }

    public String[] fillcbCat(int id) {
        if (id >= 1) {
            try {
                Statement st = cn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
                ResultSet rs = st.executeQuery("SELECT CategoryName FROM Category INNER JOIN Subcategory ON Category.Id_Subcategory = Subcategory.Id WHERE Subcategory.Id = "+ id +" ORDER BY Category.Id");
                rs.last();
                int rows = rs.getRow();
                rs.first();
                String[] s = new String[rows+1];
                for (int i = 0; i < rows; i++) {
                    s[i+1] = rs.getString(1);
                    rs.next();
                }
                s[0] = "All";
                return s;
            } catch (SQLException e) {
                System.err.println(e);
            }
        } else {
            try {
                Statement st = cn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
                ResultSet rs = st.executeQuery("SELECT CategoryName FROM Category ORDER BY Id");
                rs.last();
                int rows = rs.getRow();
                rs.first();
                String[] s = new String[rows+1];
                for (int i = 0; i < rows; i++) {
                    s[i+1] = rs.getString(1);
                    rs.next();
                }
                s[0] = "All";
                return s;
            } catch (SQLException e) {
                System.err.println(e);
            }
        }
        return null;
    }

    public String[] fillcbSubcat() {
        try {
            Statement st = cn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            ResultSet rs = st.executeQuery("SELECT SubcategoryName FROM Subcategory ORDER BY Id");
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

    public String[][] getProducts(int cat, int subCat, String word, String pMax, String pMin, int order) {
        if (pMax.equals("")) {
            pMax = "100000";
        }
        if (pMin.equals("")) {
            pMin = "0";
        }
        String where = " WHERE (Product.Price BETWEEN "+pMin+" AND "+pMax+") ";
        if (cat != 0) {
            where = where + "AND (Category.Id = "+cat+") ";
        } if (subCat != 0) {
            where = where + "AND (Subcategory.Id = "+subCat+") ";
        } if (!word.equals("")) {
            where = where + "AND (UPPER(Product.ProductName) LIKE UPPER('%"+word+"%')) ";
        }
        where = where + "ORDER BY "+order+" ASC";
        String[][] er = new String[1][1];
        try {
            Statement st = cn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            ResultSet rs = st.executeQuery("SELECT Product.Id, Product.ProductName, Product.Price, Product.Amount, Product.ImageURL, Product.Desctiprion, Product.Composition, Employee.Name, Employee.Surname, Supplier.CompanyName, Category.CategoryName " +
                    "FROM Product LEFT JOIN Employee ON Employee.Id = Product.Id_Baker " +
                    "LEFT JOIN Supplier ON Supplier.Id = Product.Id_Supplier " +
                    "INNER JOIN Category ON Category.Id = Product.Id_Category " +
                    "INNER JOIN Subcategory ON Subcategory.Id = Category.Id_Subcategory" + where);
            ResultSetMetaData rsmd = rs.getMetaData();
            rs.last();
            int amountRows = rs.getRow();
            rs.first();
            int amountColumns = rsmd.getColumnCount();
            String[][] s = new String[amountRows][amountColumns];
            for (int i = 0; i < amountRows; i++) {
                for (int j = 0; j < amountColumns; j++) {
                    s[i][j] = rs.getString(j+1);
                    if (s[i][j] == null) {
                        s[i][j] = "";
                    }
                }
                rs.next();
            }
            return s;
        } catch (SQLException e) {
            System.err.println(e);
        }
        return er;
    }

    public int[] getAllIds(String s) {
        try {
            Statement st = cn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            ResultSet rs = st.executeQuery("SELECT Id FROM "+s);
            rs.last();
            int rows = rs.getRow();
            rs.first();
            int[] ids = new int[rows];
            for (int i = 0; i < rows; i++) {
                ids[i] = rs.getInt(1);
                rs.next();
            }
            return ids;
        } catch (SQLException e) {
            System.err.println(e);
        }
        return null;
    }

    public int getLastId(String s) {
        try {
            Statement st = cn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            ResultSet rs = st.executeQuery("SELECT Id FROM "+s+" ORDER BY 1 DESC");
            int id = 0;
            if (rs.next()) {
                id = rs.getInt(1);
            }
            return id;
        } catch (SQLException e) {
            System.err.println(e);
        }
        return 0;
    }

    public int getAmount(int id) {
        try {
            Statement st = cn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            ResultSet rs = st.executeQuery("SELECT Amount FROM Product WHERE Id = "+id);
            int amount = 0;
            if (rs.next()) {
                amount = rs.getInt(1);
            }
            return amount;
        } catch (SQLException e) {
            System.err.println(e);
        }
        return 0;
    }

    public void insertOrders(int id, int customerId, int cashierId, int paymentId, int packingId, String orderTime, String orderFinishTime, double orderCost, double orderCostWithTaxes) {
        try {
            Statement st = cn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            st.executeUpdate("INSERT INTO PurchaseOrder VALUES " +
                    "("+id+", "+customerId+", "+cashierId+", "+paymentId+", "+packingId+", '"+orderTime+"', '"+orderFinishTime+"', "+orderCost+", "+orderCostWithTaxes+")");
        } catch (SQLException e) {
            System.err.println(e);
        }
    }

    public void insertProductHasOrder(int productId, int orderId, int amount) {
        try {
            Statement st = cn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            st.executeUpdate("INSERT INTO Product_had_PurchaseOrder VALUES " +
                    "("+productId+", "+orderId+", "+amount+")");
        } catch (SQLException e) {
            System.err.println(e);
        }
    }

    public void updateAmountOfProducts(int id, int amount) {
        try {
            Statement st = cn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            st.executeUpdate("UPDATE Product SET Amount = "+amount+" WHERE Id = "+id);
        } catch (SQLException e) {
            System.err.println(e);
        }
    }

    public double getCost(int id) {
        try {
            Statement st = cn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            ResultSet rs = st.executeQuery("SELECT Price FROM Product WHERE Id = "+id);
            double price = 0;
            if (rs.next()) {
                price = rs.getDouble(1);
            }
            return price;
        } catch (SQLException e) {
            System.err.println(e);
        }
        return 0;
    }

    public String getFullName(int id) {
        try {
            Statement st = cn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            ResultSet rs = st.executeQuery("SELECT Name, Surname FROM Customer WHERE Id = "+id);
            String fullName = "";
            if (rs.next()) {
                fullName = rs.getString(1)+" "+rs.getString(2);
            }
            return fullName;
        } catch (SQLException e) {
            System.err.println(e);
        }
        return null;
    }

    public String getProductName(int id) {
        try {
            Statement st = cn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            ResultSet rs = st.executeQuery("SELECT ProductName FROM Product WHERE Id = "+id);
            String name = "";
            if (rs.next()) {
                name = rs.getString(1);
            }
            return name;
        } catch (SQLException e) {
            System.err.println(e);
        }
        return null;
    }

    public int[] getIdsToBake(int x) {
        try {
            Statement st = cn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            ResultSet rs = st.executeQuery("SELECT Id, Amount, ProductName FROM Product ORDER BY "+x);
            rs.last();
            int rows = rs.getRow();
            rs.first();
            int[] ids = new int[rows];
            for (int i = 0; i < rows; i++) {
                ids[i] = rs.getInt(1);
                rs.next();
            }
            return ids;
        } catch (SQLException e) {
            System.err.println(e);
        }
        return null;
    }

    public String[][] getAllCompletedOrders(int x) {
        switch(x) {
            case 0:
                x = 7;
                break;
            case 1:
                x = 1;
                break;
            case 2:
                x = 3;
                break;
            case 3:
                x = 5;
                break;
            case 4:
                x =6;
                break;
            case 5:
                x = 7;
                break;
            case 6:
                x = 8;
                break;
            case 7:
                x = 9;
                break;
            default:
                x = 7;
        }
        String[][] er = new String[1][1];
        try {
            Statement st = cn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            ResultSet rs = st.executeQuery("SELECT Customer.Name, Customer.Surname, Employee.Name, Employee.Surname, Payment.PaymentType, Packing.PackingType, OrderTime, OrderCompletion, OrderCost\n" +
                    " FROM PurchaseOrder \n" +
                    " INNER JOIN Customer ON Customer.Id = PurchaseOrder.Id_Customer \n" +
                    " INNER JOIN Employee ON Employee.Id = PurchaseOrder.Id_Cashier\n" +
                    " INNER JOIN Payment ON Payment.Id = PurchaseOrder.Id_PaymentType\n" +
                    " INNER JOIN Packing ON Packing.Id = PurchaseOrder.Id_PackingType ORDER BY "+x);
            ResultSetMetaData rsmd = rs.getMetaData();
            rs.last();
            int amountRows = rs.getRow();
            rs.first();
            int amountColumns = rsmd.getColumnCount();
            String[][] s = new String[amountRows][amountColumns];
            for (int i = 0; i < amountRows; i++) {
                for (int j = 0; j < amountColumns; j++) {
                    s[i][j] = rs.getString(j+1);
                }
                rs.next();
            }
            return s;
        } catch (SQLException e) {
            System.err.println(e);
        }
        return er;
    }
}

