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



//        showPanel = new ShowPanel(); i commented this part because there will be input problem
//        for showpanel if it is supposed be new here
//        intori nemishe azash shey sakht manzorme kollan vali librarypart ro bbin buttone songs

        this.add(showPanel,BorderLayout.CENTER);
    }
}
