package view.Center;

import model.Song;
import view.Library.LibraryPart;
import view.Player.PlayerPart;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

/**
 * this jpanel connects songs to player and songs can be played by clicking them here
 */
public class SongBtn extends JPanel {

    private ArrayList<Song> songs;
    private Song song;
    private int index;
    private PlayerPart playerPart;
    private JLabel icon;
    private JLabel title;
    private JLabel album;
    private JLabel artist;
    private JPanel data;
    private Color background;
    private Color foreground;
    private Color pressedBackground;
    private Font font1;
    private Font font2;


    public SongBtn(PlayerPart playerPart, ArrayList<Song> songs, int index) {

        super();

        this.songs = songs;
        this.index = index;
        this.song = songs.get(index);
        this.playerPart = playerPart;


        background = new Color(50, 50, 50);
        foreground = new Color(210, 210, 210);
        pressedBackground = new Color(65, 65, 65);

//        this.setLayout(new GridLayout(2, 1));
        this.setLayout(new BorderLayout());
        this.setBackground(background);
        this.font1 = new Font("Arial", Font.BOLD, 13);
        this.font2 = new Font("Arial", Font.ITALIC, 11);

        icon = new JLabel();
        icon.setHorizontalAlignment(SwingConstants.CENTER);
        ImageIcon imgIcon;
        if (song.getArtwork() != null) {
            imgIcon = new ImageIcon(song.getArtwork());
        } else {
            imgIcon = new ImageIcon("/Users/apple/Desktop/userIcon.png");
        }
        Image img = imgIcon.getImage().getScaledInstance(130, 130, java.awt.Image.SCALE_SMOOTH);
        Icon icon1 = new ImageIcon(img);
        icon.setIcon(icon1);
        icon.setForeground(foreground);
        this.add(icon, BorderLayout.CENTER);

        data = new JPanel();
//        data.setPreferredSize(new Dimension(80, 10));
        data.setLayout(new BorderLayout());
        data.setBackground(background);

        title = new JLabel(song.getTitle());
        title.setForeground(foreground);
        title.setFont(font1);
        data.add(title, BorderLayout.NORTH);

        artist = new JLabel(song.getArtistName());
        artist.setForeground(foreground);
        artist.setFont(font2);
        data.add(artist, BorderLayout.CENTER);

        album = new JLabel(song.getAlbumName());
        album.setForeground(foreground);
        album.setFont(font2);
        data.add(album, BorderLayout.SOUTH);

        this.add(data, BorderLayout.SOUTH);

        this.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
            }

            @Override
            public void mousePressed(MouseEvent e) {
                icon.setBackground(pressedBackground);
                data.setBackground(pressedBackground);
            }

            @Override
            public void mouseReleased(MouseEvent e) {
                icon.setBackground(background);
                data.setBackground(background);
                playerPart.setSongs(songs, index);
            }

            @Override
            public void mouseEntered(MouseEvent e) {
            }

            @Override
            public void mouseExited(MouseEvent e) {
            }
        });


    }

}
