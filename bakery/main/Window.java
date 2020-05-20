package bakery.main;
import bakery.img.img;

import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import static javax.swing.BorderFactory.createEmptyBorder;

public class Window extends JFrame implements ActionListener, KeyListener {

    //global
    private final sqlQueries q = new sqlQueries();
    private final img img = new img();
    private final Logic logic = new Logic();
    private final JLayeredPane layere = new JLayeredPane();
    private final JPanel pLogo = new JPanel();
    private final JPanel pBanner = new JPanel();
    private final JPanel pBG = new JPanel();
    private final JLabel lLogo = new JLabel();
    private final JLabel lBanner = new JLabel();
    private final JLabel lBG = new JLabel();
    private int userId = 1;
    private int shift = 0;
    private String window = "";
    private boolean isManager = false;
    private boolean isSeller = false;
    private String sMin = "0";
    private String sMax = "100";

    //login window
    private final JPanel pUser = new JPanel();
    private final JLabel lUser = new JLabel("Username");
    private final JPanel pPassword = new JPanel();
    private final JLabel lPassword = new JLabel("Password");
    private final JTextField tfUser = new JTextField();
    private final JPasswordField pfPassword = new JPasswordField();
    private final JButton bLogin = new JButton("Login");
    private final JButton bNewAccount = new JButton("Create new account");
    private final JPanel pAlert = new JPanel();
    private final JLabel lAlert = new JLabel("Incorrect login or password");

    //create account
    private final JButton bCreateAccount = new JButton("Create Account");
    private final JButton bCancel = new JButton("Cancel");

    private final JPanel pName = new JPanel();
    private final JPanel pSurname = new JPanel();
    private final JPanel pPesel = new JPanel();
    private final JPanel pBirthDate = new JPanel();
    private final JPanel pGender = new JPanel();
    private final JPanel pTelephone = new JPanel();
    private final JPanel pStreet = new JPanel();
    private final JPanel pHomeNr = new JPanel();
    private final JPanel pPostalCode = new JPanel();
    private final JPanel pCity = new JPanel();
    private final JPanel pWPhoto = new JPanel();
    private final JPanel pCow = new JPanel();
    private final JPanel pPosition = new JPanel();

    private final JLabel lCow = new JLabel();
    private final JLabel lName = new JLabel("Name");
    private final JLabel lSurname = new JLabel("Surname");
    private final JLabel lPesel = new JLabel("Pesel");
    private final JLabel lBirthDate = new JLabel("Birth Date");
    private final JLabel lGender = new JLabel("Gender");
    private final JLabel lTelephone = new JLabel("Telephone");
    private final JLabel lStreet = new JLabel("Street");
    private final JLabel lHomeNr = new JLabel("Home");
    private final JLabel lPostalCode = new JLabel("Postal Code");
    private final JLabel lCity = new JLabel("City");
    private final JLabel lWPhoto = new JLabel("What is in the photo?");
    private final JLabel lPosition = new JLabel("Position");

    private final JTextField tfName = new JTextField();
    private final JTextField tfSurname = new JTextField();
    private final JTextField tfPesel = new JTextField();
    private final JTextField tfBirthDate = new JTextField();
    private final JTextField tfTelephone = new JTextField();
    private final JTextField tfStreet = new JTextField();
    private final JTextField tfHomeNr = new JTextField();
    private final JTextField tfPostalCode = new JTextField();
    private final JTextField tfCity = new JTextField();
    private final JTextField tfWPhoto = new JTextField();

    private final ButtonGroup bgGender = new ButtonGroup();
    private final JRadioButton rbMale = new JRadioButton("Male");
    private final JRadioButton rbFemale = new JRadioButton("Female");

    private final JTextField tfUserN = new JTextField();
    private final JPasswordField pfPasswordN = new JPasswordField();

    private final JComboBox cbPosition = new JComboBox();

    //left banner
    private final JButton bHome = new JButton("Home");
    private final JButton bSearchProducts = new JButton("Search products");
    private final JButton bNewOrders = new JButton("New orders");
    private final JButton bBake = new JButton("Bake");
    private final JButton bCompletedOrders = new JButton("Completed orders");
    private final JButton bBestClient = new JButton("Best client");
    private final JButton bBestSeller = new JButton("Best seller");

    //home window
    private final JPanel pWelcomeHome = new JPanel();
    private final JLabel lWelcomeHome = new JLabel();

    private final JPanel pProfilePicture = new JPanel();
    private final JLabel lProfilePicture = new JLabel();

    private final JButton bUpdateHome = new JButton("Update");

    private final JPanel pUrPosition = new JPanel();
    private final JPanel pUrSalary = new JPanel();
    private final JLabel lUrPosition = new JLabel("Your position:");
    private final JLabel lUrSalary = new JLabel("Your salary:");
    private final JLabel lSalary = new JLabel();
    private final JPanel pUrPosition2 = new JPanel();
    private final JPanel pUrSalary2 = new JPanel();
    private final JLabel lUrPosition2 = new JLabel();
    private final JLabel lUrSalary2 = new JLabel();
    private final JLabel lSalary2 = new JLabel();

    private final JPanel pUrAdres = new JPanel();
    private final JLabel lUrAdres = new JLabel("Your adres:");

    private final JPanel pBigAdres1 = new JPanel();
    private final JPanel pBigAdres2 = new JPanel();
    private final JLabel lBigAdresl1 = new JLabel();
    private final JLabel lBigAdresl2 = new JLabel();

    //search product window
    private final List<String> listCategory = new ArrayList<String>();

    private final JPanel pProductBox = new JPanel();
    private final JScrollPane sp = new JScrollPane(pProductBox);

    private final JComboBox cbCategory = new JComboBox();
    private final JComboBox cbSubategory = new JComboBox();
    private final JComboBox cbOrderBy = new JComboBox();

    private final JPanel pMin = new JPanel();
    private final JPanel pMax = new JPanel();
    private final JPanel pSearchProductByName = new JPanel();
    private final JPanel pCategory = new JPanel();
    private final JPanel pSubcategory = new JPanel();
    private final JPanel pOrderProducts = new JPanel();

    private final JLabel lMin = new JLabel("Min price");
    private final JLabel lMax = new JLabel("Max price");
    private final JLabel lSearchProductByName = new JLabel("Search");
    private final JLabel lCategory = new JLabel("Category");
    private final JLabel lSubcategory = new JLabel("Subcategory");
    private final JLabel lOrderProducts = new JLabel("Order by");

    private final JTextField tfMin = new JTextField();
    private final JTextField tfMax = new JTextField();
    private final JTextField tfSearchProductByName = new JTextField();


    //new orders window
    private final List<OrderGenerator> listOrders = new ArrayList<OrderGenerator>();

    private final JPanel pNewOrders = new JPanel();
    private final JScrollPane spNewOrders = new JScrollPane(pNewOrders);

    private final JPanel pNewOrdersTitle = new JPanel();
    private final JLabel lNewOrdersTitle = new JLabel("New Orders List");

    private final JButton bGenerateNewOrder = new JButton("Generate New Order");
    private final JButton bAcceptAll = new JButton("Accept Orders");

    //completed orders window

    //production window

    //best client window

    //best seller window


    public Window() {
        setSize(1000, 600);
        setTitle("Bakery App");
        setResizable(false);
        setLocationRelativeTo(null);
        setLayout(null);
        add(layere);
        layere.setBounds(0,0,1000, 600);
        q.connect();
        shift = q.getLastId("PurchaseOrder");
        setStyle();
        createTop();
        setListeners();
        setComboBoxes();
    }

