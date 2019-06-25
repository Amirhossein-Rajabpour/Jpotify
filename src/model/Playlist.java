package model;

import java.util.ArrayList;

public class Playlist {

    private String playlistName;
    ArrayList<Song> playlistSongs = new ArrayList<>();

    public Playlist(String playlistName) {
        this.playlistName = playlistName;
    }

    public String getPlaylistName() {
        return playlistName;
    }

    public void setPlaylistName(String playlistName) {
        this.playlistName = playlistName;
    }

    public ArrayList<Song> getPlaylistSongs() {
        return playlistSongs;
    }

    public void setPlaylistSongs(ArrayList<Song> playlistSongs) {
        this.playlistSongs = playlistSongs;
    }
    public void addSong(Song song){
        playlistSongs.add(song);
    }
}
