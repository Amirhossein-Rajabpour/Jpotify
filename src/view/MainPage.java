package view;

import javax.swing.*;
import java.awt.*;

public class MainPage extends JFrame {

    private String userName;
    private String friendsId;
    private JFrame mainFrame;
    private LibraryPart Library;
    private PlayerPart playerPart;
    private CentralPanel centralPanel;
    private FriendActivity friendActivity;
    //    private ToolBar toolBar;
    private static final int WIDTH = 680, HEIGHT = 405;

    public MainPage(String userName, String friendsId) {

        super();
        this.userName = userName;
        this.friendsId = friendsId;

        this.setLayout(new BorderLayout());
        this.setSize(WIDTH, HEIGHT);
//        this.setLocation(300,100);
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        this.setLocation(dim.width / 2 - this.getSize().width / 2, dim.height / 2 - this.getSize().height / 2 - 150);
        this.setBackground(new Color(57, 54, 50));

//        toolBar = new ToolBar();
//        this.add(toolBar,BorderLayout.NORTH);

        Library = new LibraryPart();
        this.add(new JScrollPane(Library), BorderLayout.WEST);

        centralPanel = new CentralPanel(userName);
        this.add(centralPanel, BorderLayout.CENTER);

        friendActivity = new FriendActivity();
        this.add(friendActivity,BorderLayout.EAST);

        playerPart = new PlayerPart();
        this.add(playerPart, BorderLayout.SOUTH);


        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);


    }
}
