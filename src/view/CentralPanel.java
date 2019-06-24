package view;

import model.Song;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

/**
 * CentralPanel at the center of the MainPage frame
 */
public class CentralPanel extends JPanel {

    private ToolBar toolBar;
    private ShowPanel showPanel;



    public CentralPanel(String userName) {
        super();

        this.setLayout(new BorderLayout());
        this.setBackground(new Color(33, 33, 33));

        toolBar = new ToolBar(userName);
        toolBar.setSize(new Dimension(50, 10));
        this.add(toolBar, BorderLayout.NORTH);


//        ArrayList<Song> songs = new ArrayList<>();

//        Song song1 = new Song("C:\\Users\\Asus\\Desktop\\Cheri Cheri Lady - Modern Talking.mp3");
//        Song song2 = new Song("C:\\Users\\Asus\\Desktop\\50-Cent-Candy-Shop-@Otaghe8Bot.mp3");
//        songs.add(song1);
//        songs.add(song2);
        showPanel = new ShowPanel();

        this.add(showPanel,BorderLayout.CENTER);
    }
}
