package bakery.main;
import bakery.img.img;

import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.File;

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
    private boolean isManager = false;

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
    private final JButton bCompletedOrders = new JButton("Completed orders");
    private final JButton bBestClient = new JButton("Best client");
    private final JButton bBestSeller = new JButton("Best seller");

    //home window
    private final JPanel pWelcomeHome = new JPanel();
    private final JLabel lWelcomeHome = new JLabel();

    private final JPanel pProfilePicture = new JPanel();
    private final JLabel lProfilePicture = new JLabel();

    private final JButton bUpdateHome = new JButton("Update");

    private final JPanel pUrInfo = new JPanel();
    private final JLabel lUrInfo = new JLabel();

    private final JPanel pUrPosition = new JPanel();
    private final JPanel pUrSalary = new JPanel();
    private final JLabel lUrPosition = new JLabel();
    private final JLabel lUrSalary = new JLabel();
    private final JLabel lSalary = new JLabel();

    private final JPanel pUrAdres = new JPanel();
    private final JLabel lUrAdres = new JLabel();

    private final JPanel pBigAdres = new JPanel();
    private final JLabel lBigAdresl1 = new JLabel();
    private final JLabel lBigAdresl2 = new JLabel();

    //search product window

    //new orders window

    //completed orders window

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

        //
    }

    private void setComboBoxes() {

        for (String s : q.fillcbPosition()) {
            cbPosition.addItem(s);
        }
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

        lWelcomeHome.setFont(new Font(Font.DIALOG,  Font.BOLD, 15));
        lWelcomeHome.setForeground(new Color(90, 52, 43));

        pProfilePicture.setOpaque(false);
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

        loginWindow();
        //createLeftBanner();
    }

    private void createLeftBanner() {
        bHome.setBounds(25, 120, 170, 30);
        bSearchProducts.setBounds(25, 170, 170, 30);
        bNewOrders.setBounds(25, 220, 170, 30);
        bCompletedOrders.setBounds(25, 270, 170, 30);
        bBestClient.setBounds(25, 320, 170, 30);
        bBestSeller.setBounds(25, 370, 170, 30);
        layere.add(bHome, 1, 0);
        layere.add(bSearchProducts, 1, 0);
        layere.add(bNewOrders, 1, 0);
        layere.add(bCompletedOrders, 1, 0);
        layere.add(bBestClient, 1, 0);
        layere.add(bBestSeller, 1, 0);
        homeWindow();
    }

    private void homeWindow() {
        pWelcomeHome.setBounds(400, 80, 200, 40);
        lWelcomeHome.setText("Welcome "+q.getNameHome(userId)+"!");
        pWelcomeHome.add(lWelcomeHome);

        pProfilePicture.setBounds(800, 100, 150, 150);
        lProfilePicture.setIcon(img.getImage(q.getPicture("Employee",userId)));
        pProfilePicture.add(lProfilePicture);

        pBigAdres.setBounds(300, 200, 100, 200);
        lBigAdresl1.setText(q.getAdres1(userId));
        lBigAdresl2.setText(q.getAdres2(userId));
        pBigAdres.add(lBigAdresl1);
        pBigAdres.add(lBigAdresl2);

        layere.add(pWelcomeHome,1,0);
        layere.add(pProfilePicture, 1, 0);
        layere.add(pBigAdres, 1, 0);
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

        } else if (z == bSearchProducts) {

        } else if (z == bNewOrders) {

        } else if (z == bCompletedOrders) {

        } else if (z == bBestClient) {

        } else if (z == bBestSeller) {

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
        }
    }
}
