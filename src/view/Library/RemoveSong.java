package view.Library;

import model.Album;
import model.Song;
import view.Player.PlayerPart;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

/**
 * this class opens a frame and user select what songs to be deleted
 */
public class RemoveSong extends JFrame {

    private JPanel south;
    private JCheckBox[] songCheckbox;
    private JButton remove;
    private PlayerPart playerPart;
    private Color background;
    private JPanel panel;
    private JPanel north;
    private JPanel center;
    private Color foreground;
    private JLabel nameLabel;
    private JButton create;
    private String name;

    public RemoveSong(ArrayList<Song> songs, LibraryPart libraryPart, PlayerPart playerPart) {

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
        nameLabel = new JLabel("Edit songs");
        nameLabel.setFont(new Font("Arial", Font.BOLD, 18));
        nameLabel.setForeground(Color.lightGray);
        nameLabel.setHorizontalAlignment(SwingConstants.CENTER);
        north.add(nameLabel, BorderLayout.CENTER);
        this.add(north,BorderLayout.NORTH);


        /**
         * center panel places at the center of the panel
         */
        center = new JPanel();

        JScrollPane scrollPane = new JScrollPane(center);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);

        center.setLayout(new GridLayout(songs.size() + 2, 1));
        center.setBackground(new Color(237,237,237));


        this.playerPart = playerPart;
        songCheckbox = new JCheckBox[songs.size()];
        for (int i = 0; i < songs.size(); i++) {

            songCheckbox[i] = new JCheckBox(songs.get(i).getTitle());
            center.add(songCheckbox[i]);
        }

        panel.add(scrollPane, BorderLayout.CENTER);


        south = new JPanel();
        south.setBackground(background);
        south.setLayout(new BorderLayout());



        remove = new JButton("Remove");
        south.add(remove, BorderLayout.CENTER);
        remove.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {


                for (int i = 0; i < songs.size(); i++) {

                    if (songCheckbox[i].isSelected()) {

                        libraryPart.removeSpecificSong(libraryPart.getUsername() + "/songs/" + songs.get(i).getTitle());
                        songs.remove(songs.get(i));
                        playerPart.setSongs(songs, 0);
                    }
                }

                libraryPart.setSongs(songs);


/**
 * this part of code updates library songs and albums.
 */
                ArrayList<Album> loadedAlbums = new ArrayList<>();
                for (Song song : songs) {
                    Album album = new Album(song.getAlbumName());

                    loadedAlbums.add(album);
                }
                libraryPart.setAlbums(loadedAlbums);

                libraryPart.getShowPanel().revalidate();
                setVisible(false);
            }
        });
        panel.add(south, BorderLayout.SOUTH);


        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        this.setLocation(dim.width / 2 - this.getSize().width / 2, dim.height / 2 - this.getSize().height / 2 - 70);
        setVisible(true);
    }
}
