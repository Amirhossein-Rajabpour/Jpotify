package view.Library;

import model.Playlist;
import model.Song;
import view.Center.PlaylistBtn;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Objects;

/**
 * this frame edits playlists name and songs and user can remove and add songs
 * to each playlist and even change playlist name here
 */
public class EditPlaylist extends JFrame {

    private JCheckBox[] allSongsChechbox;
    private JTextField nameTextfield;
    private JLabel nameLabel;
    private JButton editButton;
    private JButton deletePlaylist;
    private Playlist Playlist;

    public EditPlaylist(ArrayList<Song> songs, String playlisName  , LibraryPart libraryPart) {

        super();
        setLayout(new FlowLayout());
        setSize(300,300);

        nameLabel = new JLabel("Edit your playlist name and songs");
        add(nameLabel);

        nameTextfield = new JTextField();
        nameTextfield.setText(playlisName);
        add(nameTextfield);

        allSongsChechbox = new JCheckBox[songs.size()];

        for (int i = 0; i < songs.size(); i++) {

            allSongsChechbox[i] = new JCheckBox(songs.get(i).getTitle());
            add(allSongsChechbox[i]);
        }


        for(int i = 0; i < songs.size() ;  i++){
            for (int j = 0; j < songs.get(i).getPlaylists().size(); j++) {

                if (Objects.equals(songs.get(i).getPlaylists().get(j), playlisName)) {
                    allSongsChechbox[i].setSelected(true);
                }
            }
        }

        editButton = new JButton("Edit");
        add(editButton);
        editButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                libraryPart.addPlaylistName(nameTextfield.getText());
                for (int j = 0; j < songs.size(); j++)
                    songs.get(j).removePlaylist(playlisName);

                for (int i = 0; i < songs.size(); i++) {
                    if (allSongsChechbox[i].isSelected()) {
                        songs.get(i).addPlaylist(nameTextfield.getText());
                    }
                }
                libraryPart.getPlaylistName().remove(playlisName);
                setVisible(false);
            }
        });

        deletePlaylist = new JButton("Remove playlist");
        add(deletePlaylist);
//        deletePlaylist.addActionListener(new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent e) {
//
//                for(int j = 0; j < songs.size(); j++)
//                    songs.get(j).removePlaylist(returnPlaylist(songs,playlisName));
//
//                setVisible(false);
//            }
//        });
//
        setVisible(true);
//    }

    }
}