    private void setListeners() {

        //login window
        bLogin.addActionListener(this);
        bNewAccount.addActionListener(this);

        //new account window
        tfName.addKeyListener(this);
        tfSurname.addKeyListener(this);
        tfPesel.addKeyListener(this);
        tfBirthDate.addKeyListener(this);
        tfTelephone.addKeyListener(this);
        tfStreet.addKeyListener(this);
        tfHomeNr.addKeyListener(this);
        tfPostalCode.addKeyListener(this);
        tfCity.addKeyListener(this);
        tfWPhoto.addKeyListener(this);
        bCreateAccount.addActionListener(this);
        bCancel.addActionListener(this);
        pfPasswordN.addKeyListener(this);
        tfUserN.addKeyListener(this);

        //left banner
        bHome.addActionListener(this);
        bSearchProducts.addActionListener(this);
        bNewOrders.addActionListener(this);
        bCompletedOrders.addActionListener(this);
        bBestClient.addActionListener(this);
        bBestSeller.addActionListener(this);

        //search product window
        tfMin.addKeyListener(this);
        tfMax.addKeyListener(this);
        tfSearchProductByName.addKeyListener(this);

        //new orders window
        bGenerateNewOrder.addActionListener(this);
        bAcceptAll.addActionListener(this);

    }

    private void setComboBoxes() {

        for (String s : q.fillcbPosition()) {
            cbPosition.addItem(s);
        }

        cbSubategory.addItem("All");
        for (String s : q.fillcbSubcat()) {
            cbSubategory.addItem(s);
        }

        for (String s : q.fillcbCat(0)) {
            cbCategory.addItem(s);
            listCategory.add(s);
        }

        cbOrderBy.addItem("Default");
        cbOrderBy.addItem("Name");
        cbOrderBy.addItem("Price");
        cbOrderBy.addItem("Amount");
    }

