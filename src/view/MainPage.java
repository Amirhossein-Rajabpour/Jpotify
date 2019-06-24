package view;

import javax.swing.*;
import java.awt.*;

public class MainPage extends JFrame {

    private String userName;
    private String friendsId;
    private LibraryPart Library;
    private BottomPanel bottomPanel;
    private CentralPanel centralPanel;
    private FriendActivity friendActivity;
    private ShowPanel showPanel;
    private static final int WIDTH = 780, HEIGHT = 475;

    public MainPage(String userName, String friendsId) {

        super();
        this.userName = userName;
        this.friendsId = friendsId;

        this.setLayout(new BorderLayout());
        this.setMinimumSize(new Dimension(WIDTH, HEIGHT));
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        this.setLocation(dim.width / 2 - this.getSize().width / 2, dim.height / 2 - this.getSize().height / 2 - 150);
        this.setBackground(new Color(57, 54, 50));

        centralPanel = new CentralPanel(userName);
        this.add(centralPanel, BorderLayout.CENTER);

        Library = new LibraryPart();
        Library.setShowPanel(centralPanel.getShowPanel());
        this.add(new JScrollPane(Library), BorderLayout.WEST);

//        centralPanel.setShowPanel(Library.getShowPanel());


//        friendActivity = new FriendActivity();
//        this.add(friendActivity,BorderLayout.EAST);


        bottomPanel = new BottomPanel();
        this.add(bottomPanel, BorderLayout.SOUTH);

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);


    }
}
