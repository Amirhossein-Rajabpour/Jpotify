package view.Center;

import view.Library.LibraryPart;
import view.Player.PlayerPart;

import javax.swing.*;
import java.awt.*;

/**
 * CentralPanel at the center of the MainPage frame
 * this panel includes a search bar and a main panel for showing songs and albums and other features of the program
 */
public class CentralPanel extends JPanel {

    private ToolBar toolBar;
    private ShowPanel showPanel;
    public CentralPanel(String userName, PlayerPart playerPart,LibraryPart libraryPart) {
        super();

        this.setLayout(new BorderLayout());
        this.setBackground(new Color(33, 33, 33));

        toolBar = new ToolBar(userName, libraryPart);
        toolBar.setSize(new Dimension(50, 10));
        this.add(toolBar, BorderLayout.NORTH);


        showPanel = new ShowPanel(playerPart);
        JScrollPane jscrollPane = new JScrollPane(showPanel);
        jscrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
        jscrollPane.setBackground(new Color(33, 33, 33));
        this.add(jscrollPane, BorderLayout.CENTER);

//        this.add(showPanel,BorderLayout.CENTER);
    }

    public void setShowPanel(ShowPanel showPanel){

        this.showPanel = showPanel;
    }

    public ShowPanel getShowPanel() {
        return showPanel;
    }
}
