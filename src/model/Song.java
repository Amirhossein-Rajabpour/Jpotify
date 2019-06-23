package model;

import com.mpatric.mp3agic.*;

import java.awt.*;
import java.io.IOException;

public class Song extends Mp3File {

    private String title;
    private String artistName;
    private String path;
    private String albumName;
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

    public void setArtwork() {
        if(mp3file.hasId3v2Tag()) {
            ID3v2 id3v2Tag = mp3file.getId3v2Tag();
            artwork = id3v2Tag.getAlbumImage();

        }
    }
}
