package view.Center;

import model.Song;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SongBtn extends JButton {

    private Song song;
    private int index;


    public SongBtn(Song song, int index) {

        super();
        this.song = song;
        this.index = index;

        this.setSize(new Dimension(100,50));
        ImageIcon imgIcon;
        if (song.getArtwork() != null) {
            imgIcon = new ImageIcon(song.getArtwork());
        } else {
            imgIcon = new ImageIcon("/Users/apple/Desktop/userIcon.png");
        }
        Image img = imgIcon.getImage().getScaledInstance(40, 40, index);
        Icon icon = new ImageIcon(img);
        this.setIcon(icon);


        this.setText(song.getTitle() + "\n" + song.getArtistName() + "\n" + song.getAlbumName());
        this.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
    }

}
