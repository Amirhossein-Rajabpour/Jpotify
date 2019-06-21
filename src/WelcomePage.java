import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Welcome page class is the first page that user sees and
 * user enter his name and friends id for connecting to the server
 */

public class WelcomePage extends JFrame {
    private static final int WIDTH = 400, HEIGHT = 200;
    private JLabel welcomeLabel;
    private JLabel userLabel;
    private JTextField userTextField;
    private JLabel IDLabel;
    private JTextField IDTextField;
    private JButton EnterBtn;
    private FlowLayout layout;


    public WelcomePage() throws HeadlessException {
        super();
        layout = new FlowLayout();
        this.setLayout(layout);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        layout.setAlignment(FlowLayout.CENTER);
        setSize(WIDTH + 100, HEIGHT);
        this.setTitle("JPotify");
//        this.setPreferredSize(new Dimension(WelcomePage.WIDTH, 40));

        Dimension labelDimension = new Dimension(WIDTH - (WIDTH)/3, 30);
        Dimension textFieldDimension = new Dimension(WIDTH - (WIDTH)/2, 30);


        welcomeLabel = new JLabel("welcome to the jpotify!!");
        welcomeLabel.setPreferredSize(labelDimension);
        add(welcomeLabel);

        userLabel = new JLabel(" Choose Your UserName  ");
        userLabel.setPreferredSize(labelDimension);
        add(userLabel);
/**
 * this textField gets the username
 */
        userTextField = new JTextField();
        userTextField.setPreferredSize(textFieldDimension);
//        textField.setBounds(50,100, 200,30);
        add(userTextField);

        IDLabel = new JLabel(" enter your friends ID ");
        IDLabel.setPreferredSize(labelDimension);
        add(IDLabel);
/**
 * this textField gets friends id for server connection
 */
        IDTextField = new JTextField();
        IDTextField.setPreferredSize(textFieldDimension);
        add(IDTextField);


        EnterBtn = new JButton("Enter!",new ImageIcon("success.png"));
        EnterBtn.setBounds(40,100,50,30);
//        btn.setPreferredSize(new Dimension(WelcomePage.WIDTH - (WelcomePage.WIDTH)/2, 20));
        EnterBtn.setToolTipText("click here");
        add(EnterBtn);


        setVisible(true);

    }
}
