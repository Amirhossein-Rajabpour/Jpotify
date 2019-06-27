package view.Center;

import model.Album;
import model.Playlist;
import model.Song;
import view.Player.PlayerPart;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

/**
 * this class is a container which shows songs, albums, playlists and  etc in the middle part of the program
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
        this.setPreferredSize(new Dimension(1000, 700));
        this.setLayout(new FlowLayout());
        this.setBackground(background);

    }

    public void setSongs(ArrayList<Song> songs) {

        this.songs = null;
        this.songs = songs;
        this.songBtns = null;
        System.out.println("size " + songs.size());
        this.songBtns = new SongBtn[songs.size()];

        for (int i = 0; i < songs.size(); i++) {

            songBtns[i] = new SongBtn(playerPart,songs,i);
            songBtns[i].setPreferredSize(new Dimension(130,180));
            add(songBtns[i]);

        }
        setVisible(true);
    }

    public void setAlbums(ArrayList<Album> albums) {

        this.albums = albums;
        albumButtons = new JButton[albums.size()];

        for (int i = 0; i < albums.size(); i++) {

            albumButtons[i] = new JButton();
            albumButtons[i].setSize(100, 10);


            ImageIcon albumImgIcon;
            if (albums.get(i).getFirstSong().getArtwork() != null) {
                albumImgIcon = new ImageIcon(albums.get(i).getFirstSong().getArtwork());
            } else {
                albumImgIcon = new ImageIcon("/Users/apple/Desktop/userIcon.png");
            }
            Image img = albumImgIcon.getImage().getScaledInstance(100, 100, i);
            Icon icon = new ImageIcon(img);
            albumButtons[i].setIcon(icon);


            albumButtons[i].setText(albums.get(i).getAlbumName());

            add(albumButtons[i]);
            this.add(Box.createRigidArea(new Dimension(10, 10)));
        }
        this.setVisible(true);
    }


    public void setPlaylists(ArrayList<String> playlistNames, ArrayList<Song> songs) {


        this.playlistNames = playlistNames;
        playlistBtns = new PlaylistBtn[playlistNames.size()];

        for (int i = 0; i < playlistNames.size(); i++) {

            playlistBtns[i] = (PlaylistBtn) new PlaylistBtn(songs, playlistNames.get(i), playerPart, this);
            playlistBtns[i].setSize(100, 40);


//            ImageIcon albumImgIcon;
//            if (playlistNames.get(i).getFirstSong().getArtwork() != null) {
//                albumImgIcon = new ImageIcon(albums.get(i).getFirstSong().getArtwork());
//            } else {
//                albumImgIcon = new ImageIcon("/Users/apple/Desktop/userIcon.png");
//            }
//            Image img = albumImgIcon.getImage().getScaledInstance(100, 100, i);
//            Icon icon = new ImageIcon(img);
//            albumButtons[i].setIcon(icon);


            add(playlistBtns[i]);

            this.add(Box.createRigidArea(new Dimension(10, 10)));
        }
        this.setVisible(true);
    }
}
