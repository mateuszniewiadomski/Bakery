package bakery.main;
import bakery.img.img;

import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import static javax.swing.BorderFactory.createEmptyBorder;

public class Window extends JFrame implements ActionListener, KeyListener, MouseListener {

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
    private boolean isConfectioner = false;
    private String sMin = "0";
    private String sMax = "100";

    //login window
    private final JPanel pUser = new JPanel();
    private final JLabel lUser = new JLabel("Username");
    private final JPanel pPassword = new JPanel();
    private final JLabel lPassword = new JLabel("Password");
    private final JTextField tfUser = new JTextField();
    private final JPasswordField pfPassword = new JPasswordField();
    private final JButton bLogin = new JButton("Sign in");
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
    private final JButton bStatistics = new JButton("Statistics");
    private final JButton bManagerArea = new JButton("Manager area");

    private final JPanel pMustManager = new JPanel();
    private final JLabel lMustManager = new JLabel("no access - you must be a manager!");

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
    private final JPanel pUrPosition2 = new JPanel();
    private final JPanel pUrSalary2 = new JPanel();
    private final JLabel lUrPosition2 = new JLabel();
    private final JLabel lUrSalary2 = new JLabel();

    private final JPanel pUrAdres = new JPanel();
    private final JLabel lUrAdres = new JLabel("Your adres:");

    private final JPanel pBigAdres1 = new JPanel();
    private final JPanel pBigAdres2 = new JPanel();
    private final JLabel lBigAdresl1 = new JLabel();
    private final JLabel lBigAdresl2 = new JLabel();

    private final JButton bLogOut = new JButton("Sign out");

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

    private final JPanel pMustSeller = new JPanel();
    private final JLabel lMustSeller = new JLabel("no access - you must be a seller!");

    //bake window
    private final List<Integer> listBakeProductsId = new ArrayList<Integer>();

    private JTextField[] tfAmountToBake;

    private final JPanel pProductsToBake = new JPanel();
    private final JScrollPane spBake = new JScrollPane(pProductsToBake);

    private final JPanel pBakeTitle = new JPanel();
    private final JLabel lBakeTitle = new JLabel("Bake area");

    private final JButton bBakeProducts = new JButton("Bake");

    private final JPanel pMustConfectioner = new JPanel();
    private final JLabel lMustConfectioner = new JLabel("no access - you must be a confectioner!");

    private final JPanel pProductName = new JPanel();
    private final JLabel lProductName = new JLabel("Product name");

    private final JPanel pProductCurrentAmount = new JPanel();
    private final JLabel lProductCurrentAmuont = new JLabel("Current amount");

    private final JPanel pProductAmountToBake = new JPanel();
    private final JLabel lProductAmountToBake = new JLabel("Amount to bake");

    private final JComboBox cbOrderToBake = new JComboBox();

    //completed orders window
    private final JPanel pAllCompletedOrders = new JPanel();
    private final JScrollPane spCompletedOrders = new JScrollPane(pAllCompletedOrders);

    private final JComboBox cbOrderCompletedOrders = new JComboBox();

    private final JPanel pOrderCompletedOrders = new JPanel();
    private final JLabel lOrderCompletedOrders = new JLabel("Order by: ");

    //statistics window
    private final JComboBox cbStatsCategory = new JComboBox();

    private final JPanel pStatsBox = new JPanel();

    private final JPanel pStats = new JPanel();
    private final JLabel lStats = new JLabel("Choose category:");

    //manager area window
    private final List<Integer> listOfIds = new ArrayList<Integer>();

    private final JPanel bgManager = new JPanel();

    private final JButton bManagerAdd = new JButton("Add");
    private JButton[] bManagerDelete;
    private JButton[] bManagerUpdate;
    private JButton[] bManagerRead;
    private final JButton bManagerBack = new JButton("Back");
    private final JButton bManagerAccept = new JButton("Accept");
    private final JButton bManagerCancel = new JButton("Cancel");

    private final JComboBox cbChooseDbo = new JComboBox();

    private final JPanel pManagementBox = new JPanel();
    private final JScrollPane spManagement = new JScrollPane(pManagementBox);

    private JComboBox cbManagamet = new JComboBox();
    private JComboBox cbManagamet1 = new JComboBox();
    private JComboBox cbManagamet2 = new JComboBox();
    private String[][] sData;
    private JTextField[] tfData;
    private int stroreId;
    private int[] storeBakerId;

    private boolean update = false;

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
        bBake.addActionListener(this);
        bCompletedOrders.addActionListener(this);
        bStatistics.addActionListener(this);

        bManagerArea.removeActionListener(this);
        bManagerArea.removeMouseListener(this);
        if (isManager) {
            bManagerArea.addActionListener(this);
        } else {
            bManagerArea.addMouseListener(this);
        }

        //home window
        bLogOut.addActionListener(this);

        //search product window
        tfMin.addKeyListener(this);
        tfMax.addKeyListener(this);
        tfSearchProductByName.addKeyListener(this);

        //new orders window
        bGenerateNewOrder.addActionListener(this);

        bAcceptAll.removeActionListener(this);
        bAcceptAll.removeMouseListener(this);
        if (isSeller) {
            bAcceptAll.addActionListener(this);
        } else {
            bAcceptAll.addMouseListener(this);
        }

        //completed orders window

        bBakeProducts.removeActionListener(this);
        bBakeProducts.removeMouseListener(this);
        if (isConfectioner) {
            bBakeProducts.addActionListener(this);
        } else {
            bBakeProducts.addMouseListener(this);
        }

        //manager area window
        bManagerBack.addActionListener(this);
        bManagerAdd.addActionListener(this);
        bManagerCancel.addActionListener(this);
        bManagerAccept.addActionListener(this);
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

        cbOrderToBake.addItem("<Order>");
        cbOrderToBake.addItem("Priority");
        cbOrderToBake.addItem("Name");

        cbOrderCompletedOrders.addItem("<Default>");
        cbOrderCompletedOrders.addItem("Customer");
        cbOrderCompletedOrders.addItem("Cashier");
        cbOrderCompletedOrders.addItem("Payment");
        cbOrderCompletedOrders.addItem("Packing");
        cbOrderCompletedOrders.addItem("Order Time");
        cbOrderCompletedOrders.addItem("Order Completion");
        cbOrderCompletedOrders.addItem("Cost");

        cbStatsCategory.addItem("Cash");
        cbStatsCategory.addItem("Products");
        cbStatsCategory.addItem("Clients");
        cbStatsCategory.addItem("Bakery");

        cbChooseDbo.addItem("Clients");
        cbChooseDbo.addItem("Employees");
        cbChooseDbo.addItem("Products");
        cbChooseDbo.addItem("Supplier");
        cbChooseDbo.addItem("Position");
        cbChooseDbo.addItem("Category");
        cbChooseDbo.addItem("Subcategory");
        cbChooseDbo.addItem("Payment");
        cbChooseDbo.addItem("Packing");
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

        bStatistics.setFont(new Font(Font.DIALOG,  Font.BOLD, 15));
        bStatistics.setBackground(new Color(90, 52, 43));
        bStatistics.setForeground(new Color(255, 242, 216));
        bStatistics.setBorderPainted(false);

        if (isManager) {
            bManagerArea.setFont(new Font(Font.DIALOG,  Font.BOLD, 15));
            bManagerArea.setBackground(new Color(90, 52, 43));
            bManagerArea.setForeground(new Color(255, 242, 216));
            bManagerArea.setBorderPainted(false);
        } else {
            bManagerArea.setFont(new Font(Font.DIALOG,  Font.BOLD, 15));
            bManagerArea.setBackground(new Color(90, 52, 43));
            bManagerArea.setForeground(new Color(161, 150, 133));
            bManagerArea.setBorderPainted(false);
        }

        lMustManager.setFont(new Font(Font.DIALOG,  Font.ITALIC, 13));
        pMustManager.add(lMustManager);

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

        bLogOut.setFont(new Font(Font.DIALOG,  Font.BOLD, 15));
        bLogOut.setBackground(new Color(90, 52, 43));
        bLogOut.setForeground(new Color(255, 242, 216));
        bLogOut.setBorderPainted(false);

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

        if (isSeller) {
            bAcceptAll.setFont(new Font(Font.DIALOG,  Font.BOLD, 15));
            bAcceptAll.setBackground(new Color(90, 52, 43));
            bAcceptAll.setForeground(new Color(255, 242, 216));
            bAcceptAll.setBorderPainted(false);
        } else {
            bAcceptAll.setFont(new Font(Font.DIALOG,  Font.BOLD, 15));
            bAcceptAll.setBackground(new Color(90, 52, 43));
            bAcceptAll.setForeground(new Color(161, 150, 133));
            bAcceptAll.setBorderPainted(false);
        }

        lMustSeller.setFont(new Font(Font.DIALOG,  Font.ITALIC, 10));
        pMustSeller.add(lMustSeller);
        pMustSeller.setBackground(new Color(255, 255, 255, 230));

        bGenerateNewOrder.setBounds(700, 80, 200, 25);
        pNewOrdersTitle.setBounds(300, 90, 400, 40);
        bAcceptAll.setBounds(700, 110, 200, 25);
        pMustSeller.setBounds(780, 130, 200, 25);

        //bake products window
        if (isConfectioner) {
            bBakeProducts.setFont(new Font(Font.DIALOG,  Font.BOLD, 15));
            bBakeProducts.setBackground(new Color(90, 52, 43));
            bBakeProducts.setForeground(new Color(255, 242, 216));
            bBakeProducts.setBorderPainted(false);
        } else {
            bBakeProducts.setFont(new Font(Font.DIALOG,  Font.BOLD, 15));
            bBakeProducts.setBackground(new Color(90, 52, 43));
            bBakeProducts.setForeground(new Color(161, 150, 133));
            bBakeProducts.setBorderPainted(false);
        }

        lMustConfectioner.setFont(new Font(Font.DIALOG,  Font.ITALIC, 10));
        pMustConfectioner.add(lMustConfectioner);

        lBakeTitle.setFont(new Font(Font.DIALOG,  Font.BOLD, 25));
        lBakeTitle.setForeground(new Color(90, 52, 43));

        lProductName.setFont(new Font(Font.DIALOG,  Font.BOLD, 15));
        lProductName.setForeground(new Color(90, 52, 43));

        lProductCurrentAmuont.setFont(new Font(Font.DIALOG,  Font.BOLD, 15));
        lProductCurrentAmuont.setForeground(new Color(90, 52, 43));

        lProductAmountToBake.setFont(new Font(Font.DIALOG,  Font.BOLD, 15));
        lProductAmountToBake.setForeground(new Color(90, 52, 43));

        pBakeTitle.setOpaque(false);
        pProductName.setOpaque(false);
        pProductCurrentAmount.setOpaque(false);
        pProductAmountToBake.setOpaque(false);

        pBakeTitle.add(lBakeTitle);
        pProductName.add(lProductName);
        pProductCurrentAmount.add(lProductCurrentAmuont);
        pProductAmountToBake.add(lProductAmountToBake);

        pBakeTitle.setBounds(350, 80, 200, 40);
        bBakeProducts.setBounds(600, 85, 200, 25);

        pMustConfectioner.setBounds(690, 100, 200, 25);

        pProductName.setBounds(280, 120, 200, 25);
        pProductCurrentAmount.setBounds(475, 120, 200, 25);
        pProductAmountToBake.setBounds(680, 120, 200, 25);
        cbOrderToBake.setBounds(850, 85, 100, 25);

        cbOrderToBake.setForeground(new Color(90, 52, 43));
        cbOrderToBake.setBackground(new Color(255, 248, 235));
        cbOrderToBake.setBorder(new LineBorder(new Color(90, 52, 43)));

        //completed orders window
        cbOrderCompletedOrders.setForeground(new Color(90, 52, 43));
        cbOrderCompletedOrders.setBackground(new Color(255, 248, 235));
        cbOrderCompletedOrders.setBorder(new LineBorder(new Color(90, 52, 43)));

        lOrderCompletedOrders.setFont(new Font(Font.DIALOG,  Font.BOLD, 15));
        lOrderCompletedOrders.setForeground(new Color(90, 52, 43));

        pOrderCompletedOrders.add(lOrderCompletedOrders);

        pOrderCompletedOrders.setOpaque(false);

        pOrderCompletedOrders.setBounds(440, 95, 100, 30);
        cbOrderCompletedOrders.setBounds(550, 100, 150, 25);

        //statistics window
        cbStatsCategory.setForeground(new Color(90, 52, 43));
        cbStatsCategory.setBackground(new Color(255, 248, 235));
        cbStatsCategory.setBorder(new LineBorder(new Color(90, 52, 43)));

        lStats.setFont(new Font(Font.DIALOG,  Font.BOLD, 15));
        lStats.setForeground(new Color(90, 52, 43));

        pStats.add(lStats);

        pStats.setOpaque(false);

        pStats.setBounds(400, 95, 150, 30);
        cbStatsCategory.setBounds(550, 100, 150, 25);

        //manager area window
        bManagerBack.setFont(new Font(Font.DIALOG,  Font.BOLD, 15));
        bManagerBack.setBackground(new Color(54, 54, 55));
        bManagerBack.setForeground(new Color(255, 255, 255));
        bManagerBack.setBorderPainted(false);

        bManagerAdd.setFont(new Font(Font.DIALOG,  Font.BOLD, 15));
        bManagerAdd.setBackground(new Color(40, 203, 0));
        bManagerAdd.setForeground(new Color(255, 248, 236));
        bManagerAdd.setBorderPainted(false);

        bManagerAccept.setFont(new Font(Font.DIALOG,  Font.BOLD, 15));
        bManagerAccept.setBackground(new Color(54, 54, 55));
        bManagerAccept.setForeground(new Color(255, 255, 255));
        bManagerAccept.setBorderPainted(false);

        bManagerCancel.setFont(new Font(Font.DIALOG,  Font.BOLD, 15));
        bManagerCancel.setBackground(new Color(54, 54, 55));
        bManagerCancel.setForeground(new Color(255, 255, 255));
        bManagerCancel.setBorderPainted(false);

        cbChooseDbo.setForeground(new Color(64, 64, 64));
        cbChooseDbo.setBackground(new Color(255, 255, 255));
        cbChooseDbo.setBorder(new LineBorder(new Color(64, 64, 64)));

        cbManagamet.setForeground(new Color(64, 64, 64));
        cbManagamet.setBackground(new Color(255, 255, 255));
        cbManagamet.setBorder(new LineBorder(new Color(64, 64, 64)));

        cbManagamet1.setForeground(new Color(64, 64, 64));
        cbManagamet1.setBackground(new Color(255, 255, 255));
        cbManagamet1.setBorder(new LineBorder(new Color(64, 64, 64)));

        cbManagamet2.setForeground(new Color(64, 64, 64));
        cbManagamet2.setBackground(new Color(255, 255, 255));
        cbManagamet2.setBorder(new LineBorder(new Color(64, 64, 64)));

        bgManager.setBounds(0, 0, 1000, 600);
        bgManager.setBackground(Color.white);

        bManagerBack.setBounds(800, 80, 150, 25);
        bManagerAdd.setBounds(200, 80, 150, 25);
        cbChooseDbo.setBounds(650, 80, 100, 25);
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

        layere.add(pLogo, 4, 0);
        layere.add(pBanner, 3, 0);
        layere.add(pBG, 0, 0);

