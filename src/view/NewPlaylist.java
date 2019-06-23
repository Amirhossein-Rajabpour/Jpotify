package view;

import model.Song;
import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class NewPlaylist extends JFrame {

    JTextField name;
    JLabel nameLabel;
    JButton create;

    public NewPlaylist(ArrayList<Song> songs){

        super();
        this.setLayout(new FlowLayout());

        nameLabel = new JLabel("what is the name of new playlist");
        name = new JTextField();

        int size = songs.size();
        JCheckBox[] songCheckbox = new JCheckBox[size];
        for(int i = 0; i < size ; i++){

            songCheckbox[i] = new JCheckBox(songs.get(i).getTitle());
        }
    }
    
}
