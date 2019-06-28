package view.Library;

import model.Album;
import model.Playlist;
import model.Song;
import view.Center.ShowPanel;
import view.Player.PlayerPart;

import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.text.EditorKit;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.stream.Stream;

/**
 * This JPanel is placed at the left side of MainPaige which includes library and playlists
 * this class also manages reading and writing song for program
 */

public class LibraryPart extends JPanel {

    private JLabel options;
    private JLabel icon;
    private JLabel Jpotify;
    private static final String JPOTIFY_LABEL = "Jpotify";
    private JSeparator jSeparator;
    private JLabel libraryLabel;
    private JTextField fileChooserBtn;
    private JTextField songsBtn;
    private JTextField albumsBtn;
    private JTextField EditBtn;
    private JLabel playlistLabel;
    private JTextField playlistBtn;
    private JTextField newPlaylistBtn;
    private JTextField sharedPlaylistBtn;
    private JTextField favouriteBtn;
    private Song song;
    private ShowPanel showPanel;
    private Color foreground;
    private Color pressedBackground;
    private Album album;
    private String username;
    private PlayerPart playerPart;
    private NewPlaylist newPlaylist;
    private RemoveSong removeSong;


    private ArrayList<Song> songs = new ArrayList<>();
    /**
     * playlist doesnt have arraylist in library and they are shown in showpanel exactly like favourite songs.
     */
    private ArrayList<Album> albums = new ArrayList<>();
    private ArrayList<Song> favouriteSongs = new ArrayList<>();
    private ArrayList<Song> sharedSongs = new ArrayList<>();
    private ArrayList<String> playlistNames = new ArrayList<>();


    public LibraryPart(String user, PlayerPart playerPart) throws IOException {

        super();
        this.setPreferredSize(new Dimension(102, 750));
        setSize(400, 400);
        this.setBackground(new Color(24, 24, 24));
        setLayout(new GridLayout(19, 1));
        foreground = new Color(179, 179, 179);
        pressedBackground = new Color(45, 45, 45);
        this.playerPart = playerPart;

        username = user;
        if (new File(username + "/songs/").list().length > 0) {
            System.out.println("existed");
            songs = loadSongs(username);
            System.out.println(songs.get(0).getAlbumName() + "zartzart");
        } else System.out.println("not entered");


        options = new JLabel("      ● ● ●");
        options.setForeground(Color.WHITE);
        options.setFont(new Font("Arial", Font.BOLD, 6));
        options.setToolTipText("options");
        options.setBackground(new Color(24, 24, 24));
        options.setForeground(Color.white);
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

        icon = new JLabel();
        icon.setHorizontalAlignment(SwingConstants.CENTER);
        ImageIcon JpotifyIcon = new ImageIcon("/Users/apple/Desktop/JpotifyIcon.png");
        Image image = JpotifyIcon.getImage(); // transform it
        Image newimg = image.getScaledInstance(18, 18, java.awt.Image.SCALE_SMOOTH); // scale it the smooth way
        JpotifyIcon = new ImageIcon(newimg);
        icon.setIcon(JpotifyIcon);
        add(icon);

        Jpotify = new JLabel(JPOTIFY_LABEL);
        Jpotify.setFont(new Font("Arial", Font.BOLD, 10));
        Jpotify.setForeground(foreground);
        Jpotify.setBackground(this.getBackground());
        Jpotify.setHorizontalAlignment(SwingConstants.CENTER);
        add(Jpotify);


        jSeparator = new JSeparator(SwingConstants.HORIZONTAL);
        jSeparator.setForeground(new Color(39, 39, 39));
        add(jSeparator);


        libraryLabel = new JLabel("    LIBRARY      ");
        libraryLabel.setFont(new Font("Arial", Font.CENTER_BASELINE, 9));
        libraryLabel.setForeground(foreground);
        libraryLabel.setBackground(this.getBackground());
        add(libraryLabel);
//        add(Box.createRigidArea(new Dimension(0, 5)));


/**
 * This button is for adding a new song to the program
 */
        fileChooserBtn = new JTextField("   Add To Library");
        fileChooserBtn.setFont(new Font("Arial", Font.BOLD, 9));
        fileChooserBtn.setEditable(false);
        fileChooserBtn.setBackground(this.getBackground());
        fileChooserBtn.setForeground(foreground);
        fileChooserBtn.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
            }

