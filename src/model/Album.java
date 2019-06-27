package model;

import java.util.ArrayList;

public class Album {

    private String albumName;
    ArrayList<Song> albumSongs = new ArrayList<>();

    public Album(String albumName){
        this.albumName = albumName;
    }

    public String getAlbumName() {
        return albumName;
    }

    public ArrayList<Song> getAlbumSongs() {
        return albumSongs;
    }

    public void setAlbumName(String albumName) {
        this.albumName = albumName;
    }

    public void setAlbumSongs(ArrayList<Song> albumSongs) {
        this.albumSongs = albumSongs;
    }
    public void addSong(Song song){
        albumSongs.add(song);
    }
    public Song getFirstSong(){
        if(getAlbumSongs().size() != 0)
       return albumSongs.get(0);
        else
        {
            System.out.println("error");
            return null;

        }

    }

}
