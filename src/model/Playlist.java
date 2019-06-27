package model;

import java.io.Serializable;

/**
 * playlist is actually a tag not a class.
 * and each song can be added to many playlists so each song has a playlist arraylist
 */
public class Playlist implements Serializable {

    private String playlistName;

    public Playlist(String playlistName) {
        this.playlistName = playlistName;
    }

    /**
     * @return the name of playlist
     */
    public String getPlaylistName() {
        return playlistName;
    }

    public void setPlaylistName(String playlistName) {
        this.playlistName = playlistName;
    }

}