            @Override
            public void mousePressed(MouseEvent e) {
                fileChooserBtn.setBackground(pressedBackground);
            }

            /**
             * here user choose a song from computer and it adds to the program songs for user and it saves in a specific folder
             * @param e
             */
            @Override
            public void mouseReleased(MouseEvent e) {
                fileChooserBtn.setBackground(getBackground());
                JFileChooser fileChooser = new JFileChooser();
                fileChooser.setFileFilter(new FileNameExtensionFilter(".mp3 files", "mp3"));
                fileChooser.setCurrentDirectory(new File("E:/"));
                int result = fileChooser.showOpenDialog(fileChooser);
                if (result == JFileChooser.APPROVE_OPTION) {
                    File selectedFile = fileChooser.getSelectedFile();
                    System.out.println("Selected file: " + selectedFile.getAbsolutePath());
                    saveSong(addSong(selectedFile.getAbsolutePath()));
                    System.out.println("song saved");
                }
            }

            @Override
            public void mouseEntered(MouseEvent e) {
            }

            @Override
            public void mouseExited(MouseEvent e) {
            }
        });
        add(fileChooserBtn);


/**
 * This button shows all existed songs according to last time played
 */
        songsBtn = new JTextField("   Songs");
        songsBtn.setFont(new Font("Arial", Font.BOLD, 9));
        songsBtn.setEditable(false);
        songsBtn.setBackground(this.getBackground());
        songsBtn.setForeground(foreground);
        songsBtn.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
            }

            @Override
            public void mousePressed(MouseEvent e) {
                songsBtn.setBackground(pressedBackground);
            }

            @Override
            public void mouseReleased(MouseEvent e) {

                songsBtn.setBackground(getBackground());

                showPanel.removeAll();
                showPanel.repaint();
                showPanel.setSongs(songs);
                showPanel.revalidate();
            }

            @Override
            public void mouseEntered(MouseEvent e) {
            }

            @Override
            public void mouseExited(MouseEvent e) {
            }
        });
        add(songsBtn);


/**
 * This button shows all albums according to last time played
 */
        albumsBtn = new JTextField("   Albums");
        albumsBtn.setFont(new Font("Arial", Font.BOLD, 9));
        albumsBtn.setBackground(this.getBackground());
        albumsBtn.setForeground(foreground);
        albumsBtn.setEditable(false);
        albumsBtn.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
            }

            @Override
            public void mousePressed(MouseEvent e) {
                albumsBtn.setBackground(pressedBackground);
            }

            @Override
            public void mouseReleased(MouseEvent e) {
                albumsBtn.setBackground(getBackground());
                showPanel.removeAll();
                showPanel.repaint();

                showPanel.setAlbums(albums, songs);
                showPanel.revalidate();
            }

            @Override
            public void mouseEntered(MouseEvent e) {
            }

            @Override
            public void mouseExited(MouseEvent e) {
            }
        });
        add(albumsBtn);

/**
 * by clicking this button a new panel will be opened and user and choose what songs to be deleted from the program
 */
        EditBtn = new JTextField("   Edit");
        EditBtn.setFont(new Font("Arial", Font.BOLD, 9));
        EditBtn.setBackground(this.getBackground());
        EditBtn.setForeground(foreground);
        EditBtn.setEditable(false);
        EditBtn.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
            }

            @Override
            public void mousePressed(MouseEvent e) {
                EditBtn.setBackground(pressedBackground);
            }

            @Override
            public void mouseReleased(MouseEvent e) {
                EditBtn.setBackground(getBackground());

                removeSong = new RemoveSong(songs, getLibrarypartItself(), playerPart);

            }

            @Override
            public void mouseEntered(MouseEvent e) {
            }

            @Override
            public void mouseExited(MouseEvent e) {
            }
        });
        add(EditBtn);


        add(Box.createRigidArea(new Dimension(0, 5)));

        playlistLabel = new JLabel("    PLAYLISTS");
        playlistLabel.setFont(new Font("Arial", Font.CENTER_BASELINE, 9));
        playlistLabel.setForeground(foreground);
        playlistLabel.setBackground(this.getBackground());
        add(playlistLabel);
