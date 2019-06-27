package view.Center;

import model.Album;
import model.Song;
import view.Player.PlayerPart;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class AlbumBtn extends JPanel {

    private ArrayList<Album> albums;
    private ArrayList<Song> songs;
    private Song song;
    private PlayerPart playerPart;

    private Album album;
    private JLabel icon;
    private JLabel title;
    private JLabel albumLabel;
    private JLabel artist;
    private JPanel data;
    private Color background;
    private Color foreground;
    private Color pressedBackground;
    private Font font1;
    private Font font2;


    public AlbumBtn(PlayerPart playerPart, Album album, ArrayList<Song> songs) {

        super();

        this.album = album;
        this.playerPart = playerPart;
    }

}
