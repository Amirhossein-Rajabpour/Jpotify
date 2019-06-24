package view;

import model.Song;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.HashMap;

public class NewPlaylist extends JFrame {

    private JTextField name;
    private JLabel nameLabel;
    private JButton create;
    private JCheckBox[] songCheckbox;
    private int size;
    private String playlistName;
    HashMap<String,ArrayList<Song>> Playlist = new HashMap<>(); // this HashMap is for Playlist


    public NewPlaylist(ArrayList<Song> songs){

        super();
        setLayout(new FlowLayout());

        nameLabel = new JLabel("what is the name of new playlist");
        add(nameLabel);


        name = new JTextField();
        add(name);

        size = songs.size();
        songCheckbox = new JCheckBox[size];
        for(int i = 0; i < size ; i++){

            songCheckbox[i] = new JCheckBox(songs.get(i).getTitle());
            add(songCheckbox[i]);
        }

        create = new JButton("create");
        create.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                playlistName = name.getText();
                System.out.println(playlistName);

                Playlist = new HashMap<String, ArrayList<Song>>();
                ArrayList<Song> playlistSongs = new ArrayList<>();

                for(int i = 0; i < size; i++){

                    if(songCheckbox[i].isSelected()){
                        playlistSongs.add(songs.get(i));
                        Playlist.put(playlistName,playlistSongs);
                    }
                }
//                for(int i = 0; i < playlistSongs.size() ; i++ )
//                    System.out.println(playlistSongs.get(i).getTitle());
            }
        });
        add(create);

        setSize(400,400);
        setVisible(true);
    }
}
