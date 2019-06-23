package view;
import javazoom.jl.player.Player;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class PlayerPart extends JPanel{

    JButton playOrPause;
    JButton next;
    JButton previous;
    JButton favourite;
    JLabel  songInfo;


    public PlayerPart(){

        super();
        setSize(700,400);
//        songInfo = new JLabel(song.getTitle() + " by " + song.getArtistName());

        previous = new JButton("previous");
//        previous.setPreferredSize(new Dimension(30,30));
        previous.setBounds(400,100,15,15);
        previous.setToolTipText("previous song");
        add(previous);

        playOrPause = new JButton("play");
//        playOrPause.setIcon();
        playOrPause.setBounds(350,100,20,20);
        playOrPause.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                FileInputStream file = null;
                //                    file = new FileInputStream(song.getPath());
//                    Player playMP3 = new Player(file);
//                    playMP3.play();


                if(playOrPause.getText().equals("play"))
                playOrPause.setText("pause");
                else {
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
    }
}
