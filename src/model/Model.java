package model;

//import com.mpatric.mp3agic.*;
import view.Song;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;

public class Model {

    ArrayList<Song> songs = new ArrayList<Song>();
    ArrayList<Song> favouriteSongs = new ArrayList<>();

    /**
     * Adds a song to songs arraylist
     * @param path
     */
    void addSong(String path){

        Song song = new Song(path);
        songs.add(song);
        System.out.println(song.getTitle());
    }

    /**
     * Adds a song to user's favourites songs
     * @param path
     */
    void addFavourite(String path){

        Song song = new Song(path);
        favouriteSongs.add(song);
    }

    /**
     * this method takes the song location and with mp3agic library specifies song's title, artist, album and artwork
     * @param path
     */
    void readSongInfo(String path){

//        Mp3File mp3file = null;
//        Song song = new Song(path);
//
//        try {
//            mp3file = new Mp3File(path);
//            if(mp3file.hasId3v1Tag() || mp3file.hasId3v2Tag()){
//
//                ID3v1 id3v1Tag = mp3file.getId3v1Tag();
//                ID3v2 id3v2Tag = mp3file.getId3v2Tag();
//
//                song.setTitle(id3v1Tag.getTitle());
//                song.setArtistName(id3v1Tag.getArtist());
//                song.setAlbumName(id3v1Tag.getAlbum());
//                song.setArtwork(id3v2Tag.getAlbumImage());
//
//            }
//        } catch (IOException e) {
//            e.printStackTrace();
//        } catch (UnsupportedTagException e) {
//            e.printStackTrace();
//        } catch (InvalidDataException e) {
//            e.printStackTrace();
//        }

    }


}
