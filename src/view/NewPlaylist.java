package view;

import model.Song;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.HashMap;

public class NewPlaylist extends JFrame implements ActionListener {

    private JTextField name;
    private JLabel nameLabel;
    private JButton create;
    private JCheckBox[] songCheckbox;
    private int size;
    private String playlistName;
    private ArrayList<Song> songs;
    HashMap<String,ArrayList<Song>> Playlist = new HashMap<>(); // this HashMap is for Playlist


    public NewPlaylist(ArrayList<Song> songs){

        super();
        this.setLayout(new FlowLayout());

        nameLabel = new JLabel("what is the name of new playlist");
        add(nameLabel);


        name = new JTextField();
        playlistName = name.getText();
        add(name);

        size = songs.size();
        songCheckbox = new JCheckBox[size];
        for(int i = 0; i < size ; i++){

            songCheckbox[i] = new JCheckBox(songs.get(i).getTitle());
            add(songCheckbox[i]);
//            songCheckbox[i].addActionListener(this);
        }

        create = new JButton("create");
        create.addActionListener(this);
        add(create);
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        for(int i = 0; i < size; i++){

            if(songCheckbox[i].isSelected()){
                Playlist.get(playlistName).add(songs.get(i));
            }

        }
    }
}
