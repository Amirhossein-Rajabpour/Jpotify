package model;

import view.Song;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;

public class Model {

    ArrayList<Song> songs = new ArrayList<Song>();
    ArrayList<Song> favouriteSongs = new ArrayList<>();

    void addSong(String path){

        Song song = new Song(path);
        songs.add(song);
        System.out.println(song.getTitle());
    }

    void addFavourite(String path){

        Song song = new Song(path);
        favouriteSongs.add(song);
    }


}