        loginWindow();
    }

    private void createLeftBanner() {
        bHome.setBounds(25, 120, 170, 30);
        bSearchProducts.setBounds(25, 170, 170, 30);
        bNewOrders.setBounds(25, 220, 170, 30);
        bBake.setBounds(25, 270, 170, 30);
        bCompletedOrders.setBounds(25, 320, 170, 30);
        bStatistics.setBounds(25, 370, 170, 30);
        bManagerArea.setBounds(25, 470, 170, 30);

        pMustManager.setBounds(100, 490, 240, 25);

        layere.add(bHome, 1, 0);
        layere.add(bSearchProducts, 1, 0);
        layere.add(bNewOrders, 1, 0);
        layere.add(bBake, 1, 0);
        layere.add(bCompletedOrders, 1, 0);
        layere.add(bStatistics, 1, 0);
        layere.add(bManagerArea, 1, 0);
        checkPosition();
        setStyle();
        if (isManager) {
            bManagerArea.setEnabled(true);
        } else {
            bManagerArea.setEnabled(false);
        }
        bManagerArea.removeActionListener(this);
        bManagerArea.removeMouseListener(this);
        if (isManager) {
            bManagerArea.addActionListener(this);
        } else {
            bManagerArea.addMouseListener(this);
        }
        bBakeProducts.removeActionListener(this);
        bBakeProducts.removeMouseListener(this);
        if (isConfectioner) {
            bBakeProducts.addActionListener(this);
        } else {
            bBakeProducts.addMouseListener(this);
        }
        bAcceptAll.removeActionListener(this);
        bAcceptAll.removeMouseListener(this);
        if (isSeller) {
            bAcceptAll.addActionListener(this);
        } else {
            bAcceptAll.addMouseListener(this);
        }
        homeWindow();
    }

    private void checkPosition() {
        isManager = isSeller = isConfectioner = false;
        String position = q.getSalaryOrPosition(userId, "Position.Id");
        if (position.equals("1")) {
            isManager = true;
        } else {
            isManager = false;
        }
        if (position.equals("3")) {
            isSeller = true;
        } else {
            isSeller= false;
        } if (position.equals("2")) {
            isConfectioner = true;
        } else {
            isConfectioner= false;
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

        bLogOut.setBounds(650, 470, 150, 30);

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

        layere.add(bLogOut, 1, 0);

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
        } else if (window.equals("bakeWindow")) {
            removeBakeWindow();
        } else if (window.equals("completedOrdersWindow")) {
            removeCompletedOrdersWindow();
        } else if (window.equals("statisticsWindow")) {
            removeStatisticsWindow();
        } else if (window.equals("managerWindow")) {
            removeManagerWindow();
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
        layere.remove(bLogOut);
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
        cbCategory.setSelectedIndex(0);
        cbSubategory.setSelectedIndex(0);
        tfSearchProductByName.setText("");
        tfMin.setText("");
        tfMax.setText("");
        cbOrderBy.setSelectedIndex(0);
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
            if (!listOrders.get(i).isDone()) {
                for (int j = 0; j < listOrders.get(i).getProducts().length; j++) {
                    int x = q.getAmount(listOrders.get(i).getProducts()[j][0]);
                    if (x - listOrders.get(i).getProducts()[j][1] < 0) {
                        makeIt = false;
                    }
                }
                if (makeIt) {
                    Date Date = Calendar.getInstance().getTime();
                    DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                    double sum = 0;
                    for (int z = 0; z < listOrders.get(i).getProducts().length; z++) {
                        sum = sum + listOrders.get(i).getProducts()[z][1]*q.getCost(listOrders.get(i).getProducts()[z][0]);
                        q.updateAmountOfProducts(listOrders.get(i).getProducts()[z][0], q.getAmount(listOrders.get(i).getProducts()[z][0]) - listOrders.get(i).getProducts()[z][1]);
                    }
                    double noTaxes = sum*0.77;
                    q.insertOrders(i+1+shift, listOrders.get(i).getCustomerId(), userId, listOrders.get(i).getPaymentId(), listOrders.get(i).getPackingId(), listOrders.get(i).getDate(), dateFormat.format(Date), sum, noTaxes);
                    for (int z = 0; z < listOrders.get(i).getProducts().length; z++) {
                        q.insertProductHasOrder(listOrders.get(i).getProducts()[z][0], i+1+shift, listOrders.get(i).getProducts()[z][1]);
                    }
                    listOrders.get(i).setDone(true);
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

            if (!listOrders.get(i).isDone()) {

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
                lClient[i] = new JLabel(q.getFullName(listOrders.get(i).getCustomerId()));
                lProduct[i] = new JLabel("Products:");
                lDate[i] = new JLabel(listOrders.get(i).getDate());
                lToPay[i] = new JLabel();

                JLabel[] lProductName = new JLabel[listOrders.get(i).getProducts().length];
                JLabel[] lProductCost = new JLabel[listOrders.get(i).getProducts().length];
                JLabel[] lProductAmount = new JLabel[listOrders.get(i).getProducts().length];

                JPanel[] pProductName = new JPanel[listOrders.get(i).getProducts().length];
                JPanel[] pProductCost = new JPanel[listOrders.get(i).getProducts().length];
                JPanel[] pProductAmount = new JPanel[listOrders.get(i).getProducts().length];
                JPanel[] pExtraSpace1 = new JPanel[listOrders.get(i).getProducts().length];
                JPanel[] pExtraSpace2 = new JPanel[listOrders.get(i).getProducts().length];

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

                for (int j = 0; j < listOrders.get(i).getProducts().length; j++) {

                    additionalHeight = additionalHeight + 22;

                    toPay = toPay + listOrders.get(i).getProducts()[j][1]*q.getCost(listOrders.get(i).getProducts()[j][0]);

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

                    lProductName[j] = new JLabel(q.getProductName(listOrders.get(i).getProducts()[j][0]));
                    lProductCost[j] = new JLabel("$ "+q.getCost(listOrders.get(i).getProducts()[j][0]));
                    lProductAmount[j] = new JLabel("x"+listOrders.get(i).getProducts()[j][1]);

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

                if (i%2 == 0) {
                    p1[i].setBackground(new Color(255, 255, 255, 65));
                } else {
                    p1[i].setBackground(new Color(207, 255, 255, 50));
                }

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

        layere.remove(spNewOrders);
        layere.remove(pNewOrdersTitle);
        layere.remove(bGenerateNewOrder);
        layere.remove(bAcceptAll);

        layere.revalidate();
        layere.repaint();
    }

    private void bakeWindow() {

        window = "bakeWindow";

        layere.add(cbOrderToBake, 1, 0);
        layere.add(pBakeTitle, 1, 0);
        layere.add(bBakeProducts, 1, 0);
        layere.add(pProductName, 1, 0);
        layere.add(pProductCurrentAmount, 1, 0);
        layere.add(pProductAmountToBake, 1, 0);

        cbOrderToBake.addActionListener(this);

        bakeWindowUpdate();
    }

    private void bakeWindowUpdate() {

        layere.remove(spBake);
        layere.revalidate();
        layere.repaint();

        pProductsToBake.removeAll();
        pProductsToBake.revalidate();
        pProductsToBake.repaint();

        listBakeProductsId.clear();
        int[] ids = q.getIdsToBake(cbOrderToBake.getSelectedIndex()+1);
        for (int i : ids) {
            listBakeProductsId.add(i);
        }

        JPanel[] p1 = new JPanel[ids.length];
        tfAmountToBake = new JTextField[ids.length];
        JPanel[] pProductName = new JPanel[ids.length];
        JPanel[] pProductAmount = new JPanel[ids.length];

        for (int i = 0; i < ids.length; i++) {

            p1[i] = new JPanel();
            pProductName[i] = new JPanel();
            pProductAmount[i] = new JPanel();
            tfAmountToBake[i] = new JTextField("0");

            tfAmountToBake[i].addKeyListener(this);

            JLabel lProductName = new JLabel();
            JLabel lProductAmount = new JLabel();
            JPanel ptf = new JPanel();

            pProductName[i].add(lProductName);
            pProductAmount[i].add(lProductAmount);
            ptf.add(tfAmountToBake[i]);

            lProductName.setText(q.getProductName(ids[i]));
            lProductAmount.setText(String.valueOf(q.getAmount(ids[i])));

            if (q.getAmount(ids[i]) < 5) {
                lProductAmount.setForeground(new Color(255, 0, 0));
            } else if (q.getAmount(ids[i]) > 7) {
                lProductAmount.setForeground(new Color(73, 255, 0));
            } else {
                lProductAmount.setForeground(new Color(255, 141, 0));
            }

            lProductAmount.setFont(new Font(Font.DIALOG,  Font.BOLD, 15));

            lProductName.setFont(new Font(Font.DIALOG,  Font.BOLD, 15));
            lProductName.setForeground(new Color(90, 52, 43));

            tfAmountToBake[i].setForeground(new Color(90, 52, 43));
            tfAmountToBake[i].setBackground(new Color(255, 248, 235));
            tfAmountToBake[i].setBorder(new LineBorder(new Color(90, 52, 43)));

            pProductName[i].setOpaque(false);
            pProductAmount[i].setOpaque(false);
            ptf.setOpaque(false);

            pProductName[i].setPreferredSize(new Dimension(200, 35));
            pProductAmount[i].setPreferredSize(new Dimension(200, 35));
            tfAmountToBake[i].setPreferredSize(new Dimension(50, 25));
            ptf.setPreferredSize(new Dimension(200, 35));
            p1[i].setPreferredSize(new Dimension(700, 40));

            if (i%2 == 0) {
                p1[i].setBackground(new Color(255, 255, 255, 65));
            } else {
                p1[i].setBackground(new Color(207, 255, 255, 50));
            }

            p1[i].add(pProductName[i]);
            p1[i].add(pProductAmount[i]);
            p1[i].add(ptf);

            pProductsToBake.add(p1[i]);
        }

        pProductsToBake.setPreferredSize(new Dimension(750, 46*ids.length));
        pProductsToBake.setOpaque(false);
        spBake.setOpaque(false);
        spBake.getViewport().setOpaque(false);
        spBake.setBorder(createEmptyBorder());
        spBake.setBounds(200, 150, 786, 414);

        layere.add(spBake, 1, 0);
    }

    private void updateBake() {

        for (int i = 0; i < listBakeProductsId.size(); i++) {
            if (tfAmountToBake[i].getText().equals("")) {
                tfAmountToBake[i].setText("0");
            }
            int add = Integer.valueOf(tfAmountToBake[i].getText());
            int now = q.getAmount(listBakeProductsId.get(i));
            q.updateAmountOfProducts(listBakeProductsId.get(i), now+add);
        }
    }

    private void removeBakeWindow() {

        cbOrderToBake.removeActionListener(this);

        layere.remove(cbOrderToBake);
        layere.remove(pBakeTitle);
        layere.remove(bBakeProducts);
        layere.remove(pProductName);
        layere.remove(pProductCurrentAmount);
        layere.remove(pProductAmountToBake);
        layere.remove(spBake);

        layere.revalidate();
        layere.repaint();
    }

    private void completedOrdersWindow() {

        window = "completedOrdersWindow";

        layere.add(pOrderCompletedOrders, 1, 0);
        layere.add(cbOrderCompletedOrders, 1, 0);

        cbOrderCompletedOrders.addActionListener(this);

        layere.revalidate();
        layere.repaint();

        updateCompletedOrdersWindow();
    }

    private void updateCompletedOrdersWindow(){

        layere.remove(spCompletedOrders);
        layere.revalidate();
        layere.repaint();

        pAllCompletedOrders.removeAll();
        pAllCompletedOrders.revalidate();
        pAllCompletedOrders.repaint();

        String[][] a = q.getAllCompletedOrders(cbOrderCompletedOrders.getSelectedIndex());

        int i = 0;

        for (String s[] : a) {

            JPanel p1 = new JPanel();

            JPanel pClientName = new JPanel();
            JPanel pCashierName = new JPanel();
            JPanel pPayment = new JPanel();
            JPanel pPacking = new JPanel();
            JPanel pDate1 = new JPanel();
            JPanel pDate2 = new JPanel();
            JPanel pCost = new JPanel();
            JPanel pSpace1 = new JPanel();
            JPanel pSpace2 = new JPanel();
            JPanel pSpace3 = new JPanel();

            JLabel lClientName = new JLabel("Customer: "+s[0]+" "+s[1]);
            JLabel lCashierName = new JLabel("Cashier: "+s[2]+" "+s[3]);
            JLabel lPayment = new JLabel("By: "+s[4]);
            JLabel lPacking = new JLabel("Packing: "+s[5]);
            JLabel lDate1 = new JLabel(" Date of order: "+s[6]);
            JLabel lDate2 = new JLabel("Order finished: "+s[7]);
            JLabel lCost = new JLabel("Payment: $ "+s[8]);

            pClientName.add(lClientName);
            pCashierName.add(lCashierName);
            pDate1.add(lDate1);
            pDate2.add(lDate2);
            pPacking.add(lPacking);
            pPayment.add(lPayment);
            pCost.add(lCost);

            pClientName.setOpaque(false);
            pCashierName.setOpaque(false);
            pDate1.setOpaque(false);
            pDate2.setOpaque(false);
            pPacking.setOpaque(false);
            pPayment.setOpaque(false);
            pCost.setOpaque(false);
            pSpace1.setOpaque(false);
            pSpace2.setOpaque(false);
            pSpace3.setOpaque(false);

            if (i%2 == 0) {
                p1.setBackground(new Color(255, 255, 255, 65));
            } else {
                p1.setBackground(new Color(207, 255, 255, 50));
            }

            pClientName.setPreferredSize(new Dimension(170, 25));
            pCashierName.setPreferredSize(new Dimension(170, 25));
            pDate1.setPreferredSize(new Dimension(200, 25));
            pDate2.setPreferredSize(new Dimension(200, 25));
            pPacking.setPreferredSize(new Dimension(150, 25));
            pPayment.setPreferredSize(new Dimension(150, 25));
            pCost.setPreferredSize(new Dimension(110, 25));
            p1.setPreferredSize(new Dimension(700, 100));
            pSpace1.setPreferredSize(new Dimension(300, 25));
            pSpace2.setPreferredSize(new Dimension(300, 25));
            pSpace3.setPreferredSize(new Dimension(270, 25));

            p1.add(pClientName);
            p1.add(pSpace1);
            p1.add(pDate1);
            p1.add(pCashierName);
            p1.add(pSpace2);
            p1.add(pDate2);
            p1.add(pPacking);
            p1.add(pSpace3);
            p1.add(pCost);
            p1.add(pPayment);

            pAllCompletedOrders.add(p1);
            i = i+1;
        }


        pAllCompletedOrders.setPreferredSize(new Dimension(750, 106*i));
        pAllCompletedOrders.setOpaque(false);
        spCompletedOrders.setOpaque(false);
        spCompletedOrders.getViewport().setOpaque(false);
        spCompletedOrders.setBorder(createEmptyBorder());
        spCompletedOrders.setBounds(200, 150, 786, 414);

        layere.add(spCompletedOrders, 1, 0);


    }

    private void removeCompletedOrdersWindow() {

        layere.remove(pOrderCompletedOrders);
        layere.remove(cbOrderCompletedOrders);
        layere.remove(spCompletedOrders);

        cbOrderCompletedOrders.removeActionListener(this);

        layere.revalidate();
        layere.repaint();
    }

    private void statisticsWindow() {

        window = "statisticsWindow";

        layere.add(cbStatsCategory, 1, 0);
        layere.add(pStats, 1, 0);

        cbStatsCategory.addActionListener(this);

        updateStatisticsWindow();
    }

    private void updateStatisticsWindow() {

        layere.remove(pStatsBox);
        layere.revalidate();
        layere.repaint();

        pStatsBox.removeAll();
        pStatsBox.revalidate();
        pStatsBox.repaint();

        JPanel[] p = new JPanel[10];
        JLabel[] l = new JLabel[10];

        for (int i = 0; i < 10; i++) {
            p[i] = new JPanel();
            l[i] = new JLabel();
            p[i].add(l[i]);
            p[i].setOpaque(false);
            p[i].setPreferredSize(new Dimension(700, 30));
            l[i].setFont(new Font(Font.DIALOG,  Font.BOLD, 15));
            l[i].setForeground(new Color(90, 52, 43));
            pStatsBox.add(p[i]);
        }

        switch (cbStatsCategory.getSelectedIndex()) {
            case 0:
                String s1c0 = q.getStatsCash1();
                String s2c0 = q.getStatsCash2();
                String s3c0 = q.getStatsCash3_0();
                String s4c0 = q.getStatsCash3();
                String s5c0 = q.getStatsCash4();
                String s6c0 = q.getStatsCash5();
                l[1].setText("Total earned: $ "+s1c0);
                l[2].setText("Average earnings per order: $ "+s2c0);
                l[3].setText("Total paid taxes: $ "+s3c0);
                l[4].setText("Best month: $ "+s4c0);
                l[5].setText("Best day: $ "+s5c0);
                l[6].setText("Worst day: $ "+s6c0);
                break;
            case 1:
                String[] s1c1 = q.getStatsProduct1();
                String[] s2c1 = q.getStatsProduct2();
                String[] s3c1 = q.getStatsProduct3();
                String[] s4c1 = q.getStatsProduct4();
                String[] s5c1 = q.getStatsProduct5();
                String[] s6c1 = q.getStatsProduct6();
                l[1].setText("Best selling product: \""+s1c1[0]+"\", Amount: "+s1c1[1]);
                l[2].setText("Best selling subcategory: \""+s2c1[0]+"\", Amount: "+s2c1[1]);
                l[3].setText("Best selling category: \""+s3c1[0]+"\", Amount: "+s3c1[1]);
                l[5].setText("Worst selling product: \""+s4c1[0]+"\", Amount: "+s4c1[1]);
                l[6].setText("Worst selling subcategory: \""+s5c1[0]+"\", Amount: "+s5c1[1]);
                l[7].setText("Worst selling category: \""+s6c1[0]+"\", Amount: "+s6c1[1]);
                break;
            case 2:
                String s1c2 = q.getStatsCustomer1();
                String[] s2c2 = q.getStatsCustomer2();
                String[] s3c2 = q.getStatsCustomer3(s2c2[0]);
                String[] s4c2 = q.getStatsCustomer4(s2c2[0]);
                String s5c2 = q.getStatsCustomer5(s2c2[0]);
                l[1].setText("Total clients: "+s1c2);
                l[3].setText("Best client: "+s2c2[1]+" "+s2c2[2]+"!");
                l[4].setText("He spent: $ "+s2c2[3]+" in "+s2c2[4]+" orders");
                l[5].setText("He bought in total: "+s5c2+" products");
                l[6].setText("His favourite product: \""+s3c2[0]+"\", and bought: "+s3c2[1]+" products from it");
                l[7].setText("His favourite category: \""+s4c2[0]+"\", and bought: \""+s4c2[1]+"\" products from it");
                break;
            case 3:
                String s1c3 = q.getStatsFactory1();
                String[] s3c3 = q.getStatsFactory2();
                l[1].setText("Total employees: "+s1c3);
                l[3].setText("Best cashier: "+s3c3[0]+" "+s3c3[1]);
                l[4].setText("She made: "+s3c3[2]+" orders");
                l[5].setText("And bring: $ "+s3c3[3]+" for the company");
                break;
            default:
        }
        pStatsBox.setOpaque(false);
        pStatsBox.setBounds(200, 150, 786, 414);
        layere.add(pStatsBox, 1, 0);
    }

    private void removeStatisticsWindow() {

        cbStatsCategory.removeActionListener(this);

        layere.remove(pStatsBox);

        layere.remove(cbStatsCategory);
        layere.remove(pStats);

        layere.revalidate();
        layere.repaint();
    }

    private void managerWindow() {

        window = "managerWindow";

        layere.add(cbChooseDbo, 2, 0);
        layere.add(bManagerBack, 2, 0);
        layere.add(bManagerAdd, 2, 0);
        layere.add(bgManager, 1, 0);

        cbChooseDbo.addActionListener(this);

        updateManagerWindow();
    }

    private void updateManagerWindow() {

        listOfIds.clear();

        layere.remove(spManagement);
        layere.revalidate();
        layere.repaint();

        pManagementBox.removeAll();
        pManagementBox.revalidate();
        pManagementBox.repaint();

        int d = 0;

        switch (cbChooseDbo.getSelectedIndex()) {
            case 0:
                sData = q.getCustomerAndAdres();
                bManagerUpdate = new JButton[sData.length];
                bManagerDelete = new JButton[sData.length];
                bManagerRead = new JButton[sData.length];

                for (int i = 0; i < sData.length; i++) {

                    d = d + 1;

                    JPanel p0 = new JPanel();
                    JPanel p0e1 = new JPanel();
                    JPanel p0e2 = new JPanel();
                    JPanel p0e3 = new JPanel();
                    JPanel p0e4 = new JPanel();
                    JPanel p0l = new JPanel();
                    JLabel l0 = new JLabel(sData[i][2]+" "+sData[i][3]);

                    bManagerUpdate[i] = new JButton("Update");
                    bManagerDelete[i] = new JButton("Delete");
                    bManagerRead[i] = new JButton("Read");

                    p0.add(l0);
                    p0.setOpaque(false);
                    p0e1.setOpaque(false);
                    p0e2.setOpaque(false);
                    p0e3.setOpaque(false);
                    p0e4.setOpaque(false);
                    p0l.setBackground(new Color(64, 64, 64));

                    l0.setFont(new Font(Font.DIALOG,  Font.BOLD, 15));
                    l0.setForeground(new Color(64, 64, 64));

                    bManagerUpdate[i].setFont(new Font(Font.DIALOG,  Font.BOLD, 15));
                    bManagerUpdate[i].setBackground(new Color(203, 135, 0));
                    bManagerUpdate[i].setForeground(new Color(255, 248, 236));
                    bManagerUpdate[i].setBorderPainted(false);

                    bManagerDelete[i].setFont(new Font(Font.DIALOG,  Font.BOLD, 15));
                    bManagerDelete[i].setBackground(new Color(203, 0, 0));
                    bManagerDelete[i].setForeground(new Color(255, 248, 236));
                    bManagerDelete[i].setBorderPainted(false);

                    bManagerRead[i].setFont(new Font(Font.DIALOG,  Font.BOLD, 15));
                    bManagerRead[i].setBackground(new Color(0, 108, 203));
                    bManagerRead[i].setForeground(new Color(255, 248, 236));
                    bManagerRead[i].setBorderPainted(false);

                    bManagerUpdate[i].addActionListener(this);
                    bManagerDelete[i].addActionListener(this);
                    bManagerRead[i].addActionListener(this);

                    p0.setPreferredSize(new Dimension(200, 30));
                    p0e1.setPreferredSize(new Dimension(100, 25));
                    p0e2.setPreferredSize(new Dimension(20, 25));
                    p0e3.setPreferredSize(new Dimension(20, 25));
                    p0e4.setPreferredSize(new Dimension(250, 25));
                    bManagerUpdate[i].setPreferredSize(new Dimension(100, 25));
                    bManagerDelete[i].setPreferredSize(new Dimension(100, 25));
                    bManagerRead[i].setPreferredSize(new Dimension(100, 25));
                    p0l.setPreferredSize(new Dimension(900, 1));

                    pManagementBox.add(p0l);
                    pManagementBox.add(p0);
                    pManagementBox.add(p0e1);
                    pManagementBox.add(bManagerUpdate[i]);
                    pManagementBox.add(p0e2);
                    pManagementBox.add(bManagerDelete[i]);
                    pManagementBox.add(p0e3);
                    pManagementBox.add(bManagerRead[i]);
                    pManagementBox.add(p0e4);
                }

                break;
            case 1:
                sData = q.getEmployeeAndAdres();
                bManagerUpdate = new JButton[sData.length];
                bManagerDelete = new JButton[sData.length];
                bManagerRead = new JButton[sData.length];

                for (int i = 0; i < sData.length; i++) {

                    d = d + 1;

                    JPanel p0 = new JPanel();
                    JPanel p0e1 = new JPanel();
                    JPanel p0e2 = new JPanel();
                    JPanel p0e3 = new JPanel();
                    JPanel p0e4 = new JPanel();
                    JPanel p0e5 = new JPanel();
                    JPanel p1 = new JPanel();
                    JPanel p0l = new JPanel();
                    JLabel l0 = new JLabel(sData[i][3]+" "+sData[i][4]);
                    JLabel l1 = new JLabel(sData[i][5]);

                    bManagerUpdate[i] = new JButton("Update");
                    bManagerDelete[i] = new JButton("Delete");
                    bManagerRead[i] = new JButton("Read");

                    p0.add(l0);
                    p1.add(l1);
                    p0.setOpaque(false);
                    p1.setOpaque(false);
                    p0e1.setOpaque(false);
                    p0e2.setOpaque(false);
                    p0e3.setOpaque(false);
                    p0e4.setOpaque(false);
                    p0e5.setOpaque(false);
                    p0l.setBackground(new Color(64, 64, 64));

                    l0.setFont(new Font(Font.DIALOG,  Font.BOLD, 15));
                    l0.setForeground(new Color(64, 64, 64));

                    l1.setFont(new Font(Font.DIALOG,  Font.BOLD, 15));
                    l1.setForeground(new Color(64, 64, 64));

                    bManagerUpdate[i].setFont(new Font(Font.DIALOG,  Font.BOLD, 15));
                    bManagerUpdate[i].setBackground(new Color(203, 135, 0));
                    bManagerUpdate[i].setForeground(new Color(255, 248, 236));
                    bManagerUpdate[i].setBorderPainted(false);

                    bManagerDelete[i].setFont(new Font(Font.DIALOG,  Font.BOLD, 15));
                    bManagerDelete[i].setBackground(new Color(203, 0, 0));
                    bManagerDelete[i].setForeground(new Color(255, 248, 236));
                    bManagerDelete[i].setBorderPainted(false);

                    bManagerRead[i].setFont(new Font(Font.DIALOG,  Font.BOLD, 15));
                    bManagerRead[i].setBackground(new Color(0, 108, 203));
                    bManagerRead[i].setForeground(new Color(255, 248, 236));
                    bManagerRead[i].setBorderPainted(false);

                    bManagerUpdate[i].addActionListener(this);
                    bManagerDelete[i].addActionListener(this);
                    bManagerRead[i].addActionListener(this);

                    p0.setPreferredSize(new Dimension(200, 30));
                    p0e1.setPreferredSize(new Dimension(20, 25));
                    p0e2.setPreferredSize(new Dimension(20, 25));
                    p1.setPreferredSize(new Dimension(100, 30));
                    p0e3.setPreferredSize(new Dimension(20, 25));
                    p0e4.setPreferredSize(new Dimension(20, 25));
                    p0e5.setPreferredSize(new Dimension(100, 25));
                    bManagerUpdate[i].setPreferredSize(new Dimension(100, 25));
                    bManagerDelete[i].setPreferredSize(new Dimension(100, 25));
                    bManagerRead[i].setPreferredSize(new Dimension(100, 25));
                    p0l.setPreferredSize(new Dimension(900, 1));

                    pManagementBox.add(p0l);
                    pManagementBox.add(p1);
                    pManagementBox.add(p0e1);
                    pManagementBox.add(p0);
                    pManagementBox.add(p0e2);
                    pManagementBox.add(bManagerUpdate[i]);
                    pManagementBox.add(p0e3);
                    pManagementBox.add(bManagerDelete[i]);
                    pManagementBox.add(p0e4);
                    pManagementBox.add(bManagerRead[i]);
                    pManagementBox.add(p0e5);
                }

                break;
            case 2:
                sData = q.getProductCategorySubcategory();
                bManagerUpdate = new JButton[sData.length];
                bManagerDelete = new JButton[sData.length];
                bManagerRead = new JButton[sData.length];

                for (int i = 0; i < sData.length; i++) {

                    d = d + 1;

                    JPanel p0 = new JPanel();
                    JPanel p0e1 = new JPanel();
                    JPanel p0e2 = new JPanel();
                    JPanel p0e3 = new JPanel();
                    JPanel p0e4 = new JPanel();
                    JPanel p0e5 = new JPanel();
                    JPanel p1 = new JPanel();
                    JPanel p0l = new JPanel();
                    JLabel l0 = new JLabel(sData[i][4]);
                    JLabel l1 = new JLabel("$ "+sData[i][5]);

                    bManagerUpdate[i] = new JButton("Update");
                    bManagerDelete[i] = new JButton("Delete");
                    bManagerRead[i] = new JButton("Read");

                    p0.add(l0);
                    p1.add(l1);
                    p0.setOpaque(false);
                    p1.setOpaque(false);
                    p0e1.setOpaque(false);
                    p0e2.setOpaque(false);
                    p0e3.setOpaque(false);
                    p0e4.setOpaque(false);
                    p0e5.setOpaque(false);
                    p0l.setBackground(new Color(64, 64, 64));

                    l0.setFont(new Font(Font.DIALOG,  Font.BOLD, 15));
                    l0.setForeground(new Color(64, 64, 64));

                    l1.setFont(new Font(Font.DIALOG,  Font.BOLD, 15));
                    l1.setForeground(new Color(64, 64, 64));

                    bManagerUpdate[i].setFont(new Font(Font.DIALOG,  Font.BOLD, 15));
                    bManagerUpdate[i].setBackground(new Color(203, 135, 0));
                    bManagerUpdate[i].setForeground(new Color(255, 248, 236));
                    bManagerUpdate[i].setBorderPainted(false);

                    bManagerDelete[i].setFont(new Font(Font.DIALOG,  Font.BOLD, 15));
                    bManagerDelete[i].setBackground(new Color(203, 0, 0));
                    bManagerDelete[i].setForeground(new Color(255, 248, 236));
                    bManagerDelete[i].setBorderPainted(false);

                    bManagerRead[i].setFont(new Font(Font.DIALOG,  Font.BOLD, 15));
                    bManagerRead[i].setBackground(new Color(0, 108, 203));
                    bManagerRead[i].setForeground(new Color(255, 248, 236));
                    bManagerRead[i].setBorderPainted(false);

                    bManagerUpdate[i].addActionListener(this);
                    bManagerDelete[i].addActionListener(this);
                    bManagerRead[i].addActionListener(this);

                    p0.setPreferredSize(new Dimension(200, 30));
                    p0e1.setPreferredSize(new Dimension(20, 25));
                    p0e2.setPreferredSize(new Dimension(20, 25));
                    p1.setPreferredSize(new Dimension(100, 30));
                    p0e3.setPreferredSize(new Dimension(20, 25));
                    p0e4.setPreferredSize(new Dimension(20, 25));
                    p0e5.setPreferredSize(new Dimension(100, 25));
                    bManagerUpdate[i].setPreferredSize(new Dimension(100, 25));
                    bManagerDelete[i].setPreferredSize(new Dimension(100, 25));
                    bManagerRead[i].setPreferredSize(new Dimension(100, 25));
                    p0l.setPreferredSize(new Dimension(900, 1));

                    pManagementBox.add(p0l);
                    pManagementBox.add(p0);
                    pManagementBox.add(p0e1);
                    pManagementBox.add(p1);
                    pManagementBox.add(p0e4);
                    pManagementBox.add(bManagerUpdate[i]);
                    pManagementBox.add(p0e2);
                    pManagementBox.add(bManagerDelete[i]);
                    pManagementBox.add(p0e3);
                    pManagementBox.add(bManagerRead[i]);
                    pManagementBox.add(p0e5);
                }

                break;
            case 3:
                sData = q.getSupplierAndAdres();
                bManagerUpdate = new JButton[sData.length];
                bManagerDelete = new JButton[sData.length];
                bManagerRead = new JButton[sData.length];

                for (int i = 0; i < sData.length; i++) {

                    d = d + 1;

                    JPanel p0 = new JPanel();
                    JPanel p0e1 = new JPanel();
                    JPanel p0e2 = new JPanel();
                    JPanel p0e3 = new JPanel();
                    JPanel p0e4 = new JPanel();
                    JPanel p0l = new JPanel();
                    JLabel l0 = new JLabel(sData[i][2]);

                    bManagerUpdate[i] = new JButton("Update");
                    bManagerDelete[i] = new JButton("Delete");
                    bManagerRead[i] = new JButton("Read");

                    p0.add(l0);
                    p0.setOpaque(false);
                    p0e1.setOpaque(false);
                    p0e2.setOpaque(false);
                    p0e3.setOpaque(false);
                    p0e4.setOpaque(false);
                    p0l.setBackground(new Color(64, 64, 64));

                    l0.setFont(new Font(Font.DIALOG,  Font.BOLD, 15));
                    l0.setForeground(new Color(64, 64, 64));

                    bManagerUpdate[i].setFont(new Font(Font.DIALOG,  Font.BOLD, 15));
                    bManagerUpdate[i].setBackground(new Color(203, 135, 0));
                    bManagerUpdate[i].setForeground(new Color(255, 248, 236));
                    bManagerUpdate[i].setBorderPainted(false);

                    bManagerDelete[i].setFont(new Font(Font.DIALOG,  Font.BOLD, 15));
                    bManagerDelete[i].setBackground(new Color(203, 0, 0));
                    bManagerDelete[i].setForeground(new Color(255, 248, 236));
                    bManagerDelete[i].setBorderPainted(false);

                    bManagerRead[i].setFont(new Font(Font.DIALOG,  Font.BOLD, 15));
                    bManagerRead[i].setBackground(new Color(0, 108, 203));
                    bManagerRead[i].setForeground(new Color(255, 248, 236));
                    bManagerRead[i].setBorderPainted(false);

                    bManagerUpdate[i].addActionListener(this);
                    bManagerDelete[i].addActionListener(this);
                    bManagerRead[i].addActionListener(this);

                    p0.setPreferredSize(new Dimension(200, 30));
                    p0e1.setPreferredSize(new Dimension(50, 25));
                    p0e2.setPreferredSize(new Dimension(20, 25));
                    p0e3.setPreferredSize(new Dimension(20, 25));
                    p0e4.setPreferredSize(new Dimension(200, 25));
                    bManagerUpdate[i].setPreferredSize(new Dimension(100, 25));
                    bManagerDelete[i].setPreferredSize(new Dimension(100, 25));
                    bManagerRead[i].setPreferredSize(new Dimension(100, 25));
                    p0l.setPreferredSize(new Dimension(900, 1));

                    pManagementBox.add(p0l);
                    pManagementBox.add(p0);
                    pManagementBox.add(p0e1);
                    pManagementBox.add(bManagerUpdate[i]);
                    pManagementBox.add(p0e2);
                    pManagementBox.add(bManagerDelete[i]);
                    pManagementBox.add(p0e3);
                    pManagementBox.add(bManagerRead[i]);
                    pManagementBox.add(p0e4);
                }


                break;
            case 4:

                sData = q.getPosition();
                bManagerUpdate = new JButton[sData.length];
                bManagerDelete = new JButton[sData.length];
                bManagerRead = new JButton[sData.length];

                for (int i = 0; i < sData.length; i++) {

                    d = d + 1;

                    JPanel p0 = new JPanel();
                    JPanel p0e1 = new JPanel();
                    JPanel p0e2 = new JPanel();
                    JPanel p0e3 = new JPanel();
                    JPanel p0e4 = new JPanel();
                    JPanel p0l = new JPanel();
                    JLabel l0 = new JLabel(sData[i][1]);

                    bManagerUpdate[i] = new JButton("Update");
                    bManagerDelete[i] = new JButton("Delete");
                    bManagerRead[i] = new JButton("Read");

                    p0.add(l0);
                    p0.setOpaque(false);
                    p0e1.setOpaque(false);
                    p0e2.setOpaque(false);
                    p0e3.setOpaque(false);
                    p0e4.setOpaque(false);
                    p0l.setBackground(new Color(64, 64, 64));

                    l0.setFont(new Font(Font.DIALOG,  Font.BOLD, 15));
                    l0.setForeground(new Color(64, 64, 64));

                    bManagerUpdate[i].setFont(new Font(Font.DIALOG,  Font.BOLD, 15));
                    bManagerUpdate[i].setBackground(new Color(203, 135, 0));
                    bManagerUpdate[i].setForeground(new Color(255, 248, 236));
                    bManagerUpdate[i].setBorderPainted(false);

                    bManagerDelete[i].setFont(new Font(Font.DIALOG,  Font.BOLD, 15));
                    bManagerDelete[i].setBackground(new Color(203, 0, 0));
                    bManagerDelete[i].setForeground(new Color(255, 248, 236));
                    bManagerDelete[i].setBorderPainted(false);

                    bManagerRead[i].setFont(new Font(Font.DIALOG,  Font.BOLD, 15));
                    bManagerRead[i].setBackground(new Color(0, 108, 203));
                    bManagerRead[i].setForeground(new Color(255, 248, 236));
                    bManagerRead[i].setBorderPainted(false);

                    bManagerUpdate[i].addActionListener(this);
                    bManagerDelete[i].addActionListener(this);
                    bManagerRead[i].addActionListener(this);

                    p0.setPreferredSize(new Dimension(200, 30));
                    p0e1.setPreferredSize(new Dimension(50, 25));
                    p0e2.setPreferredSize(new Dimension(20, 25));
                    p0e3.setPreferredSize(new Dimension(20, 25));
                    p0e4.setPreferredSize(new Dimension(300, 25));
                    bManagerUpdate[i].setPreferredSize(new Dimension(100, 25));
                    bManagerDelete[i].setPreferredSize(new Dimension(100, 25));
                    bManagerRead[i].setPreferredSize(new Dimension(100, 25));
                    p0l.setPreferredSize(new Dimension(900, 1));

                    pManagementBox.add(p0l);
                    pManagementBox.add(p0);
                    pManagementBox.add(p0e1);
                    pManagementBox.add(bManagerUpdate[i]);
                    pManagementBox.add(p0e2);
                    pManagementBox.add(bManagerDelete[i]);
                    pManagementBox.add(p0e3);
                    pManagementBox.add(bManagerRead[i]);
                    pManagementBox.add(p0e4);
                }
                break;
            case 5:

                sData = q.getCategory();
                bManagerUpdate = new JButton[sData.length];
                bManagerDelete = new JButton[sData.length];
                bManagerRead = new JButton[sData.length];

                for (int i = 0; i < sData.length; i++) {

                    d = d + 1;

                    JPanel p0 = new JPanel();
                    JPanel p0e1 = new JPanel();
                    JPanel p0e2 = new JPanel();
                    JPanel p0e3 = new JPanel();
                    JPanel p0e4 = new JPanel();
                    JPanel p0l = new JPanel();
                    JLabel l0 = new JLabel(sData[i][1]);

                    bManagerUpdate[i] = new JButton("Update");
                    bManagerDelete[i] = new JButton("Delete");
                    bManagerRead[i] = new JButton("Read");

                    p0.add(l0);
                    p0.setOpaque(false);
                    p0e1.setOpaque(false);
                    p0e2.setOpaque(false);
                    p0e3.setOpaque(false);
                    p0e4.setOpaque(false);
                    p0l.setBackground(new Color(64, 64, 64));

                    l0.setFont(new Font(Font.DIALOG,  Font.BOLD, 15));
                    l0.setForeground(new Color(64, 64, 64));

                    bManagerUpdate[i].setFont(new Font(Font.DIALOG,  Font.BOLD, 15));
                    bManagerUpdate[i].setBackground(new Color(203, 135, 0));
                    bManagerUpdate[i].setForeground(new Color(255, 248, 236));
                    bManagerUpdate[i].setBorderPainted(false);

                    bManagerDelete[i].setFont(new Font(Font.DIALOG,  Font.BOLD, 15));
                    bManagerDelete[i].setBackground(new Color(203, 0, 0));
                    bManagerDelete[i].setForeground(new Color(255, 248, 236));
                    bManagerDelete[i].setBorderPainted(false);

                    bManagerRead[i].setFont(new Font(Font.DIALOG,  Font.BOLD, 15));
                    bManagerRead[i].setBackground(new Color(0, 108, 203));
                    bManagerRead[i].setForeground(new Color(255, 248, 236));
                    bManagerRead[i].setBorderPainted(false);

                    bManagerUpdate[i].addActionListener(this);
                    bManagerDelete[i].addActionListener(this);
                    bManagerRead[i].addActionListener(this);

                    p0.setPreferredSize(new Dimension(200, 30));
                    p0e1.setPreferredSize(new Dimension(50, 25));
                    p0e2.setPreferredSize(new Dimension(20, 25));
                    p0e3.setPreferredSize(new Dimension(20, 25));
                    p0e4.setPreferredSize(new Dimension(300, 25));
                    bManagerUpdate[i].setPreferredSize(new Dimension(100, 25));
                    bManagerDelete[i].setPreferredSize(new Dimension(100, 25));
                    bManagerRead[i].setPreferredSize(new Dimension(100, 25));
                    p0l.setPreferredSize(new Dimension(900, 1));

                    pManagementBox.add(p0l);
                    pManagementBox.add(p0);
                    pManagementBox.add(p0e1);
                    pManagementBox.add(bManagerUpdate[i]);
                    pManagementBox.add(p0e2);
                    pManagementBox.add(bManagerDelete[i]);
                    pManagementBox.add(p0e3);
                    pManagementBox.add(bManagerRead[i]);
                    pManagementBox.add(p0e4);
                }
                break;
            case 6:

                sData = q.getSubcategory();
                bManagerUpdate = new JButton[sData.length];
                bManagerDelete = new JButton[sData.length];
                bManagerRead = new JButton[sData.length];

                for (int i = 0; i < sData.length; i++) {

                    d = d + 1;

                    JPanel p0 = new JPanel();
                    JPanel p0e1 = new JPanel();
                    JPanel p0e2 = new JPanel();
                    JPanel p0e3 = new JPanel();
                    JPanel p0e4 = new JPanel();
                    JPanel p0l = new JPanel();
                    JLabel l0 = new JLabel(sData[i][1]);

                    bManagerUpdate[i] = new JButton("Update");
                    bManagerDelete[i] = new JButton("Delete");
                    bManagerRead[i] = new JButton("Read");

                    p0.add(l0);
                    p0.setOpaque(false);
                    p0e1.setOpaque(false);
                    p0e2.setOpaque(false);
                    p0e3.setOpaque(false);
                    p0e4.setOpaque(false);
                    p0l.setBackground(new Color(64, 64, 64));

                    l0.setFont(new Font(Font.DIALOG,  Font.BOLD, 15));
                    l0.setForeground(new Color(64, 64, 64));

                    bManagerUpdate[i].setFont(new Font(Font.DIALOG,  Font.BOLD, 15));
                    bManagerUpdate[i].setBackground(new Color(203, 135, 0));
                    bManagerUpdate[i].setForeground(new Color(255, 248, 236));
                    bManagerUpdate[i].setBorderPainted(false);

                    bManagerDelete[i].setFont(new Font(Font.DIALOG,  Font.BOLD, 15));
                    bManagerDelete[i].setBackground(new Color(203, 0, 0));
                    bManagerDelete[i].setForeground(new Color(255, 248, 236));
                    bManagerDelete[i].setBorderPainted(false);

                    bManagerRead[i].setFont(new Font(Font.DIALOG,  Font.BOLD, 15));
                    bManagerRead[i].setBackground(new Color(0, 108, 203));
                    bManagerRead[i].setForeground(new Color(255, 248, 236));
                    bManagerRead[i].setBorderPainted(false);

                    bManagerUpdate[i].addActionListener(this);
                    bManagerDelete[i].addActionListener(this);
                    bManagerRead[i].addActionListener(this);

                    p0.setPreferredSize(new Dimension(200, 30));
                    p0e1.setPreferredSize(new Dimension(50, 25));
                    p0e2.setPreferredSize(new Dimension(20, 25));
                    p0e3.setPreferredSize(new Dimension(20, 25));
                    p0e4.setPreferredSize(new Dimension(300, 25));
                    bManagerUpdate[i].setPreferredSize(new Dimension(100, 25));
                    bManagerDelete[i].setPreferredSize(new Dimension(100, 25));
                    bManagerRead[i].setPreferredSize(new Dimension(100, 25));
                    p0l.setPreferredSize(new Dimension(900, 1));

                    pManagementBox.add(p0l);
                    pManagementBox.add(p0);
                    pManagementBox.add(p0e1);
                    pManagementBox.add(bManagerUpdate[i]);
                    pManagementBox.add(p0e2);
                    pManagementBox.add(bManagerDelete[i]);
                    pManagementBox.add(p0e3);
                    pManagementBox.add(bManagerRead[i]);
                    pManagementBox.add(p0e4);
                }
                break;
            case 7:

                sData = q.getPayment();
                bManagerUpdate = new JButton[sData.length];
                bManagerDelete = new JButton[sData.length];
                bManagerRead = new JButton[sData.length];

                for (int i = 0; i < sData.length; i++) {

                    d = d + 1;

                    JPanel p0 = new JPanel();
                    JPanel p0e1 = new JPanel();
                    JPanel p0e2 = new JPanel();
                    JPanel p0e3 = new JPanel();
                    JPanel p0e4 = new JPanel();
                    JPanel p0l = new JPanel();
                    JLabel l0 = new JLabel(sData[i][1]);

                    bManagerUpdate[i] = new JButton("Update");
                    bManagerDelete[i] = new JButton("Delete");
                    bManagerRead[i] = new JButton("Read");

                    p0.add(l0);
                    p0.setOpaque(false);
                    p0e1.setOpaque(false);
                    p0e2.setOpaque(false);
                    p0e3.setOpaque(false);
                    p0e4.setOpaque(false);
                    p0l.setBackground(new Color(64, 64, 64));

                    l0.setFont(new Font(Font.DIALOG,  Font.BOLD, 15));
                    l0.setForeground(new Color(64, 64, 64));

                    bManagerUpdate[i].setFont(new Font(Font.DIALOG,  Font.BOLD, 15));
                    bManagerUpdate[i].setBackground(new Color(203, 135, 0));
                    bManagerUpdate[i].setForeground(new Color(255, 248, 236));
                    bManagerUpdate[i].setBorderPainted(false);

                    bManagerDelete[i].setFont(new Font(Font.DIALOG,  Font.BOLD, 15));
                    bManagerDelete[i].setBackground(new Color(203, 0, 0));
                    bManagerDelete[i].setForeground(new Color(255, 248, 236));
                    bManagerDelete[i].setBorderPainted(false);

                    bManagerRead[i].setFont(new Font(Font.DIALOG,  Font.BOLD, 15));
                    bManagerRead[i].setBackground(new Color(0, 108, 203));
                    bManagerRead[i].setForeground(new Color(255, 248, 236));
                    bManagerRead[i].setBorderPainted(false);

                    bManagerUpdate[i].addActionListener(this);
                    bManagerDelete[i].addActionListener(this);
                    bManagerRead[i].addActionListener(this);

                    p0.setPreferredSize(new Dimension(200, 30));
                    p0e1.setPreferredSize(new Dimension(50, 25));
                    p0e2.setPreferredSize(new Dimension(20, 25));
                    p0e3.setPreferredSize(new Dimension(20, 25));
                    p0e4.setPreferredSize(new Dimension(300, 25));
                    bManagerUpdate[i].setPreferredSize(new Dimension(100, 25));
                    bManagerDelete[i].setPreferredSize(new Dimension(100, 25));
                    bManagerRead[i].setPreferredSize(new Dimension(100, 25));
                    p0l.setPreferredSize(new Dimension(900, 1));

                    pManagementBox.add(p0l);
                    pManagementBox.add(p0);
                    pManagementBox.add(p0e1);
                    pManagementBox.add(bManagerUpdate[i]);
                    pManagementBox.add(p0e2);
                    pManagementBox.add(bManagerDelete[i]);
                    pManagementBox.add(p0e3);
                    pManagementBox.add(bManagerRead[i]);
                    pManagementBox.add(p0e4);
                }
                break;
            case 8:

                sData = q.getPacking();
                bManagerUpdate = new JButton[sData.length];
                bManagerDelete = new JButton[sData.length];
                bManagerRead = new JButton[sData.length];

                for (int i = 0; i < sData.length; i++) {

                    d = d + 1;

                    JPanel p0 = new JPanel();
                    JPanel p0e1 = new JPanel();
                    JPanel p0e2 = new JPanel();
                    JPanel p0e3 = new JPanel();
                    JPanel p0e4 = new JPanel();
                    JPanel p0l = new JPanel();
                    JLabel l0 = new JLabel(sData[i][1]);

                    bManagerUpdate[i] = new JButton("Update");
                    bManagerDelete[i] = new JButton("Delete");
                    bManagerRead[i] = new JButton("Read");

                    p0.add(l0);
                    p0.setOpaque(false);
                    p0e1.setOpaque(false);
                    p0e2.setOpaque(false);
                    p0e3.setOpaque(false);
                    p0e4.setOpaque(false);
                    p0l.setBackground(new Color(64, 64, 64));

                    l0.setFont(new Font(Font.DIALOG,  Font.BOLD, 15));
                    l0.setForeground(new Color(64, 64, 64));

                    bManagerUpdate[i].setFont(new Font(Font.DIALOG,  Font.BOLD, 15));
                    bManagerUpdate[i].setBackground(new Color(203, 135, 0));
                    bManagerUpdate[i].setForeground(new Color(255, 248, 236));
                    bManagerUpdate[i].setBorderPainted(false);

                    bManagerDelete[i].setFont(new Font(Font.DIALOG,  Font.BOLD, 15));
                    bManagerDelete[i].setBackground(new Color(203, 0, 0));
                    bManagerDelete[i].setForeground(new Color(255, 248, 236));
                    bManagerDelete[i].setBorderPainted(false);

                    bManagerRead[i].setFont(new Font(Font.DIALOG,  Font.BOLD, 15));
                    bManagerRead[i].setBackground(new Color(0, 108, 203));
                    bManagerRead[i].setForeground(new Color(255, 248, 236));
                    bManagerRead[i].setBorderPainted(false);

                    bManagerUpdate[i].addActionListener(this);
                    bManagerDelete[i].addActionListener(this);
                    bManagerRead[i].addActionListener(this);

                    p0.setPreferredSize(new Dimension(200, 30));
                    p0e1.setPreferredSize(new Dimension(50, 25));
                    p0e2.setPreferredSize(new Dimension(20, 25));
                    p0e3.setPreferredSize(new Dimension(20, 25));
                    p0e4.setPreferredSize(new Dimension(300, 25));
                    bManagerUpdate[i].setPreferredSize(new Dimension(100, 25));
                    bManagerDelete[i].setPreferredSize(new Dimension(100, 25));
                    bManagerRead[i].setPreferredSize(new Dimension(100, 25));
                    p0l.setPreferredSize(new Dimension(900, 1));

                    pManagementBox.add(p0l);
                    pManagementBox.add(p0);
                    pManagementBox.add(p0e1);
                    pManagementBox.add(bManagerUpdate[i]);
                    pManagementBox.add(p0e2);
                    pManagementBox.add(bManagerDelete[i]);
                    pManagementBox.add(p0e3);
                    pManagementBox.add(bManagerRead[i]);
                    pManagementBox.add(p0e4);
                }
                break;
            default:
        }

        pManagementBox.setPreferredSize(new Dimension(900, 41*d));
        pManagementBox.setOpaque(false);
        spManagement.setOpaque(false);
        spManagement.getViewport().setOpaque(false);
        spManagement.setBorder(createEmptyBorder());
        spManagement.setBounds(0, 120, 986, 444);

        layere.add(spManagement, 1, 0);

    }

    private void updateCustomerAndAdres(int i) {

        update = true;

        stroreId = i;

        layere.remove(bgManager);
        layere.remove(spManagement);
        layere.remove(cbChooseDbo);
        layere.remove(bManagerAdd);
        layere.remove(bManagerBack);

        layere.revalidate();
        layere.repaint();

        bgManager.setLayout(null);

        layere.add(bgManager, 1, 0);
        bManagerAccept.setBounds(550, 500, 100, 25);
        bManagerCancel.setBounds(350, 500, 100, 25);
        layere.add(bManagerAccept, 2, 0);
        layere.add(bManagerCancel, 2, 0);

        tfData = new JTextField[6];

        JPanel pname = new JPanel();
        JPanel psurname = new JPanel();
        JPanel pstreet = new JPanel();
        JPanel phome = new JPanel();
        JPanel ppostalCode = new JPanel();
        JPanel pcity = new JPanel();

        JLabel lname = new JLabel("Name:");
        JLabel lsurname = new JLabel("Surname:");
        JLabel lstreet = new JLabel("Street:");
        JLabel lhome = new JLabel("Home nr:");
        JLabel lpostalCode = new JLabel("Postal code:");
        JLabel lcity = new JLabel("City: ");

        pname.setOpaque(false);
        psurname.setOpaque(false);
        pstreet.setOpaque(false);
        phome.setOpaque(false);
        ppostalCode.setOpaque(false);
        pcity.setOpaque(false);

        pname.add(lname);
        psurname.add(lsurname);
        pstreet.add(lstreet);
        phome.add(lhome);
        ppostalCode.add(lpostalCode);
        pcity.add(lcity);

        tfData[0] = new JTextField(sData[i][2]);
        tfData[1] = new JTextField(sData[i][3]);
        tfData[2] = new JTextField(sData[i][4]);
        tfData[3] = new JTextField(sData[i][5]);
        tfData[4] = new JTextField(sData[i][6]);
        tfData[5] = new JTextField(sData[i][7]);

        tfData[0].addKeyListener(this);
        tfData[1].addKeyListener(this);
        tfData[2].addKeyListener(this);
        tfData[3].addKeyListener(this);
        tfData[4].addKeyListener(this);
        tfData[5].addKeyListener(this);

        tfData[0].setBounds(300, 200, 100, 25);
        tfData[1].setBounds(300, 250, 100, 25);
        tfData[2].setBounds(700, 150, 100, 25);
        tfData[3].setBounds(700, 200, 100, 25);
        tfData[4].setBounds(700, 250, 100, 25);
        tfData[5].setBounds(700, 300, 100, 25);

        pname.setBounds(200, 200, 100, 25);
        psurname.setBounds(200, 250, 100, 25);
        pstreet.setBounds(600, 150, 100, 25);
        phome.setBounds(600, 200, 100, 25);
        ppostalCode.setBounds(600, 250, 100, 25);
        pcity.setBounds(600, 300, 100, 25);

        bgManager.add(pname, 2, 0);
        bgManager.add(psurname, 2, 0);
        bgManager.add(pstreet, 2, 0);
        bgManager.add(phome, 2, 0);
        bgManager.add(ppostalCode, 2, 0);
        bgManager.add(pcity, 2, 0);
        bgManager.add(pname, 2, 0);

        bgManager.add(tfData[0], 2, 0);
        bgManager.add(tfData[1], 2, 0);
        bgManager.add(tfData[2], 2, 0);
        bgManager.add(tfData[3], 2, 0);
        bgManager.add(tfData[4], 2, 0);
        bgManager.add(tfData[5], 2, 0);
    }

    private void newCustomerAndAdres() {

        update = false;

        layere.remove(bgManager);
        layere.remove(spManagement);
        layere.remove(cbChooseDbo);
        layere.remove(bManagerAdd);
        layere.remove(bManagerBack);

        layere.revalidate();
        layere.repaint();

        bgManager.setLayout(null);

        layere.add(bgManager, 1, 0);
        bManagerAccept.setBounds(550, 500, 100, 25);
        bManagerCancel.setBounds(350, 500, 100, 25);
        layere.add(bManagerAccept, 2, 0);
        layere.add(bManagerCancel, 2, 0);

        tfData = new JTextField[6];

        JPanel pname = new JPanel();
        JPanel psurname = new JPanel();
        JPanel pstreet = new JPanel();
        JPanel phome = new JPanel();
        JPanel ppostalCode = new JPanel();
        JPanel pcity = new JPanel();

        JLabel lname = new JLabel("Name:");
        JLabel lsurname = new JLabel("Surname:");
        JLabel lstreet = new JLabel("Street:");
        JLabel lhome = new JLabel("Home nr:");
        JLabel lpostalCode = new JLabel("Postal code:");
        JLabel lcity = new JLabel("City: ");

        pname.setOpaque(false);
        psurname.setOpaque(false);
        pstreet.setOpaque(false);
        phome.setOpaque(false);
        ppostalCode.setOpaque(false);
        pcity.setOpaque(false);

        pname.add(lname);
        psurname.add(lsurname);
        pstreet.add(lstreet);
        phome.add(lhome);
        ppostalCode.add(lpostalCode);
        pcity.add(lcity);

        tfData[0] = new JTextField();
        tfData[1] = new JTextField();
        tfData[2] = new JTextField();
        tfData[3] = new JTextField();
        tfData[4] = new JTextField();
        tfData[5] = new JTextField();

        tfData[0].addKeyListener(this);
        tfData[1].addKeyListener(this);
        tfData[2].addKeyListener(this);
        tfData[3].addKeyListener(this);
        tfData[4].addKeyListener(this);
        tfData[5].addKeyListener(this);

        tfData[0].setBounds(300, 200, 100, 25);
        tfData[1].setBounds(300, 250, 100, 25);
        tfData[2].setBounds(700, 150, 100, 25);
        tfData[3].setBounds(700, 200, 100, 25);
        tfData[4].setBounds(700, 250, 100, 25);
        tfData[5].setBounds(700, 300, 100, 25);

        pname.setBounds(200, 200, 100, 25);
        psurname.setBounds(200, 250, 100, 25);
        pstreet.setBounds(600, 150, 100, 25);
        phome.setBounds(600, 200, 100, 25);
        ppostalCode.setBounds(600, 250, 100, 25);
        pcity.setBounds(600, 300, 100, 25);

        bgManager.add(pname, 2, 0);
        bgManager.add(psurname, 2, 0);
        bgManager.add(pstreet, 2, 0);
        bgManager.add(phome, 2, 0);
        bgManager.add(ppostalCode, 2, 0);
        bgManager.add(pcity, 2, 0);
        bgManager.add(pname, 2, 0);

        bgManager.add(tfData[0], 2, 0);
        bgManager.add(tfData[1], 2, 0);
        bgManager.add(tfData[2], 2, 0);
        bgManager.add(tfData[3], 2, 0);
        bgManager.add(tfData[4], 2, 0);
        bgManager.add(tfData[5], 2, 0);
    }

    private void readCustomerAndAdres(int i) {

        JFrame frame = new JFrame();
        frame.setSize(550, 300);

        JPanel p = new JPanel();

        JPanel p1 = new JPanel();
        JPanel p2 = new JPanel();
        JPanel p3 = new JPanel();
        JPanel p4 = new JPanel();
        JPanel p5 = new JPanel();
        JPanel p6 = new JPanel();
        JPanel p7 = new JPanel();
        JPanel p8 = new JPanel();
        JPanel p9 = new JPanel();
        JPanel p10 = new JPanel();
        JPanel p11 = new JPanel();
        JPanel p12 = new JPanel();

        JLabel l1 = new JLabel("Name:");
        JLabel l2 = new JLabel(sData[i][2]);
        JLabel l3 = new JLabel("Surname:");
        JLabel l4 = new JLabel(sData[i][3]);
        JLabel l5 = new JLabel("Street:");
        JLabel l6 = new JLabel(sData[i][4]);
        JLabel l7 = new JLabel("Home number:");
        JLabel l8 = new JLabel(sData[i][5]);
        JLabel l9 = new JLabel("Postal Code:");
        JLabel l10 = new JLabel(sData[i][6]);
        JLabel l11 = new JLabel("City:");
        JLabel l12 = new JLabel(sData[i][7]);

        p.setLayout(null);
        p.setBackground(Color.white);
        p.setPreferredSize(new Dimension(550, 300));

        p1.setOpaque(false);
        p2.setOpaque(false);
        p3.setOpaque(false);
        p4.setOpaque(false);
        p5.setOpaque(false);
        p6.setOpaque(false);
        p7.setOpaque(false);
        p8.setOpaque(false);
        p9.setOpaque(false);
        p10.setOpaque(false);
        p11.setOpaque(false);
        p12.setOpaque(false);

        p1.add(l1);
        p2.add(l2);
        p3.add(l3);
        p4.add(l4);
        p5.add(l5);
        p6.add(l6);
        p7.add(l7);
        p8.add(l8);
        p9.add(l9);
        p10.add(l10);
        p11.add(l11);
        p12.add(l12);

        p1.setBounds(150, 10, 120, 25);
        p2.setBounds(270, 10, 120, 25);
        p3.setBounds(150, 40, 120, 25);
        p4.setBounds(270, 40, 120, 25);
        p5.setBounds(150, 70, 120, 25);
        p6.setBounds(270, 70, 120, 25);
        p7.setBounds(150, 100, 120, 25);
        p8.setBounds(270, 100, 120, 25);
        p9.setBounds(150, 130, 120, 25);
        p10.setBounds(270, 130, 120, 25);
        p11.setBounds(150, 160, 120, 25);
        p12.setBounds(270, 160, 120, 25);

        p.add(p1);
        p.add(p2);
        p.add(p3);
        p.add(p4);
        p.add(p5);
        p.add(p6);
        p.add(p7);
        p.add(p8);
        p.add(p9);
        p.add(p10);
        p.add(p11);
        p.add(p12);

        frame.add(p);

        frame.setTitle("Customer read");
        frame.setLocationRelativeTo(null);
        frame.setResizable(false);
        frame.setVisible(true);
    }

    private void updateEmployeeAndAdres(int i) {

        cbManagamet.removeAllItems();

        for (String s : q.fillcbPosition()) {
            cbManagamet.addItem(s);
        }

        cbManagamet.setSelectedItem(sData[i][12]);

        update = true;

        stroreId = i;

        layere.remove(bgManager);
        layere.remove(spManagement);
        layere.remove(cbChooseDbo);
        layere.remove(bManagerAdd);
        layere.remove(bManagerBack);

        layere.revalidate();
        layere.repaint();

        bgManager.setLayout(null);

        layere.add(bgManager, 1, 0);
        bManagerAccept.setBounds(550, 500, 100, 25);
        bManagerCancel.setBounds(350, 500, 100, 25);
        layere.add(bManagerAccept, 2, 0);
        layere.add(bManagerCancel, 2, 0);

        tfData = new JTextField[9];

        JPanel pname = new JPanel();
        JPanel psurname = new JPanel();
        JPanel ppesel = new JPanel();
        JPanel pbirthDate = new JPanel();
        JPanel pphoneNumber = new JPanel();
        JPanel pstreet = new JPanel();
        JPanel phome = new JPanel();
        JPanel ppostalCode = new JPanel();
        JPanel pcity = new JPanel();
        JPanel pposition = new JPanel();

        JLabel lname = new JLabel("Name:");
        JLabel lsurname = new JLabel("Surname:");
        JLabel lpesel = new JLabel("Pesel:");
        JLabel lbirthDate = new JLabel("Birth date:");
        JLabel lphoneNumber = new JLabel("Phone number:");
        JLabel lstreet = new JLabel("Street:");
        JLabel lhome = new JLabel("Home nr:");
        JLabel lpostalCode = new JLabel("Postal code:");
        JLabel lcity = new JLabel("City: ");
        JLabel lposition = new JLabel(("Position:"));

        pname.setOpaque(false);
        psurname.setOpaque(false);
        ppesel.setOpaque(false);
        pbirthDate.setOpaque(false);
        pphoneNumber.setOpaque(false);
        pstreet.setOpaque(false);
        phome.setOpaque(false);
        ppostalCode.setOpaque(false);
        pcity.setOpaque(false);
        pposition.setOpaque(false);

        pname.add(lname);
        psurname.add(lsurname);
        ppesel.add(lpesel);
        pbirthDate.add(lbirthDate);
        pphoneNumber.add(lphoneNumber);
        pstreet.add(lstreet);
        phome.add(lhome);
        ppostalCode.add(lpostalCode);
        pcity.add(lcity);
        pposition.add(lposition);

        tfData[0] = new JTextField(sData[i][3]);
        tfData[1] = new JTextField(sData[i][4]);
        tfData[2] = new JTextField(sData[i][5]);
        tfData[3] = new JTextField(sData[i][6]);
        tfData[4] = new JTextField(sData[i][7]);
        tfData[5] = new JTextField(sData[i][8]);
        tfData[6] = new JTextField(sData[i][9]);
        tfData[7] = new JTextField(sData[i][10]);
        tfData[8] = new JTextField(sData[i][11]);

        tfData[0].addKeyListener(this);
        tfData[1].addKeyListener(this);
        tfData[2].addKeyListener(this);
        tfData[3].addKeyListener(this);
        tfData[4].addKeyListener(this);
        tfData[5].addKeyListener(this);
        tfData[6].addKeyListener(this);
        tfData[7].addKeyListener(this);
        tfData[8].addKeyListener(this);

        tfData[0].setBounds(300, 100, 100, 25);
        tfData[1].setBounds(300, 150, 100, 25);
        tfData[2].setBounds(300, 200, 100, 25);
        tfData[3].setBounds(300, 250, 100, 25);
        tfData[4].setBounds(300, 300, 100, 25);
        tfData[5].setBounds(700, 150, 100, 25);
        tfData[6].setBounds(700, 200, 100, 25);
        tfData[7].setBounds(700, 250, 100, 25);
        tfData[8].setBounds(700, 300, 100, 25);

        cbManagamet.setBounds(300, 350, 100, 25);

        pname.setBounds(200, 100, 100, 25);
        psurname.setBounds(200, 150, 100, 25);
        ppesel.setBounds(200, 200, 100, 25);
        pbirthDate.setBounds(200, 250, 100, 25);
        pphoneNumber.setBounds(200, 300, 100, 25);
        pposition.setBounds(200, 350, 100, 25);
        pstreet.setBounds(600, 150, 100, 25);
        phome.setBounds(600, 200, 100, 25);
        ppostalCode.setBounds(600, 250, 100, 25);
        pcity.setBounds(600, 300, 100, 25);

        bgManager.add(pname, 2, 0);
        bgManager.add(psurname, 2, 0);
        bgManager.add(ppesel, 2, 0);
        bgManager.add(pbirthDate, 2, 0);
        bgManager.add(pphoneNumber, 2, 0);
        bgManager.add(pposition, 2, 0);
        bgManager.add(pstreet, 2, 0);
        bgManager.add(phome, 2, 0);
        bgManager.add(ppostalCode, 2, 0);
        bgManager.add(pcity, 2, 0);
        bgManager.add(pname, 2, 0);

        bgManager.add(cbManagamet, 2, 0);

        bgManager.add(tfData[0], 2, 0);
        bgManager.add(tfData[1], 2, 0);
        bgManager.add(tfData[2], 2, 0);
        bgManager.add(tfData[3], 2, 0);
        bgManager.add(tfData[4], 2, 0);
        bgManager.add(tfData[5], 2, 0);
        bgManager.add(tfData[6], 2, 0);
        bgManager.add(tfData[7], 2, 0);
        bgManager.add(tfData[8], 2, 0);
    }

    private void newEmployeeAndAdres() {
        cbManagamet.removeAllItems();

        for (String s : q.fillcbPosition()) {
            cbManagamet.addItem(s);
        }

        update = false;

        layere.remove(bgManager);
        layere.remove(spManagement);
        layere.remove(cbChooseDbo);
        layere.remove(bManagerAdd);
        layere.remove(bManagerBack);

        layere.revalidate();
        layere.repaint();

        bgManager.setLayout(null);

        layere.add(bgManager, 1, 0);
        bManagerAccept.setBounds(550, 500, 100, 25);
        bManagerCancel.setBounds(350, 500, 100, 25);
        layere.add(bManagerAccept, 2, 0);
        layere.add(bManagerCancel, 2, 0);

        tfData = new JTextField[9];

        JPanel pname = new JPanel();
        JPanel psurname = new JPanel();
        JPanel ppesel = new JPanel();
        JPanel pbirthDate = new JPanel();
        JPanel pphoneNumber = new JPanel();
        JPanel pstreet = new JPanel();
        JPanel phome = new JPanel();
        JPanel ppostalCode = new JPanel();
        JPanel pcity = new JPanel();
        JPanel pposition = new JPanel();

        JLabel lname = new JLabel("Name:");
        JLabel lsurname = new JLabel("Surname:");
        JLabel lpesel = new JLabel("Pesel:");
        JLabel lbirthDate = new JLabel("Birth date:");
        JLabel lphoneNumber = new JLabel("Phone number:");
        JLabel lstreet = new JLabel("Street:");
        JLabel lhome = new JLabel("Home nr:");
        JLabel lpostalCode = new JLabel("Postal code:");
        JLabel lcity = new JLabel("City: ");
        JLabel lposition = new JLabel(("Position:"));

        pname.setOpaque(false);
        psurname.setOpaque(false);
        ppesel.setOpaque(false);
        pbirthDate.setOpaque(false);
        pphoneNumber.setOpaque(false);
        pstreet.setOpaque(false);
        phome.setOpaque(false);
        ppostalCode.setOpaque(false);
        pcity.setOpaque(false);
        pposition.setOpaque(false);

        pname.add(lname);
        psurname.add(lsurname);
        ppesel.add(lpesel);
        pbirthDate.add(lbirthDate);
        pphoneNumber.add(lphoneNumber);
        pstreet.add(lstreet);
        phome.add(lhome);
        ppostalCode.add(lpostalCode);
        pcity.add(lcity);
        pposition.add(lposition);

        tfData[0] = new JTextField();
        tfData[1] = new JTextField();
        tfData[2] = new JTextField();
        tfData[3] = new JTextField();
        tfData[4] = new JTextField();
        tfData[5] = new JTextField();
        tfData[6] = new JTextField();
        tfData[7] = new JTextField();
        tfData[8] = new JTextField();

        tfData[0].addKeyListener(this);
        tfData[1].addKeyListener(this);
        tfData[2].addKeyListener(this);
        tfData[3].addKeyListener(this);
        tfData[4].addKeyListener(this);
        tfData[5].addKeyListener(this);
        tfData[6].addKeyListener(this);
        tfData[7].addKeyListener(this);
        tfData[8].addKeyListener(this);

        tfData[0].setBounds(300, 100, 100, 25);
        tfData[1].setBounds(300, 150, 100, 25);
        tfData[2].setBounds(300, 200, 100, 25);
        tfData[3].setBounds(300, 250, 100, 25);
        tfData[4].setBounds(300, 300, 100, 25);
        tfData[5].setBounds(700, 150, 100, 25);
        tfData[6].setBounds(700, 200, 100, 25);
        tfData[7].setBounds(700, 250, 100, 25);
        tfData[8].setBounds(700, 300, 100, 25);

        cbManagamet.setBounds(300, 350, 100, 25);

        pname.setBounds(200, 100, 100, 25);
        psurname.setBounds(200, 150, 100, 25);
        ppesel.setBounds(200, 200, 100, 25);
        pbirthDate.setBounds(200, 250, 100, 25);
        pphoneNumber.setBounds(200, 300, 100, 25);
        pposition.setBounds(200, 350, 100, 25);
        pstreet.setBounds(600, 150, 100, 25);
        phome.setBounds(600, 200, 100, 25);
        ppostalCode.setBounds(600, 250, 100, 25);
        pcity.setBounds(600, 300, 100, 25);

        bgManager.add(pname, 2, 0);
        bgManager.add(psurname, 2, 0);
        bgManager.add(ppesel, 2, 0);
        bgManager.add(pbirthDate, 2, 0);
        bgManager.add(pphoneNumber, 2, 0);
        bgManager.add(pposition, 2, 0);
        bgManager.add(pstreet, 2, 0);
        bgManager.add(phome, 2, 0);
        bgManager.add(ppostalCode, 2, 0);
        bgManager.add(pcity, 2, 0);
        bgManager.add(pname, 2, 0);

        bgManager.add(cbManagamet, 2, 0);

        bgManager.add(tfData[0], 2, 0);
        bgManager.add(tfData[1], 2, 0);
        bgManager.add(tfData[2], 2, 0);
        bgManager.add(tfData[3], 2, 0);
        bgManager.add(tfData[4], 2, 0);
        bgManager.add(tfData[5], 2, 0);
        bgManager.add(tfData[6], 2, 0);
        bgManager.add(tfData[7], 2, 0);
        bgManager.add(tfData[8], 2, 0);
    }

    private void readEmployeeAndAdres(int i) {

        JFrame frame = new JFrame();
        frame.setSize(550, 350);

        JPanel p = new JPanel();

        JPanel p1 = new JPanel();
        JPanel p2 = new JPanel();
        JPanel p3 = new JPanel();
        JPanel p4 = new JPanel();
        JPanel p5 = new JPanel();
        JPanel p6 = new JPanel();
        JPanel p7 = new JPanel();
        JPanel p8 = new JPanel();
        JPanel p9 = new JPanel();
        JPanel p10 = new JPanel();
        JPanel p11 = new JPanel();
        JPanel p12 = new JPanel();
        JPanel p13 = new JPanel();
        JPanel p14 = new JPanel();
        JPanel p15 = new JPanel();
        JPanel p16 = new JPanel();
        JPanel p17 = new JPanel();
        JPanel p18 = new JPanel();
        JPanel p19 = new JPanel();
        JPanel p20 = new JPanel();

        JLabel l1 = new JLabel("Name:");
        JLabel l2 = new JLabel(sData[i][3]);
        JLabel l3 = new JLabel("Surname:");
        JLabel l4 = new JLabel(sData[i][4]);
        JLabel l5 = new JLabel("Pesel:");
        JLabel l6 = new JLabel(sData[i][5]);
        JLabel l7 = new JLabel("Birth date:");
        JLabel l8 = new JLabel(sData[i][6]);
        JLabel l9 = new JLabel("Phone number:");
        JLabel l10 = new JLabel(sData[i][7]);
        JLabel l11 = new JLabel("Street:");
        JLabel l12 = new JLabel(sData[i][8]);
        JLabel l13 = new JLabel("Home number:");
        JLabel l14 = new JLabel(sData[i][9]);
        JLabel l15 = new JLabel("Postal code:");
        JLabel l16 = new JLabel(sData[i][10]);
        JLabel l17 = new JLabel("City:");
        JLabel l18 = new JLabel(sData[i][11]);
        JLabel l19 = new JLabel("Position:");
        JLabel l20 = new JLabel(sData[i][12]);

        p.setLayout(null);
        p.setBackground(Color.white);
        p.setPreferredSize(new Dimension(550, 350));

        p1.setOpaque(false);
        p2.setOpaque(false);
        p3.setOpaque(false);
        p4.setOpaque(false);
        p5.setOpaque(false);
        p6.setOpaque(false);
        p7.setOpaque(false);
        p8.setOpaque(false);
        p9.setOpaque(false);
        p10.setOpaque(false);
        p11.setOpaque(false);
        p12.setOpaque(false);
        p13.setOpaque(false);
        p14.setOpaque(false);
        p15.setOpaque(false);
        p16.setOpaque(false);
        p17.setOpaque(false);
        p18.setOpaque(false);
        p19.setOpaque(false);
        p20.setOpaque(false);

        p1.add(l1);
        p2.add(l2);
        p3.add(l3);
        p4.add(l4);
        p5.add(l5);
        p6.add(l6);
        p7.add(l7);
        p8.add(l8);
        p9.add(l9);
        p10.add(l10);
        p11.add(l11);
        p12.add(l12);
        p13.add(l13);
        p14.add(l14);
        p15.add(l15);
        p16.add(l16);
        p17.add(l17);
        p18.add(l18);
        p19.add(l19);
        p20.add(l20);

        p1.setBounds(150, 10, 120, 25);
        p2.setBounds(270, 10, 120, 25);
        p3.setBounds(150, 40, 120, 25);
        p4.setBounds(270, 40, 120, 25);
        p5.setBounds(150, 70, 120, 25);
        p6.setBounds(270, 70, 120, 25);
        p7.setBounds(150, 100, 120, 25);
        p8.setBounds(270, 100, 120, 25);
        p9.setBounds(150, 130, 120, 25);
        p10.setBounds(270, 130, 120, 25);
        p11.setBounds(150, 160, 120, 25);
        p12.setBounds(270, 160, 120, 25);
        p13.setBounds(150, 190, 120, 25);
        p14.setBounds(270, 190, 120, 25);
        p15.setBounds(150, 220, 120, 25);
        p16.setBounds(270, 220, 120, 25);
        p17.setBounds(150, 250, 120, 25);
        p18.setBounds(270, 250, 120, 25);
        p19.setBounds(150, 280, 120, 25);
        p20.setBounds(270, 280, 120, 25);

        p.add(p1);
        p.add(p2);
        p.add(p3);
        p.add(p4);
        p.add(p5);
        p.add(p6);
        p.add(p7);
        p.add(p8);
        p.add(p9);
        p.add(p10);
        p.add(p11);
        p.add(p12);
        p.add(p13);
        p.add(p14);
        p.add(p15);
        p.add(p16);
        p.add(p17);
        p.add(p18);
        p.add(p19);
        p.add(p20);

        frame.add(p);

        frame.setTitle("Employee read");
        frame.setLocationRelativeTo(null);
        frame.setResizable(false);
        frame.setVisible(true);
    }

    private void updateProductCategory(int i) {

        cbManagamet.removeAllItems();
        cbManagamet1.removeAllItems();
        cbManagamet2.removeAllItems();

        cbManagamet1.addItem("none");
        cbManagamet2.addItem("none");

        storeBakerId = q.getConfectionersIds();

        for (String s : q.fillcbCategory()) {
            cbManagamet.addItem(s);
        }

        for (String s : q.fillcbConfectioner()) {
            cbManagamet1.addItem(s);
        }

        for (String s : q.fillcbSupplier()) {
            cbManagamet2.addItem(s);
        }

        cbManagamet.setSelectedItem(sData[i][11]);

        if (sData[i][8] == null) {
            cbManagamet1.setSelectedIndex(0);
        } else {
            cbManagamet1.setSelectedItem(sData[i][8]+" "+sData[i][9]);
        }

        if (sData[i][10] == null) {
            cbManagamet2.setSelectedIndex(0);
        } else {
            cbManagamet2.setSelectedItem(sData[i][10]);
        }

        update = true;

        stroreId = i;

        layere.remove(bgManager);
        layere.remove(spManagement);
        layere.remove(cbChooseDbo);
        layere.remove(bManagerAdd);
        layere.remove(bManagerBack);

        layere.revalidate();
        layere.repaint();

        bgManager.setLayout(null);

        layere.add(bgManager, 1, 0);
        bManagerAccept.setBounds(550, 500, 100, 25);
        bManagerCancel.setBounds(350, 500, 100, 25);
        layere.add(bManagerAccept, 2, 0);
        layere.add(bManagerCancel, 2, 0);

        tfData = new JTextField[4];

        JPanel p1 = new JPanel();
        JPanel p2 = new JPanel();
        JPanel p3 = new JPanel();
        JPanel p4 = new JPanel();
        JPanel p5 = new JPanel();
        JPanel p6 = new JPanel();
        JPanel p7 = new JPanel();

        JLabel l1 = new JLabel("Name:");
        JLabel l2 = new JLabel("Price:");
        JLabel l3 = new JLabel("Description:");
        JLabel l4 = new JLabel("Composition");
        JLabel l5 = new JLabel("Category:");
        JLabel l6 = new JLabel("Confectioner:");
        JLabel l7 = new JLabel("Supplier:");

        p1.setOpaque(false);
        p2.setOpaque(false);
        p3.setOpaque(false);
        p4.setOpaque(false);
        p5.setOpaque(false);
        p6.setOpaque(false);
        p7.setOpaque(false);

        p1.add(l1);
        p2.add(l2);
        p3.add(l3);
        p4.add(l4);
        p5.add(l5);
        p6.add(l6);
        p7.add(l7);

        tfData[0] = new JTextField(sData[i][4]);
        tfData[1] = new JTextField(sData[i][5]);
        tfData[2] = new JTextField(sData[i][6]);
        tfData[3] = new JTextField(sData[i][7]);

        tfData[0].addKeyListener(this);
        tfData[1].addKeyListener(this);
        tfData[2].addKeyListener(this);
        tfData[3].addKeyListener(this);

        tfData[0].setBounds(300, 150, 200, 25);
        tfData[1].setBounds(300, 200, 100, 25);
        tfData[2].setBounds(200, 290, 700, 50);
        tfData[3].setBounds(200, 390, 700, 50);

        cbManagamet.setBounds(700, 100, 150, 25);
        cbManagamet1.setBounds(700, 150, 150, 25);
        cbManagamet2.setBounds(700, 200, 150, 25);

        p1.setBounds(200, 150, 100, 25);
        p2.setBounds(200, 200, 100, 25);
        p3.setBounds(200, 250, 100, 25);
        p4.setBounds(200, 350, 100, 25);
        p5.setBounds(600, 100, 100, 25);
        p6.setBounds(600, 150, 100, 25);
        p7.setBounds(600, 200, 100, 25);

        bgManager.add(p1, 2, 0);
        bgManager.add(p2, 2, 0);
        bgManager.add(p3, 2, 0);
        bgManager.add(p4, 2, 0);
        bgManager.add(p5, 2, 0);
        bgManager.add(p6, 2, 0);
        bgManager.add(p7, 2, 0);

        bgManager.add(cbManagamet, 2, 0);
        bgManager.add(cbManagamet1, 2, 0);
        bgManager.add(cbManagamet2, 2, 0);

        bgManager.add(tfData[0], 2, 0);
        bgManager.add(tfData[1], 2, 0);
        bgManager.add(tfData[2], 2, 0);
        bgManager.add(tfData[3], 2, 0);
    }

    private void newProductCategory() {

        cbManagamet.removeAllItems();
        cbManagamet1.removeAllItems();
        cbManagamet2.removeAllItems();

        cbManagamet1.addItem("none");
        cbManagamet2.addItem("none");

        storeBakerId = q.getConfectionersIds();

        for (String s : q.fillcbCategory()) {
            cbManagamet.addItem(s);
        }

        for (String s : q.fillcbConfectioner()) {
            cbManagamet1.addItem(s);
        }

        for (String s : q.fillcbSupplier()) {
            cbManagamet2.addItem(s);
        }

        update = false;

        layere.remove(bgManager);
        layere.remove(spManagement);
        layere.remove(cbChooseDbo);
        layere.remove(bManagerAdd);
        layere.remove(bManagerBack);

        layere.revalidate();
        layere.repaint();

        bgManager.setLayout(null);

        layere.add(bgManager, 1, 0);
        bManagerAccept.setBounds(550, 500, 100, 25);
        bManagerCancel.setBounds(350, 500, 100, 25);
        layere.add(bManagerAccept, 2, 0);
        layere.add(bManagerCancel, 2, 0);

        tfData = new JTextField[4];

        JPanel p1 = new JPanel();
        JPanel p2 = new JPanel();
        JPanel p3 = new JPanel();
        JPanel p4 = new JPanel();
        JPanel p5 = new JPanel();
        JPanel p6 = new JPanel();
        JPanel p7 = new JPanel();

        JLabel l1 = new JLabel("Name:");
        JLabel l2 = new JLabel("Price:");
        JLabel l3 = new JLabel("Description:");
        JLabel l4 = new JLabel("Composition");
        JLabel l5 = new JLabel("Category:");
        JLabel l6 = new JLabel("Confectioner:");
        JLabel l7 = new JLabel("Supplier:");

        p1.setOpaque(false);
        p2.setOpaque(false);
        p3.setOpaque(false);
        p4.setOpaque(false);
        p5.setOpaque(false);
        p6.setOpaque(false);
        p7.setOpaque(false);

        p1.add(l1);
        p2.add(l2);
        p3.add(l3);
        p4.add(l4);
        p5.add(l5);
        p6.add(l6);
        p7.add(l7);

        tfData[0] = new JTextField();
        tfData[1] = new JTextField();
        tfData[2] = new JTextField();
        tfData[3] = new JTextField();

        tfData[0].addKeyListener(this);
        tfData[1].addKeyListener(this);
        tfData[2].addKeyListener(this);
        tfData[3].addKeyListener(this);

        tfData[0].setBounds(300, 150, 200, 25);
        tfData[1].setBounds(300, 200, 100, 25);
        tfData[2].setBounds(200, 290, 700, 50);
        tfData[3].setBounds(200, 390, 700, 50);

        cbManagamet.setBounds(700, 100, 150, 25);
        cbManagamet1.setBounds(700, 150, 150, 25);
        cbManagamet2.setBounds(700, 200, 150, 25);

        p1.setBounds(200, 150, 100, 25);
        p2.setBounds(200, 200, 100, 25);
        p3.setBounds(200, 250, 100, 25);
        p4.setBounds(200, 350, 100, 25);
        p5.setBounds(600, 100, 100, 25);
        p6.setBounds(600, 150, 100, 25);
        p7.setBounds(600, 200, 100, 25);

        bgManager.add(p1, 2, 0);
        bgManager.add(p2, 2, 0);
        bgManager.add(p3, 2, 0);
        bgManager.add(p4, 2, 0);
        bgManager.add(p5, 2, 0);
        bgManager.add(p6, 2, 0);
        bgManager.add(p7, 2, 0);

        bgManager.add(cbManagamet, 2, 0);
        bgManager.add(cbManagamet1, 2, 0);
        bgManager.add(cbManagamet2, 2, 0);

        bgManager.add(tfData[0], 2, 0);
        bgManager.add(tfData[1], 2, 0);
        bgManager.add(tfData[2], 2, 0);
        bgManager.add(tfData[3], 2, 0);
    }

    private void readProductCategory(int i) {
        JFrame frame = new JFrame();
        frame.setSize(550, 350);

        JPanel p = new JPanel();

        JPanel p1 = new JPanel();
        JPanel p2 = new JPanel();
        JPanel p3 = new JPanel();
        JPanel p4 = new JPanel();
        JPanel p5 = new JPanel();
        JPanel p6 = new JPanel();
        JPanel p7 = new JPanel();
        JPanel p8 = new JPanel();
        JPanel p9 = new JPanel();
        JPanel p10 = new JPanel();
        JPanel p11 = new JPanel();
        JPanel p12 = new JPanel();
        JPanel p13 = new JPanel();
        JPanel p14 = new JPanel();

        JLabel l1 = new JLabel("Product name:");
        JLabel l2 = new JLabel(sData[i][4]);
        JLabel l3 = new JLabel("Price:");
        JLabel l4 = new JLabel("$ "+sData[i][5]);
        JLabel l5 = new JLabel("Description:");
        JLabel l6 = new JLabel(sData[i][6]);
        JLabel l7 = new JLabel("Composition:");
        JLabel l8 = new JLabel(sData[i][7]);
        JLabel l9 = new JLabel("Creator:");
        JLabel l10 = new JLabel();
        if (sData[i][8] != null) {
            l10.setText(sData[i][8]+" "+sData[i][9]);
        } else {
            l10.setText("supplier");
        }
        JLabel l11 = new JLabel("Supplier:");
        JLabel l12 = new JLabel();
        if (sData[i][10] != null) {
            l12.setText(sData[i][10]);
        } else {
            l12.setText("us");
        }
        JLabel l13 = new JLabel("Category:");
        JLabel l14 = new JLabel(sData[i][11]);

        p.setLayout(null);
        p.setBackground(Color.white);
        p.setPreferredSize(new Dimension(550, 350));

        p1.setOpaque(false);
        p2.setOpaque(false);
        p3.setOpaque(false);
        p4.setOpaque(false);
        p5.setOpaque(false);
        p6.setOpaque(false);
        p7.setOpaque(false);
        p8.setOpaque(false);
        p9.setOpaque(false);
        p10.setOpaque(false);
        p11.setOpaque(false);
        p12.setOpaque(false);
        p13.setOpaque(false);
        p14.setOpaque(false);

        p1.add(l1);
        p2.add(l2);
        p3.add(l3);
        p4.add(l4);
        p5.add(l5);
        p6.add(l6);
        p7.add(l7);
        p8.add(l8);
        p9.add(l9);
        p10.add(l10);
        p11.add(l11);
        p12.add(l12);
        p13.add(l13);
        p14.add(l14);

        p1.setBounds(150, 10, 120, 25);
        p2.setBounds(270, 10, 120, 25);
        p3.setBounds(150, 40, 120, 25);
        p4.setBounds(270, 40, 120, 25);
        p5.setBounds(150, 70, 120, 25);
        p6.setBounds(100, 100, 400, 25);
        p7.setBounds(150, 130, 120, 25);
        p8.setBounds(100, 160, 400, 25);
        p9.setBounds(150, 190, 120, 25);
        p10.setBounds(270, 190, 120, 25);
        p11.setBounds(150, 220, 120, 25);
        p12.setBounds(270, 220, 120, 25);
        p13.setBounds(150, 250, 120, 25);
        p14.setBounds(270, 250, 120, 25);

        p.add(p1);
        p.add(p2);
        p.add(p3);
        p.add(p4);
        p.add(p5);
        p.add(p6);
        p.add(p7);
        p.add(p8);
        p.add(p9);
        p.add(p10);
        p.add(p11);
        p.add(p12);
        p.add(p13);
        p.add(p14);

        frame.add(p);

        frame.setTitle("Product read");
        frame.setLocationRelativeTo(null);
        frame.setResizable(false);
        frame.setVisible(true);
    }

    private void updateSupplierAdres(int i) {

        update = true;

        stroreId = i;

        layere.remove(bgManager);
        layere.remove(spManagement);
        layere.remove(cbChooseDbo);
        layere.remove(bManagerAdd);
        layere.remove(bManagerBack);

        layere.revalidate();
        layere.repaint();

        bgManager.setLayout(null);

        layere.add(bgManager, 1, 0);
        bManagerAccept.setBounds(550, 500, 100, 25);
        bManagerCancel.setBounds(350, 500, 100, 25);
        layere.add(bManagerAccept, 2, 0);
        layere.add(bManagerCancel, 2, 0);

        tfData = new JTextField[7];

        JPanel pname = new JPanel();
        JPanel pphone = new JPanel();
        JPanel pemail = new JPanel();
        JPanel pstreet = new JPanel();
        JPanel phome = new JPanel();
        JPanel ppostalCode = new JPanel();
        JPanel pcity = new JPanel();

        JLabel lname = new JLabel("Name:");
        JLabel lphone = new JLabel("Phone number:");
        JLabel lemail = new JLabel("E-Mail:");
        JLabel lstreet = new JLabel("Street:");
        JLabel lhome = new JLabel("Home nr:");
        JLabel lpostalCode = new JLabel("Postal code:");
        JLabel lcity = new JLabel("City: ");

        pname.setOpaque(false);
        pphone.setOpaque(false);
        pemail.setOpaque(false);
        pstreet.setOpaque(false);
        phome.setOpaque(false);
        ppostalCode.setOpaque(false);
        pcity.setOpaque(false);

        pname.add(lname);
        pphone.add(lphone);
        pemail.add(lemail);
        pstreet.add(lstreet);
        phome.add(lhome);
        ppostalCode.add(lpostalCode);
        pcity.add(lcity);

        tfData[0] = new JTextField(sData[i][2]);
        tfData[1] = new JTextField(sData[i][3]);
        tfData[2] = new JTextField(sData[i][4]);
        tfData[3] = new JTextField(sData[i][5]);
        tfData[4] = new JTextField(sData[i][6]);
        tfData[5] = new JTextField(sData[i][7]);
        tfData[6] = new JTextField(sData[i][8]);

        tfData[0].addKeyListener(this);
        tfData[1].addKeyListener(this);
        tfData[2].addKeyListener(this);
        tfData[3].addKeyListener(this);
        tfData[4].addKeyListener(this);
        tfData[5].addKeyListener(this);
        tfData[6].addKeyListener(this);

        tfData[0].setBounds(300, 150, 100, 25);
        tfData[1].setBounds(300, 200, 100, 25);
        tfData[2].setBounds(300, 250, 150, 25);
        tfData[3].setBounds(700, 150, 100, 25);
        tfData[4].setBounds(700, 200, 100, 25);
        tfData[5].setBounds(700, 250, 100, 25);
        tfData[6].setBounds(700, 300, 100, 25);

        pname.setBounds(200, 150, 100, 25);
        pphone.setBounds(200, 200, 100, 25);
        pemail.setBounds(200, 250, 100, 25);
        pstreet.setBounds(600, 150, 100, 25);
        phome.setBounds(600, 200, 100, 25);
        ppostalCode.setBounds(600, 250, 100, 25);
        pcity.setBounds(600, 300, 100, 25);

        bgManager.add(pname, 2, 0);
        bgManager.add(pphone, 2, 0);
        bgManager.add(pemail, 2, 0);
        bgManager.add(pstreet, 2, 0);
        bgManager.add(phome, 2, 0);
        bgManager.add(ppostalCode, 2, 0);
        bgManager.add(pcity, 2, 0);
        bgManager.add(pname, 2, 0);

        bgManager.add(tfData[0], 2, 0);
        bgManager.add(tfData[1], 2, 0);
        bgManager.add(tfData[2], 2, 0);
        bgManager.add(tfData[3], 2, 0);
        bgManager.add(tfData[4], 2, 0);
        bgManager.add(tfData[5], 2, 0);
        bgManager.add(tfData[6], 2, 0);
    }

    private void newSupplierAdres() {

        update = false;

        layere.remove(bgManager);
        layere.remove(spManagement);
        layere.remove(cbChooseDbo);
        layere.remove(bManagerAdd);
        layere.remove(bManagerBack);

        layere.revalidate();
        layere.repaint();

        bgManager.setLayout(null);

        layere.add(bgManager, 1, 0);
        bManagerAccept.setBounds(550, 500, 100, 25);
        bManagerCancel.setBounds(350, 500, 100, 25);
        layere.add(bManagerAccept, 2, 0);
        layere.add(bManagerCancel, 2, 0);

        tfData = new JTextField[7];

        JPanel pname = new JPanel();
        JPanel pphone = new JPanel();
        JPanel pemail = new JPanel();
        JPanel pstreet = new JPanel();
        JPanel phome = new JPanel();
        JPanel ppostalCode = new JPanel();
        JPanel pcity = new JPanel();

        JLabel lname = new JLabel("Name:");
        JLabel lphone = new JLabel("Phone number:");
        JLabel lemail = new JLabel("E-Mail:");
        JLabel lstreet = new JLabel("Street:");
        JLabel lhome = new JLabel("Home nr:");
        JLabel lpostalCode = new JLabel("Postal code:");
        JLabel lcity = new JLabel("City: ");

        pname.setOpaque(false);
        pphone.setOpaque(false);
        pemail.setOpaque(false);
        pstreet.setOpaque(false);
        phome.setOpaque(false);
        ppostalCode.setOpaque(false);
        pcity.setOpaque(false);

        pname.add(lname);
        pphone.add(lphone);
        pemail.add(lemail);
        pstreet.add(lstreet);
        phome.add(lhome);
        ppostalCode.add(lpostalCode);
        pcity.add(lcity);

        tfData[0] = new JTextField();
        tfData[1] = new JTextField();
        tfData[2] = new JTextField();
        tfData[3] = new JTextField();
        tfData[4] = new JTextField();
        tfData[5] = new JTextField();
        tfData[6] = new JTextField();

        tfData[0].addKeyListener(this);
        tfData[1].addKeyListener(this);
        tfData[2].addKeyListener(this);
        tfData[3].addKeyListener(this);
        tfData[4].addKeyListener(this);
        tfData[5].addKeyListener(this);
        tfData[6].addKeyListener(this);

        tfData[0].setBounds(300, 150, 100, 25);
        tfData[1].setBounds(300, 200, 100, 25);
        tfData[2].setBounds(300, 250, 150, 25);
        tfData[3].setBounds(700, 150, 100, 25);
        tfData[4].setBounds(700, 200, 100, 25);
        tfData[5].setBounds(700, 250, 100, 25);
        tfData[6].setBounds(700, 300, 100, 25);

        pname.setBounds(200, 150, 100, 25);
        pphone.setBounds(200, 200, 100, 25);
        pemail.setBounds(200, 250, 100, 25);
        pstreet.setBounds(600, 150, 100, 25);
        phome.setBounds(600, 200, 100, 25);
        ppostalCode.setBounds(600, 250, 100, 25);
        pcity.setBounds(600, 300, 100, 25);

        bgManager.add(pname, 2, 0);
        bgManager.add(pphone, 2, 0);
        bgManager.add(pemail, 2, 0);
        bgManager.add(pstreet, 2, 0);
        bgManager.add(phome, 2, 0);
        bgManager.add(ppostalCode, 2, 0);
        bgManager.add(pcity, 2, 0);
        bgManager.add(pname, 2, 0);

        bgManager.add(tfData[0], 2, 0);
        bgManager.add(tfData[1], 2, 0);
        bgManager.add(tfData[2], 2, 0);
        bgManager.add(tfData[3], 2, 0);
        bgManager.add(tfData[4], 2, 0);
        bgManager.add(tfData[5], 2, 0);
        bgManager.add(tfData[6], 2, 0);
    }

    private void readSupplierAdres(int i) {

        JFrame frame = new JFrame();
        frame.setSize(550, 300);

        JPanel p = new JPanel();

        JPanel p1 = new JPanel();
        JPanel p2 = new JPanel();
        JPanel p3 = new JPanel();
        JPanel p4 = new JPanel();
        JPanel p5 = new JPanel();
        JPanel p6 = new JPanel();
        JPanel p7 = new JPanel();
        JPanel p8 = new JPanel();
        JPanel p9 = new JPanel();
        JPanel p10 = new JPanel();
        JPanel p11 = new JPanel();
        JPanel p12 = new JPanel();
        JPanel p13 = new JPanel();
        JPanel p14 = new JPanel();

        JLabel l1 = new JLabel("Company name:");
        JLabel l2 = new JLabel(sData[i][2]);
        JLabel l3 = new JLabel("Phone number:");
        JLabel l4 = new JLabel(sData[i][3]);
        JLabel l5 = new JLabel("E-Mail:");
        JLabel l6 = new JLabel(sData[i][4]);
        JLabel l7 = new JLabel("Street:");
        JLabel l8 = new JLabel(sData[i][5]);
        JLabel l9 = new JLabel("Home number:");
        JLabel l10 = new JLabel(sData[i][6]);
        JLabel l11 = new JLabel("Postal Code:");
        JLabel l12 = new JLabel(sData[i][7]);
        JLabel l13 = new JLabel("City:");
        JLabel l14 = new JLabel(sData[i][8]);

        p.setLayout(null);
        p.setBackground(Color.white);
        p.setPreferredSize(new Dimension(550, 300));

        p1.setOpaque(false);
        p2.setOpaque(false);
        p3.setOpaque(false);
        p4.setOpaque(false);
        p5.setOpaque(false);
        p6.setOpaque(false);
        p7.setOpaque(false);
        p8.setOpaque(false);
        p9.setOpaque(false);
        p10.setOpaque(false);
        p11.setOpaque(false);
        p12.setOpaque(false);
        p13.setOpaque(false);
        p14.setOpaque(false);

        p1.add(l1);
        p2.add(l2);
        p3.add(l3);
        p4.add(l4);
        p5.add(l5);
        p6.add(l6);
        p7.add(l7);
        p8.add(l8);
        p9.add(l9);
        p10.add(l10);
        p11.add(l11);
        p12.add(l12);
        p13.add(l13);
        p14.add(l14);

        p1.setBounds(150, 10, 120, 25);
        p2.setBounds(270, 10, 120, 25);
        p3.setBounds(150, 40, 120, 25);
        p4.setBounds(270, 40, 120, 25);
        p5.setBounds(150, 70, 120, 25);
        p6.setBounds(270, 70, 160, 25);
        p7.setBounds(150, 100, 120, 25);
        p8.setBounds(270, 100, 120, 25);
        p9.setBounds(150, 130, 120, 25);
        p10.setBounds(270, 130, 120, 25);
        p11.setBounds(150, 160, 120, 25);
        p12.setBounds(270, 160, 120, 25);
        p13.setBounds(150, 190, 120, 25);
        p14.setBounds(270, 190, 120, 25);

        p.add(p1);
        p.add(p2);
        p.add(p3);
        p.add(p4);
        p.add(p5);
        p.add(p6);
        p.add(p7);
        p.add(p8);
        p.add(p9);
        p.add(p10);
        p.add(p11);
        p.add(p12);
        p.add(p13);
        p.add(p14);

        frame.add(p);

        frame.setTitle("Supplier read");
        frame.setLocationRelativeTo(null);
        frame.setResizable(false);
        frame.setVisible(true);
    }

    private void updatePositions(int i) {

        update = true;

        stroreId = i;

        layere.remove(bgManager);
        layere.remove(spManagement);
        layere.remove(cbChooseDbo);
        layere.remove(bManagerAdd);
        layere.remove(bManagerBack);

        layere.revalidate();
        layere.repaint();

        bgManager.setLayout(null);

        layere.add(bgManager, 1, 0);
        bManagerAccept.setBounds(550, 500, 100, 25);
        bManagerCancel.setBounds(350, 500, 100, 25);
        layere.add(bManagerAccept, 2, 0);
        layere.add(bManagerCancel, 2, 0);

        tfData = new JTextField[2];

        JPanel pname = new JPanel();
        JPanel psalary = new JPanel();

        JLabel lname = new JLabel("Position:");
        JLabel lsalary = new JLabel("Salary:");

        pname.setOpaque(false);
        psalary.setOpaque(false);

        pname.add(lname);
        psalary.add(lsalary);

        tfData[0] = new JTextField(sData[i][1]);
        tfData[1] = new JTextField(sData[i][2]);

        tfData[0].addKeyListener(this);
        tfData[1].addKeyListener(this);

        tfData[0].setBounds(200, 250, 100, 25);
        tfData[1].setBounds(600, 250, 100, 25);

        pname.setBounds(200, 200, 100, 25);
        psalary.setBounds(600, 200, 100, 25);

        bgManager.add(pname, 2, 0);
        bgManager.add(psalary, 2, 0);

        bgManager.add(tfData[0], 2, 0);
        bgManager.add(tfData[1], 2, 0);
    }

    private void newPositions() {

        update = false;

        layere.remove(bgManager);
        layere.remove(spManagement);
        layere.remove(cbChooseDbo);
        layere.remove(bManagerAdd);
        layere.remove(bManagerBack);

        layere.revalidate();
        layere.repaint();

        bgManager.setLayout(null);

        layere.add(bgManager, 1, 0);
        bManagerAccept.setBounds(550, 500, 100, 25);
        bManagerCancel.setBounds(350, 500, 100, 25);
        layere.add(bManagerAccept, 2, 0);
        layere.add(bManagerCancel, 2, 0);

        tfData = new JTextField[2];

        JPanel pname = new JPanel();
        JPanel psalary = new JPanel();

        JLabel lname = new JLabel("Position:");
        JLabel lsalary = new JLabel("Salary:");

        pname.setOpaque(false);
        psalary.setOpaque(false);

        pname.add(lname);
        psalary.add(lsalary);

        tfData[0] = new JTextField();
        tfData[1] = new JTextField();

        tfData[0].addKeyListener(this);
        tfData[1].addKeyListener(this);

        tfData[0].setBounds(200, 250, 100, 25);
        tfData[1].setBounds(600, 250, 100, 25);

        pname.setBounds(200, 200, 100, 25);
        psalary.setBounds(600, 200, 100, 25);

        bgManager.add(pname, 2, 0);
        bgManager.add(psalary, 2, 0);

        bgManager.add(tfData[0], 2, 0);
        bgManager.add(tfData[1], 2, 0);
    }

    private void readPositions(int i) {

        JFrame frame = new JFrame();
        frame.setSize(550, 150);

        JPanel p = new JPanel();

        JPanel p1 = new JPanel();
        JPanel p2 = new JPanel();
        JPanel p3 = new JPanel();
        JPanel p4 = new JPanel();

        JLabel l1 = new JLabel("Position name:");
        JLabel l2 = new JLabel(sData[i][1]);
        JLabel l3 = new JLabel("Salary:");
        JLabel l4 = new JLabel("$ "+sData[i][2]);

        p.setLayout(null);
        p.setBackground(Color.white);
        p.setPreferredSize(new Dimension(550, 150));

        p1.setOpaque(false);
        p2.setOpaque(false);
        p3.setOpaque(false);
        p4.setOpaque(false);

        p1.add(l1);
        p2.add(l2);
        p3.add(l3);
        p4.add(l4);

        p1.setBounds(150, 10, 120, 25);
        p2.setBounds(270, 10, 120, 25);
        p3.setBounds(150, 40, 120, 25);
        p4.setBounds(270, 40, 120, 25);

        p.add(p1);
        p.add(p2);
        p.add(p3);
        p.add(p4);

        frame.add(p);

        frame.setTitle("Packing type read");
        frame.setLocationRelativeTo(null);
        frame.setResizable(false);
        frame.setVisible(true);

    }

    private void updateCategory(int i) {

        update = true;

        stroreId = i;

        layere.remove(bgManager);
        layere.remove(spManagement);
        layere.remove(cbChooseDbo);
        layere.remove(bManagerAdd);
        layere.remove(bManagerBack);

        layere.revalidate();
        layere.repaint();

        bgManager.setLayout(null);

        layere.add(bgManager, 1, 0);
        bManagerAccept.setBounds(550, 500, 100, 25);
        bManagerCancel.setBounds(350, 500, 100, 25);
        layere.add(bManagerAccept, 2, 0);
        layere.add(bManagerCancel, 2, 0);

        tfData = new JTextField[1];

        JPanel p1 = new JPanel();
        JPanel p2 = new JPanel();

        JLabel l1 = new JLabel("Category Name:");

        p1.setOpaque(false);
        p2.setOpaque(false);

        p1.add(l1);

        tfData[0] = new JTextField(sData[i][1]);

        tfData[0].addKeyListener(this);

        tfData[0].setBounds(400, 250, 200, 25);
        p1.setBounds(400, 200, 100, 25);

        bgManager.add(p1, 2, 0);
        bgManager.add(tfData[0], 2, 0);

    }

    private void newCategory() {

        update = false;

        layere.remove(bgManager);
        layere.remove(spManagement);
        layere.remove(cbChooseDbo);
        layere.remove(bManagerAdd);
        layere.remove(bManagerBack);

        layere.revalidate();
        layere.repaint();

        bgManager.setLayout(null);

        layere.add(bgManager, 1, 0);
        bManagerAccept.setBounds(550, 500, 100, 25);
        bManagerCancel.setBounds(350, 500, 100, 25);
        layere.add(bManagerAccept, 2, 0);
        layere.add(bManagerCancel, 2, 0);

        tfData = new JTextField[1];

        tfData[0] = new JTextField();

        JPanel p1 = new JPanel();
        JPanel p2 = new JPanel();

        JLabel l1 = new JLabel("Category Name:");

        p1.setOpaque(false);
        p2.setOpaque(false);

        p1.add(l1);

        tfData[0].addKeyListener(this);

        tfData[0].setBounds(400, 250, 200, 25);
        p1.setBounds(400, 200, 100, 25);

        bgManager.add(p1, 2, 0);
        bgManager.add(tfData[0], 2, 0);
    }

    private void readCategory(int i) {

        JFrame frame = new JFrame();
        frame.setSize(550, 100);

        JPanel p = new JPanel();

        JPanel p1 = new JPanel();
        JPanel p2 = new JPanel();

        JLabel l1 = new JLabel("Category name:");
        JLabel l2 = new JLabel(sData[i][1]);

        p.setLayout(null);
        p.setBackground(Color.white);
        p.setPreferredSize(new Dimension(550, 100));

        p1.setOpaque(false);
        p2.setOpaque(false);

        p1.add(l1);
        p2.add(l2);

        p1.setBounds(150, 10, 120, 25);
        p2.setBounds(270, 10, 120, 25);

        p.add(p1);
        p.add(p2);

        frame.add(p);

        frame.setTitle("Category read");
        frame.setLocationRelativeTo(null);
        frame.setResizable(false);
        frame.setVisible(true);
    }

    private void updateSubcategory(int i) {

        update = true;

        stroreId = i;

        layere.remove(bgManager);
        layere.remove(spManagement);
        layere.remove(cbChooseDbo);
        layere.remove(bManagerAdd);
        layere.remove(bManagerBack);

        layere.revalidate();
        layere.repaint();

        cbManagamet.removeAllItems();

        for (String s : q.fillcbSubcat()) {
            cbManagamet.addItem(s);
        }

        cbManagamet.setSelectedItem(sData[i][3]);

        bgManager.setLayout(null);

        layere.add(bgManager, 1, 0);
        bManagerAccept.setBounds(550, 500, 100, 25);
        bManagerCancel.setBounds(350, 500, 100, 25);
        layere.add(bManagerAccept, 2, 0);
        layere.add(bManagerCancel, 2, 0);

        tfData = new JTextField[1];

        JPanel p1 = new JPanel();
        JPanel p2 = new JPanel();

        JLabel l1 = new JLabel("Subcategory Name:");
        JLabel l2 = new JLabel("Choose category:");

        p1.setOpaque(false);
        p2.setOpaque(false);

        p1.add(l1);
        p2.add(l2);

        tfData[0] = new JTextField(sData[i][1]);

        tfData[0].addKeyListener(this);

        tfData[0].setBounds(200, 250, 200, 25);

        cbManagamet.setBounds(600, 250, 150, 25);

        p1.setBounds(200, 200, 120, 25);
        p2.setBounds(600, 200, 100, 25);

        bgManager.add(p1, 2, 0);
        bgManager.add(p2, 2, 0);

        bgManager.add(cbManagamet, 2, 0);

        bgManager.add(tfData[0], 2, 0);
    }

    private void newSubcategory() {

        update = false;

        layere.remove(bgManager);
        layere.remove(spManagement);
        layere.remove(cbChooseDbo);
        layere.remove(bManagerAdd);
        layere.remove(bManagerBack);

        layere.revalidate();
        layere.repaint();

        cbManagamet.removeAllItems();

        for (String s : q.fillcbSubcat()) {
            cbManagamet.addItem(s);
        }

        bgManager.setLayout(null);

        layere.add(bgManager, 1, 0);
        bManagerAccept.setBounds(550, 500, 100, 25);
        bManagerCancel.setBounds(350, 500, 100, 25);
        layere.add(bManagerAccept, 2, 0);
        layere.add(bManagerCancel, 2, 0);

        tfData = new JTextField[1];

        JPanel p1 = new JPanel();
        JPanel p2 = new JPanel();

        JLabel l1 = new JLabel("Subcategory Name:");
        JLabel l2 = new JLabel("Choose category:");

        p1.setOpaque(false);
        p2.setOpaque(false);

        p1.add(l1);
        p2.add(l2);

        tfData[0] = new JTextField();

        tfData[0].addKeyListener(this);

        tfData[0].setBounds(200, 250, 200, 25);

        cbManagamet.setBounds(600, 250, 150, 25);

        p1.setBounds(200, 200, 120, 25);
        p2.setBounds(600, 200, 100, 25);

        bgManager.add(p1, 2, 0);
        bgManager.add(p2, 2, 0);

        bgManager.add(cbManagamet, 2, 0);

        bgManager.add(tfData[0], 2, 0);

    }

    private void readSubcategory(int i) {

        JFrame frame = new JFrame();
        frame.setSize(550, 150);

        JPanel p = new JPanel();

        JPanel p1 = new JPanel();
        JPanel p2 = new JPanel();
        JPanel p3 = new JPanel();
        JPanel p4 = new JPanel();

        JLabel l1 = new JLabel("Subcategory name:");
        JLabel l2 = new JLabel(sData[i][1]);
        JLabel l3 = new JLabel("Category name:");
        JLabel l4 = new JLabel(sData[i][3]);

        p.setLayout(null);
        p.setBackground(Color.white);
        p.setPreferredSize(new Dimension(550, 150));

        p1.setOpaque(false);
        p2.setOpaque(false);
        p3.setOpaque(false);
        p4.setOpaque(false);

        p1.add(l1);
        p2.add(l2);
        p3.add(l3);
        p4.add(l4);

        p1.setBounds(150, 10, 120, 25);
        p2.setBounds(270, 10, 120, 25);
        p3.setBounds(150, 40, 120, 25);
        p4.setBounds(270, 40, 120, 25);

        p.add(p1);
        p.add(p2);
        p.add(p3);
        p.add(p4);

        frame.add(p);

        frame.setTitle("Packing type read");
        frame.setLocationRelativeTo(null);
        frame.setResizable(false);
        frame.setVisible(true);
    }

    private void updatePayment(int i) {

        update = true;

        stroreId = i;

        layere.remove(bgManager);
        layere.remove(spManagement);
        layere.remove(cbChooseDbo);
        layere.remove(bManagerAdd);
        layere.remove(bManagerBack);

        layere.revalidate();
        layere.repaint();

        bgManager.setLayout(null);

        layere.add(bgManager, 1, 0);
        bManagerAccept.setBounds(550, 500, 100, 25);
        bManagerCancel.setBounds(350, 500, 100, 25);
        layere.add(bManagerAccept, 2, 0);
        layere.add(bManagerCancel, 2, 0);

        tfData = new JTextField[1];

        JPanel p1 = new JPanel();
        JPanel p2 = new JPanel();

        JLabel l1 = new JLabel("Payment Name:");

        p1.setOpaque(false);
        p2.setOpaque(false);

        p1.add(l1);

        tfData[0] = new JTextField(sData[i][1]);

        tfData[0].addKeyListener(this);

        tfData[0].setBounds(400, 250, 200, 25);
        p1.setBounds(400, 200, 100, 25);

        bgManager.add(p1, 2, 0);
        bgManager.add(tfData[0], 2, 0);
    }

    private void newPayment() {

        update = false;

        layere.remove(bgManager);
        layere.remove(spManagement);
        layere.remove(cbChooseDbo);
        layere.remove(bManagerAdd);
        layere.remove(bManagerBack);

        layere.revalidate();
        layere.repaint();

        bgManager.setLayout(null);

        layere.add(bgManager, 1, 0);
        bManagerAccept.setBounds(550, 500, 100, 25);
        bManagerCancel.setBounds(350, 500, 100, 25);
        layere.add(bManagerAccept, 2, 0);
        layere.add(bManagerCancel, 2, 0);

        tfData = new JTextField[1];
        tfData[0] = new JTextField();

        JPanel p1 = new JPanel();
        JPanel p2 = new JPanel();

        JLabel l1 = new JLabel("Payment Name:");

        p1.setOpaque(false);
        p2.setOpaque(false);

        p1.add(l1);

        tfData[0].addKeyListener(this);

        tfData[0].setBounds(400, 250, 200, 25);
        p1.setBounds(400, 200, 100, 25);

        bgManager.add(p1, 2, 0);
        bgManager.add(tfData[0], 2, 0);
    }

    private void readPayment(int i) {
        JFrame frame = new JFrame();
        frame.setSize(550, 100);

        JPanel p = new JPanel();

        JPanel p1 = new JPanel();
        JPanel p2 = new JPanel();

        JLabel l1 = new JLabel("Payment type:");
        JLabel l2 = new JLabel(sData[i][1]);

        p.setLayout(null);
        p.setBackground(Color.white);
        p.setPreferredSize(new Dimension(550, 100));

        p1.setOpaque(false);
        p2.setOpaque(false);

        p1.add(l1);
        p2.add(l2);

        p1.setBounds(150, 10, 120, 25);
        p2.setBounds(270, 10, 120, 25);

        p.add(p1);
        p.add(p2);

        frame.add(p);

        frame.setTitle("Payment type read");
        frame.setLocationRelativeTo(null);
        frame.setResizable(false);
        frame.setVisible(true);
    }

    private void updatePacking(int i) {

        update = true;

        stroreId = i;

        layere.remove(bgManager);
        layere.remove(spManagement);
        layere.remove(cbChooseDbo);
        layere.remove(bManagerAdd);
        layere.remove(bManagerBack);

        layere.revalidate();
        layere.repaint();

        bgManager.setLayout(null);

        layere.add(bgManager, 1, 0);
        bManagerAccept.setBounds(550, 500, 100, 25);
        bManagerCancel.setBounds(350, 500, 100, 25);
        layere.add(bManagerAccept, 2, 0);
        layere.add(bManagerCancel, 2, 0);

        tfData = new JTextField[1];

        JPanel p1 = new JPanel();
        JPanel p2 = new JPanel();

        JLabel l1 = new JLabel("Packing type:");

        p1.setOpaque(false);
        p2.setOpaque(false);

        p1.add(l1);

        tfData[0] = new JTextField(sData[i][1]);

        tfData[0].addKeyListener(this);

        tfData[0].setBounds(400, 250, 200, 25);
        p1.setBounds(400, 200, 100, 25);

        bgManager.add(p1, 2, 0);
        bgManager.add(tfData[0], 2, 0);
    }

    private void newPacking() {

        update = false;

        layere.remove(bgManager);
        layere.remove(spManagement);
        layere.remove(cbChooseDbo);
        layere.remove(bManagerAdd);
        layere.remove(bManagerBack);

        layere.revalidate();
        layere.repaint();

        bgManager.setLayout(null);

        layere.add(bgManager, 1, 0);
        bManagerAccept.setBounds(550, 500, 100, 25);
        bManagerCancel.setBounds(350, 500, 100, 25);
        layere.add(bManagerAccept, 2, 0);
        layere.add(bManagerCancel, 2, 0);

        tfData = new JTextField[1];
        tfData[0] = new JTextField();

        JPanel p1 = new JPanel();
        JPanel p2 = new JPanel();

        JLabel l1 = new JLabel("Packing type:");

        p1.setOpaque(false);
        p2.setOpaque(false);

        p1.add(l1);

        tfData[0].addKeyListener(this);

        tfData[0].setBounds(400, 250, 200, 25);
        p1.setBounds(400, 200, 100, 25);

        bgManager.add(p1, 2, 0);
        bgManager.add(tfData[0], 2, 0);
    }

    private void readPacking(int i) {

        JFrame frame = new JFrame();
        frame.setSize(550, 100);

        JPanel p = new JPanel();

        JPanel p1 = new JPanel();
        JPanel p2 = new JPanel();

        JLabel l1 = new JLabel("Packing type:");
        JLabel l2 = new JLabel(sData[i][1]);

        p.setLayout(null);
        p.setBackground(Color.white);
        p.setPreferredSize(new Dimension(550, 100));

        p1.setOpaque(false);
        p2.setOpaque(false);

        p1.add(l1);
        p2.add(l2);

        p1.setBounds(150, 10, 120, 25);
        p2.setBounds(270, 10, 120, 25);

        p.add(p1);
        p.add(p2);

        frame.add(p);

        frame.setTitle("Packing type read");
        frame.setLocationRelativeTo(null);
        frame.setResizable(false);
        frame.setVisible(true);
    }

    private void removeManagerMore() {

        layere.remove(bManagerCancel);
        layere.remove(bManagerAccept);
        layere.remove(bgManager);
        layere.revalidate();
        layere.repaint();

        bgManager.removeAll();
        bgManager.revalidate();
        bgManager.repaint();

        managerWindow();
    }

    private void removeManagerWindow() {

        layere.remove(bgManager);
        layere.remove(spManagement);
        layere.remove(cbChooseDbo);
        layere.remove(bManagerAdd);
        layere.remove(bManagerBack);

        layere.revalidate();
        layere.repaint();
    }

    private void removeLeftBanner() {

        layere.remove(bHome);
        layere.remove(bSearchProducts);
        layere.remove(bNewOrders);
        layere.remove(bBake);
        layere.remove(bCompletedOrders);
        layere.remove(bStatistics);
        layere.remove(bManagerArea);

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
            } else {
                JOptionPane.showMessageDialog(this, "Check if all data is correct", "Error", JOptionPane.ERROR_MESSAGE);
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
        } else if (z == bBake) {
            removeWindows();
            bakeWindow();
        } else if (z == bCompletedOrders) {
            removeWindows();
            completedOrdersWindow();
        } else if (z == bStatistics) {
            removeWindows();
            statisticsWindow();
        } else if (z == bManagerArea) {
            removeWindows();
            removeLeftBanner();
            managerWindow();
        } else if (z == bLogOut) {
            removeWindows();
            removeLeftBanner();
            tfUser.setText("");
            pfPassword.setText("");
            loginWindow();
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
        } else if (z == bBakeProducts) {
            updateBake();
            bakeWindowUpdate();
        } else if (z == cbOrderToBake) {
            bakeWindowUpdate();
        } else if (z == cbOrderCompletedOrders) {
            updateCompletedOrdersWindow();
        } else if (z == cbStatsCategory) {
            updateStatisticsWindow();
        } else if (z == cbChooseDbo) {
            updateManagerWindow();
        } else if (z == bManagerAdd) {
            switch (cbChooseDbo.getSelectedIndex()) {
                case 0:
                    newCustomerAndAdres();
                    break;
                case 1:
                    newEmployeeAndAdres();
                    break;
                case 2:
                    newProductCategory();
                    break;
                case 3:
                    newSupplierAdres();
                    break;
                case 4:
                    newPositions();
                    break;
                case 5:
                    newCategory();
                    break;
                case 6:
                    newSubcategory();
                    break;
                case 7:
                    newPayment();
                    break;
                case 8:
                    newPacking();
                    break;
                default:
            }
        } else if (z == bManagerBack) {
            removeWindows();
            createLeftBanner();
        } else if (z == bManagerAccept) {
            switch (cbChooseDbo.getSelectedIndex()) {
                case 0:
                    if (update) {
                        if (logic.checkNames(tfData[0].getText()) && logic.checkNames(tfData[1].getText()) && logic.checkNames(tfData[2].getText()) && logic.checkNumber(tfData[3].getText()) && logic.checkPostalCode(tfData[4].getText()) && logic.checkNames(tfData[5].getText())) {
                            q.updateCustomerAndAdres(sData[stroreId][0], sData[stroreId][1], tfData[0].getText(), tfData[1].getText(), tfData[2].getText(), tfData[3].getText(), tfData[4].getText(), tfData[5].getText());
                            removeManagerMore();
                        } else {
                            JOptionPane.showMessageDialog(this, "Check if all data is correct", "Error", JOptionPane.ERROR_MESSAGE);
                        }
                    } else {
                        if (logic.checkNames(tfData[0].getText()) && logic.checkNames(tfData[1].getText()) && logic.checkNames(tfData[2].getText()) && logic.checkNumber(tfData[3].getText()) && logic.checkPostalCode(tfData[4].getText()) && logic.checkNames(tfData[5].getText())) {
                            q.newCustomerAndAdres(q.getLastId("Customer")+1, q.getLastId("Adres")+1, tfData[0].getText(), tfData[1].getText(), tfData[2].getText(), tfData[3].getText(), tfData[4].getText(), tfData[5].getText());
                            removeManagerMore();
                        } else {
                            JOptionPane.showMessageDialog(this, "Check if all data is correct", "Error", JOptionPane.ERROR_MESSAGE);
                        }
                    }
                    break;
                case 1:
                    if (update) {
                        if (logic.checkNames(tfData[0].getText()) && logic.checkNames(tfData[1].getText()) && logic.checkPesel(tfData[2].getText()) && logic.checkBirthDate(tfData[3].getText()) && logic.checkTelephone(tfData[4].getText()) && logic.checkNames(tfData[5].getText()) && logic.checkNumber(tfData[6].getText()) && logic.checkPostalCode(tfData[7].getText()) && logic.checkNames(tfData[8].getText())) {
                            if (logic.setGender(tfData[2].getText())) {
                                q.updateEmployeeAndAdres(sData[stroreId][0], sData[stroreId][1], cbManagamet.getSelectedIndex()+1, tfData[0].getText(), tfData[1].getText(), tfData[2].getText(), tfData[3].getText(), "w", tfData[4].getText(), tfData[5].getText(), tfData[6].getText(), tfData[7].getText(), tfData[8].getText());
                            } else {
                                q.updateEmployeeAndAdres(sData[stroreId][0], sData[stroreId][1], cbManagamet.getSelectedIndex()+1, tfData[0].getText(), tfData[1].getText(), tfData[2].getText(), tfData[3].getText(), "m", tfData[4].getText(), tfData[5].getText(), tfData[6].getText(), tfData[7].getText(), tfData[8].getText());
                            }
                            removeManagerMore();
                        } else {
                            JOptionPane.showMessageDialog(this, "Check if all data is correct", "Error", JOptionPane.ERROR_MESSAGE);
                        }
                    } else {
                        if (logic.checkNames(tfData[0].getText()) && logic.checkNames(tfData[1].getText()) && logic.checkPesel(tfData[2].getText()) && logic.checkBirthDate(tfData[3].getText()) && logic.checkTelephone(tfData[4].getText()) && logic.checkNames(tfData[5].getText()) && logic.checkNumber(tfData[6].getText()) && logic.checkPostalCode(tfData[7].getText()) && logic.checkNames(tfData[8].getText())) {
                            if (logic.setGender(tfData[2].getText())) {
                                q.newEmployeeAndAdres(q.getLastId("Employee")+1, q.getLastId("Adres")+1, cbManagamet.getSelectedIndex()+1, tfData[0].getText(), tfData[1].getText(), tfData[2].getText(), tfData[3].getText(), "w", tfData[4].getText(), tfData[5].getText(), tfData[6].getText(), tfData[7].getText(), tfData[8].getText());
                            } else {
                                q.newEmployeeAndAdres(q.getLastId("Employee")+1, q.getLastId("Adres")+1, cbManagamet.getSelectedIndex()+1, tfData[0].getText(), tfData[1].getText(), tfData[2].getText(), tfData[3].getText(), "m", tfData[4].getText(), tfData[5].getText(), tfData[6].getText(), tfData[7].getText(), tfData[8].getText());
                            }
                            removeManagerMore();
                        } else {
                            JOptionPane.showMessageDialog(this, "Check if all data is correct", "Error", JOptionPane.ERROR_MESSAGE);
                        }
                    }
                    break;
                case 2:
                    if (update) {
                        if (logic.checkProductNewName(tfData[0].getText()) && logic.checkPrice(tfData[1].getText()) && logic.checkText(tfData[2].getText()) && logic.checkText(tfData[3].getText())) {
                            String s;
                            if (cbManagamet1.getSelectedIndex()==0) {
                                s = "NULL";
                            } else {
                                s = ""+storeBakerId[cbManagamet1.getSelectedIndex()-1];
                            }
                            q.updateProductCategorySubcategory(sData[stroreId][0], cbManagamet.getSelectedIndex()+1, s, cbManagamet2.getSelectedIndex(), tfData[0].getText(), tfData[1].getText(), tfData[2].getText(), tfData[3].getText());
                            removeManagerMore();
                        } else {
                            JOptionPane.showMessageDialog(this, "Check if all data is correct", "Error", JOptionPane.ERROR_MESSAGE);
                        }
                    } else {
                        if (logic.checkProductNewName(tfData[0].getText()) && logic.checkPrice(tfData[1].getText()) && logic.checkText(tfData[2].getText()) && logic.checkText(tfData[3].getText())) {
                            String s;
                            if (cbManagamet1.getSelectedIndex()==0) {
                                s = "NULL";
                            } else {
                                s = ""+storeBakerId[cbManagamet1.getSelectedIndex()-1];
                            }
                            q.newProductCategorySubcategory(q.getLastId("Product")+1, cbManagamet.getSelectedIndex()+1, s, cbManagamet2.getSelectedIndex(), tfData[0].getText(), tfData[1].getText(), tfData[2].getText(), tfData[3].getText());
                            removeManagerMore();
                        } else {
                            JOptionPane.showMessageDialog(this, "Check if all data is correct", "Error", JOptionPane.ERROR_MESSAGE);
                        }
                    }
                    break;
                case 3:
                    if (update) {
                        if (logic.checkNames(tfData[0].getText()) && logic.checkTelephone(tfData[1].getText()) && logic.checkEmail(tfData[2].getText()) && logic.checkNames(tfData[3].getText()) && logic.checkNumber(tfData[4].getText()) && logic.checkPostalCode(tfData[5].getText()) && logic.checkNames(tfData[6].getText())) {
                            q.updateSupplierAndAdres(sData[stroreId][0], sData[stroreId][1], tfData[0].getText(), tfData[1].getText(), tfData[2].getText(), tfData[3].getText(), tfData[4].getText(), tfData[5].getText(), tfData[6].getText());
                            removeManagerMore();
                        } else {
                            JOptionPane.showMessageDialog(this, "Check if all data is correct", "Error", JOptionPane.ERROR_MESSAGE);
                        }
                    } else {
                        if (logic.checkNames(tfData[0].getText()) && logic.checkTelephone(tfData[1].getText()) && logic.checkEmail(tfData[2].getText()) && logic.checkNames(tfData[3].getText()) && logic.checkNumber(tfData[4].getText()) && logic.checkPostalCode(tfData[5].getText()) && logic.checkNames(tfData[6].getText())) {
                            q.newSupplierAndAdres(q.getLastId("Supplier")+1, q.getLastId("Adres")+1, tfData[0].getText(), tfData[1].getText(), tfData[2].getText(), tfData[3].getText(), tfData[4].getText(), tfData[5].getText(), tfData[6].getText());
                            removeManagerMore();
                        } else {
                            JOptionPane.showMessageDialog(this, "Check if all data is correct", "Error", JOptionPane.ERROR_MESSAGE);
                        }
                    }
                    break;
                case 4:
                    if (update) {
                        if (logic.checkNames(tfData[0].getText()) && logic.checkPrice(tfData[1].getText())) {
                            q.updatePosition(sData[stroreId][0], tfData[0].getText(), tfData[1].getText());
                            removeManagerMore();
                        } else {
                            JOptionPane.showMessageDialog(this, "Check if all data is correct", "Error", JOptionPane.ERROR_MESSAGE);
                        }
                    } else {
                        if (logic.checkNames(tfData[0].getText()) && logic.checkPrice(tfData[1].getText())) {
                            q.newPosition(q.getLastId("Position")+1, tfData[0].getText(), tfData[1].getText());
                            removeManagerMore();
                        } else {
                            JOptionPane.showMessageDialog(this, "Check if all data is correct", "Error", JOptionPane.ERROR_MESSAGE);
                        }
                    }
                    break;
                case 5:
                    if (update) {
                        if (logic.checkText(tfData[0].getText())) {
                            q.updateSubcategory(sData[stroreId][0], tfData[0].getText());
                            removeManagerMore();
                        } else {
                            JOptionPane.showMessageDialog(this, "Check if all data is correct", "Error", JOptionPane.ERROR_MESSAGE);
                        }
                    } else {
                        if (logic.checkText(tfData[0].getText())) {
                            q.newSubcategory(q.getLastId("Subcategory")+1, tfData[0].getText());
                            removeManagerMore();
                        } else {
                            JOptionPane.showMessageDialog(this, "Check if all data is correct", "Error", JOptionPane.ERROR_MESSAGE);
                        }
                    }
                    break;
                case 6:
                    if (update) {
                        if (logic.checkText(tfData[0].getText())) {
                            q.updateCategory(sData[stroreId][0], tfData[0].getText(), cbManagamet.getSelectedIndex()+1);
                            removeManagerMore();
                        } else {
                            JOptionPane.showMessageDialog(this, "Check if all data is correct", "Error", JOptionPane.ERROR_MESSAGE);
                        }
                    } else {
                        if (logic.checkText(tfData[0].getText())) {
                            q.newCategory(q.getLastId("Category")+1, tfData[0].getText(), cbManagamet.getSelectedIndex()+1);
                            removeManagerMore();
                        } else {
                            JOptionPane.showMessageDialog(this, "Check if all data is correct", "Error", JOptionPane.ERROR_MESSAGE);
                        }
                    }
                    break;
                case 7:
                    if (update) {
                        if (logic.checkText(tfData[0].getText())) {
                            q.updatePayment(sData[stroreId][0], tfData[0].getText());
                            removeManagerMore();
                        } else {
                            JOptionPane.showMessageDialog(this, "Check if all data is correct", "Error", JOptionPane.ERROR_MESSAGE);
                        }
                    } else {
                        if (logic.checkText(tfData[0].getText())) {
                            q.newPayment(q.getLastId("Payment")+1, tfData[0].getText());
                            removeManagerMore();
                        } else {
                            JOptionPane.showMessageDialog(this, "Check if all data is correct", "Error", JOptionPane.ERROR_MESSAGE);
                        }
                    }
                    break;
                case 8:
                    if (update) {
                        if (logic.checkText(tfData[0].getText())) {
                            q.updatePacking(sData[stroreId][0], tfData[0].getText());
                            removeManagerMore();
                        } else {
                            JOptionPane.showMessageDialog(this, "Check if all data is correct", "Error", JOptionPane.ERROR_MESSAGE);
                        }
                    } else {
                        if (logic.checkText(tfData[0].getText())) {
                            q.newPacking(q.getLastId("Packing")+1, tfData[0].getText());
                            removeManagerMore();
                        } else {
                            JOptionPane.showMessageDialog(this, "Check if all data is correct", "Error", JOptionPane.ERROR_MESSAGE);
                        }
                    }
                    break;
                default:
            }
        } else if (z == bManagerCancel) {
            removeManagerMore();
        } else {
            if (bManagerDelete != null) {
                for (int i = 0; i < bManagerDelete.length; i++) {
                    if (z == bManagerDelete[i]) {
                        switch (cbChooseDbo.getSelectedIndex()) {
                            case 0:
                                q.deleteCustomer(sData[i][0]);
                                shift = shift + listOrders.size();
                                listOrders.clear();
                                updateManagerWindow();
                                break;
                            case 1:
                                q.deleteEmployee(sData[i][0]);
                                shift = shift + listOrders.size();
                                listOrders.clear();
                                updateManagerWindow();
                                break;
                            case 2:
                                q.deleteProdct(sData[i][0]);
                                shift = shift + listOrders.size();
                                listOrders.clear();
                                updateManagerWindow();
                                break;
                            case 3:
                                q.deleteSupplier(sData[i][0]);
                                shift = shift + listOrders.size();
                                listOrders.clear();
                                updateManagerWindow();
                                break;
                            case 4:
                                q.deletePosition(sData[i][0]);
                                shift = shift + listOrders.size();
                                listOrders.clear();
                                updateManagerWindow();
                                break;
                            case 5:
                                q.deleteSubcategory(sData[i][0]);
                                shift = shift + listOrders.size();
                                listOrders.clear();
                                updateManagerWindow();
                                break;
                            case 6:
                                q.deleteCategory(sData[i][0]);
                                shift = shift + listOrders.size();
                                listOrders.clear();
                                updateManagerWindow();
                                break;
                            case 7:
                                q.deletePayment(sData[i][0]);
                                shift = shift + listOrders.size();
                                listOrders.clear();
                                updateManagerWindow();
                                break;
                            case 8:
                                q.deletePacking(sData[i][0]);
                                shift = shift + listOrders.size();
                                listOrders.clear();
                                updateManagerWindow();
                                break;
                            default:
                        }
                    }
                }
            }
            if (bManagerUpdate != null) {
                for (int i = 0; i < bManagerUpdate.length; i++) {
                    if (z == bManagerUpdate[i]) {
                        switch (cbChooseDbo.getSelectedIndex()) {
                            case 0:
                                updateCustomerAndAdres(i);
                                break;
                            case 1:
                                updateEmployeeAndAdres(i);
                                break;
                            case 2:
                                updateProductCategory(i);
                                break;
                            case 3:
                                updateSupplierAdres(i);
                                break;
                            case 4:
                                updatePositions(i);
                                break;
                            case 5:
                                updateCategory(i);
                                break;
                            case 6:
                                updateSubcategory(i);
                                break;
                            case 7:
                                updatePayment(i);
                                break;
                            case 8:
                                updatePacking(i);
                                break;
                            default:
                        }
                    }
                }
            }
            if (bManagerRead != null) {
                for (int i = 0; i < bManagerRead.length; i++) {
                    if (z == bManagerRead[i]) {
                        switch (cbChooseDbo.getSelectedIndex()) {
                            case 0:
                                readCustomerAndAdres(i);
                                break;
                            case 1:
                                readEmployeeAndAdres(i);
                                break;
                            case 2:
                                readProductCategory(i);
                                break;
                            case 3:
                                readSupplierAdres(i);
                                break;
                            case 4:
                                readPositions(i);
                                break;
                            case 5:
                                readCategory(i);
                                break;
                            case 6:
                                readSubcategory(i);
                                break;
                            case 7:
                                readPayment(i);
                                break;
                            case 8:
                                readPacking(i);
                                break;
                            default:
                        }
                    }
                }
            }
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
        } else {
            if (tfAmountToBake != null) {
                for (int i = 0; i < tfAmountToBake.length; i++) {
                    if (z == tfAmountToBake[i]) {
                        if (logic.checkProductToBake(tfAmountToBake[i].getText())) {
                            tfAmountToBake[i].setBackground(new Color(227, 245, 227));
                        } else {
                            tfAmountToBake[i].setText("0");
                            tfAmountToBake[i].setBackground(new Color(246, 226, 226));
                        }
                    }
                }
            }
            if (tfData != null) {
                for (int i = 0; i < tfData.length; i++) {
                    switch (cbChooseDbo.getSelectedIndex()) {
                        case 0:
                            if (z == tfData[0]) {
                                if (logic.checkNames(tfData[0].getText())) {
                                    tfData[0].setBackground(new Color(227, 245, 227));
                                } else {
                                    tfData[0].setBackground(new Color(246, 226, 226));
                                }
                            } else if (z == tfData[1]) {
                                if (logic.checkNames(tfData[1].getText())) {
                                    tfData[1].setBackground(new Color(227, 245, 227));
                                } else {
                                    tfData[1].setBackground(new Color(246, 226, 226));
                                }
                            } else if (z == tfData[2]) {
                                if (logic.checkNames(tfData[2].getText())) {
                                    tfData[2].setBackground(new Color(227, 245, 227));
                                } else {
                                    tfData[2].setBackground(new Color(246, 226, 226));
                                }
                            } else if (z == tfData[3]) {
                                if (logic.checkNumber(tfData[3].getText())) {
                                    tfData[3].setBackground(new Color(227, 245, 227));
                                } else {
                                    tfData[3].setBackground(new Color(246, 226, 226));
                                }
                            } else if (z == tfData[4]) {
                                if (logic.checkPostalCode(tfData[4].getText())) {
                                    tfData[4].setBackground(new Color(227, 245, 227));
                                } else {
                                    tfData[4].setBackground(new Color(246, 226, 226));
                                }
                            } else if (z == tfData[5]) {
                                if (logic.checkNames(tfData[5].getText())) {
                                    tfData[5].setBackground(new Color(227, 245, 227));
                                } else {
                                    tfData[5].setBackground(new Color(246, 226, 226));
                                }
                            }
                            break;
                        case 1:
                            if (z == tfData[0]) {
                                if (logic.checkNames(tfData[0].getText())) {
                                    tfData[0].setBackground(new Color(227, 245, 227));
                                } else {
                                    tfData[0].setBackground(new Color(246, 226, 226));
                                }
                            } else if (z == tfData[1]) {
                                if (logic.checkNames(tfData[1].getText())) {
                                    tfData[1].setBackground(new Color(227, 245, 227));
                                } else {
                                    tfData[1].setBackground(new Color(246, 226, 226));
                                }
                            } else if (z == tfData[2]) {
                                if (logic.checkPesel(tfData[2].getText())) {
                                    tfData[2].setBackground(new Color(227, 245, 227));
                                    tfData[3].setText(logic.setBirthDate(tfData[2].getText()));
                                } else {
                                    tfData[2].setBackground(new Color(246, 226, 226));
                                }
                            } else if (z == tfData[3]) {
                                if (logic.checkBirthDate(tfData[3].getText())) {
                                    tfData[3].setBackground(new Color(227, 245, 227));
                                } else {
                                    tfData[3].setBackground(new Color(246, 226, 226));
                                }
                            } else if (z == tfData[4]) {
                                if (logic.checkTelephone(tfData[4].getText())) {
                                    tfData[4].setBackground(new Color(227, 245, 227));
                                } else {
                                    tfData[4].setBackground(new Color(246, 226, 226));
                                }
                            } else if (z == tfData[5]) {
                                if (logic.checkNames(tfData[5].getText())) {
                                    tfData[5].setBackground(new Color(227, 245, 227));
                                } else {
                                    tfData[5].setBackground(new Color(246, 226, 226));
                                }
                            } else if (z == tfData[6]) {
                                if (logic.checkNumber(tfData[6].getText())) {
                                    tfData[6].setBackground(new Color(227, 245, 227));
                                } else {
                                    tfData[6].setBackground(new Color(246, 226, 226));
                                }
                            } else if (z == tfData[7]) {
                                if (logic.checkPostalCode(tfData[7].getText())) {
                                    tfData[7].setBackground(new Color(227, 245, 227));
                                } else {
                                    tfData[7].setBackground(new Color(246, 226, 226));
                                }
                            } else if (z == tfData[8]) {
                                if (logic.checkNames(tfData[8].getText())) {
                                    tfData[8].setBackground(new Color(227, 245, 227));
                                } else {
                                    tfData[8].setBackground(new Color(246, 226, 226));
                                }
                            }
                            break;
                        case 2:
                            if (z == tfData[0]) {
                                if (logic.checkProductNewName(tfData[0].getText())) {
                                    tfData[0].setBackground(new Color(227, 245, 227));
                                } else {
                                    tfData[0].setBackground(new Color(246, 226, 226));
                                }
                            } else if (z == tfData[1]) {
                                if (logic.checkPrice(tfData[1].getText())) {
                                    tfData[1].setBackground(new Color(227, 245, 227));
                                } else {
                                    tfData[1].setBackground(new Color(246, 226, 226));
                                }
                            } else if (z == tfData[2]) {
                                if (logic.checkText(tfData[2].getText())) {
                                    tfData[2].setBackground(new Color(227, 245, 227));
                                } else {
                                    tfData[2].setBackground(new Color(246, 226, 226));
                                }
                            } else if (z == tfData[3]) {
                                if (logic.checkText(tfData[3].getText())) {
                                    tfData[3].setBackground(new Color(227, 245, 227));
                                } else {
                                    tfData[3].setBackground(new Color(246, 226, 226));
                                }
                            }
                            break;
                        case 3:
                            if (z == tfData[0]) {
                                if (logic.checkNames(tfData[0].getText())) {
                                    tfData[0].setBackground(new Color(227, 245, 227));
                                } else {
                                    tfData[0].setBackground(new Color(246, 226, 226));
                                }
                            } else if (z == tfData[1]) {
                                if (logic.checkTelephone(tfData[1].getText())) {
                                    tfData[1].setBackground(new Color(227, 245, 227));
                                } else {
                                    tfData[1].setBackground(new Color(246, 226, 226));
                                }
                            } else if (z == tfData[2]) {
                                if (logic.checkEmail(tfData[2].getText())) {
                                    tfData[2].setBackground(new Color(227, 245, 227));
                                } else {
                                    tfData[2].setBackground(new Color(246, 226, 226));
                                }
                            } else if (z == tfData[3]) {
                                if (logic.checkNames(tfData[3].getText())) {
                                    tfData[3].setBackground(new Color(227, 245, 227));
                                } else {
                                    tfData[3].setBackground(new Color(246, 226, 226));
                                }
                            } else if (z == tfData[4]) {
                                if (logic.checkNumber(tfData[4].getText())) {
                                    tfData[4].setBackground(new Color(227, 245, 227));
                                } else {
                                    tfData[4].setBackground(new Color(246, 226, 226));
                                }
                            } else if (z == tfData[5]) {
                                if (logic.checkPostalCode(tfData[5].getText())) {
                                    tfData[5].setBackground(new Color(227, 245, 227));
                                } else {
                                    tfData[5].setBackground(new Color(246, 226, 226));
                                }
                            } else if (z == tfData[6]) {
                                if (logic.checkNames(tfData[6].getText())) {
                                    tfData[6].setBackground(new Color(227, 245, 227));
                                } else {
                                    tfData[6].setBackground(new Color(246, 226, 226));
                                }
                            }
                            break;
                        case 4:
                            if (z == tfData[0]) {
                                if (logic.checkNames(tfData[0].getText())) {
                                    tfData[0].setBackground(new Color(227, 245, 227));
                                } else {
                                    tfData[0].setBackground(new Color(246, 226, 226));
                                }
                            } else if (z == tfData[1]) {
                                if (logic.checkPrice(tfData[1].getText())) {
                                    tfData[1].setBackground(new Color(227, 245, 227));
                                } else {
                                    tfData[1].setBackground(new Color(246, 226, 226));
                                }
                            }
                            break;
                        case 5:
                            if (z == tfData[0]) {
                                if (logic.checkText(tfData[0].getText())) {
                                    tfData[0].setBackground(new Color(227, 245, 227));
                                } else {
                                    tfData[0].setBackground(new Color(246, 226, 226));
                                }
                            }
                            break;
                        case 6:
                            if (z == tfData[0]) {
                                if (logic.checkText(tfData[0].getText())) {
                                    tfData[0].setBackground(new Color(227, 245, 227));
                                } else {
                                    tfData[0].setBackground(new Color(246, 226, 226));
                                }
                            }
                            break;
                        case 7:
                            if (z == tfData[0]) {
                                if (logic.checkText(tfData[0].getText())) {
                                    tfData[0].setBackground(new Color(227, 245, 227));
                                } else {
                                    tfData[0].setBackground(new Color(246, 226, 226));
                                }
                            }
                            break;
                        case 8:
                            if (z == tfData[0]) {
                                if (logic.checkText(tfData[0].getText())) {
                                    tfData[0].setBackground(new Color(227, 245, 227));
                                } else {
                                    tfData[0].setBackground(new Color(246, 226, 226));
                                }
                            }
                            break;
                        default:
                    }
                }
            }
        }
    }

    @Override
    public void mouseClicked(MouseEvent mouseEvent) {

    }

    @Override
    public void mousePressed(MouseEvent mouseEvent) {

    }

    @Override
    public void mouseReleased(MouseEvent mouseEvent) {

    }

    @Override
    public void mouseEntered(MouseEvent mouseEvent) {
        Object z = mouseEvent.getSource();
        if (z == bManagerArea) {
            layere.add(pMustManager, 2, 0);
        } else if (z == bAcceptAll) {
            layere.add(pMustSeller, 2, 0);
        } else if (z == bBakeProducts) {
            layere.add(pMustConfectioner, 2, 0);
        }
    }

    @Override
    public void mouseExited(MouseEvent mouseEvent) {
        Object z = mouseEvent.getSource();
        if (z == bManagerArea) {
            layere.remove(pMustManager);
            layere.revalidate();
            layere.repaint();
        } else if (z == bAcceptAll) {
            layere.remove(pMustSeller);
            layere.revalidate();
            layere.repaint();
        } else if (z == bBakeProducts) {
            layere.remove(pMustConfectioner);
            layere.revalidate();
            layere.repaint();
        }
    }
}