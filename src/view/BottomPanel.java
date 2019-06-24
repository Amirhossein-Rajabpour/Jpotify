package view;

import javax.swing.*;
import java.awt.*;

public class BottomPanel extends JPanel {

    private Color background;
    private PlayerPart playerPart;
    private ProgressBarPanel progressBarPanel;
    private SongInfoPanel songInfoPanel;

    public BottomPanel() {
        super();

        background = new Color(40, 40, 40);
        this.setLayout(new BorderLayout());
        this.setBackground(background);

        playerPart = new PlayerPart();
        this.add(playerPart, BorderLayout.CENTER);

        progressBarPanel = new ProgressBarPanel();
        this.add(progressBarPanel,BorderLayout.SOUTH);

        songInfoPanel = new SongInfoPanel();
        this.add(songInfoPanel,BorderLayout.WEST);

        playerPart.setProgressBarPanel(progressBarPanel.getProgressBar());

    }


}