    private void setStyle() {

        //login window
        pUser.setOpaque(false);
        pPassword.setOpaque(false);

        lUser.setFont(new Font(Font.DIALOG,  Font.BOLD, 15));
        lPassword.setFont(new Font(Font.DIALOG,  Font.BOLD, 15));
        lUser.setForeground(new Color(90, 52, 43));
        lPassword.setForeground(new Color(90, 52, 43));

        tfUser.setForeground(new Color(90, 52, 43));
        tfUser.setBackground(new Color(255, 248, 235));
        pfPassword.setForeground(new Color(90, 52, 43));
        pfPassword.setBackground(new Color(255, 248, 235));

        tfUser.setBorder(new LineBorder(new Color(90, 52, 43)));
        pfPassword.setBorder(new LineBorder(new Color(90, 52, 43)));

        bLogin.setFont(new Font(Font.DIALOG,  Font.BOLD, 15));
        bNewAccount.setFont(new Font(Font.DIALOG,  Font.BOLD, 15));
        bLogin.setBackground(new Color(90, 52, 43));
        bNewAccount.setBackground(new Color(90, 52, 43));
        bLogin.setForeground(new Color(255, 242, 216));
        bNewAccount.setForeground(new Color(255, 242, 216));

        bLogin.setBorderPainted(false);
        bNewAccount.setBorderPainted(false);

        //new account window

        pName.setOpaque(false);
        pSurname.setOpaque(false);
        pPesel.setOpaque(false);
        pBirthDate.setOpaque(false);
        pGender.setOpaque(false);
        pTelephone.setOpaque(false);
        pStreet.setOpaque(false);
        pHomeNr.setOpaque(false);
        pPostalCode.setOpaque(false);
        pCity.setOpaque(false);
        pWPhoto.setOpaque(false);
        pPosition.setOpaque(false);

        lName.setFont(new Font(Font.DIALOG,  Font.BOLD, 15));
        lName.setForeground(new Color(90, 52, 43));
        lSurname.setFont(new Font(Font.DIALOG,  Font.BOLD, 15));
        lSurname.setForeground(new Color(90, 52, 43));
        lPesel.setFont(new Font(Font.DIALOG,  Font.BOLD, 15));
        lPesel.setForeground(new Color(90, 52, 43));
        lBirthDate.setFont(new Font(Font.DIALOG,  Font.BOLD, 15));
        lBirthDate.setForeground(new Color(90, 52, 43));
        lGender.setFont(new Font(Font.DIALOG,  Font.BOLD, 15));
        lGender.setForeground(new Color(90, 52, 43));
        lTelephone.setFont(new Font(Font.DIALOG,  Font.BOLD, 15));
        lTelephone.setForeground(new Color(90, 52, 43));
        lStreet.setFont(new Font(Font.DIALOG,  Font.BOLD, 15));
        lStreet.setForeground(new Color(90, 52, 43));
        lHomeNr.setFont(new Font(Font.DIALOG,  Font.BOLD, 15));
        lHomeNr.setForeground(new Color(90, 52, 43));
        lPostalCode.setFont(new Font(Font.DIALOG,  Font.BOLD, 15));
        lPostalCode.setForeground(new Color(90, 52, 43));
        lCity.setFont(new Font(Font.DIALOG,  Font.BOLD, 15));
        lCity.setForeground(new Color(90, 52, 43));
        lWPhoto.setFont(new Font(Font.DIALOG,  Font.BOLD, 15));
        lWPhoto.setForeground(new Color(90, 52, 43));
        lPosition.setFont(new Font(Font.DIALOG,  Font.BOLD, 15));
        lPosition.setForeground(new Color(90, 52, 43));

        tfName.setForeground(new Color(90, 52, 43));
        tfName.setBackground(new Color(255, 248, 235));
        tfName.setBorder(new LineBorder(new Color(90, 52, 43)));
        tfSurname.setForeground(new Color(90, 52, 43));
        tfSurname.setBackground(new Color(255, 248, 235));
        tfSurname.setBorder(new LineBorder(new Color(90, 52, 43)));
        tfPesel.setForeground(new Color(90, 52, 43));
        tfPesel.setBackground(new Color(255, 248, 235));
        tfPesel.setBorder(new LineBorder(new Color(90, 52, 43)));
        tfBirthDate.setForeground(new Color(90, 52, 43));
        tfBirthDate.setBackground(new Color(255, 248, 235));
        tfBirthDate.setBorder(new LineBorder(new Color(90, 52, 43)));
        tfTelephone.setForeground(new Color(90, 52, 43));
        tfTelephone.setBackground(new Color(255, 248, 235));
        tfTelephone.setBorder(new LineBorder(new Color(90, 52, 43)));
        tfUserN.setForeground(new Color(90, 52, 43));
        tfUserN.setBackground(new Color(255, 248, 235));
        tfUserN.setBorder(new LineBorder(new Color(90, 52, 43)));
        pfPasswordN.setForeground(new Color(90, 52, 43));
        pfPasswordN.setBackground(new Color(255, 248, 235));
        pfPasswordN.setBorder(new LineBorder(new Color(90, 52, 43)));
        tfStreet.setForeground(new Color(90, 52, 43));
        tfStreet.setBackground(new Color(255, 248, 235));
        tfStreet.setBorder(new LineBorder(new Color(90, 52, 43)));
        tfHomeNr.setForeground(new Color(90, 52, 43));
        tfHomeNr.setBackground(new Color(255, 248, 235));
        tfHomeNr.setBorder(new LineBorder(new Color(90, 52, 43)));
        tfPostalCode.setForeground(new Color(90, 52, 43));
        tfPostalCode.setBackground(new Color(255, 248, 235));
        tfPostalCode.setBorder(new LineBorder(new Color(90, 52, 43)));
        tfCity.setForeground(new Color(90, 52, 43));
        tfCity.setBorder(new LineBorder(new Color(90, 52, 43)));
        tfCity.setBackground(new Color(255, 248, 235));
        tfWPhoto.setForeground(new Color(90, 52, 43));
        tfWPhoto.setBackground(new Color(255, 248, 235));
        tfWPhoto.setBorder(new LineBorder(new Color(90, 52, 43)));

        cbPosition.setForeground(new Color(90, 52, 43));
        cbPosition.setBackground(new Color(255, 248, 235));
        cbPosition.setBorder(new LineBorder(new Color(90, 52, 43)));

        rbFemale.setForeground(new Color(90, 52, 43));
        rbMale.setForeground(new Color(90, 52, 43));
        rbFemale.setOpaque(false);
        rbMale.setOpaque(false);
        rbMale.setBorderPainted(false);
        rbFemale.setBorderPainted(false);

        bCreateAccount.setFont(new Font(Font.DIALOG,  Font.BOLD, 15));
        bCancel.setFont(new Font(Font.DIALOG,  Font.BOLD, 15));
        bCreateAccount.setBackground(new Color(90, 52, 43));
        bCancel.setBackground(new Color(90, 52, 43));
        bCreateAccount.setForeground(new Color(255, 242, 216));
        bCancel.setForeground(new Color(255, 242, 216));
        bCreateAccount.setBorderPainted(false);
        bCancel.setBorderPainted(false);

        //left banner
        bHome.setFont(new Font(Font.DIALOG,  Font.BOLD, 15));
        bHome.setBackground(new Color(90, 52, 43));
        bHome.setForeground(new Color(255, 242, 216));
        bHome.setBorderPainted(false);

        bSearchProducts.setFont(new Font(Font.DIALOG,  Font.BOLD, 15));
        bSearchProducts.setBackground(new Color(90, 52, 43));
        bSearchProducts.setForeground(new Color(255, 242, 216));
        bSearchProducts.setBorderPainted(false);

        bNewOrders.setFont(new Font(Font.DIALOG,  Font.BOLD, 15));
        bNewOrders.setBackground(new Color(90, 52, 43));
        bNewOrders.setForeground(new Color(255, 242, 216));
        bNewOrders.setBorderPainted(false);

        bBake.setFont(new Font(Font.DIALOG,  Font.BOLD, 15));
        bBake.setBackground(new Color(90, 52, 43));
        bBake.setForeground(new Color(255, 242, 216));
        bBake.setBorderPainted(false);

        bCompletedOrders.setFont(new Font(Font.DIALOG,  Font.BOLD, 15));
        bCompletedOrders.setBackground(new Color(90, 52, 43));
        bCompletedOrders.setForeground(new Color(255, 242, 216));
        bCompletedOrders.setBorderPainted(false);

        bBestClient.setFont(new Font(Font.DIALOG,  Font.BOLD, 15));
        bBestClient.setBackground(new Color(90, 52, 43));
        bBestClient.setForeground(new Color(255, 242, 216));
        bBestClient.setBorderPainted(false);

        bBestSeller.setFont(new Font(Font.DIALOG,  Font.BOLD, 15));
        bBestSeller.setBackground(new Color(90, 52, 43));
        bBestSeller.setForeground(new Color(255, 242, 216));
        bBestSeller.setBorderPainted(false);

        //home window
        bUpdateHome.setFont(new Font(Font.DIALOG,  Font.BOLD, 15));
        bUpdateHome.setBackground(new Color(90, 52, 43));
        bUpdateHome.setForeground(new Color(255, 242, 216));
        bUpdateHome.setBorderPainted(false);

        pWelcomeHome.setOpaque(false);

        lWelcomeHome.setFont(new Font(Font.DIALOG,  Font.BOLD, 30));
        lWelcomeHome.setForeground(new Color(90, 52, 43));

        lUrAdres.setFont(new Font(Font.DIALOG,  Font.BOLD, 20));
        lUrAdres.setForeground(new Color(90, 52, 43));

        lBigAdresl1.setFont(new Font(Font.DIALOG,  Font.BOLD, 20));
        lBigAdresl1.setForeground(new Color(90, 52, 43));

        lBigAdresl2.setFont(new Font(Font.DIALOG,  Font.BOLD, 20));
        lBigAdresl2.setForeground(new Color(90, 52, 43));

        lUrPosition.setFont(new Font(Font.DIALOG,  Font.BOLD, 20));
        lUrPosition.setForeground(new Color(90, 52, 43));

        lUrPosition2.setFont(new Font(Font.DIALOG,  Font.BOLD, 20));
        lUrPosition2.setForeground(new Color(90, 52, 43));

        lUrSalary2.setFont(new Font(Font.DIALOG,  Font.BOLD, 20));
        lUrSalary2.setForeground(new Color(90, 52, 43));

        lUrSalary.setFont(new Font(Font.DIALOG,  Font.BOLD, 20));
        lUrSalary.setForeground(new Color(90, 52, 43));

        pProfilePicture.setOpaque(false);

        //search product window
        cbSubategory.setForeground(new Color(90, 52, 43));
        cbSubategory.setBackground(new Color(255, 248, 235));
        cbSubategory.setBorder(new LineBorder(new Color(90, 52, 43)));

        cbCategory.setForeground(new Color(90, 52, 43));
        cbCategory.setBackground(new Color(255, 248, 235));
        cbCategory.setBorder(new LineBorder(new Color(90, 52, 43)));

        cbOrderBy.setForeground(new Color(90, 52, 43));
        cbOrderBy.setBackground(new Color(255, 248, 235));
        cbOrderBy.setBorder(new LineBorder(new Color(90, 52, 43)));

        tfSearchProductByName.setForeground(new Color(90, 52, 43));
        tfSearchProductByName.setBackground(new Color(255, 248, 235));
        tfSearchProductByName.setBorder(new LineBorder(new Color(90, 52, 43)));

        tfMin.setForeground(new Color(90, 52, 43));
        tfMin.setBackground(new Color(255, 248, 235));
        tfMin.setBorder(new LineBorder(new Color(90, 52, 43)));

        tfMax.setForeground(new Color(90, 52, 43));
        tfMax.setBackground(new Color(255, 248, 235));
        tfMax.setBorder(new LineBorder(new Color(90, 52, 43)));

        lCategory.setFont(new Font(Font.DIALOG,  Font.BOLD, 15));
        lCategory.setForeground(new Color(90, 52, 43));

        lSubcategory.setFont(new Font(Font.DIALOG,  Font.BOLD, 15));
        lSubcategory.setForeground(new Color(90, 52, 43));

        lSearchProductByName.setFont(new Font(Font.DIALOG,  Font.BOLD, 15));
        lSearchProductByName.setForeground(new Color(90, 52, 43));

        lMin.setFont(new Font(Font.DIALOG,  Font.BOLD, 15));
        lMin.setForeground(new Color(90, 52, 43));

        lMax.setFont(new Font(Font.DIALOG,  Font.BOLD, 15));
        lMax.setForeground(new Color(90, 52, 43));

        lOrderProducts.setFont(new Font(Font.DIALOG,  Font.BOLD, 15));
        lOrderProducts.setForeground(new Color(90, 52, 43));

        pCategory.setOpaque(false);
        pSubcategory.setOpaque(false);
        pSearchProductByName.setOpaque(false);
        pMin.setOpaque(false);
        pMax.setOpaque(false);
        pOrderProducts.setOpaque(false);

        pCategory.add(lCategory);
        pSubcategory.add(lSubcategory);
        pSearchProductByName.add(lSearchProductByName);
        pMin.add(lMin);
        pMax.add(lMax);
        pOrderProducts.add(lOrderProducts);

        cbSubategory.setBounds(210, 110, 120, 25);
        cbCategory.setBounds(360, 110, 120, 25);
        tfSearchProductByName.setBounds(500, 110, 120, 25);
        tfMin.setBounds(750, 80, 50, 25);
        tfMax.setBounds(750, 110, 50, 25);
        cbOrderBy.setBounds(850, 110, 120, 25);

        pCategory.setBounds(210, 80, 120, 25);
        pSubcategory.setBounds(360, 80, 120, 25);
        pSearchProductByName.setBounds(500, 80, 120, 25);
        pMin.setBounds(650, 78, 120, 25);
        pMax.setBounds(650, 108, 120, 25);
        pOrderProducts.setBounds(850, 80, 120, 25);

        //new orders window
        lNewOrdersTitle.setFont(new Font(Font.DIALOG,  Font.BOLD, 25));
        lNewOrdersTitle.setForeground(new Color(90, 52, 43));

        pNewOrdersTitle.setOpaque(false);
        pNewOrdersTitle.add(lNewOrdersTitle);

        bGenerateNewOrder.setFont(new Font(Font.DIALOG,  Font.BOLD, 15));
        bGenerateNewOrder.setBackground(new Color(90, 52, 43));
        bGenerateNewOrder.setForeground(new Color(255, 242, 216));
        bGenerateNewOrder.setBorderPainted(false);

        bAcceptAll.setFont(new Font(Font.DIALOG,  Font.BOLD, 15));
        bAcceptAll.setBackground(new Color(90, 52, 43));
        bAcceptAll.setForeground(new Color(255, 242, 216));
        bAcceptAll.setBorderPainted(false);

        bGenerateNewOrder.setBounds(700, 80, 200, 25);
        pNewOrdersTitle.setBounds(300, 90, 400, 40);
        bAcceptAll.setBounds(700, 110, 200, 25);
    }