/**
 * this button shows all existed playlists for user
 */

        playlistBtn = new JTextField("   Playlists");
        playlistBtn.setFont(new Font("Arial", Font.BOLD, 9));
        playlistBtn.setEditable(false);
        playlistBtn.setBackground(this.getBackground());
        playlistBtn.setForeground(foreground);
        playlistBtn.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
            }

            @Override
            public void mousePressed(MouseEvent e) {
                playlistBtn.setBackground(pressedBackground);
            }

            @Override
            public void mouseReleased(MouseEvent e) {
                playlistBtn.setBackground(getBackground());
                showPanel.removeAll();
                showPanel.repaint();
                showPanel.setPlaylists(playlistNames, songs, getLibrarypartItself());
                showPanel.revalidate();

            }

            @Override
            public void mouseEntered(MouseEvent e) {
            }

            @Override
            public void mouseExited(MouseEvent e) {
            }
        });
        add(playlistBtn);


/**
 * This button creates and adds a new playlist
 */
        newPlaylistBtn = new JTextField("   New Playlist");
        newPlaylistBtn.setFont(new Font("Arial", Font.BOLD, 9));
        newPlaylistBtn.setEditable(false);
        newPlaylistBtn.setBackground(this.getBackground());
        newPlaylistBtn.setForeground(foreground);
        newPlaylistBtn.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
            }

            @Override
            public void mousePressed(MouseEvent e) {
                newPlaylistBtn.setBackground(pressedBackground);
            }

            @Override
            public void mouseReleased(MouseEvent e) {
                newPlaylistBtn.setBackground(getBackground());

                newPlaylist = new NewPlaylist(songs, getLibrarypartItself());
            }

            @Override
            public void mouseEntered(MouseEvent e) {
            }

            @Override
            public void mouseExited(MouseEvent e) {
            }
        });
        add(newPlaylistBtn);


/**
 * This buttons shows user's shared playlist on network
 */
        sharedPlaylistBtn = new JTextField("   Shared Playlist");
        sharedPlaylistBtn.setFont(new Font("Arial", Font.BOLD, 9));
        sharedPlaylistBtn.setEditable(false);
        sharedPlaylistBtn.setBackground(this.getBackground());
        sharedPlaylistBtn.setForeground(foreground);
        sharedPlaylistBtn.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
            }

            @Override
            public void mousePressed(MouseEvent e) {
                sharedPlaylistBtn.setBackground(pressedBackground);
            }

            @Override
            public void mouseReleased(MouseEvent e) {
                sharedPlaylistBtn.setBackground(getBackground());

                showPanel.removeAll();
                showPanel.repaint();
                sharedSongs = null;
                sharedSongs = new ArrayList<>();

                for (Song song : songs) {
                    if (song.isSharable()) {
                        sharedSongs.add(song);
                    }
                }
                showPanel.setSongs(sharedSongs);
                showPanel.revalidate();
            }

            @Override
            public void mouseEntered(MouseEvent e) {
            }

            @Override
            public void mouseExited(MouseEvent e) {
            }
        });
        add(sharedPlaylistBtn);


