package view.Library;

import model.Playlist;
import model.Song;
import view.Center.PlaylistBtn;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.util.ArrayList;
import java.util.Objects;

/**
 * this frame edits playlists name and songs and user can remove and add songs
 * to each playlist and even change playlist name here
 */
public class EditPlaylist extends JFrame {

    private JTextField nameTextField;
    private JCheckBox[] allSongsChechbox;
    private JLabel nameLabel;
    private JButton editButton;
    private JButton deletePlaylist;
    private Playlist Playlist;
    private Color background;
    private Color foreground;
    private JPanel panel;
    private JPanel north;
    private JPanel center;
    private JPanel south;

    public EditPlaylist(ArrayList<Song> songs, String playlisName, LibraryPart libraryPart) {

        super();
        setLayout(new FlowLayout());
        foreground = new Color(195, 195, 195);
        background = new Color(59, 63, 63);
        this.setSize(new Dimension(260, 400));
        this.setResizable(false);

        this.setBackground(background);

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

        nameLabel = new JLabel("Edit playlist name and songs");
        nameLabel.setFont(new Font("Arial", Font.BOLD, 18));
        nameLabel.setForeground(Color.lightGray);
        nameLabel.setHorizontalAlignment(SwingConstants.CENTER);
        north.add(nameLabel, BorderLayout.CENTER);


        nameTextField = new JTextField();
        nameTextField.setForeground(foreground);
        nameTextField.setText(playlisName);
        north.add(nameTextField, BorderLayout.SOUTH);
        panel.add(north, BorderLayout.NORTH);


        /**
         * center panel places at the center of the panel
         */
        center = new JPanel();

        JScrollPane scrollPane = new JScrollPane(center);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);

        center.setLayout(new GridLayout(songs.size() + 2, 1));
        center.setBackground(new Color(237, 237, 237));


        allSongsChechbox = new JCheckBox[songs.size()];

        for (int i = 0; i < songs.size(); i++) {

            allSongsChechbox[i] = new JCheckBox(songs.get(i).getTitle());
            center.add(allSongsChechbox[i]);
        }


        for (int i = 0; i < songs.size(); i++) {
            for (int j = 0; j < songs.get(i).getPlaylists().size(); j++) {

                if (Objects.equals(songs.get(i).getPlaylists().get(j), playlisName)) {
                    allSongsChechbox[i].setSelected(true);
                }
            }
        }

        panel.add(scrollPane, BorderLayout.CENTER);


        south = new JPanel();
        south.setBackground(background);
        south.setLayout(new BorderLayout());

        editButton = new JButton("Edit songs & name");
        south.add(editButton, BorderLayout.CENTER);

        editButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                libraryPart.addPlaylistName(nameTextField.getText());
                for (int j = 0; j < songs.size(); j++)
                    songs.get(j).removePlaylist(playlisName);

                for (int i = 0; i < songs.size(); i++) {
                    if (allSongsChechbox[i].isSelected()) {
                        songs.get(i).addPlaylist(nameTextField.getText());
                    }
                }
                libraryPart.getPlaylistName().remove(playlisName);

                for (Song song : songs)
                    libraryPart.saveSong(song);
                setVisible(false);
            }
        });

        deletePlaylist = new JButton("Remove playlist");
        south.add(deletePlaylist, BorderLayout.SOUTH);
        deletePlaylist.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                for (int j = 0; j < songs.size(); j++)
                    songs.get(j).removePlaylist(nameTextField.getText());

                libraryPart.getPlaylistName().remove(playlisName);
                for (Song song : songs)
                    libraryPart.saveSong(song);
                setVisible(false);
            }
        });
        panel.add(south, BorderLayout.SOUTH);

        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        this.setLocation(dim.width / 2 - this.getSize().width / 2, dim.height / 2 - this.getSize().height / 2 - 70);
        setVisible(true);
    }
}