    private void loginWindow() {

        pUser.setBounds(350,200,100,30);
        pPassword.setBounds(350,230,100,30);

        tfUser.setBounds(480,205,170,25);
        pfPassword.setBounds(480,235,170,25);

        bLogin.setBounds(360, 270, 290, 25);
        bNewAccount.setBounds(360, 305, 290, 25);

        pUser.add(lUser);
        pPassword.add(lPassword);

        layere.add(pUser, 1, 0);
        layere.add(pPassword, 1, 0);
        layere.add(tfUser, 1, 0);
        layere.add(pfPassword, 1, 0);
        layere.add(bLogin, 1, 0);
        layere.add(bNewAccount, 1, 0);
    }

    private void incorrectLoginWindow() {

        pAlert.setBounds(420,170,250,30);
        pAlert.setOpaque(false);

        lAlert.setFont(new Font(Font.DIALOG,  Font.BOLD, 15));
        lAlert.setForeground(new Color(190, 0, 0));

        pAlert.add(lAlert);
        layere.add(pAlert, 1, 0);

        tfUser.setBackground(new Color(246, 226, 226));
        pfPassword.setBackground(new Color(246, 226, 226));
    }

    private void removeLoginWindow() {
        layere.remove(pAlert);
        layere.remove(pUser);
        layere.remove(pPassword);
        layere.remove(tfUser);
        layere.remove(pfPassword);
        layere.remove(bLogin);
        layere.remove(bNewAccount);
        layere.revalidate();
        layere.repaint();
    }

    private void newAccountWindow() {

        pName.setBounds(100,100,100,30);
        tfName.setBounds(220,105,170,25);
        pSurname.setBounds(100,135,100,30);
        tfSurname.setBounds(220,140,170,25);
        pPesel.setBounds(100,170,100,30);
        tfPesel.setBounds(220,175,170,25);
        pBirthDate.setBounds(100,205,100,30);
        tfBirthDate.setBounds(220,210,170,25);
        pGender.setBounds(100,245,100,30);
        pTelephone.setBounds(100,280,100,30);
        tfTelephone.setBounds(220,285,170,25);
        pUser.setBounds(100,350,100,30);
        tfUserN.setBounds(220,355,170,25);
        pPassword.setBounds(100,385,100,30);
        pfPasswordN.setBounds(220,390,170,25);
        pStreet.setBounds(600,100,100,30);
        tfStreet.setBounds(720,105,170,25);
        pHomeNr.setBounds(600,135,100,30);
        tfHomeNr.setBounds(720,140,170,25);
        pPostalCode.setBounds(600,170,100,30);
        tfPostalCode.setBounds(720,175,170,25);
        pCity.setBounds(600,205,100,30);
        tfCity.setBounds(720,210,170,25);
        pWPhoto.setBounds(530,350,200,30);
        tfWPhoto.setBounds(540,390,170,25);
        pPosition.setBounds(510, 267, 100, 30);
        cbPosition.setBounds(600, 270, 110, 25);

        bCreateAccount.setBounds(100, 500, 300, 25);
        bCancel.setBounds(600, 500, 300, 25);

        pName.add(lName);
        pSurname.add(lSurname);
        pPesel.add(lPesel);
        pBirthDate.add(lBirthDate);
        pGender.add(lGender);
        pTelephone.add(lTelephone);
        pStreet.add(lStreet);
        pHomeNr.add(lHomeNr);
        pPostalCode.add(lPostalCode);
        pCity.add(lCity);
        pWPhoto.add(lWPhoto);
        pPosition.add(lPosition);

        rbFemale.setBounds(220, 245, 80, 30);
        rbMale.setBounds(310, 245, 80, 30);
        bgGender.add(rbFemale);
        bgGender.add(rbMale);

        lCow.setIcon(img.getImage("cow.jpg"));
        pCow.setBounds(740, 265, 150, 150);
        pCow.add(lCow);
        pCow.setOpaque(false);

        layere.add(pName, 1, 0);
        layere.add(tfName, 1, 0);
        layere.add(pSurname, 1, 0);
        layere.add(tfSurname, 1, 0);
        layere.add(bCreateAccount, 1, 0);
        layere.add(bCancel, 1, 0);
        layere.add(pPesel, 1, 0);
        layere.add(tfPesel, 1, 0);
        layere.add(pBirthDate, 1, 0);
        layere.add(tfBirthDate, 1, 0);
        layere.add(pGender, 1, 0);
        layere.add(pTelephone, 1, 0);
        layere.add(tfTelephone, 1, 0);
        layere.add(pUser, 1, 0);
        layere.add(tfUserN, 1, 0);
        layere.add(pPassword, 1, 0);
        layere.add(pfPasswordN, 1, 0);
        layere.add(pStreet, 1, 0);
        layere.add(tfStreet, 1, 0);
        layere.add(pHomeNr, 1, 0);
        layere.add(tfHomeNr, 1, 0);
        layere.add(pPostalCode, 1, 0);
        layere.add(tfPostalCode, 1, 0);
        layere.add(pCity, 1, 0);
        layere.add(tfCity, 1, 0);
        layere.add(pWPhoto, 1, 0);
        layere.add(tfWPhoto, 1, 0);
        layere.add(pCow, 1, 0);
        layere.add(rbFemale, 1, 0);
        layere.add(rbMale, 1, 0);
        layere.add(pPosition, 1, 0);
        layere.add(cbPosition, 1, 0);

    }

    private void removeNewAccountWindow() {

        layere.remove(pName);
        layere.remove(tfName);
        layere.remove(pSurname);
        layere.remove(tfSurname);
        layere.remove(bCreateAccount);
        layere.remove(bCancel);
        layere.remove(pPesel);
        layere.remove(tfPesel);
        layere.remove(pBirthDate);
        layere.remove(tfBirthDate);
        layere.remove(pGender);
        layere.remove(pTelephone);
        layere.remove(tfTelephone);
        layere.remove(pUser);
        layere.remove(tfUserN);
        layere.remove(pPassword);
        layere.remove(pfPasswordN);
        layere.remove(pStreet);
        layere.remove(tfStreet);
        layere.remove(pHomeNr);
        layere.remove(tfHomeNr);
        layere.remove(pPostalCode);
        layere.remove(tfPostalCode);
        layere.remove(pCity);
        layere.remove(tfCity);
        layere.remove(pWPhoto);
        layere.remove(tfWPhoto);
        layere.remove(pCow);
        layere.remove(rbFemale);
        layere.remove(rbMale);
        layere.remove(pPosition);
        layere.remove(cbPosition);
        layere.revalidate();
        layere.repaint();
    }

    private void createTop() {

        lLogo.setIcon(img.getImage("logo.jpg"));
        pLogo.setBounds(60, -5, 100, 100);
        pLogo.add(lLogo);

        lBanner.setIcon(img.getImage("banner.jpg"));
        pBanner.setBounds(0,-5,1000, 70);
        pBanner.add(lBanner);

        lBG.setIcon(img.getImage("BG.jpg"));
        pBG.setBounds(0,-5, 1000, 600);
        pBG.add(lBG);

        layere.add(pLogo, 2, 0);
        layere.add(pBanner, 1, 0);
        layere.add(pBG, 0, 0);

        //loginWindow();
        createLeftBanner();
    }

