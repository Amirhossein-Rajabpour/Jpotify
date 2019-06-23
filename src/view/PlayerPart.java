package view;

import controller.PlayPartController;
import javazoom.jl.decoder.JavaLayerException;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.FileInputStream;

public class PlayerPart extends JPanel {

    private Color foreground;
    private JTextField share;
    private JTextField shuffle;
    private JTextField previous;
    private JTextField playOrPause;
    private JTextField next;
    private JTextField repeat;
    private JTextField favorite;


    public PlayerPart() {

        super();
        setSize(700, 400);
        setBackground(new Color(40, 40, 40));
        foreground = new Color(179, 179, 179);


        try {
            FileInputStream input = new FileInputStream("/Users/apple/Desktop/In the night.mpga");
            PlayPartController player = new PlayPartController(input);


            shuffle = new JTextField("🔀");
            shuffle.setBackground(this.getBackground());
            shuffle.setForeground(foreground);
            shuffle.setEditable(false);
            shuffle.setToolTipText("Shuffle On");
            shuffle.addMouseListener(new MouseListener() {
                @Override
                public void mouseClicked(MouseEvent e) {

                }

                @Override
                public void mousePressed(MouseEvent e) {

                }

                @Override
                public void mouseReleased(MouseEvent e) {
                    if (shuffle.getText().equals("🔀") && shuffle.getBackground().equals(new Color(40, 40, 40))) {
//                        shuffle.setText("➜");
                        shuffle.setBackground(new Color(55, 55, 55));
                        shuffle.setToolTipText("Shuffle Off");
                        // Right the ActionEvent here Amirhosein
                    } else {
                        shuffle.setText("🔀");
                        shuffle.setBackground(new Color(40, 40, 40));
                        shuffle.setToolTipText("Shuffle On");
                    }
                }

                @Override
                public void mouseEntered(MouseEvent e) {

                }

                @Override
                public void mouseExited(MouseEvent e) {

                }
            });
            add(shuffle);


            previous = new JTextField("𝄅◀︎");
            previous.setBackground(this.getBackground());
            previous.setForeground(foreground);
            previous.setEditable(false);
            previous.setToolTipText("Previous");
            previous.addMouseListener(new MouseListener() {
                @Override
                public void mouseClicked(MouseEvent e) {

                }

                @Override
                public void mousePressed(MouseEvent e) {

                }

                @Override
                public void mouseReleased(MouseEvent e) {
                    // Right the ActionEvent here Amirhosein
                }

                @Override
                public void mouseEntered(MouseEvent e) {

                }

                @Override
                public void mouseExited(MouseEvent e) {

                }
            });
            add(previous);


            ImageIcon playIcon = new ImageIcon("/Users/apple/Downloads/playIcon.png");
            Image image = playIcon.getImage(); // transform it
            Image newimg = image.getScaledInstance(15, 15, java.awt.Image.SCALE_SMOOTH); // scale it the smooth way
            playIcon = new ImageIcon(newimg);

            ImageIcon pauseIcon = new ImageIcon("/Users/apple/Downloads/pauseIcon.png");
            Image image2 = pauseIcon.getImage(); // transform it
            Image newimg2 = image2.getScaledInstance(40, 20, java.awt.Image.SCALE_SMOOTH); // scale it the smooth way
            pauseIcon = new ImageIcon(newimg2);


            playOrPause = new JTextField("▶︎");
            playOrPause.setBackground(this.getBackground());
            playOrPause.setForeground(foreground);
            playOrPause.setEditable(false);
            playOrPause.setToolTipText("Play");
            playOrPause.addMouseListener(new MouseListener() {
                @Override
                public void mouseClicked(MouseEvent e) {

                }

                @Override
                public void mousePressed(MouseEvent e) {

                }

                @Override
                public void mouseReleased(MouseEvent e) {
                    if (playOrPause.getText().equals("▶︎")) {
                        try {
                            player.play();
                        } catch (JavaLayerException e1) {
                            e1.printStackTrace();
                        }
                        playOrPause.setText("⏸");
                        playOrPause.setToolTipText("Pause");
                    } else {
                        player.pause();
                        playOrPause.setText("▶︎");
                        playOrPause.setToolTipText("Play");
                    }
                }

                @Override
                public void mouseEntered(MouseEvent e) {

                }

                @Override
                public void mouseExited(MouseEvent e) {

                }
            });
            add(playOrPause);


//            next = new JButton("next");
//            next.setToolTipText("next song");
            next = new JTextField("▶𝄅");
            next.setBackground(this.getBackground());
            next.setForeground(foreground);
            next.setEditable(false);
            next.setToolTipText("Next");
            next.addMouseListener(new MouseListener() {
                @Override
                public void mouseClicked(MouseEvent e) {

                }

                @Override
                public void mousePressed(MouseEvent e) {

                }

                @Override
                public void mouseReleased(MouseEvent e) {
                    // Right the ActionEvent here Amirhosein
                }

                @Override
                public void mouseEntered(MouseEvent e) {

                }

                @Override
                public void mouseExited(MouseEvent e) {

                }
            });
            add(next);


            repeat = new JTextField("🔁");
            repeat.setBackground(this.getBackground());
            repeat.setForeground(foreground);
            repeat.setEditable(false);
            repeat.setToolTipText("Repeat One");
            repeat.addMouseListener(new MouseListener() {
                @Override
                public void mouseClicked(MouseEvent e) {

                }

                @Override
                public void mousePressed(MouseEvent e) {

                }

                @Override
                public void mouseReleased(MouseEvent e) {
                    if (repeat.getText().equals("🔁") && repeat.getBackground().equals(new Color(40, 40, 40))) {
                        repeat.setText("🔂");
                        repeat.setToolTipText("Repeat All");
                        repeat.setBackground(new Color(55, 55, 55));
                        // Right the ActionEvent here Amirhosein
                    } else if (repeat.getText().equals("🔂")) {
                        repeat.setText("🔁");
                        repeat.setToolTipText("Repeat Off");
                        repeat.setBackground(new Color(55, 55, 55));
                    } else if (repeat.getText().equals("🔁") && repeat.getBackground().equals(new Color(55, 55, 55))) {
                        repeat.setText("🔁");
                        repeat.setToolTipText("Repeat One");
                        repeat.setBackground(new Color(40, 40, 40));
                    }
                }

                @Override
                public void mouseEntered(MouseEvent e) {

                }

                @Override
                public void mouseExited(MouseEvent e) {

                }
            });
            add(repeat);


            favorite = new JTextField("♥︎");
            favorite.setBackground(this.getBackground());
            favorite.setForeground(foreground);
            favorite.setEditable(false);
            favorite.setToolTipText("Like");
            favorite.addMouseListener(new MouseListener() {
                @Override
                public void mouseClicked(MouseEvent e) {

                }

                @Override
                public void mousePressed(MouseEvent e) {

                }

                @Override
                public void mouseReleased(MouseEvent e) {
                    if (favorite.getText().equals("♥︎")) {
                        favorite.setText("💔");
                        favorite.setToolTipText("Unlike");
                        // Right the ActionEvent here Amirhosein
                    } else {
                        favorite.setText("♥︎");
                        favorite.setToolTipText("Like");
                    }
                }

                @Override
                public void mouseEntered(MouseEvent e) {

                }

                @Override
                public void mouseExited(MouseEvent e) {

                }
            });
            add(favorite);


            setVisible(true);
        } catch (final Exception e) {
            throw new RuntimeException(e);
        }
    }
}
