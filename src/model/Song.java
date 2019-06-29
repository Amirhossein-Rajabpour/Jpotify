package model;

import com.mpatric.mp3agic.*;

import java.io.IOException;
import java.io.Serializable;
import java.time.Instant;
import java.util.ArrayList;

/**
 * this class represents a song which is a mp3 file
 */
public class Song implements Serializable {

    private String title;
    private String artistName;
    private String path;
    private String albumName;
    private long duration;
    private long lastTimePlayed;
    private byte[] artwork;
    private boolean isFavourite;
    private boolean isSharable;
    transient Mp3File mp3file;
    private int bytes;

    ArrayList<String> playlists = new ArrayList<>();


    public Song(String path) {

        this.path = path;
        try {
            mp3file = new Mp3File(path);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (UnsupportedTagException e) {
            e.printStackTrace();
        } catch (InvalidDataException e) {
            e.printStackTrace();
        }

        setAlbumName();
        setArtistName();
        setArtwork();
        setTitle();
        setDuration();
        setBytes();
        isSharable = false;
    }

    public void addPlaylist(String playlistName) {
        playlists.add(playlistName);
    }

    /**
     * this feature is for using song in network. if true it means song can be shared on network
     * @return
     */
    public boolean isSharable() {
        return isSharable;
    }

    public void setSharable(boolean sharable) {
        isSharable = sharable;
    }

    public void setFavourite(boolean favourite) {
        isFavourite = favourite;
    }

    /**
     * each song can be added to user's favourites songs. this method says if a song is liked by the user or not
     * @return
     */
    public boolean isFavourite() {
        return isFavourite;
    }

    public void setLastTimePlayed() {
        lastTimePlayed = Instant.now().toEpochMilli();
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

    public long getDuration() {
        return duration;
    }

    public int getBytes(){
        return this.bytes;
    }

    public void setDuration() {
        duration = mp3file.getLengthInSeconds();
    }

    /**
     * This method checks weather the mp3 file is id3v1 or id3v2
     * and then set the title according to that
     */
    public void setTitle() {
        if (mp3file.hasId3v1Tag()) {
            ID3v1 id3v1Tag = mp3file.getId3v1Tag();
            title = id3v1Tag.getTitle();
        } else if (mp3file.hasId3v2Tag()) {
            ID3v2 id3v2Tag = mp3file.getId3v2Tag();
            title = id3v2Tag.getTitle();
        } else title = "not readable title";

    }

    /**
     * This method checks weather the mp3 file is id3v1 or id3v2
     * and then set the artistName according to that
     */
    public void setArtistName() {
        if (mp3file.hasId3v1Tag()) {
            ID3v1 id3v1Tag = mp3file.getId3v1Tag();
            artistName = id3v1Tag.getArtist();
        } else if (mp3file.hasId3v2Tag()) {
            ID3v2 id3v2Tag = mp3file.getId3v2Tag();
            artistName = id3v2Tag.getArtist();
        } else artistName = "not readable artist name";
    }

    /**
     * This method checks weather the mp3 file is id3v1 or id3v2
     * and then set the AlbumName according to that
     */
    public void setAlbumName() {
        if (mp3file.hasId3v1Tag()) {
            ID3v1 id3v1Tag = mp3file.getId3v1Tag();
            albumName = id3v1Tag.getAlbum();
        } else if (mp3file.hasId3v2Tag()) {
            ID3v2 id3v2Tag = mp3file.getId3v2Tag();
            albumName = id3v2Tag.getAlbum();
        } else albumName = "not readable album name";

    }

    /**
     * if the file is id3v2 it can have artwork
     * and this method reads the file and set the artwork
     */
    public void setArtwork() {
        if (mp3file.hasId3v2Tag()) {
            ID3v2 id3v2Tag = mp3file.getId3v2Tag();
            artwork = id3v2Tag.getAlbumImage();

        }
    }

    public void setBytes() {
        if (mp3file.hasId3v2Tag()) {
            bytes = (int)mp3file.getLength();
        }
    }

    /**
     * each song can be added to many playlists that's why each song has an arraylist of playlists
     * @return
     */
    public ArrayList<String> getPlaylists() {
        return playlists;
    }

    public void removeAlbum() {
        albumName = null;
    }

    public void removePlaylist(String playlist){ if(playlists.contains(playlist))playlists.remove(playlist); }


}
