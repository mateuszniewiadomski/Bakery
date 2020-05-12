package bakery.main;

import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

public class Window extends JFrame implements ActionListener {

    //global
    private sqlQueries q;
    private JLayeredPane layere = new JLayeredPane();
    private JPanel pLogo = new JPanel();
    private JPanel pBanner = new JPanel();
    private JPanel pBG = new JPanel();
    private ImageIcon imLogo = new ImageIcon(this.getClass().getResource("logo.jpg"));
    private ImageIcon imBanner = new ImageIcon(this.getClass().getResource("banner.jpg"));
    private ImageIcon imBG = new ImageIcon(this.getClass().getResource("bg.jpg"));
    private JLabel lLogo = new JLabel();
    private JLabel lBanner = new JLabel();
    private JLabel lBG = new JLabel();

    //login window
    private JPanel pUser = new JPanel();
    private JLabel lUser = new JLabel("Username");
    private JPanel pPassword = new JPanel();
    private JLabel lPassword = new JLabel("Password");
    private JTextField tfUser = new JTextField();
    private JPasswordField pfPassword = new JPasswordField();
    private JButton bLogin = new JButton("Login");
    private JButton bNewAccount = new JButton("Create new account");
    private JPanel pAlert = new JPanel();
    private JLabel lAlert = new JLabel("Incorrect login or password");

    //create account


    public Window() {
        setSize(1000, 600);
        setTitle("Bakery App");
        setResizable(false);
        setLocationRelativeTo(null);
        setLayout(null);
        add(layere);
        layere.setBounds(0,0,1000, 600);
        q = new sqlQueries();
        q.connect();
        createTop();
    }

    private void loginWindow() {

        pUser.setBounds(350,200,100,30);
        pPassword.setBounds(350,230,100,30);

        tfUser.setBounds(480,205,170,25);
        pfPassword.setBounds(480,235,170,25);

        bLogin.setBounds(360, 270, 290, 25);
        bNewAccount.setBounds(360, 305, 290, 25);

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

        pUser.add(lUser);
        pPassword.add(lPassword);

        layere.add(pUser, new Integer(1), 0);
        layere.add(pPassword, new Integer(1), 0);
        layere.add(tfUser, new Integer(1), 0);
        layere.add(pfPassword, new Integer(1), 0);
        layere.add(bLogin, new Integer(1), 0);
        layere.add(bNewAccount, new Integer(1), 0);

        bLogin.addActionListener(this);
        bNewAccount.addActionListener(this);
    }

    private void incorrectLoginWindow() {

        pAlert.setBounds(420,170,250,30);
        pAlert.setOpaque(false);

        lAlert.setFont(new Font(Font.DIALOG,  Font.BOLD, 15));
        lAlert.setForeground(new Color(190, 0, 0));

        pAlert.add(lAlert);
        layere.add(pAlert, new Integer(1), 0);

        tfUser.setBackground(new Color(246, 226, 226));
        pfPassword.setBackground(new Color(246, 226, 226));
    }

    private void createTop() {

        lLogo.setIcon(imLogo);
        pLogo.setBounds(50, -5, 100, 100);
        pLogo.add(lLogo);

        lBanner.setIcon(imBanner);
        pBanner.setBounds(0,-5,1000, 70);
        pBanner.add(lBanner);

        lBG.setIcon(imBG);
        pBG.setBounds(0,-5, 1000, 600);
        pBG.add(lBG);

        layere.add(pLogo, new Integer(2), 0);
        layere.add(pBanner, new Integer(1), 0);
        layere.add(pBG, new Integer(0), 0);

        loginWindow();
    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        Object z = actionEvent.getSource();
        if (z == bLogin) {
            String login = tfUser.getText();
            String password = pfPassword.getText();
            if (q.checkPassword(login, password)) {
                System.out.println("Logged In!");
            } else {
                incorrectLoginWindow();
            }
        } else if (z == bNewAccount) {

        }
    }
}
