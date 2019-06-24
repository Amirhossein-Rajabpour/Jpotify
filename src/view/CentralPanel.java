package view;

import javax.swing.*;
import java.awt.*;

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


        showPanel = new ShowPanel();

        this.add(showPanel,BorderLayout.CENTER);
    }
}
