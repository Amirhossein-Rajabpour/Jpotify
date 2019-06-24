package view;

import model.Song;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.util.ArrayList;

/**
 * this class is a container which shows songs, albums, playlists and  etc in the middle part of the program
 */
public class ShowPanel extends JPanel {

    private Color background;
    private JButton[] songButtons;
    ArrayList<Song> songs = new ArrayList<>();

    public ShowPanel() {

        super();
        background = new Color(33,33,33);
        this.setLayout(new FlowLayout());
        this.setBackground(background);

        Song song2 = new Song("C:\\Users\\Asus\\Desktop\\Cheri Cheri Lady - Modern Talking.mp3");
        Song song1 = new Song("C:\\Users\\Asus\\Desktop\\50-Cent-Candy-Shop-@Otaghe8Bot.mp3");
        songs.add(song1);
        songs.add(song2);

        songButtons = new JButton[songs.size()];

        for(int i = 0; i < songs.size() ; i++){

//            songButtons[i].addActionListener((ActionListener) this);
            songButtons[i] = new JButton();
            songButtons[i].setSize(100,50);


            ImageIcon imgIcon = new ImageIcon(songs.get(i).getArtwork());
            Image img = imgIcon.getImage().getScaledInstance(40,40,i);
            Icon icon = new ImageIcon(img);
            songButtons[i].setIcon(icon);


            songButtons[i].setText(songs.get(i).getTitle() + "\n" + songs.get(i).getArtistName() + "\n" + songs.get(i).getAlbumName());
            add(songButtons[i]);
            this.add(Box.createRigidArea(new Dimension(10, 10)));
        }


        setVisible(true);
    }
}
