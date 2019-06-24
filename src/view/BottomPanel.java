package view;

import javax.swing.*;
import java.awt.*;

public class BottomPanel extends JPanel {

    private Color background;
    private PlayerPart playerPart;
    private JPanel progressBarPanel;
    private JProgressBar progressBar;
    public BottomPanel() {
        super();

        background = new Color(40, 40, 40);
        this.setLayout(new BorderLayout());
        this.setBackground(background);

        playerPart = new PlayerPart();
        this.add(playerPart, BorderLayout.CENTER);

        progressBarPanel = new JPanel();
        progressBarPanel.setForeground(new Color(179,179,179));
        progressBarPanel.setBackground(background);

        JTextField passed = new JTextField("00:00");
        passed.setFont(new Font("Arial", Font.CENTER_BASELINE,9));
        passed.setEditable(false);
        passed.setBackground(background);
        passed.setForeground(new Color(179,179,179));
        progressBarPanel.add(passed);


//        UIManager.put("ProgressBar.selectionBackground",Color.WHITE);
//        UIManager.put("ProgressBar.selectionForeground",Color.WHITE);
        progressBar = new JProgressBar(0,1000);
        progressBar.setStringPainted(false);
        progressBar.setBorderPainted(true);
        progressBarPanel.add(progressBar);
//        progressBar.setValue(300);
//        progressBar.setBackground(Color.white);
//        progressBar.setForeground(Color.WHITE);
//        progressBar.setSize(9000,2000);


        JTextField total = new JTextField("00:00");
        total.setFont(new Font("Arial", Font.CENTER_BASELINE,9));
        total.setEditable(false);
        total.setBackground(background);
        total.setForeground(new Color(179,179,179));
        progressBarPanel.add(total);

        this.add(progressBarPanel,BorderLayout.SOUTH);

    }
}
