package view.Center;

import model.Album;
import model.Song;
import view.Player.PlayerPart;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.Objects;

public class AlbumBtn extends JPanel {

    private ArrayList<String> playlistNames;
    private String playlistName;
    private PlayerPart playerPart;
    private ArrayList<Song> songs;
    private ArrayList<Song> showSongs;
    private Color background;
    private Color foreground;
    private Color pressedBackground;
    private Font font1;
    private JLabel name;
    private JPanel data;
    private Album album;
    private JLabel icon;


    public AlbumBtn(ArrayList<Song> songs, Album album, PlayerPart playerPart, ShowPanel showPanel) {

        super();

        this.album = album;
        this.playerPart = playerPart;

        this.songs = songs;
        this.showSongs = new ArrayList<>();

        this.setPreferredSize(new Dimension(130, 155));

        background = new Color(50, 50, 50);
        foreground = new Color(210, 210, 210);
        pressedBackground = new Color(65, 65, 65);
        this.setBackground(background);
        this.setLayout(new BorderLayout());
        this.font1 = new Font("Arial", Font.BOLD, 13);

        data = new JPanel(new FlowLayout());
        data.setBackground(background);
        data.setForeground(foreground);

        name = new JLabel(album.getAlbumName());
        data.add(name);
        name.setForeground(foreground);
        name.setBackground(background);


        icon = new JLabel();

        if (album.getFirstSong() != null) {
            ImageIcon albumImgIcon;
            if (album.getFirstSong().getArtwork() != null) {
                albumImgIcon = new ImageIcon(album.getFirstSong().getArtwork());
            } else {
                albumImgIcon = new ImageIcon("/Users/apple/Desktop/userIcon.png");
            }
            Image img = albumImgIcon.getImage().getScaledInstance(130, 130, java.awt.Image.SCALE_SMOOTH);
            Icon icon1 = new ImageIcon(img);
            icon.setIcon(icon1);

        }
        this.add(icon, BorderLayout.CENTER);

        for (int i = 0; i < songs.size(); i++) {

            if (Objects.equals(songs.get(i).getAlbumName(), album.getAlbumName())) {
                showSongs.add(songs.get(i));
            }

        }


        this.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
            }

            @Override
            public void mousePressed(MouseEvent e) {
                name.setBackground(pressedBackground);
                data.setBackground(pressedBackground);
            }

            @Override
            public void mouseReleased(MouseEvent e) {
                name.setBackground(background);
                data.setBackground(background);
                showPanel.removeAll();
                showPanel.repaint();
                showPanel.setSongs(showSongs);
                showPanel.revalidate();
            }

            @Override
            public void mouseEntered(MouseEvent e) {
            }

            @Override
            public void mouseExited(MouseEvent e) {
            }
        });

        this.add(data, BorderLayout.SOUTH);
    }

}