/**
 * Every user has some favourite songs which is shown by this button
 */
        favouriteBtn = new JTextField("   Favourites");
        favouriteBtn.setFont(new Font("Arial", Font.BOLD, 9));
        favouriteBtn.setEditable(false);
        favouriteBtn.setBackground(this.getBackground());
        favouriteBtn.setForeground(foreground);
        favouriteBtn.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
            }

            @Override
            public void mousePressed(MouseEvent e) {
                favouriteBtn.setBackground(pressedBackground);
            }

            @Override
            public void mouseReleased(MouseEvent e) {
                favouriteBtn.setBackground(getBackground());

                showPanel.removeAll();
                showPanel.repaint();
                favouriteSongs = null;
                favouriteSongs = new ArrayList<>();

                for (Song song : songs) {
                    if (song.isFavourite() /*&& !favouriteSongs.contains(song)*/) {
                        favouriteSongs.add(song);
                    }

                }
                showPanel.setSongs(favouriteSongs);
                showPanel.revalidate();
            }

            @Override
            public void mouseEntered(MouseEvent e) {
            }

            @Override
            public void mouseExited(MouseEvent e) {
            }
        });
        add(favouriteBtn);


        setVisible(true);
    } // end of constructor


    /**
     * Adds a song to songs arraylist
     * and also adds song to related album
     *
     * @param path
     */
    Song addSong(String path) {

        int exist = 0;
        song = new Song(path);

        for (Song song : songs) {
            if (song.getPath().equals(path))
                exist = 1;
        }
        if (exist == 0) {
            songs.add(song);
            System.out.println(song.getTitle());
            System.out.println(song.getAlbumName());
            addToAlbum(song);
        }

        return song;
    }

    /**
     * Adds a song to user's favourites songs
     *
     * @param
     */
    public void addFavourite(Song song) {
        favouriteSongs.add(song);
    }

    /**
     * this method add each song to it's album class
     *
     * @param song
     */
    public void addToAlbum(Song song) throws NullPointerException {

        if (albums.contains(song.getAlbumName())) {
            for (Album album : albums) {
                if (song.getAlbumName().equals(album.getAlbumName())) {
                    album.addSong(song);
                }
            }
        } else {
            album = new Album(song.getAlbumName());
            albums.add(album);
            album.addSong(song);
        }
        playerPart.setAlbums(albums);


    }

    /**
     * this method save added song to the program(create a file for it and write it)
     *
     * @param
     */
    public void saveSong(Song song) {

//        Song song = new Song(path);
        try {
            FileOutputStream f = new FileOutputStream(new File(username + "/songs/" + song.getTitle()));
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
     *
     * @return
     */

    public void setShowPanel(ShowPanel showPanel) {
        this.showPanel = showPanel;
    }

    public ShowPanel getShowPanel() {
        return showPanel;
    }

    /**
     * this method reads and loads all users songs and albums and add them to the program
     *
     * @param username
     * @return
     * @throws IOException
     */
    public ArrayList<Song> loadSongs(String username) throws IOException {

        ArrayList<Song> loadedSongs = new ArrayList<Song>();
        boolean cont = true;

        try (Stream<Path> filePathStream = Files.walk(Paths.get(username + "/songs/"))) {
            filePathStream.forEach(filePath -> {
                if (Files.isRegularFile(filePath)) {

                    System.out.println(filePath);

                    try {
                        FileInputStream fis = new FileInputStream(String.valueOf(filePath));
                        ObjectInputStream ois = new ObjectInputStream(fis);
                        Object obj = null;

                        System.out.println("1");
                        obj = ois.readObject();
                        loadedSongs.add((Song) obj);
                        addToAlbum((Song) obj);

                        for (String playlistNames : ((Song) obj).getPlaylists()) // i dont know why it doesnt work
                            addPlaylistName(playlistNames);

                        if (((Song) obj).isFavourite() == true)
                            favouriteSongs.add((Song) obj);

                    } catch (FileNotFoundException e) {
                        e.printStackTrace();
                    } catch (IOException e) {
                        e.printStackTrace();
                    } catch (ClassNotFoundException e) {
                        e.printStackTrace();
                    }
                }


            });
        }

        playerPart.setAlbums(albums);
        return loadedSongs;
    }




//    public void addPlaylist(Playlist playlist) { playlists.add(playlist); }

    /**
     * it returns hte library itself
     *
     * @return
     */
    LibraryPart getLibrarypartItself() {
        return this;
    }

    /**
     * it returns library playlist name only which is an arraylist of string
     *
     * @return
     */
    public ArrayList<String> getPlaylistName() {
        return this.playlistNames;
    }

    /**
     * adds a name to playlist names arraylist for library
     *
     * @param name
     */
    public void addPlaylistName(String name) {
        this.playlistNames.add(name);
    }

    /**
     * this method removes a song from library with its file
     *
     * @param path
     */
    public void removeSpecificSong(String path) {
        new File(path).delete();
    }

    public String getUsername() {
        return username;
    }

    /**
     * sets library songs
     *
     * @param songs
     */
    public void setSongs(ArrayList<Song> songs) {
        this.songs = songs;

    }

    /**
     * sets library albums
     *
     * @param albums
     */
    public void setAlbums(ArrayList<Album> albums) {
        this.albums = albums;
    }

    public ArrayList<Album> getAlbums() {
        return albums;
    }
}
