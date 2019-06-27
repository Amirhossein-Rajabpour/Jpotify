package view.Center;

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
    public CentralPanel(String userName, PlayerPart playerPart) {
        super();

        this.setLayout(new BorderLayout());
        this.setBackground(new Color(33, 33, 33));

        toolBar = new ToolBar(userName);
        toolBar.setSize(new Dimension(50, 10));
        this.add(toolBar, BorderLayout.NORTH);

        showPanel = new ShowPanel(playerPart);
        this.add(showPanel,BorderLayout.CENTER);
    }

    public void setShowPanel(ShowPanel showPanel){

        this.showPanel = showPanel;
    }

    public ShowPanel getShowPanel() {
        return showPanel;
    }
}
