package view.Center;

import model.Song;
import view.Player.PlayerPart;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.Objects;

/**
 * playlists are shown in the center through jpanels
 */
public class PlaylistBtn extends JPanel {

    private JLabel icon;
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

    public PlaylistBtn(ArrayList<Song> songs, String playlistName, PlayerPart playerPart, ShowPanel showPanel) {

        super();
        this.playerPart = playerPart;
        this.playlistName = playlistName;
        this.songs = songs;
        this.showSongs = new ArrayList<>();

        this.setPreferredSize(new Dimension(130, 145));

        background = new Color(50, 50, 50);
        foreground = new Color(210, 210, 210);
        pressedBackground = new Color(65, 65, 65);
        this.setBackground(background);
        this.font1 = new Font("Arial", Font.BOLD, 13);

        data = new JPanel(new FlowLayout());
        data.setBackground(background);
        data.setForeground(foreground);
        this.setLayout(new BorderLayout());

        name = new JLabel(playlistName);
        data.add(name);
        name.setForeground(foreground);
        name.setBackground(background);


        for (int i = 0; i < songs.size(); i++) {

            for (int j = 0; j < songs.get(i).getPlaylists().size(); j++) {

                if (Objects.equals(songs.get(i).getPlaylists().get(j).getPlaylistName(), playlistName)) {
                    showSongs.add(songs.get(i));
                }
            }

        }

        icon = new JLabel();

        if (showSongs.get(0) != null) {
            ImageIcon albumImgIcon;
            if (showSongs.get(0).getArtwork() != null) {
                albumImgIcon = new ImageIcon(showSongs.get(0).getArtwork());
            } else {
                albumImgIcon = new ImageIcon("/Users/apple/Desktop/userIcon.png");
            }
            Image img = albumImgIcon.getImage().getScaledInstance(130, 130, java.awt.Image.SCALE_SMOOTH);
            Icon icon1 = new ImageIcon(img);
            icon.setIcon(icon1);

        }
        this.add(icon, BorderLayout.CENTER);

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

        this.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent me) {
                if (me.getButton() == MouseEvent.BUTTON3) {
                    JFrame editFrame = new JFrame();
                    editFrame.setPreferredSize(new Dimension(400, 400));
                    editFrame.setVisible(true);
                    System.out.println("salam");
                }
            }
        });

        this.add(data, BorderLayout.SOUTH);


    }
}
