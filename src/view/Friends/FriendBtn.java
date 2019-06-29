package view.Friends;

import model.Song;
import view.Library.LibraryPart;
import view.Player.PlayerPart;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

public class FriendBtn extends JTextField {

    private Color background;
    private Color foreground;
    private Color pressedBackground;
    private Font Bfont;
    private Font Sfont;
    private String name;
    private String title;
    private byte[] file;
    private ArrayList<Song> songs;
    private Song song;
    private LibraryPart library;

    public FriendBtn(Font BFont, Font SFont, Color background, Color foreground, Color pressedBackground, String path, PlayerPart playerPart, LibraryPart library) {

        this.background = background;
        this.foreground = foreground;
        this.pressedBackground = pressedBackground;
        this.name = name;
        this.title = title;
        this.Bfont = BFont;
        this.Sfont = SFont;
        this.file = file;
        this.setPreferredSize(new Dimension(10,10));

        songs = new ArrayList<Song>();
        song = new Song(path);
        songs.add(song);
        name = song.getTitle();

        this.setText(name);
        this.setFont(BFont);
        this.setEditable(false);
        this.setBackground(background);
        this.setForeground(foreground);

        repaint();
        revalidate();

        this.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
            }

            @Override
            public void mousePressed(MouseEvent e) {
                setBackground(pressedBackground);
            }

            @Override
            public void mouseReleased(MouseEvent e) {
                repaint();
                revalidate();
                setBackground(getBackground());
                library.addSong(path);
//                playerPart.setSongs(songs, 0);
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