    private void createLeftBanner() {
        bHome.setBounds(25, 120, 170, 30);
        bSearchProducts.setBounds(25, 170, 170, 30);
        bNewOrders.setBounds(25, 220, 170, 30);
        bBake.setBounds(25, 270, 170, 30);
        bCompletedOrders.setBounds(25, 320, 170, 30);
        bBestClient.setBounds(25, 370, 170, 30);
        bBestSeller.setBounds(25, 420, 170, 30);
        layere.add(bHome, 1, 0);
        layere.add(bSearchProducts, 1, 0);
        layere.add(bNewOrders, 1, 0);
        layere.add(bBake, 1, 0);
        layere.add(bCompletedOrders, 1, 0);
        layere.add(bBestClient, 1, 0);
        layere.add(bBestSeller, 1, 0);
        checkPosition();
        homeWindow();
    }

    private void checkPosition() {
        String position = q.getSalaryOrPosition(userId, "PositionName");
        if (position.equals("Manager")) {
            isManager = true;
        } else {
            isManager = false;
        }
        if (position.equals("Seller")) {
            isSeller = true;
        } else {
            isSeller= false;
        }
    }

    private void homeWindow() {
        window = "home";

        pWelcomeHome.setBounds(350, 80, 400, 50);
        lWelcomeHome.setText("Welcome "+q.getNameHome(userId)+"!");
        pWelcomeHome.add(lWelcomeHome);

        pProfilePicture.setBounds(700, 160, 250, 250);
        lProfilePicture.setIcon(img.getImage(q.getPicture("Employee",userId)));
        pProfilePicture.add(lProfilePicture);

        pBigAdres1.setBounds(400, 170, 200, 40);
        pBigAdres2.setBounds(400, 200, 160, 40);
        lBigAdresl1.setText(q.getAdres1(userId) + " St.");
        lBigAdresl2.setText(q.getAdres2(userId));
        pBigAdres1.add(lBigAdresl1);
        pBigAdres2.add(lBigAdresl2);
        pBigAdres1.setOpaque(false);
        pBigAdres2.setOpaque(false);

        pUrAdres.setBounds(250, 170, 150, 40);
        pUrAdres.add(lUrAdres);
        pUrAdres.setOpaque(false);

        pUrPosition.setBounds(250, 270, 150, 40);
        pUrPosition.add(lUrPosition);
        pUrPosition.setOpaque(false);

        pUrSalary.setBounds(250, 320, 150, 40);
        pUrSalary.add(lUrSalary);
        pUrSalary.setOpaque(false);

        pUrPosition2.setBounds(400, 270, 100, 40);
        lUrPosition2.setText(q.getSalaryOrPosition(userId, "PositionName"));
        pUrPosition2.add(lUrPosition2);
        pUrPosition2.setOpaque(false);

        pUrSalary2.setBounds(400, 320, 100, 40);
        lUrSalary2.setText("$ " + q.getSalaryOrPosition(userId, "Salary"));
        pUrSalary2.add(lUrSalary2);
        pUrSalary2.setOpaque(false);

        layere.add(pWelcomeHome,1,0);
        layere.add(pProfilePicture, 1, 0);
        layere.add(pBigAdres1, 1, 0);
        layere.add(pBigAdres2, 1, 0);

        layere.add(pUrAdres, 1, 0);
        layere.add(pUrPosition, 1, 0);
        layere.add(pUrSalary, 1, 0);

        layere.add(pUrPosition2, 1, 0);
        layere.add(pUrSalary2, 1, 0);
    }

    private void removeWindows() {
        if (window.equals("home")) {
            removeHomeWindow();
        } else if (window.equals("searchProducts")) {
            removeSearchProducts();
        } else if (window.equals("newOrderWindow")) {
            removeNewOrderWindow();
        }
    }

    private void removeHomeWindow() {

        layere.remove(pWelcomeHome);
        layere.remove(pProfilePicture);
        layere.remove(pUrAdres);
        layere.remove(pBigAdres1);
        layere.remove(pBigAdres2);
        layere.remove(pUrSalary);
        layere.remove(pUrSalary2);
        layere.remove(pUrPosition);
        layere.remove(pUrPosition2);
        layere.revalidate();
        layere.repaint();
    }

    private void searchProducts() {
        layere.add(cbCategory, 1, 0);
        layere.add(cbSubategory, 1, 0);
        layere.add(cbOrderBy, 1, 0);
        layere.add(tfSearchProductByName, 1, 0);
        layere.add(tfMin, 1, 0);
        layere.add(tfMax, 1, 0);
        layere.add(pCategory, 1, 0);
        layere.add(pSubcategory, 1, 0);
        layere.add(pSearchProductByName, 1, 0);
        layere.add(pMin, 1, 0);
        layere.add(pMax, 1, 0);
        layere.add(pOrderProducts, 1, 0);


        searchProducts(0, 0, "", "100", "0", 1);
    }

