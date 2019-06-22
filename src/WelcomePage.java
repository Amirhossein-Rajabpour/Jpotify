//package Welcome;

//import AppFrame.JpotifyGUI;

import view.MainPage;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class WelcomePage extends JFrame {

    private static final int WIDTH = 350, HEIGHT = 500;

    private static final String MAIN_WELCOME_TXT = "Jpotify®";
    JLabel jLabel;

    private static final String WELCOME_TXT = "Millions of songs.\nFree on Jpotify.";
    JTextField jTextField;

    private static final String USERNAME_LABEL = "Username:";
    JLabel userLabel;
    JTextField userTextField;

    private static final String ID_LABEL = "Friend's ID";
    JLabel idLabel;
    JTextField idTextField;

    private static final String BTN_TXT = "LOG IN";
    JButton btn;

    //DataInput dataInput;
    public WelcomePage() {
        super();

        this.getContentPane().setLayout(new BoxLayout(this.getContentPane(), BoxLayout.Y_AXIS));

        jLabel = new JLabel(MAIN_WELCOME_TXT);
        Font font1 = new Font("Arial", Font.BOLD, 48);
        jLabel.setFont(font1);
        //jLabel.setForeground(new Color(105, 180, 120));
        jLabel.setForeground(new Color(130, 35, 35));
        jLabel.setBackground(Color.black);
        //jLabel.setSize(250, 100);
        jLabel.setVerticalAlignment(SwingConstants.EAST);
        ImageIcon imgThisImg = new ImageIcon("Jpotifyred.png");
        jLabel.setIcon(imgThisImg);
        this.add(jLabel);

        jTextField = new JTextField();
        Font font2 = new Font("Arial", Font.CENTER_BASELINE, 24);
        jTextField.setFont(font2);
        jTextField.setText("Millions of songs.");
        jTextField.setHorizontalAlignment((int) CENTER_ALIGNMENT);
        this.add(jTextField);
        jTextField.setEditable(false);
        jTextField.setBackground(new Color(130, 35, 35));
        jTextField.setForeground(Color.WHITE);



        // this.add(dataInput = new DataInput());
        Font font = new Font("Arial", Font.LAYOUT_LEFT_TO_RIGHT, 20);

        userLabel = new JLabel(USERNAME_LABEL);
        userLabel.setFont(font);
        userLabel.setForeground(Color.WHITE);
        this.add(userLabel);
        userTextField = new JTextField();
        add(userTextField);

        idLabel = new JLabel(ID_LABEL);
        idLabel.setFont(font);
        idLabel.setForeground(Color.WHITE);
        this.add(idLabel);
        idTextField = new JTextField();
        this.add(idTextField);
//        this.setBackground(new Color(80, 30, 30));
        this.setBackground(new Color(130, 35, 35));

        btn = new JButton(BTN_TXT);
        btn.setVerticalAlignment(SwingConstants.CENTER);
        btn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                doClickAction();
            }
        });
//        btn.setPreferredSize(new Dimension(100,100));
        this.add(btn);

        //this.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);

        this.setBackground(new Color(40, 90, 76));
        this.setForeground(new Color(131, 194, 161));

        //setResizable(false);
        setSize(WIDTH, HEIGHT);
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        this.setLocation(dim.width / 2 - this.getSize().width / 2, dim.height / 2 - this.getSize().height / 2);
//        this.setLocationRelativeTo(null);
//        this.pack();

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
    }

    public void doClickAction(){
        MainPage mainPage = new MainPage(userTextField.getText(),idTextField.getText());
        this.setVisible(false);
    }
}
