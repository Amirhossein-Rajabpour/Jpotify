package view.Player;

import javax.swing.*;
import java.awt.*;

/**
 * container for bottom of the program which contains other panels like player
 */
public class BottomPanel extends JPanel {

    private Color background;
    private PlayerPart playerPart;
    private ProgressBarPanel progressBarPanel;
    private SongInfoPanel songInfoPanel;
    private VolumeSliderPanel volumeSliderPanel;

    public BottomPanel(int friendsId) {
        super();

        background = new Color(40, 40, 40);
        this.setLayout(new BorderLayout());
        this.setBackground(background);

        playerPart = new PlayerPart(friendsId);
        this.add(playerPart, BorderLayout.CENTER);

        progressBarPanel = new ProgressBarPanel();
        this.add(progressBarPanel, BorderLayout.SOUTH);
        playerPart.setProgressBarPanel(progressBarPanel);

        songInfoPanel = new SongInfoPanel();
        this.add(songInfoPanel, BorderLayout.WEST);
        playerPart.setSongInfoPanel(songInfoPanel);

        volumeSliderPanel = new VolumeSliderPanel();
        this.add(volumeSliderPanel, BorderLayout.EAST);
    }

    public PlayerPart getPlayerPart() {
        return playerPart;
    }
}
