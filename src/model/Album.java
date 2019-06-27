package model;

import java.util.ArrayList;

/**
 * albums are managed through album class
 */
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

    /**
     * add a song to album's songs arraylist
     * @param song
     */
    public void addSong(Song song){
        albumSongs.add(song);
    }

    /**
     * this method gets first song of album for album artwork
     * @return
     */
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
