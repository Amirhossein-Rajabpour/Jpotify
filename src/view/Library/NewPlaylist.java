package view.Library;

import model.Playlist;
import model.Song;
import view.Library.LibraryPart;

import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

/**
 * this class creates a new playlist and adds that playlist to users songs
 */
public class NewPlaylist extends JFrame {

    private final Color background;
    private JPanel panel;
    private JPanel north;
    private JPanel center;
    private Color foreground;
    private JTextField nameTextField;
    private JLabel nameLabel;
    private JButton create;
    private JCheckBox[] songCheckbox;
    private int arrayListSize;
    private String name;
    private Playlist playlist;


    public NewPlaylist(ArrayList<Song> songs, LibraryPart libraryPart) {

        super();

        foreground = new Color(195, 195, 195);
        background = new Color(59, 63, 63);
        this.setSize(new Dimension(260, 400));
        this.setResizable(false);

        /**
         * panel is the container of north and center panels
         */
        panel = new JPanel();
        panel.setLayout(new BorderLayout());
        panel.setBackground(background);
        this.add(panel);

        /**
         * north panel places at the north of the panel
         */
        north = new JPanel();
        north.setBackground(background);
        north.setLayout(new BorderLayout());

        JPanel empty = new JPanel();
        empty.setBackground(background);
        JLabel emptyLabel = new JLabel();
        empty.add(emptyLabel);
        north.add(empty, BorderLayout.NORTH);
        nameLabel = new JLabel("New Playlist");
        nameLabel.setFont(new Font("Arial", Font.BOLD, 18));
        nameLabel.setForeground(Color.lightGray);
        nameLabel.setHorizontalAlignment(SwingConstants.CENTER);
        north.add(nameLabel, BorderLayout.CENTER);


        nameTextField = new JTextField();
//        nameTextField.setText("Playlist name");
        nameTextField.setForeground(foreground);
        nameTextField.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {
                nameTextField.setText("");
                nameTextField.setForeground(Color.BLACK);
            }

            @Override
            public void focusLost(FocusEvent e) {
//                nameTextField.setText("Playlist name");
                nameTextField.setForeground(foreground);
            }
        });
        north.add(nameTextField, BorderLayout.SOUTH);
        panel.add(north, BorderLayout.NORTH);


        /**
         * center panel places at the center of the panel
         */
        center = new JPanel();

        JScrollPane scrollPane = new JScrollPane(center);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);

        center.setLayout(new GridLayout(songs.size() + 2, 1));
        center.setBackground(new Color(237,237,237));


        arrayListSize = songs.size();
        songCheckbox = new JCheckBox[arrayListSize];
        for (int i = 0; i < arrayListSize; i++) {

            songCheckbox[i] = new JCheckBox(songs.get(i).getTitle());
            center.add(songCheckbox[i]);
        }
        panel.add(scrollPane, BorderLayout.CENTER);

        create = new JButton("create");
        create.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                int exist = 0;
                for(String playlisName: libraryPart.getPlaylistName()){

                    if(nameTextField.equals(playlisName)){
                        exist = 1;
                        setVisible(true);
                    }
                }

                if(nameTextField.getText().equals("")){
                    setVisible(true);
                }

                else if(exist == 0) {

                    name = nameTextField.getText();
                    if (!libraryPart.getPlaylistName().contains(name)) {


//                    playlist = new Playlist(name);

//                for (int i = 0; i < arrayListSize; i++) {
//
//                    if (songCheckbox[i].isSelected()) {
//                        playlist.addSong(songs.get(i));
//                    }
//                }
//                libraryPart.addPlaylist(playlist);

                        /**
                         * here instead of adding songs to playlist, i add playlist to songs(almost like album)
                         */
                        for (int i = 0; i < songs.size(); i++) {

                            if (songCheckbox[i].isSelected()) {
                                songs.get(i).addPlaylist(name);
                            }
                        }
                        for(Song song: songs)
                            libraryPart.saveSong(song);

                        libraryPart.addPlaylistName(name);
//                libraryPart.savePlaylists(playlist);
                        setVisible(false);
                    }else setVisible(false);
                }


            }
        });

        panel.add(create, BorderLayout.SOUTH);


//        setSize(250, 400);
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        this.setLocation(dim.width / 2 - this.getSize().width / 2, dim.height / 2 - this.getSize().height / 2 - 70);
//        pack();
        setVisible(true);
    }

    public Playlist getPlaylist() {
        return this.playlist;
    }

}
