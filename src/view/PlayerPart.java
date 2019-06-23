package view;
import javazoom.jl.player.Player;

import controller.PlayPartController;
import javazoom.jl.decoder.JavaLayerException;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class PlayerPart extends JPanel {

    JButton playOrPause;
    JButton next;
    JButton previous;
    JButton favourite;
    JLabel songInfo;


    public PlayerPart() {

        super();
        setSize(700, 400);
//        songInfo = new JLabel(song.getTitle() + " by " + song.getArtistName());

        try {
            FileInputStream input = new FileInputStream("/Users/apple/Desktop/03 Where Did You Sleep Last Night (In The Pines).mpga");
            PlayPartController player = new PlayPartController(input);


            previous = new JButton("previous");
            previous.setBounds(400, 100, 15, 15);
            previous.setToolTipText("previous song");
            add(previous);


            playOrPause = new JButton("play");
            playOrPause.setBounds(350, 100, 20, 20);
            playOrPause.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {


                    if (playOrPause.getText().equals("play")) {
                        try {
                            player.play();
                        } catch (JavaLayerException e1) {
                            e1.printStackTrace();
                        }
                        playOrPause.setText("pause");
                    } else {
                        player.pause();
                        playOrPause.setText("play");
                    }
                }
            });
            add(playOrPause);

            next = new JButton("next");
            next.setToolTipText("next song");
            add(next);

//        Icon like = new ImageIcon(getClass().getResource("view/like.png"));
            favourite = new JButton();
//        favourite.setRolloverIcon(like);
            favourite.setMargin(new Insets(0, 0, 0, 0));
            add(favourite);

            setVisible(true);
        } catch (final Exception e) {
            throw new RuntimeException(e);
        }
    }
}
