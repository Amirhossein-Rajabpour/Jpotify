package view;

import view.MainPage;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;

/**
 * this is login page which reads username and user's friends id for networking
 */
public class WelcomePage extends JFrame {

    private static final int WIDTH = 350, HEIGHT = 500;

    private Color background;
    private Color foreground;

    private static final String MAIN_WELCOME_TXT = "Jpotify®";
    private JLabel jLabel;
    private JLabel icon;

    private static final String WELCOME_TXT1 = "Millions of songs.";
    private JLabel msg1;
    private static final String WELCOME_TXT2 = "Free on Jpotify.";
    private JLabel msg2;

    private static final String USERNAME_LABEL = "Username";
    private JLabel userLabel;
    private JTextField userTextField;

    private static final String ID_LABEL = "Friend's ID";
    private JLabel idLabel;
    private JTextField idTextField;

    private static final String BTN_TXT = "LOG IN";
    private JButton btn;

    public WelcomePage() {
        super();

        this.setLayout(new BorderLayout());

        background = new Color(49, 53, 53);
        foreground = new Color(195, 195, 195);


        /**
         * north panel places at the top of the welcomePage
         * contains icon & JLabel
         */
        JPanel north = new JPanel();
        north.setLayout(new GridLayout(3, 1));
        north.setBackground(background);

        icon = new JLabel();
        icon.setHorizontalAlignment(SwingConstants.CENTER);
        ImageIcon JpotifyIcon = new ImageIcon("/Users/apple/Desktop/JpotifyWhite.png");
        Image image = JpotifyIcon.getImage(); // transform it
        Image newimg = image.getScaledInstance(38, 38, java.awt.Image.SCALE_SMOOTH); // scale it the smooth way
        JpotifyIcon = new ImageIcon(newimg);
        icon.setIcon(JpotifyIcon);
        icon.setForeground(Color.white);
        north.add(icon);

        jLabel = new JLabel(MAIN_WELCOME_TXT);
        Font font1 = new Font("Arial", Font.BOLD, 48);
        jLabel.setFont(font1);
        jLabel.setForeground(Color.white);
        jLabel.setHorizontalAlignment(SwingConstants.CENTER);
        north.add(jLabel);

        this.add(north, BorderLayout.NORTH);


        /**
         * center panel places at the center of the view.WelcomePage
         * contains msg1 & msg2
         */
        JPanel center = new JPanel();
        center.setLayout(new GridLayout(6, 1));
        center.setBackground(background);


        center.add(Box.createRigidArea(new Dimension(0, 5)));

        Font font2 = new Font("Arial", Font.BOLD, 24);
        msg1 = new JLabel();
        msg1.setFont(font2);
        msg1.setText(WELCOME_TXT1);
        msg1.setHorizontalAlignment((int) CENTER_ALIGNMENT);
        msg1.setForeground(Color.WHITE);
        msg1.setBackground(this.getBackground());
        center.add(msg1);

        msg2 = new JLabel();
        msg2.setFont(font2);
        msg2.setText(WELCOME_TXT2);
        msg2.setHorizontalAlignment((int) CENTER_ALIGNMENT);
        msg2.setForeground(Color.WHITE);
        center.add(msg2);

        center.add(Box.createRigidArea(new Dimension(0, 5)));
        center.add(Box.createRigidArea(new Dimension(0, 5)));
        center.add(Box.createRigidArea(new Dimension(0, 5)));
        this.add(center, BorderLayout.CENTER);


        Font font = new Font("Arial", Font.LAYOUT_LEFT_TO_RIGHT, 14);

        /**
         * south panel places at the bottom of the view.WelcomePage
         * contains userLabel & userTextField & idLabel & idTextField & btn
         */
        JPanel south = new JPanel();
        south.setLayout(new BoxLayout(south, BoxLayout.Y_AXIS));
        south.setBackground(background);

        userLabel = new JLabel(USERNAME_LABEL);
        userLabel.setFont(font);
        userLabel.setForeground(Color.WHITE);
        south.add(userLabel);
        userTextField = new JTextField();
        userTextField.setForeground(foreground);
        userTextField.setBackground(new Color(255, 255, 255, 14));
        south.add(userTextField);

        south.add(Box.createRigidArea(new Dimension(0, 15)));

        idLabel = new JLabel(ID_LABEL);
        idLabel.setFont(font);
        idLabel.setForeground(Color.WHITE);
        south.add(idLabel);
        idTextField = new JTextField();
        idTextField.setForeground(foreground);
        idTextField.setBackground(new Color(255, 255, 255, 14));
        south.add(idTextField);

        south.add(Box.createRigidArea(new Dimension(0, 25)));

        btn = new JButton(BTN_TXT);
        btn.setHorizontalAlignment(SwingConstants.CENTER);
        btn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    doClickAction();
                } catch (IOException e1) {
                    e1.printStackTrace();
                }
            }
        });
        south.add(btn);
        this.add(south, BorderLayout.SOUTH);


        setResizable(false);
        setSize(WIDTH, HEIGHT);
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        this.setLocation(dim.width / 2 - this.getSize().width / 2, dim.height / 2 - this.getSize().height / 2 - 70);

        this.setBackground(new Color(49, 53, 53));
        this.setForeground(new Color(49, 53, 53));
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
    }

    public void doClickAction() throws IOException {

        if (!userTextField.getText().equals("")) {
            if (new File(userTextField.getText()).exists()) {

            } else {
                new File(userTextField.getText()).mkdir();
                new File(userTextField.getText() + "/songs/").mkdir();
            }
            int id = Integer.parseInt(idTextField.getText());
            MainPage mainPage = new MainPage(userTextField.getText(), id);
            this.setVisible(false);
        }


    }
}
