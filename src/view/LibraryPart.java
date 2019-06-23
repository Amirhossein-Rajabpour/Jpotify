package view;

import com.mpatric.mp3agic.*;
import model.Song;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

/**
 * This JPanel is the left part of our program which includes library and playlists
 */

public class LibraryPart extends JPanel {

    private JLabel libraryLabel;
    private JButton fileChooserBtn;
    private JButton songsBtn;
    private JButton albumsBtn;
    private JLabel playlistLabel;
    private JButton newPlaylistBtn;
    private JButton sharedPlaylistBtn;
    private JButton favouriteBtn;
    private Song song;
    private JList<String> buttonList;

    ArrayList<Song> songs = new ArrayList<>();
    ArrayList<Song> favouriteSongs = new ArrayList<>();
    HashMap<String,ArrayList<Song>> Album = new HashMap<>();


    public LibraryPart(){

        super();
        setSize(120,400);
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        this.setBackground(Color.black);
        buttonList = new JList<>();


        libraryLabel = new JLabel("Library     ");
        libraryLabel.setAlignmentX(RIGHT_ALIGNMENT);
        libraryLabel.setForeground(Color.white);
        buttonList.add(libraryLabel);
        add(buttonList);
//        add(libraryLabel);
//        add(Box.createRigidArea(new Dimension(0, 5)));


/**
 * This button is for adding a new song to the program
 */
        fileChooserBtn = new JButton(" Add to library ");
        fileChooserBtn.setPreferredSize(new Dimension(5,40));

        fileChooserBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                JFileChooser fileChooser = new JFileChooser();
                fileChooser.setCurrentDirectory(new File("E:/"));
                int result = fileChooser.showOpenDialog(fileChooser);
                if (result == JFileChooser.APPROVE_OPTION) {
                    File selectedFile = fileChooser.getSelectedFile();
                    System.out.println("Selected file: " + selectedFile.getAbsolutePath());
                    addSong(selectedFile.getAbsolutePath());
                    System.out.println(song.getPath());
                }
            }
        });

        fileChooserBtn.setBackground(Color.black);
        fileChooserBtn.setForeground(Color.WHITE);
        fileChooserBtn.setAlignmentX(CENTER_ALIGNMENT);
        add(fileChooserBtn);
//        add(Box.createRigidArea(new Dimension(0, 5)));
//        buttonList.add(fileChooserBtn);
//        add(buttonList);


/**
 * This button shows all existed songs according to last time played
 */
        songsBtn = new JButton("       Songs       ");
        songsBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                System.out.println(songs);

            }
        });
        songsBtn.setBackground(Color.black);
        songsBtn.setForeground(Color.WHITE);
        songsBtn.setAlignmentX(CENTER_ALIGNMENT);
        add(songsBtn);
        add(Box.createRigidArea(new Dimension(0, 5)));


/**
 * This button shows all albums according to last time played
 */
        albumsBtn = new JButton("      Albums      ");

        albumsBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
        albumsBtn.setBackground(Color.black);
        albumsBtn.setForeground(Color.WHITE);
        albumsBtn.setAlignmentX(CENTER_ALIGNMENT);
        add(albumsBtn);
        add(Box.createRigidArea(new Dimension(0, 10)));




        playlistLabel = new JLabel("PlayLists  ");
        playlistLabel.setAlignmentX(RIGHT_ALIGNMENT);
        playlistLabel.setForeground(Color.white);
        add(playlistLabel);
        add(Box.createRigidArea(new Dimension(0, 5)));


/**
 * This button creates and adds a new playlist
 */
        newPlaylistBtn = new JButton("  New Playlist  ");
        newPlaylistBtn.setBackground(Color.black);
        newPlaylistBtn.setForeground(Color.WHITE);
        newPlaylistBtn.setAlignmentX(CENTER_ALIGNMENT);
        newPlaylistBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
        add(newPlaylistBtn);
        add(Box.createRigidArea(new Dimension(0, 5)));


/**
 * This buttons shows user's shared playlist on network
 */
        sharedPlaylistBtn = new JButton("Shared Playlist");
        sharedPlaylistBtn.setBackground(Color.black);
        sharedPlaylistBtn.setForeground(Color.WHITE);
        sharedPlaylistBtn.setAlignmentX(CENTER_ALIGNMENT);
        sharedPlaylistBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
        add(sharedPlaylistBtn);
        add(Box.createRigidArea(new Dimension(0, 5)));


/**
 * Every user has some favourite songs which is shown by this button
 */
        favouriteBtn = new JButton("    Favourites    ");
        favouriteBtn.setBackground(Color.black);
        favouriteBtn.setForeground(Color.WHITE);
        favouriteBtn.setAlignmentX(CENTER_ALIGNMENT);
        favouriteBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
        add(favouriteBtn);
        add(Box.createRigidArea(new Dimension(0, 5)));


        setVisible(true);
    } // end of constructor

    /**
     * Adds a song to songs arraylist
     * @param path
     */
    void addSong(String path){

        song = new Song(path);
        songs.add(song);
        System.out.println(song.getTitle());
    }

    /**
     * Adds a song to user's favourites songs
     * @param path
     */
    void addFavourite(String path){

        song = new Song(path);
        favouriteSongs.add(song);
    }


    @Override
    public String toString() {
        return "LibraryPart{" +
                "songs=" + songs +
                '}';
    }


}
