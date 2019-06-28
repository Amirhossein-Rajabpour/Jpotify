package view.Center;

import model.Album;
import model.Song;
import view.Library.LibraryPart;
import view.Player.PlayerPart;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

/**
 * this class is a container which shows songs, albums, playlists and  etc in the middle part of the program
 * also it connects to program's player and library.
 */
public class ShowPanel extends JPanel {

    private Color background;
    private JButton[] albumButtons;
    private PlaylistBtn[] playlistBtns;
    private SongBtn[] songBtns;
    private AlbumBtn[] albumBtns;
    private PlayerPart playerPart;
    ArrayList<Song> songs = new ArrayList<>();
    ArrayList<Album> albums = new ArrayList<>();
    private ArrayList<String> playlistNames;


    public ShowPanel(PlayerPart playerPart) {

        super();
        this.playerPart = playerPart;
        background = new Color(33, 33, 33);
//        this.setPreferredSize(new Dimension(300, 1000));
//        this.setMaximumSize(new Dimension(2, 7000));
//        this.setSize(new Dimension(2000, 7));
        this.setLayout(new FlowLayout());
        this.setBackground(background);

    }

    /**
     * shows song
     *
     * @param songs
     */
    public void setSongs(ArrayList<Song> songs) {

        this.setPreferredSize(new Dimension(300, ((songs.size() / 4) + 1) * 170));

        this.songs = null;
        this.songs = songs;
        this.songBtns = null;
        this.songBtns = new SongBtn[songs.size()];

        for (int i = 0; i < songs.size(); i++) {

            songBtns[i] = new SongBtn(playerPart, songs, i);
            add(songBtns[i]);

        }
        setVisible(true);
    }

    /**
     * shows albums
     *
     * @param albums
     */
    public void setAlbums(ArrayList<Album> albums, ArrayList<Song> songs) {

        this.setPreferredSize(new Dimension(300, ((songs.size() / 4) + 1) * 155));

        this.albums = albums;
        albumBtns = new AlbumBtn[albums.size()];

        for (int i = 0; i < albums.size(); i++) {

            albumBtns[i] = new AlbumBtn(songs, albums.get(i), playerPart, this);
            add(albumBtns[i]);

        }
        this.setVisible(true);
    }

    /**
     * shows playlists
     *
     * @param playlistNames
     * @param songs
     */
    public void setPlaylists(ArrayList<String> playlistNames, ArrayList<Song> songs, LibraryPart libraryPart) {

        this.setPreferredSize(new Dimension(300, ((songs.size() / 4) + 1) * 155));

        this.playlistNames = playlistNames;
        playlistBtns = new PlaylistBtn[playlistNames.size()];

        for (int i = 0; i < playlistNames.size(); i++) {

            playlistBtns[i] = new PlaylistBtn(songs, playlistNames.get(i), playerPart, this, libraryPart);
            add(playlistBtns[i]);

        }
        this.setVisible(true);
    }
}
