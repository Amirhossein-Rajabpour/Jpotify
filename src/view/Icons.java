package view;

import javax.swing.*;
import java.awt.*;

public class Icons {

    private ImageIcon shareIcon;

    private ImageIcon playIcon;

    private ImageIcon pauseIcon;

    private ImageIcon previousIcon;

    private ImageIcon nextIcon;

    private ImageIcon shuffleIcon;

    private ImageIcon repeatOneIcon;

    private ImageIcon repeatAllIcon;

    private ImageIcon likeIcon;

    private ImageIcon unLikeIcon;


    public Icons() {

        playIcon = new ImageIcon("/Users/apple/Desktop/playIcon.png");
        Image image = playIcon.getImage(); // transform it
        Image newimg = image.getScaledInstance(24, 24, java.awt.Image.SCALE_SMOOTH); // scale it the smooth way
        playIcon = new ImageIcon(newimg);

        pauseIcon = new ImageIcon("/Users/apple/Desktop/pauseIcon.png");
        Image image1 = pauseIcon.getImage(); // transform it
        Image newimg1 = image1.getScaledInstance(24, 24, java.awt.Image.SCALE_SMOOTH); // scale it the smooth way
        pauseIcon = new ImageIcon(newimg1);

        previousIcon = new ImageIcon("/Users/apple/Desktop/previousIcon.png");
        Image image9 = previousIcon.getImage(); // transform it
        Image newimg9 = image9.getScaledInstance(24, 24, java.awt.Image.SCALE_SMOOTH); // scale it the smooth way
        previousIcon = new ImageIcon(newimg9);

        nextIcon = new ImageIcon("/Users/apple/Desktop/nextIcon.png");
        Image image2 = nextIcon.getImage(); // transform it
        Image newimg2 = image2.getScaledInstance(24, 24, java.awt.Image.SCALE_SMOOTH); // scale it the smooth way
        nextIcon = new ImageIcon(newimg2);

        shuffleIcon = new ImageIcon("/Users/apple/Desktop/shuffleIcon.png");
        Image image3 = shuffleIcon.getImage(); // transform it
        Image newimg3 = image3.getScaledInstance(24, 24, java.awt.Image.SCALE_SMOOTH); // scale it the smooth way
        shuffleIcon = new ImageIcon(newimg3);

        repeatOneIcon = new ImageIcon("/Users/apple/Desktop/repeat1Icon.png");
        Image image4 = repeatOneIcon.getImage(); // transform it
        Image newimg4 = image4.getScaledInstance(24, 24, java.awt.Image.SCALE_SMOOTH); // scale it the smooth way
        repeatOneIcon = new ImageIcon(newimg4);

        repeatAllIcon = new ImageIcon("/Users/apple/Desktop/repeatAllIcon.png");
        Image image5 = repeatAllIcon.getImage(); // transform it
        Image newimg5 = image5.getScaledInstance(24, 24, java.awt.Image.SCALE_SMOOTH); // scale it the smooth way
        repeatAllIcon = new ImageIcon(newimg5);

        likeIcon = new ImageIcon("/Users/apple/Desktop/likeIcon.png");
        Image image6 = likeIcon.getImage(); // transform it
        Image newimg6 = image6.getScaledInstance(24, 24, java.awt.Image.SCALE_SMOOTH); // scale it the smooth way
        likeIcon = new ImageIcon(newimg6);

        unLikeIcon = new ImageIcon("/Users/apple/Desktop/unlikeIcon.png");
        Image image7 = unLikeIcon.getImage(); // transform it
        Image newimg7 = image7.getScaledInstance(24, 24, java.awt.Image.SCALE_SMOOTH); // scale it the smooth way
        unLikeIcon = new ImageIcon(newimg7);

        shareIcon = new ImageIcon("/Users/apple/Desktop/JpotifyIcon.png");
        Image image8 = shareIcon.getImage(); // transform it
        Image newimg8 = image8.getScaledInstance(24, 24, java.awt.Image.SCALE_SMOOTH); // scale it the smooth way
        shareIcon = new ImageIcon(newimg8);


    }

    public ImageIcon getLikeIcon() {
        return likeIcon;
    }

    public ImageIcon getNextIcon() {
        return nextIcon;
    }

    public ImageIcon getPauseIcon() {
        return pauseIcon;
    }

    public ImageIcon getPlayIcon() {
        return playIcon;
    }

    public ImageIcon getPreviousIcon() {
        return previousIcon;
    }

    public ImageIcon getRepeatAllIcon() {
        return repeatAllIcon;
    }

    public ImageIcon getRepeatOneIcon() {
        return repeatOneIcon;
    }

    public ImageIcon getShareIcon() {
        return shareIcon;
    }

    public ImageIcon getShuffleIcon() {
        return shuffleIcon;
    }

    public ImageIcon getUnLikeIcon() {
        return unLikeIcon;
    }
}
