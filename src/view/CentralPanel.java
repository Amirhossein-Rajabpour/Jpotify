package view;

import javax.swing.*;
import java.awt.*;

/**
 * CentralPanel at the center of the MainPage frame
 */
public class CentralPanel extends JPanel {

    private ToolBar toolBar;


    public CentralPanel(String userName) {
        super();

        this.setLayout(new BorderLayout());
        this.setBackground(new Color(38, 38, 38));

        toolBar = new ToolBar(userName);
        toolBar.setSize(new Dimension(50, 10));
        this.add(toolBar, BorderLayout.NORTH);

    }
}
