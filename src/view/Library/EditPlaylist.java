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
    private Playlist Playlist;

    public EditPlaylist(ArrayList<Song> songs, PlaylistBtn playlistBtn) {

        super();
        setLayout(new FlowLayout());

        nameLabel = new JLabel("Edit your playlist name and songs");
        add(nameLabel);

        nameTextfield = new JTextField();
        nameTextfield.setText(playlistBtn.getPlaylistName());
        add(nameTextfield);

        allSongsChechbox = new JCheckBox[songs.size()];

        for (int i = 0; i < songs.size(); i++) {

            allSongsChechbox[i] = new JCheckBox(songs.get(i).getTitle());
            add(allSongsChechbox[i]);
        }


        for(int i = 0; i < songs.size() ;  i++){
            for (int j = 0; j < songs.get(i).getPlaylists().size(); j++) {

                if (Objects.equals(songs.get(i).getPlaylists().get(j).getPlaylistName(), playlistBtn.getPlaylistName()))
                    allSongsChechbox[i].isSelected();
            }
        }

        editButton = new JButton("Edit");
        add(editButton);
        editButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                playlistBtn.setPlaylistName(nameTextfield.getText());

                for(int i = 0; i < songs.size() ; i++){
                    if(allSongsChechbox[i].isSelected()){
                        songs.get(i).addPlaylist(returnPlaylist(songs, playlistBtn));
                    }
                }
                setVisible(false);
            }
        });

        setVisible(true);
    }

    /**
     * this method returns the playlist which is common in playlistBtn and songs playlist arraylist
     * @param songs
     * @param playlistBtn
     * @return
     */
    public Playlist returnPlaylist(ArrayList<Song> songs , PlaylistBtn playlistBtn){

        outer : for(int i = 0; i < songs.size() ;  i++){
                      for (int j = 0; j < songs.get(i).getPlaylists().size(); j++) {

                          if (Objects.equals(songs.get(i).getPlaylists().get(j).getPlaylistName(), playlistBtn.getPlaylistName()))
                             return songs.get(i).getPlaylists().get(j);
                             break outer;
                      }
                 }

        return null;
    }
}
