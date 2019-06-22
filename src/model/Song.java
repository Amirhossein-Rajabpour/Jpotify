package model;

import java.awt.*;

public class Song {

    private String title;
    private String artistName;
    private String path;
    private String albumName;
    private byte[] artwork;


    public Song(String path ){

        this.path = path;
    }
    public Song(){}

    public void setAlbumName(String albumName) {
        this.albumName = albumName;
    }

    public void setArtwork(byte[] artwork) {
        this.artwork = artwork;
    }

    public String getAlbumName() {
        return albumName;
    }

    public byte[] getArtwork() {
        return artwork;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public String getTitle() {
        return title;
    }

    public String getArtistName() {
        return artistName;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setArtistName(String artistName) {
        this.artistName = artistName;
    }
}