    private void searchProducts(int cat, int subcat, String word, String pMax, String pMin, int order) {

        window = "searchProducts";

        cbCategory.removeActionListener(this);
        cbSubategory.removeActionListener(this);
        cbOrderBy.removeActionListener(this);

        String[][] a = q.getProducts(cat, subcat, word, pMax, pMin, order);
        JPanel[] p1 = new JPanel[a.length];
        JPanel[] pTitle = new JPanel[a.length];
        JPanel[] pTitleGroup = new JPanel[a.length];
        JLabel[] lTitle = new JLabel[a.length];
        JLabel[] limg = new JLabel[a.length];
        JPanel[] pimg = new JPanel[a.length];
        JPanel[] pCost = new JPanel[a.length];
        JLabel[] lCost = new JLabel[a.length];
        JPanel[] pAmount = new JPanel[a.length];
        JLabel[] lAmount = new JLabel[a.length];
        JPanel[] pMadeBy = new JPanel[a.length];
        JLabel[] lMadeBy = new JLabel[a.length];
        JPanel[] pDesc = new JPanel[a.length];
        JLabel[] lDesc = new JLabel[a.length];
        JPanel[] pComp = new JPanel[a.length];
        JLabel[] lComp = new JLabel[a.length];
        JPanel[] pCategory = new JPanel[a.length];
        JLabel[] lCategory = new JLabel[a.length];

        int i = 0;
        for (String s[] : a) {
            p1[i] = new JPanel();
            pTitle[i] = new JPanel();
            lTitle[i] = new JLabel();
            pTitleGroup[i] = new JPanel();
            pimg[i] = new JPanel();
            limg[i] = new JLabel();
            pCost[i] = new JPanel();
            lCost[i] = new JLabel();
            pAmount[i] = new JPanel();
            lAmount[i] = new JLabel();
            pMadeBy[i] = new JPanel();
            lMadeBy[i] = new JLabel();
            pDesc[i] = new JPanel();
            lDesc[i] = new JLabel();
            pComp[i] = new JPanel();
            lComp[i] = new JLabel();
            pCategory[i] = new JPanel();
            lCategory[i] = new JLabel();

            limg[i].setIcon(img.getImage(s[4]));
            pimg[i].setPreferredSize(new Dimension(100, 100));
            pimg[i].add(limg[i]);
            pimg[i].setOpaque(false);

            //p1[i].setOpaque(false);
            p1[i].setBackground(new Color(255, 255, 255, 50));
            p1[i].setPreferredSize(new Dimension(750, 205));

            lTitle[i].setFont(new Font(Font.DIALOG,  Font.BOLD, 20));
            lTitle[i].setForeground(new Color(90, 52, 43));
            lTitle[i].setText(s[1]);

            lCategory[i].setFont(new Font(Font.DIALOG,  Font.ITALIC, 15));
            lCategory[i].setForeground(new Color(90, 52, 43));
            lCategory[i].setText(s[10]);

            pTitleGroup[i].setPreferredSize(new Dimension(300, 100));
            pTitleGroup[i].setOpaque(false);

            pCategory[i].setPreferredSize(new Dimension(300, 40));
            pCategory[i].add(lCategory[i]);
            pCategory[i].setOpaque(false);

            pTitle[i].setPreferredSize(new Dimension(300, 40));
            pTitle[i].add(lTitle[i]);
            pTitle[i].setOpaque(false);
            pTitleGroup[i].add(pTitle[i]);
            pTitleGroup[i].add(pCategory[i]);

            lCost[i].setFont(new Font(Font.DIALOG,  Font.BOLD, 30));
            lCost[i].setForeground(new Color(90, 52, 43));
            lCost[i].setText("$ "+s[2]);

            pCost[i].setPreferredSize(new Dimension(300, 100));
            pCost[i].add(lCost[i]);
            pCost[i].setOpaque(false);

            lAmount[i].setFont(new Font(Font.DIALOG,  Font.ITALIC, 15));
            lAmount[i].setForeground(new Color(90, 52, 43));
            lAmount[i].setText("Amount: "+s[3]+" pcs.");

            pAmount[i].setPreferredSize(new Dimension(300, 30));
            pAmount[i].add(lAmount[i]);
            pAmount[i].setOpaque(false);
            pCost[i].add(pAmount[i]);

            lMadeBy[i].setFont(new Font(Font.DIALOG,  Font.ITALIC, 15));
            lMadeBy[i].setForeground(new Color(90, 52, 43));
            lMadeBy[i].setText("Made by: "+s[7]+" "+s[8]+" "+s[9]);

            pMadeBy[i].setOpaque(false);
            pMadeBy[i].setPreferredSize(new Dimension(700, 100));
            pMadeBy[i].add(lMadeBy[i]);

            lDesc[i].setFont(new Font(Font.DIALOG,  Font.ITALIC, 15));
            lDesc[i].setForeground(new Color(90, 52, 43));
            lDesc[i].setText("Description: "+s[5]);

            pDesc[i].setOpaque(false);
            pDesc[i].setPreferredSize(new Dimension(700, 25));
            pDesc[i].add(lDesc[i]);

            lComp[i].setFont(new Font(Font.DIALOG,  Font.ITALIC, 15));
            lComp[i].setForeground(new Color(90, 52, 43));
            lComp[i].setText("Composition: "+s[6]);

            pComp[i].setOpaque(false);
            pComp[i].setPreferredSize(new Dimension(700, 25));
            pComp[i].add(lComp[i]);

            pMadeBy[i].add(pDesc[i]);
            pMadeBy[i].add(pComp[i]);
            JPanel line = new JPanel();
            line.setPreferredSize(new Dimension(750, 2));
            line.setBackground(new Color(90, 52, 43));

            p1[i].add(line);
            p1[i].add(pimg[i]);
            p1[i].add(pTitleGroup[i]);
            p1[i].add(pCost[i]);
            p1[i].add(pMadeBy[i]);


            pProductBox.add(p1[i]);
            i++;
        }

        pProductBox.setPreferredSize(new Dimension(750, 207*(i+1)));
        pProductBox.setOpaque(false);
        sp.setOpaque(false);
        sp.getViewport().setOpaque(false);
        sp.setBorder(createEmptyBorder());
        sp.setBounds(200, 150, 786, 414);
        layere.add(sp, 1, 0);

        cbCategory.addActionListener(this);
        cbSubategory.addActionListener(this);
        cbOrderBy.addActionListener(this);
    }

    private void removeSearchProducts() {
        layere.remove(sp);
        layere.remove(cbSubategory);
        layere.remove(cbCategory);
        layere.remove(tfSearchProductByName);
        layere.remove(tfMin);
        layere.remove(tfMax);
        layere.remove(cbOrderBy);
        layere.remove(pSubcategory);
        layere.remove(pCategory);
        layere.remove(pSearchProductByName);
        layere.remove(pMax);
        layere.remove(pMin);
        layere.remove(pOrderProducts);

        layere.revalidate();
        layere.repaint();
    }

    private void removeSearchProductsBoxes() {
        layere.remove(sp);
        layere.remove(spNewOrders);
        layere.revalidate();
        layere.repaint();
        pProductBox.removeAll();
        pProductBox.revalidate();
        pProductBox.repaint();
    }

    private void newOrderWindow() {

        window = "newOrderWindow";

        layere.add(bGenerateNewOrder, 1, 0);
        layere.add(pNewOrdersTitle, 1, 0);
        layere.add(bAcceptAll, 1, 0);

        layere.remove(spNewOrders);
        layere.revalidate();
        layere.repaint();

        pNewOrders.removeAll();
        pNewOrders.revalidate();
        pNewOrders.repaint();

        updateNewOrdersList();
    }

    private void generateNewOrder() {

        listOrders.add(new OrderGenerator());

        layere.remove(spNewOrders);
        layere.revalidate();
        layere.repaint();

        pNewOrders.removeAll();
        pNewOrders.revalidate();
        pNewOrders.repaint();

        updateNewOrdersList();
    }

    private void acceptOrders() {

        layere.remove(spNewOrders);
        layere.revalidate();
        layere.repaint();

        pNewOrders.removeAll();
        pNewOrders.revalidate();
        pNewOrders.repaint();

        for (int i = 0; i < listOrders.size(); i++) {
            boolean makeIt = true;
            if (!listOrders.get(i).done) {
                for (int j = 0; j < listOrders.get(i).products.length; j++) {
                    int x = q.getAmount(listOrders.get(i).products[j][0]);
                    if (x - listOrders.get(i).products[j][1] < 0) {
                        makeIt = false;
                    }
                }
                if (makeIt) {
                    Date Date = Calendar.getInstance().getTime();
                    DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                    double sum = 0;
                    for (int z = 0; z < listOrders.get(i).products.length; z++) {
                        sum = sum + listOrders.get(i).products[z][1]*q.getCost(listOrders.get(i).products[z][0]);
                        q.updateAmountOfProducts(listOrders.get(i).products[z][0], q.getAmount(listOrders.get(i).products[z][0]) - listOrders.get(i).products[z][1]);
                    }
                    double noTaxes = sum*0.77;
                    q.insertOrders(i+1+shift, listOrders.get(i).customerId, userId, listOrders.get(i).paymentId, listOrders.get(i).packingId, listOrders.get(i).date, dateFormat.format(Date), sum, noTaxes);
                    for (int z = 0; z < listOrders.get(i).products.length; z++) {
                        q.insertProductHasOrder(listOrders.get(i).products[z][0], i+1+shift, listOrders.get(i).products[z][1]);
                    }
                    listOrders.get(i).done = true;
                }
            }
        }

        updateNewOrdersList();
    }

