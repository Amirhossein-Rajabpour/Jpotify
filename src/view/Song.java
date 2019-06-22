package view;

public class Song {

    private String title;
    private String artistName;
    private String path;
    //artwork

    public Song(String path ){

        this.title = title;
        this.artistName = artistName;
        this.path = path;
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
