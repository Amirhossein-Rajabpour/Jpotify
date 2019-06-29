package view;

import network.server.FileServer;
import view.Center.CentralPanel;
import view.Center.ShowPanel;
import view.Friends.FriendActivity;
import view.Library.LibraryPart;
import view.Player.BottomPanel;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;

/**
 * this is programs main page which connects and shows all elements and panels of the program
 */
public class MainPage extends JFrame {

    private String userName;
    private int friendId;
    private LibraryPart library;
    private BottomPanel bottomPanel;
    private CentralPanel centralPanel;
    private FriendActivity friendActivity;
    private ShowPanel showPanel;
    private static final int WIDTH = 780, HEIGHT = 475;

    public MainPage(String userName, int friendId) throws IOException {

        super();
        this.userName = userName;
        this.friendId = friendId;

        this.setLayout(new BorderLayout());
        this.setMinimumSize(new Dimension(WIDTH, HEIGHT));
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        this.setLocation(dim.width / 2 - this.getSize().width / 2, dim.height / 2 - this.getSize().height / 2 - 150);
        this.setBackground(new Color(57, 54, 50));

        bottomPanel = new BottomPanel(friendId);
        this.add(bottomPanel, BorderLayout.SOUTH);


        library = new LibraryPart(getUserName(), bottomPanel.getPlayerPart());

        centralPanel = new CentralPanel(userName, bottomPanel.getPlayerPart(), library);
        this.add(centralPanel, BorderLayout.CENTER);

        library.setShowPanel(centralPanel.getShowPanel());
        JScrollPane jscrollPane = new JScrollPane(library);
        jscrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
        this.add(library, BorderLayout.WEST);


        FileServer fileServer = new FileServer(4422);

        friendActivity = new FriendActivity(bottomPanel.getPlayerPart(), fileServer, friendId);
        JScrollPane scrollPane = new JScrollPane(friendActivity);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
        scrollPane.setBackground(new Color(24, 24, 24));
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
