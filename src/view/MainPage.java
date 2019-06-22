package view;

import javax.swing.*;
import java.awt.*;

public class MainPage extends JFrame {

    JFrame mainFrame;
    LibraryPart Library;
    PlayerPart playerPart;
    Song song;
    private static final int WIDTH = 700, HEIGHT = 700;

    public MainPage(String userName){

        super();
        this.setLayout(new BorderLayout());
        this.setSize(WIDTH,HEIGHT);
        this.setLocation(300,100);


        Library = new LibraryPart();
        this.add(new JScrollPane(Library),BorderLayout.WEST);

        playerPart = new PlayerPart();
        this.add(playerPart,BorderLayout.SOUTH);


        this.setVisible(true);




    }
}
