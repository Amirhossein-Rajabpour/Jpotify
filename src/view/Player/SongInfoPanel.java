package view.Player;

import javax.swing.*;
import java.awt.*;

/**
 * this class show song information like title, artist, artwork and album on the down and left side of the frame
 */
public class SongInfoPanel extends JPanel {

    private JLabel icon;
    private JLabel title;
    private JLabel album;
    private JLabel artist;
    private JPanel data;
    private Color background;
    private Color foreground;
    private Font font1;
    private Font font2;

    public SongInfoPanel() {

        super();
        background = new Color(40, 40, 40);
        foreground = Color.white;

        this.setLayout(new GridLayout(1, 2));
        this.setBackground(background);
        this.font1 = new Font("Arial", Font.ITALIC, 10);
        this.font2 = new Font("Arial", Font.BOLD, 8);

        icon = new JLabel();
        icon.setHorizontalAlignment(SwingConstants.CENTER);
        ImageIcon songArtwork = new ImageIcon("/Users/apple/Desktop/userIcon.png");
        Image image = songArtwork.getImage(); // transform it
        Image newImg = image.getScaledInstance(43, 43, java.awt.Image.SCALE_SMOOTH); // scale it the smooth way
        songArtwork = new ImageIcon(newImg);
        icon.setIcon(songArtwork);
        icon.setForeground(foreground);
        this.add(icon);

        data = new JPanel();
        data.setPreferredSize(new Dimension(80,10));
        data.setLayout(new BorderLayout());
        data.setBackground(background);

        artist = new JLabel("Artist");
        artist.setForeground(foreground);
        artist.setFont(font2);
        data.add(artist, BorderLayout.NORTH);

        title = new JLabel("Title");
        title.setForeground(foreground);
        title.setFont(font1);
        data.add(title, BorderLayout.CENTER);

        album = new JLabel("Album");
        album.setForeground(foreground);
        album.setFont(font2);
        data.add(album, BorderLayout.SOUTH);

        this.add(data);


    }

    /**
     * updates song information on player
     * @param artwork
     * @param title
     * @param artistName
     * @param albumName
     */
    public void refresh(byte[] artwork, String title, String artistName, String albumName) {

        icon.setHorizontalAlignment(SwingConstants.CENTER);
        ImageIcon songArtwork;
        if (artwork != null) {
            songArtwork = new ImageIcon(artwork);
        } else {
            songArtwork = new ImageIcon("/Users/apple/Desktop/userIcon.png");
        }
        Image image = songArtwork.getImage(); // transform it
        Image newImg = image.getScaledInstance(43, 43, java.awt.Image.SCALE_SMOOTH); // scale it the smooth way
        songArtwork = new ImageIcon(newImg);
        icon.setIcon(songArtwork);
        icon.setForeground(Color.white);

        if (title != null) {
            this.title.setText(title);
        } else {
            this.title.setText("Title");
        }

        if (artistName != null) {
            this.artist.setText(artistName);
        } else {
            this.artist.setText("Artist");
        }

        if (albumName != null) {
            this.album.setText(albumName);
        } else {
            this.album.setText("Album");
        }

    }
}
