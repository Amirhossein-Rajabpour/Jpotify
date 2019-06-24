package view;

import javax.swing.*;
import java.awt.*;

public class ProgressBarPanel extends JPanel {

    private Color background;
    private JProgressBar progressBar;
    private int num;
    private boolean isPlaying;


    public ProgressBarPanel() {

        background = new Color(40, 40, 40);
        this.setForeground(new Color(179, 179, 179));
        this.setBackground(background);
        this.isPlaying = false;

        JTextField passed = new JTextField("00:00");
        passed.setFont(new Font("Arial", Font.CENTER_BASELINE, 9));
        passed.setEditable(false);
        passed.setBackground(background);
        passed.setForeground(new Color(179, 179, 179));
        this.add(passed);


//        UIManager.put("ProgressBar.selectionBackground",Color.WHITE);
//        UIManager.put("ProgressBar.selectionForeground",Color.WHITE);
        progressBar = new JProgressBar(0, 100);
        progressBar.setStringPainted(false);
        progressBar.setBorderPainted(true);
        this.add(progressBar);
//        progressBar.setValue(300);
//        progressBar.setBackground(Color.white);
//        progressBar.setForeground(Color.WHITE);
//        progressBar.setSize(9000,2000);


        JTextField total = new JTextField("00:00");
        total.setFont(new Font("Arial", Font.CENTER_BASELINE, 9));
        total.setEditable(false);
        total.setBackground(background);
        total.setForeground(new Color(179, 179, 179));
        this.add(total);
    }

    public void iterate() {
        while (num < 100) {
            progressBar.setValue(num);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) { }
            num += 95;
        }
    }

    public JProgressBar getProgressBar() {
        return progressBar;
    }
}
