package view;

import javax.swing.*;
import java.awt.*;

public class MainPage extends JFrame {

    private JFrame mainFrame;
    private LibraryPart Library;
    private PlayerPart playerPart;
    private Song song;
    private ToolBar toolBar;
    private static final int WIDTH = 700, HEIGHT = 700;

    public MainPage(String userName,String friendsId){

        super();
        this.setLayout(new BorderLayout());
        this.setSize(WIDTH,HEIGHT);
        this.setLocation(300,100);

        toolBar = new ToolBar();
        this.add(toolBar,BorderLayout.NORTH);

        Library = new LibraryPart();
        this.add(new JScrollPane(Library),BorderLayout.WEST);

        playerPart = new PlayerPart();
        this.add(playerPart,BorderLayout.SOUTH);


        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);




    }
}
