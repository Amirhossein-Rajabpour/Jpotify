package view;

import view.Center.CentralPanel;
import view.Center.ShowPanel;
import view.Friends.FriendActivity;
import view.Library.LibraryPart;
import view.Player.BottomPanel;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;

public class MainPage extends JFrame {

    private String userName;
    private String friendsId;
    private LibraryPart library;
    private BottomPanel bottomPanel;
    private CentralPanel centralPanel;
    private FriendActivity friendActivity;
    private ShowPanel showPanel;
    private static final int WIDTH = 780, HEIGHT = 475;

    public MainPage(String userName, String friendsId) throws IOException {

        super();
        this.userName = userName;
        this.friendsId = friendsId;

        this.setLayout(new BorderLayout());
        this.setMinimumSize(new Dimension(WIDTH, HEIGHT));
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        this.setLocation(dim.width / 2 - this.getSize().width / 2, dim.height / 2 - this.getSize().height / 2 - 150);
        this.setBackground(new Color(57, 54, 50));

        bottomPanel = new BottomPanel();
        this.add(bottomPanel, BorderLayout.SOUTH);

        centralPanel = new CentralPanel(userName, bottomPanel.getPlayerPart());
        this.add(centralPanel, BorderLayout.CENTER);

        library = new LibraryPart(getUserName(), bottomPanel.getPlayerPart());
        library.setShowPanel(centralPanel.getShowPanel());
        JScrollPane jscrollPane = new JScrollPane(library);
        jscrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
        this.add(jscrollPane, BorderLayout.WEST);


        friendActivity = new FriendActivity();
        JScrollPane scrollPane = new JScrollPane(friendActivity);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
        this.add(scrollPane, BorderLayout.EAST);


        SwingUtilities.updateComponentTreeUI(this);

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.revalidate();
        this.setVisible(true);

    }

    public String getUserName() {
        return userName;
    }
}