    private void updateNewOrdersList() {

        JPanel[] p1 = new JPanel[listOrders.size()];
        JPanel[] pTitle = new JPanel[listOrders.size()];
        JPanel[] pClient = new JPanel[listOrders.size()];
        JPanel[] pProduct = new JPanel[listOrders.size()];
        JPanel[] pBlankSpace1 = new JPanel[listOrders.size()];
        JPanel[] pBlankSpace2 = new JPanel[listOrders.size()];
        JPanel[] pBlankSpace3 = new JPanel[listOrders.size()];
        JPanel[] pDate = new JPanel[listOrders.size()];
        JPanel[] pToPay = new JPanel[listOrders.size()];

        JLabel[] lTitle = new JLabel[listOrders.size()];
        JLabel[] lClient = new JLabel[listOrders.size()];
        JLabel[] lProduct = new JLabel[listOrders.size()];
        JLabel[] lDate = new JLabel[listOrders.size()];
        JLabel[] lToPay = new JLabel[listOrders.size()];

        int extraHeight = 0;
        int currentObjects = 0;

        for (int i = 0; i < listOrders.size(); i++) {

            if (!listOrders.get(i).done) {

                currentObjects = currentObjects + 1;

                p1[i] = new JPanel();
                pTitle[i] = new JPanel();
                pProduct[i] = new JPanel();
                pBlankSpace1[i] = new JPanel();
                pBlankSpace2[i] = new JPanel();
                pBlankSpace3[i] = new JPanel();
                pDate[i] = new JPanel();
                pToPay[i] = new JPanel();
                pClient[i] = new JPanel();

                pTitle[i].setOpaque(false);
                pProduct[i].setOpaque(false);
                pBlankSpace1[i].setOpaque(false);
                pBlankSpace2[i].setOpaque(false);
                pBlankSpace3[i].setOpaque(false);
                pDate[i].setOpaque(false);
                pToPay[i].setOpaque(false);
                pClient[i].setOpaque(false);

                lTitle[i] = new JLabel("New order from: ");
                lClient[i] = new JLabel(q.getFullName(listOrders.get(i).customerId));
                lProduct[i] = new JLabel("Products:");
                lDate[i] = new JLabel(listOrders.get(i).date);
                lToPay[i] = new JLabel();

                JLabel[] lProductName = new JLabel[listOrders.get(i).products.length];
                JLabel[] lProductCost = new JLabel[listOrders.get(i).products.length];
                JLabel[] lProductAmount = new JLabel[listOrders.get(i).products.length];

                JPanel[] pProductName = new JPanel[listOrders.get(i).products.length];
                JPanel[] pProductCost = new JPanel[listOrders.get(i).products.length];
                JPanel[] pProductAmount = new JPanel[listOrders.get(i).products.length];
                JPanel[] pExtraSpace1 = new JPanel[listOrders.get(i).products.length];
                JPanel[] pExtraSpace2 = new JPanel[listOrders.get(i).products.length];

                p1[i].add(pTitle[i]);
                p1[i].add(pClient[i]);
                p1[i].add(pBlankSpace3[i]);
                p1[i].add(pDate[i]);
                p1[i].add(pProduct[i]);
                p1[i].add(pBlankSpace1[i]);

                pTitle[i].add(lTitle[i]);
                pClient[i].add(lClient[i]);
                pProduct[i].add(lProduct[i]);

                pTitle[i].setPreferredSize(new Dimension(180, 30));
                pClient[i].setPreferredSize(new Dimension(180, 30));
                pDate[i].setPreferredSize(new Dimension(150, 40));
                pProduct[i].setPreferredSize(new Dimension(150, 30));
                pBlankSpace1[i].setPreferredSize(new Dimension(550, 30));
                pBlankSpace3[i].setPreferredSize(new Dimension(200, 30));

                int additionalHeight = 0;
                double toPay = 0.00;

                for (int j = 0; j < listOrders.get(i).products.length; j++) {

                    additionalHeight = additionalHeight + 22;

                    toPay = toPay + listOrders.get(i).products[j][1]*q.getCost(listOrders.get(i).products[j][0]);

                    pProductName[j] = new JPanel();
                    pProductCost[j] = new JPanel();
                    pProductAmount[j] = new JPanel();
                    pExtraSpace1[j] = new JPanel();
                    pExtraSpace2[j] = new JPanel();

                    pProductName[j].setOpaque(false);
                    pProductCost[j].setOpaque(false);
                    pProductAmount[j].setOpaque(false);
                    pExtraSpace1[j].setOpaque(false);
                    pExtraSpace2[j].setOpaque(false);

                    lProductName[j] = new JLabel(q.getProductName(listOrders.get(i).products[j][0]));
                    lProductCost[j] = new JLabel("$ "+q.getCost(listOrders.get(i).products[j][0]));
                    lProductAmount[j] = new JLabel("x"+listOrders.get(i).products[j][1]);

                    lProductName[j].setFont(new Font(Font.DIALOG,  Font.BOLD, 12));
                    lProductName[j].setForeground(new Color(90, 52, 43));

                    lProductCost[j].setFont(new Font(Font.DIALOG,  Font.BOLD, 12));
                    lProductCost[j].setForeground(new Color(90, 52, 43));

                    lProductAmount[j].setFont(new Font(Font.DIALOG,  Font.BOLD, 12));
                    lProductAmount[j].setForeground(new Color(90, 52, 43));

                    pExtraSpace1[j].setPreferredSize(new Dimension(100, 20));
                    pProductName[j].setPreferredSize(new Dimension(150, 20));
                    pProductCost[j].setPreferredSize(new Dimension(50, 20));
                    pProductAmount[j].setPreferredSize(new Dimension(50, 20));
                    pExtraSpace2[j].setPreferredSize(new Dimension(300, 20));

                    pProductName[j].add(lProductName[j]);
                    pProductCost[j].add(lProductCost[j]);
                    pProductAmount[j].add(lProductAmount[j]);

                    p1[i].add(pExtraSpace1[j]);
                    p1[i].add(pProductName[j]);
                    p1[i].add(pProductCost[j]);
                    p1[i].add(pProductAmount[j]);
                    p1[i].add(pExtraSpace2[j]);

                }
                lToPay[i].setText("To pay:    $ "+toPay);

                extraHeight = extraHeight + additionalHeight;

                p1[i].setBackground(new Color(255, 255, 255, 50));
                p1[i].setPreferredSize(new Dimension(750, 140+additionalHeight));

                lTitle[i].setFont(new Font(Font.DIALOG,  Font.BOLD, 20));
                lTitle[i].setForeground(new Color(90, 52, 43));

                lClient[i].setFont(new Font(Font.DIALOG,  Font.ITALIC, 20));
                lClient[i].setForeground(new Color(90, 52, 43));

                lProduct[i].setFont(new Font(Font.DIALOG,  Font.BOLD, 15));
                lProduct[i].setForeground(new Color(90, 52, 43));

                lDate[i].setFont(new Font(Font.DIALOG,  Font.BOLD, 15));
                lDate[i].setForeground(new Color(90, 52, 43));

                lToPay[i].setFont(new Font(Font.DIALOG,  Font.BOLD, 15));
                lToPay[i].setForeground(new Color(90, 52, 43));

                pToPay[i].setPreferredSize(new Dimension(200, 40));
                pBlankSpace2[i].setPreferredSize(new Dimension(400, 40));

                pDate[i].add(lDate[i]);
                pToPay[i].add(lToPay[i]);

                p1[i].add(pBlankSpace2[i]);
                p1[i].add(pToPay[i]);

                pNewOrders.add(p1[i]);
            }
        }

        pNewOrders.setPreferredSize(new Dimension(750, 145*currentObjects+extraHeight));
        pNewOrders.setOpaque(false);
        spNewOrders.setOpaque(false);
        spNewOrders.getViewport().setOpaque(false);
        spNewOrders.setBorder(createEmptyBorder());
        spNewOrders.setBounds(200, 150, 786, 414);

        layere.add(spNewOrders, 1, 0);
    }

