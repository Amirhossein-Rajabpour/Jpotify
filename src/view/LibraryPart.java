package view;

import com.mpatric.mp3agic.*;
import model.Song;

import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.plaf.synth.SynthOptionPaneUI;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;

/**
 * This JPanel is the left part of our program which includes library and playlists
 */

public class LibraryPart extends JPanel {

    private JTextField options;
    private JLabel libraryLabel;
    private JButton fileChooserBtn;
    private JButton songsBtn;
    private JButton albumsBtn;
    private JLabel playlistLabel;
    private JButton newPlaylistBtn;
    private JButton sharedPlaylistBtn;
    private JButton favouriteBtn;
    private Song song;
    private ShowPanel showPanel;
    private JList<String> buttonList;

    ArrayList<Song> songs = new ArrayList<>();
    ArrayList<Song> favouriteSongs = new ArrayList<>();
    HashMap<String,ArrayList<Song>> Album = new HashMap<>(); // this HashMap is for albums
    HashMap<String,ArrayList<Song>> Playlist = new HashMap<>(); // this HashMap is for Playlist




    public LibraryPart(){

        super();
        setSize(120,400);
        this.setBackground(new Color(24,24,24));
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
//        setShowPanel(showPanel);


//        Dimension minSize = new Dimension(5, 20);
//        Dimension prefSize = new Dimension(15, 20);
//        Dimension maxSize = new Dimension(15, 20);
//        add(new Box.Filler(minSize, prefSize, maxSize));
        // add(Box.createRigidArea(new Dimension(15, 5)));


        options = new JTextField("● ● ●");
        options.setForeground(Color.WHITE);
        options.setFont(new Font("Arial", Font.BOLD, 8));
        options.setToolTipText("options");
        options.setHorizontalAlignment(SwingConstants.LEFT);
        options.setEditable(false);
        options.setBackground(new Color(24,24,24));
        options.setPreferredSize(new Dimension(20,10));
        options.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {

            }

            @Override
            public void mousePressed(MouseEvent e) {

            }

            @Override
            public void mouseReleased(MouseEvent e) {

            }

            @Override
            public void mouseEntered(MouseEvent e) {

            }

            @Override
            public void mouseExited(MouseEvent e) {

            }
        });
        this.add(options);
        //⦁

        buttonList = new JList<>();

        libraryLabel = new JLabel("Library     ");
        libraryLabel.setAlignmentX(RIGHT_ALIGNMENT);
        libraryLabel.setForeground(Color.white);
//        buttonList.add(libraryLabel);
//        add(buttonList);
        add(libraryLabel);
        add(Box.createRigidArea(new Dimension(0, 5)));


/**
 * This button is for adding a new song to the program
 */
        fileChooserBtn = new JButton(" Add to library ");
        fileChooserBtn.setPreferredSize(new Dimension(5,40));

        fileChooserBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                JFileChooser fileChooser = new JFileChooser();
                fileChooser.setFileFilter(new FileNameExtensionFilter(".mp3 files","mp3"));
                fileChooser.setCurrentDirectory(new File("E:/"));
                int result = fileChooser.showOpenDialog(fileChooser);
                if (result == JFileChooser.APPROVE_OPTION) {
                    File selectedFile = fileChooser.getSelectedFile();
                    System.out.println("Selected file: " + selectedFile.getAbsolutePath());
                    addSong(selectedFile.getAbsolutePath());
                    saveSong(selectedFile.getAbsolutePath());
                    System.out.println("song saved");

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

                for(Song song: songs){
                    System.out.println(song.getTitle());
                }
                showPanel.setSongs(songs);



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

                System.out.println(Album.keySet());
                showPanel.setAlbums(Album);

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
                showPanel.setSongs(favouriteSongs);
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
        System.out.println(song.getAlbumName());
        addToAlbum(song);
    }

    /**
     * Adds a song to user's favourites songs
     * @param path
     */
    public void addFavourite(String path){

        song = new Song(path);
        favouriteSongs.add(song);
    }

    /**
     * this method add each song to it's album HashMap
     * @param song
     */
    public void addToAlbum(Song song) throws NullPointerException{

        if(Album.containsKey(song.getAlbumName()))
        Album.get(song.getAlbumName()).add(song);

        else {
            ArrayList<Song> songs = new ArrayList<>();
            songs.add(song);
            Album.put(song.getAlbumName(),songs);
        }

    }

    /**
     * this method save added song to the program
     * @param path
     */
    public void saveSong(String path){

        Song song = new Song(path);
        FileOutputStream f = null;
        try {
            f = new FileOutputStream(new File( song.getTitle() + ".mp3"));
            ObjectOutputStream o = new ObjectOutputStream(f);

            o.writeObject(song);

            o.close();
            f.close();


        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    /**
     * this method is for using library's showpanel on other classes
     * @return
     */
    public ShowPanel getShowPanel(){
        return showPanel;
    }
    public void setShowPanel(ShowPanel showPanel) {
        this.showPanel = showPanel;
    }
    public void updateShowPanel(ShowPanel showPanel){
        remove(this.showPanel);
        setShowPanel(showPanel);
    }


    @Override
    public String toString() {
        return "LibraryPart{" +
                "songs=" + songs +
                '}';
    }


}
