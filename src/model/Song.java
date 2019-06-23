package model;

import com.mpatric.mp3agic.*;

import java.awt.*;
import java.io.IOException;
import java.time.Instant;

/**
 * this class represents a song which is a mp3 file
 */
public class Song extends Mp3File {

    private String title;
    private String artistName;
    private String path;
    private String albumName;
    private long lastTimePlayed;
    private byte[] artwork;
    Mp3File mp3file;


    public Song(String path ){

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
    }

    public void setLastTimePlayed(){
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

    /**
     * This method checks weather the mp3 file is id3v1 or id3v2
     * and then set the title according to that
     */
    public void setTitle() {
        if(mp3file.hasId3v1Tag()){
            ID3v1 id3v1Tag = mp3file.getId3v1Tag();
            title = id3v1Tag.getTitle();
        }
        else if(mp3file.hasId3v2Tag()){
            ID3v2 id3v2Tag = mp3file.getId3v2Tag();
            title = id3v2Tag.getTitle();
        }
        else title = "not readable title";

    }
    /**
     * This method checks weather the mp3 file is id3v1 or id3v2
     * and then set the artistName according to that
     */
    public void setArtistName() {
        if(mp3file.hasId3v1Tag()){
            ID3v1 id3v1Tag = mp3file.getId3v1Tag();
            artistName = id3v1Tag.getTitle();
        }
        else if(mp3file.hasId3v2Tag()){
            ID3v2 id3v2Tag = mp3file.getId3v2Tag();
            artistName = id3v2Tag.getTitle();
        }
        else title = "not readable artist name";
    }
    /**
     * This method checks weather the mp3 file is id3v1 or id3v2
     * and then set the AlbumName according to that
     */
    public void setAlbumName() {
        if(mp3file.hasId3v1Tag()){
            ID3v1 id3v1Tag = mp3file.getId3v1Tag();
            albumName = id3v1Tag.getTitle();
        }
        else if(mp3file.hasId3v2Tag()){
            ID3v2 id3v2Tag = mp3file.getId3v2Tag();
            albumName = id3v2Tag.getTitle();
        }
        else title = "not readable album name";
    }

    /**
     * if the file is id3v2 it can have artwork
     * and this method reads the file and set the artwork
     */
    public void setArtwork() {
        if(mp3file.hasId3v2Tag()) {
            ID3v2 id3v2Tag = mp3file.getId3v2Tag();
            artwork = id3v2Tag.getAlbumImage();

        }
    }
}
