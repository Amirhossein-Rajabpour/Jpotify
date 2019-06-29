package view.Friends;

import network.server.FileServer;
import view.Library.LibraryPart;
import view.Player.PlayerPart;

import javax.swing.*;
import java.awt.*;

/**
 * this panel shows friends activities through network connection
 */
public class FriendActivity extends JPanel {

    private JLabel friendActivity;
    private static final String FRIENDACTIVITY_LABEL = "  Friend Activity          ";
    private JSeparator jSeparator;
    private Color background;
    private Color foreground;
    private Color pressedBackground;
    private Font Bfont;
    private Font Sfont;
    private String name;
    private byte[] file;
    private PlayerPart playerPart;
    private FileServer fileServer;
    private LibraryPart library;

    public FriendActivity(PlayerPart playerPart, LibraryPart libraryPart) {
        super();

        this.playerPart = playerPart;
        this.fileServer = fileServer;
        this.library = libraryPart;


        Sfont = new Font("Arial", Font.BOLD, 11);
        Bfont = new Font("Arial", Font.BOLD, 9);
        background = new Color(24, 24, 24);
        foreground = new Color(179, 179, 179);
        pressedBackground = new Color(45, 45, 45);

        this.setMaximumSize(new Dimension(120, 500));
        this.setMinimumSize(new Dimension(200, 700));
        this.setLayout(new GridLayout(25,1));
        this.setBackground(background);

        add(Box.createRigidArea(new Dimension(0, 5)));
        add(Box.createRigidArea(new Dimension(0, 5)));

        friendActivity = new JLabel(FRIENDACTIVITY_LABEL);
        friendActivity.setFont(new Font("Arial", Font.BOLD, 10));
        friendActivity.setForeground(Color.white);
        this.add(friendActivity);

        jSeparator = new JSeparator(SwingConstants.HORIZONTAL);
        jSeparator.setForeground(new Color(39, 39, 39));
        this.add(jSeparator);
    }

    public void addNewParticipant( String path) {

        FriendBtn name = new FriendBtn( Bfont, Sfont, background, foreground, pressedBackground, path, playerPart, library);

//        removeAll();
//        repaint();
        this.add(name);
        this.revalidate();

    }
}
