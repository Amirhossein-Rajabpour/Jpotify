package view.Friends;

import network.server.FileServer;
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

    public FriendActivity(PlayerPart playerPart, FileServer fileServer, int friendId) {
        super();

        this.playerPart = playerPart;
        this.fileServer = fileServer;


        Sfont = new Font("Arial", Font.BOLD, 11);
        Bfont = new Font("Arial", Font.BOLD, 9);
        background = new Color(24, 24, 24);
        foreground = new Color(179, 179, 179);
        pressedBackground = new Color(45, 45, 45);

        this.setMaximumSize(new Dimension(200, 700));
        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
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

    public void addNewParticipant(String fName, String title, byte[] fFile) {

        this.name = fName;
        this.file = fFile;
        FriendBtn name = new FriendBtn(fName, title, Bfont, Sfont, background, foreground, pressedBackground, file);

        this.add(name);

    }
}
