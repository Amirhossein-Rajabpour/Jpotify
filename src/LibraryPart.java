import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * This JPanel is the left part of our program which includes library and playlists
 */

public class LibraryPart extends JPanel {

    private JFrame libraryFrame;
    private JLabel libraryLabel;
    private JButton fileChooserBtn;
    private JButton songsBtn;
    private JButton albumsBtn;
    private JLabel playlistLabel;
    private JButton newPlaylistBtn;
    private JButton sharedPlaylistBtn;
    private JButton favouriteBtn;


    public LibraryPart(){

        super();
        setSize(100,400);
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

        Dimension dimension = new Dimension(this.WIDTH - 20, 30);

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

        libraryLabel = new JLabel("Library");
        libraryLabel.setPreferredSize(dimension);
        libraryLabel.setAlignmentX(RIGHT_ALIGNMENT);
        add(libraryLabel);
        add(Box.createRigidArea(new Dimension(0, 5)));

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
 * This button is for adding e new song to the program
 */
        fileChooserBtn = new JButton("Add to library");
        fileChooserBtn.setPreferredSize(dimension);
        fileChooserBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
        fileChooserBtn.setAlignmentX(CENTER_ALIGNMENT);
        add(fileChooserBtn);
        add(Box.createRigidArea(new Dimension(0, 5)));


/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
 * This button shows all existed songs according to last time played
 */
        songsBtn = new JButton("Songs");
        songsBtn.setPreferredSize(new Dimension(100,100));
        songsBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
        songsBtn.setAlignmentX(CENTER_ALIGNMENT);
        add(songsBtn);
        add(Box.createRigidArea(new Dimension(0, 5)));

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
 * This button shows all albums according to last time played
 */
        albumsBtn = new JButton("Albums");
//        albumsBtn.setPreferredSize(dimension);
        albumsBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
        albumsBtn.setAlignmentX(CENTER_ALIGNMENT);
        add(albumsBtn);
        add(Box.createRigidArea(new Dimension(0, 10)));

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

        JSeparator separator = new JSeparator();
//        separator.setPreferredSize(dimension);
//        add(separator);

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

        playlistLabel = new JLabel("PlayLists");
//        playlistLabel.setPreferredSize(dimension);
        playlistLabel.setAlignmentX(RIGHT_ALIGNMENT);
        add(playlistLabel);
        add(Box.createRigidArea(new Dimension(0, 5)));

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
 * This button creates and adds a new playlist
 */
        newPlaylistBtn = new JButton("New Playlist");
//        newPlaylistBtn.setPreferredSize(dimension);
        newPlaylistBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
        newPlaylistBtn.setAlignmentX(CENTER_ALIGNMENT);
        add(newPlaylistBtn);
        add(Box.createRigidArea(new Dimension(0, 5)));

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
 * This buttons shows user's shared playlist on network
 */
        sharedPlaylistBtn = new JButton("Shared Playlist");
//        sharedPlaylistBtn.setPreferredSize(dimension);
        sharedPlaylistBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
        sharedPlaylistBtn.setAlignmentX(CENTER_ALIGNMENT);
        add(sharedPlaylistBtn);
        add(Box.createRigidArea(new Dimension(0, 5)));

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
 * Every user has some favourite songs which is shown by this button
 */
        favouriteBtn = new JButton("Favourites");
//        favouriteBtn.setPreferredSize(dimension);
        favouriteBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
        favouriteBtn.setAlignmentX(CENTER_ALIGNMENT);
        add(favouriteBtn);
        add(Box.createRigidArea(new Dimension(0, 5)));


        setVisible(true);


    }




}
