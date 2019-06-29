package view.Player;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class ProgressBarPanel extends JPanel implements Runnable {

    private JTextField passed;
    private Color background;
    private JProgressBar progressBar;
    private JTextField total;
    private int num = 0;
    private boolean isPlaying;


    public ProgressBarPanel() {

        this.isPlaying = false;
        background = new Color(40, 40, 40);
        this.setForeground(new Color(179, 179, 179));
        this.setBackground(background);

        passed = new JTextField("00:00");
        passed.setFont(new Font("Arial", Font.CENTER_BASELINE, 9));
        passed.setEditable(false);
        passed.setBackground(background);
        passed.setForeground(new Color(179, 179, 179));
        this.add(passed);

        progressBar = new JProgressBar(0, 0);
        progressBar.setStringPainted(false);
        progressBar.setBorderPainted(true);
        progressBar.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                int mouseX = e.getX();
                int progressBarVal = (int) Math.round(((double) mouseX / (double) progressBar.getWidth()) * progressBar.getMaximum());
                progressBar.setValue(progressBarVal);
                num = progressBarVal;
                passed.setText("" + progressBar.getValue() / 60 + ":" + progressBar.getValue() % 60);
            }
        });
        this.add(progressBar);


        total = new JTextField("00:00");
        total.setFont(new Font("Arial", Font.CENTER_BASELINE, 9));
        total.setEditable(false);
        total.setBackground(background);
        total.setForeground(new Color(179, 179, 179));
        this.add(total);

    }


    public JProgressBar getProgressBar() {
        return progressBar;
    }

    public void refresh(int songDuration) {
        this.progressBar.setMaximum(songDuration);
        this.progressBar.setValue(0);
        this.total.setText("" + songDuration / 60 + ":" + songDuration % 60);
        this.passed.setText("00:00");
        this.num = 0;
        this.isPlaying = false;
    }

    public void iterate() {

        while (num < progressBar.getMaximum() && isPlaying == true) {
            progressBar.setValue(num);
            passed.setText("" + progressBar.getValue() / 60 + ":" + progressBar.getValue() % 60);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
            }
            num++;
        }
    }

    public void stop() {
        isPlaying = false;
    }


    @Override
    public void run() {
        isPlaying = true;
        iterate();
    }
}
