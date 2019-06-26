package view.Library;

import model.Album;
import model.Playlist;
import model.Song;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

public class RemoveSong extends JFrame {

    private JCheckBox[] songCheckbox;
    private JButton remove;

    public RemoveSong(ArrayList<Song> songs , LibraryPart libraryPart) {

        super();
        setLayout(new FlowLayout());
        setSize(400,400);

        songCheckbox = new JCheckBox[songs.size()];
        for (int i = 0; i < songs.size(); i++) {

            songCheckbox[i] = new JCheckBox(songs.get(i).getTitle());
            add(songCheckbox[i]);
        }

        remove = new JButton("remove");
        add(remove);
        remove.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {


                for (int i = 0; i < songs.size() ; i++  ) {

                    if (songCheckbox[i].isSelected()) {

                        libraryPart.removeSpecificSong(libraryPart.getUsername() + "/songs/" + songs.get(i).getTitle());

                    }
                }

/**
 * this part of code updates library songs and albums.
 */
                try {
                    libraryPart.setSongs(libraryPart.loadSongs(libraryPart.getUsername()));
                    ArrayList<Album> loadedAlbums = new ArrayList<>();
                    for(Song song: libraryPart.loadSongs(libraryPart.getUsername()) )
                    {
                        Album album = new Album(song.getAlbumName());
                        loadedAlbums.add(album);

                    }
                    libraryPart.setAlbums(loadedAlbums);
                } catch (IOException e1) {
                    e1.printStackTrace();
                }

                libraryPart.getShowPanel().revalidate();
                setVisible(false);
            }
        });

        setVisible(true);
    }
}