    private void removeNewOrderWindow() {

        layere.remove(pNewOrdersTitle);
        layere.remove(bGenerateNewOrder);
        layere.remove(bAcceptAll);

        layere.revalidate();
        layere.repaint();
    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        Object z = actionEvent.getSource();
        if (z == bLogin) {
            String login = tfUser.getText();
            String password = pfPassword.getText();
            if (q.checkPassword(login, password)) {
                userId = q.setUserId(tfUser.getText());
                removeLoginWindow();
                createLeftBanner();
                homeWindow();
            } else {
                incorrectLoginWindow();
            }
        } else if (z == bNewAccount) {
            removeLoginWindow();
            newAccountWindow();
        } else if (z == bCreateAccount) {
            if (logic.checkNames(tfName.getText()) && logic.checkNames(tfSurname.getText()) && logic.checkPesel(tfPesel.getText()) && logic.checkBirthDate(tfBirthDate.getText()) && logic.checkTelephone(tfTelephone.getText()) && logic.checkUsername(tfUserN.getText()) && !q.userExists(tfUserN.getText()) && logic.checkPassword(pfPasswordN.getText()) && logic.checkNames(tfStreet.getText()) && logic.checkNumber(tfHomeNr.getText()) && logic.checkNames(tfCity.getText()) && logic.checkImage(tfWPhoto.getText())) {
                String gender = "";
                int position = cbPosition.getSelectedIndex();
                if (rbMale.isSelected()) {
                    gender = "m";
                } else {
                    gender = "w";
                }
                q.newAccount(tfName.getText(),tfSurname.getText(),tfPesel.getText(),tfBirthDate.getText(),gender,tfTelephone.getText(),tfStreet.getText(),Integer.parseInt(tfHomeNr.getText()),tfPostalCode.getText(),tfCity.getText(),tfUserN.getText(),pfPasswordN.getText(),position);
                removeNewAccountWindow();
                loginWindow();
            }
        } else if (z == bCancel) {
            removeNewAccountWindow();
            loginWindow();
        } else if (z == bHome) {
            removeWindows();
            layere.remove(sp);
            homeWindow();
        } else if (z == bSearchProducts) {
            removeWindows();
            removeSearchProductsBoxes();
            searchProducts();
            cbCategory.setSelectedItem(0);
            cbSubategory.setSelectedItem(0);
        } else if (z == bNewOrders) {
            removeWindows();
            newOrderWindow();
        } else if (z == bCompletedOrders) {
            removeWindows();

        } else if (z == bBestClient) {
            removeWindows();

        } else if (z == bBestSeller) {
            removeWindows();

        } else if (z == cbSubategory) {
            cbCategory.setModel(new DefaultComboBoxModel(q.fillcbCat(cbSubategory.getSelectedIndex())));
            removeSearchProductsBoxes();
            searchProducts(0, cbSubategory.getSelectedIndex(), tfSearchProductByName.getText(), tfMax.getText(), tfMin.getText(), cbOrderBy.getSelectedIndex()+1);
        } else if (z == cbCategory) {
            String s = cbCategory.getSelectedItem().toString();
            removeSearchProductsBoxes();
            searchProducts(listCategory.indexOf(s), cbSubategory.getSelectedIndex(), tfSearchProductByName.getText(), tfMax.getText(), tfMin.getText(), cbOrderBy.getSelectedIndex()+1);
        } else if (z == cbOrderBy) {
            removeSearchProductsBoxes();
            searchProducts(listCategory.indexOf(cbCategory.getSelectedItem().toString()), cbSubategory.getSelectedIndex(), tfSearchProductByName.getText(), tfMax.getText(), tfMin.getText(), cbOrderBy.getSelectedIndex()+1);
        } else if (z == bGenerateNewOrder) {
            generateNewOrder();
        } else if (z == bAcceptAll) {
            acceptOrders();
        }
    }

    @Override
    public void keyTyped(KeyEvent keyEvent) {

    }

    @Override
    public void keyPressed(KeyEvent keyEvent) {

    }

    @Override
    public void keyReleased(KeyEvent keyEvent) {
        Object z = keyEvent.getSource();
        if (z == tfName) {
            if (logic.checkNames(tfName.getText())) {
                tfName.setBackground(new Color(227, 245, 227));
            } else {
                tfName.setBackground(new Color(246, 226, 226));
            }
        } else if (z == tfSurname) {
            if (logic.checkNames(tfSurname.getText())) {
                tfSurname.setBackground(new Color(227, 245, 227));
            } else {
                tfSurname.setBackground(new Color(246, 226, 226));
            }
        } else if (z == tfPesel) {
            if (logic.checkPesel(tfPesel.getText())) {
                tfPesel.setBackground(new Color(227, 245, 227));
                tfBirthDate.setText(logic.setBirthDate(tfPesel.getText()));
                if (logic.setGender(tfPesel.getText())) {
                    rbFemale.doClick();
                } else {
                    rbMale.doClick();
                }
            } else {
                tfPesel.setBackground(new Color(246, 226, 226));
            }
        } else if (z == tfBirthDate) {
            if (logic.checkBirthDate(tfBirthDate.getText())) {
                tfBirthDate.setBackground(new Color(227, 245, 227));
            } else {
                tfBirthDate.setBackground(new Color(246, 226, 226));
            }
        } else if (z == tfTelephone) {
            if (logic.checkTelephone(tfTelephone.getText())) {
                tfTelephone.setBackground(new Color(227, 245, 227));
            } else {
                tfTelephone.setBackground(new Color(246, 226, 226));
            }
        } else if (z == tfStreet) {
            if (logic.checkNames(tfStreet.getText())) {
                tfStreet.setBackground(new Color(227, 245, 227));
            } else {
                tfStreet.setBackground(new Color(246, 226, 226));
            }
        } else if (z == tfHomeNr) {
            if (logic.checkNumber(tfHomeNr.getText())) {
                tfHomeNr.setBackground(new Color(227, 245, 227));
            } else {
                tfHomeNr.setBackground(new Color(246, 226, 226));
            }
        } else if (z == tfPostalCode) {
            if (logic.checkPostalCode(tfPostalCode.getText())) {
                tfPostalCode.setBackground(new Color(227, 245, 227));
            } else {
                tfPostalCode.setBackground(new Color(246, 226, 226));
            }
        } else if (z == tfCity) {
            if (logic.checkNames(tfCity.getText())) {
                tfCity.setBackground(new Color(227, 245, 227));
            } else {
                tfCity.setBackground(new Color(246, 226, 226));
            }
        } else if (z == tfWPhoto) {
            if (logic.checkImage(tfWPhoto.getText())) {
                tfWPhoto.setBackground(new Color(227, 245, 227));
            } else {
                tfWPhoto.setBackground(new Color(246, 226, 226));
            }
        } else if (z == tfUserN) {
            if (logic.checkUsername(tfUserN.getText())) {
                if (!q.userExists(tfUserN.getText())) {
                    tfUserN.setBackground(new Color(227, 245, 227));
                } else {
                    tfUserN.setBackground(new Color(246, 226, 226));
                }
            } else {
                tfUserN.setBackground(new Color(246, 226, 226));
            }
        } else if (z == pfPasswordN) {
            if (logic.checkPassword(pfPasswordN.getText())) {
                pfPasswordN.setBackground(new Color(227, 245, 227));
            } else {
                pfPasswordN.setBackground(new Color(246, 226, 226));
            }
        } else if (z == tfSearchProductByName) {
            if (logic.checkProductName(tfSearchProductByName.getText())) {
                tfSearchProductByName.setBackground(new Color(255, 248, 235));
                removeSearchProductsBoxes();
                searchProducts(listCategory.indexOf(cbCategory.getSelectedItem().toString()), cbSubategory.getSelectedIndex(), tfSearchProductByName.getText(), tfMax.getText(), tfMin.getText(), cbOrderBy.getSelectedIndex()+1);
            } else {
                tfSearchProductByName.setBackground(new Color(246, 226, 226));
            }
        } else if (z == tfMin) {
            if (logic.checkPrice(tfMin.getText())) {
                tfMin.setBackground(new Color(255, 248, 235));
                sMin = tfMin.getText();
                removeSearchProductsBoxes();
                searchProducts(listCategory.indexOf(cbCategory.getSelectedItem().toString()), cbSubategory.getSelectedIndex(), tfSearchProductByName.getText(), tfMax.getText(), tfMin.getText(), cbOrderBy.getSelectedIndex()+1);
            } else {
                tfMin.setText(sMin);
                tfMin.setBackground(new Color(246, 226, 226));
            }
        } else if (z == tfMax) {
            if (logic.checkPrice(tfMax.getText())) {
                tfMax.setBackground(new Color(255, 248, 235));
                sMax = tfMax.getText();
                removeSearchProductsBoxes();
                searchProducts(listCategory.indexOf(cbCategory.getSelectedItem().toString()), cbSubategory.getSelectedIndex(), tfSearchProductByName.getText(), tfMax.getText(), tfMin.getText(), cbOrderBy.getSelectedIndex()+1);
            } else {
                tfMax.setText(sMax);
                tfMax.setBackground(new Color(246, 226, 226));
            }
        }
    }
}