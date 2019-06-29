package view.Player;

import controller.PlayPartController;
import controller.AudioController;
import javazoom.jl.decoder.JavaLayerException;
import model.Album;
import model.Song;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;

/**
 * this class handles play and pause and next and previous and also shuffle features for songs
 * also a song can be added to favourite songs here and also be marked as sharable on network
 */
public class PlayerPart extends JPanel {

    private Color foreground;
    private Color background;
    private Color pressedBackground;
    private JTextField share;
    private JTextField shuffle;
    private JTextField previous;
    private JTextField playOrPause;
    private JTextField next;
    private JTextField repeat;
    private JTextField favorite;
    private int currentSong;
    private ProgressBarPanel progressBarPanel;
    private ArrayList<Song> songs = new ArrayList<>();
    private ArrayList<Song> shuffleSongs = new ArrayList<>();
    private ArrayList<Song> playingSongs = new ArrayList<>();
    private PlayPartController player;
    private FileInputStream input;
    private boolean repeatAllIsOn;
    private boolean repeatOneIsOn;
    private SongInfoPanel songInfoPanel;
    private AudioController audioController;
    private ArrayList<Album> albums;
    private Thread thread;


    public PlayerPart() {
        // player part should work according to the playing song's place for example if the song is in play list
        // next and previous button should work with that playlist ArrayList

        super();
        audioController = new AudioController();
        setSize(700, 400);

        background = new Color(40, 40, 40);
        setBackground(background);
        pressedBackground = new Color(65, 65, 65);
        foreground = new Color(179, 179, 179);

        currentSong = 0;
        repeatOneIsOn = false;
        repeatAllIsOn = false;


        try {
/**
 * new input and player in constructor in order to resume a song
 */

            share = new JTextField("➚");
            share.setBackground(this.getBackground());
            share.setForeground(foreground);
            share.setEditable(false);
            share.setToolTipText("Share");
            share.addMouseListener(new MouseListener() {
                @Override
                public void mouseClicked(MouseEvent e) {

                }

                @Override
                public void mousePressed(MouseEvent e) {

                }

                @Override
                public void mouseReleased(MouseEvent e) {
                    if (songs.size() != 0) {
                        if (share.getBackground().equals(background)) {
                            share.setBackground(pressedBackground);
                            share.setToolTipText("Unshare");
                            if (songs.size() != 0) {
                                songs.get(currentSong).setSharable(true);
                            }

                        } else {
                            share.setBackground(background);
                            share.setToolTipText("Share");
                            if (songs.size() != 0) {
                                songs.get(currentSong).setSharable(false);
                            }
                        }
                    }
                }

                @Override
                public void mouseEntered(MouseEvent e) {

                }

                @Override
                public void mouseExited(MouseEvent e) {

                }
            });
            add(share);

/**
 * playing on shuffle mode
 */
            shuffle = new JTextField("⤨");
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
                    if (songs.size() != 0) {
                        if (shuffle.getText().equals("⤨") && shuffle.getBackground().equals(background)) {
                            shuffle.setBackground(pressedBackground);
                            shuffle.setToolTipText("Shuffle Off");
                            playingSongs = shuffleSongs;
                        } else {
                            shuffle.setText("⤨");
                            shuffle.setBackground(background);
                            shuffle.setToolTipText("Shuffle On");
                            playingSongs = songs;
                        }
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

/**
 * going to previous song
 */
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
                    previous.setBackground(pressedBackground);
                }

                @Override
                public void mouseReleased(MouseEvent e) {
                    previous.setBackground(background);
/**
 * playing and pausing and multithreading here
 */
                    if (songs.size() != 0) {
                        player.pause();
                        playOrPause.setText("▶︎");
                        playOrPause.setToolTipText("Play");

                        if (repeatOneIsOn) {
                            currentSong = currentSong;
                            try {
                                input = new FileInputStream(playingSongs.get(currentSong).getPath());
                                player = new PlayPartController(input);
                                progressBarPanel.refresh((int) playingSongs.get(currentSong).getDuration());
                                songInfoPanel.refresh(playingSongs.get(currentSong).getArtwork(), playingSongs.get(currentSong).getTitle(), playingSongs.get(currentSong).getArtistName(), playingSongs.get(currentSong).getAlbumName());
                            } catch (FileNotFoundException e1) {
                                e1.printStackTrace();
                            } catch (JavaLayerException e1) {
                                e1.printStackTrace();
                            }
                        } else if (repeatAllIsOn && currentSong == 0) {
                            currentSong = playingSongs.size() - 1;
                            try {
                                input = new FileInputStream(playingSongs.get(currentSong).getPath());
                                player = new PlayPartController(input);
                                progressBarPanel.refresh((int) playingSongs.get(currentSong).getDuration());
                                songInfoPanel.refresh(playingSongs.get(currentSong).getArtwork(), playingSongs.get(currentSong).getTitle(), playingSongs.get(currentSong).getArtistName(), playingSongs.get(currentSong).getAlbumName());
                            } catch (FileNotFoundException e1) {
                                e1.printStackTrace();
                            } catch (JavaLayerException e1) {
                                e1.printStackTrace();
                            }
                        } else {
                            if (currentSong != 0) {
                                currentSong--;
                                /**
                                 * new input and player here for going to next song
                                 */
                                try {
                                    input = new FileInputStream(playingSongs.get(currentSong).getPath());
                                    player = new PlayPartController(input);
                                    progressBarPanel.refresh((int) playingSongs.get(currentSong).getDuration());
                                    songInfoPanel.refresh(playingSongs.get(currentSong).getArtwork(), playingSongs.get(currentSong).getTitle(), playingSongs.get(currentSong).getArtistName(), playingSongs.get(currentSong).getAlbumName());
                                } catch (FileNotFoundException e1) {
                                    e1.printStackTrace();
                                } catch (JavaLayerException e1) {
                                    e1.printStackTrace();
                                }
                                if (songs.get(currentSong).isSharable()) {
                                    share.setBackground(pressedBackground);
                                    share.setToolTipText("Unshare");
                                } else {
                                    share.setBackground(background);
                                    share.setToolTipText("Share");
                                }

                                if (songs.get(currentSong).isFavourite()) {
                                    favorite.setText("💔");
                                    favorite.setToolTipText("Unlike");
                                } else {
                                    favorite.setText("♥︎");
                                    favorite.setToolTipText("Like");
                                }
                            }
                        }
                    }

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
                    playOrPause.setBackground(pressedBackground);
                }

                @Override
                public void mouseReleased(MouseEvent e) {

                    playOrPause.setBackground(background);

                    if (player != null) {
                        if (playOrPause.getText().equals("▶︎")) {

                            try {

                                player.play();

                                thread = new Thread(progressBarPanel);
                                thread.start();


                                sortSongs(currentSong);
                                sortAlbums(currentSong);
//                            soundController.setGain();
                            } catch (JavaLayerException e1) {
                                e1.printStackTrace();
                            }
                            playOrPause.setText("⏸");
                            playOrPause.setToolTipText("Pause");
                        } else {
                            player.pause();
                            progressBarPanel.stop();
                            playOrPause.setText("▶︎");
                            playOrPause.setToolTipText("Play");
                        }

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
/**
 * going to next song
 */

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
                    next.setBackground(pressedBackground);
                }

                @Override
                public void mouseReleased(MouseEvent e) {
                    next.setBackground(background);
                    if (songs.size() != 0) {
                        player.pause();
                        playOrPause.setText("▶︎");
                        playOrPause.setToolTipText("Play");

                        if (repeatOneIsOn) {
                            currentSong = currentSong;
                            try {
                                input = new FileInputStream(playingSongs.get(currentSong).getPath());
                                player = new PlayPartController(input);
                                progressBarPanel.refresh((int) playingSongs.get(currentSong).getDuration());
                                songInfoPanel.refresh(playingSongs.get(currentSong).getArtwork(), playingSongs.get(currentSong).getTitle(), playingSongs.get(currentSong).getArtistName(), playingSongs.get(currentSong).getAlbumName());
                            } catch (FileNotFoundException e1) {
                                e1.printStackTrace();
                            } catch (JavaLayerException e1) {
                                e1.printStackTrace();
                            }
                        } else if (repeatAllIsOn && currentSong == playingSongs.size() - 1) {
                            currentSong = 0;
                            try {
                                input = new FileInputStream(playingSongs.get(currentSong).getPath());
                                player = new PlayPartController(input);
                                progressBarPanel.refresh((int) playingSongs.get(currentSong).getDuration());
                                songInfoPanel.refresh(playingSongs.get(currentSong).getArtwork(), playingSongs.get(currentSong).getTitle(), playingSongs.get(currentSong).getArtistName(), playingSongs.get(currentSong).getAlbumName());
                            } catch (FileNotFoundException e1) {
                                e1.printStackTrace();
                            } catch (JavaLayerException e1) {
                                e1.printStackTrace();
                            }
                        } else {
                            if (currentSong != playingSongs.size() - 1) {
                                currentSong++;
                                /**
                                 * new input and player here for going to next song
                                 */
                                try {
                                    input = new FileInputStream(playingSongs.get(currentSong).getPath());
                                    player = new PlayPartController(input);
                                    progressBarPanel.refresh((int) playingSongs.get(currentSong).getDuration());
                                    songInfoPanel.refresh(playingSongs.get(currentSong).getArtwork(), playingSongs.get(currentSong).getTitle(), playingSongs.get(currentSong).getArtistName(), playingSongs.get(currentSong).getAlbumName());
                                } catch (FileNotFoundException e1) {
                                    e1.printStackTrace();
                                } catch (JavaLayerException e1) {
                                    e1.printStackTrace();
                                }

                                if (songs.get(currentSong).isSharable()) {
                                    share.setBackground(pressedBackground);
                                    share.setToolTipText("Unshare");
                                } else {
                                    share.setBackground(background);
                                    share.setToolTipText("Share");
                                }

                                if (songs.get(currentSong).isFavourite()) {
                                    favorite.setText("💔");
                                    favorite.setToolTipText("Unlike");
                                } else {
                                    favorite.setText("♥︎");
                                    favorite.setToolTipText("Like");
                                }
                            }
                        }
                    }


                }

                @Override
                public void mouseEntered(MouseEvent e) {

                }

                @Override
                public void mouseExited(MouseEvent e) {

                }
            });
            add(next);

/**
 * repeating song
 */
            repeat = new JTextField("⤿");
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
                    if (songs.size() != 0) {
                        if (repeat.getText().equals("⟲") && repeat.getBackground().equals(background)) {
                            repeat.setText("⤿");
                            repeatOneIsOn = true;
                            repeat.setToolTipText("Repeat All");
                            repeat.setBackground(pressedBackground);
                            // Right the ActionEvent here Amirhosein
                        } else if (repeat.getText().equals("⤿")) {
                            repeat.setText("⟲");
                            repeatOneIsOn = false;
                            repeatAllIsOn = true;
                            repeat.setToolTipText("Repeat Off");
                            repeat.setBackground(pressedBackground);
                        } else if (repeat.getText().equals("⟲") && repeat.getBackground().equals(pressedBackground)) {
                            repeat.setText("⤿");
                            repeatAllIsOn = false;
                            repeat.setToolTipText("Repeat One");
                            repeat.setBackground(background);
                        }
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
                    if (songs.size() != 0) {
                        if (favorite.getText().equals("♥︎")) {
                            favorite.setText("💔");
                            favorite.setToolTipText("Unlike");
                            if (songs.size() != 0) {
                                songs.get(currentSong).setFavourite(true);
                            }
                            System.out.println("liked");

                        } else {
                            favorite.setText("♥︎");
                            favorite.setToolTipText("Like");

                            songs.get(currentSong).setFavourite(false);
                        }
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

    /**
     * this method sets an array for player and also mention which element of array should be played
     *
     * @param songs
     * @param initialIndex
     */
    public void setSongs(ArrayList<Song> songs, int initialIndex) {

        if (songs.size() == 0) {
            progressBarPanel.refresh(0);
            songInfoPanel.refresh(null, null, null, null);
            if (player != null) {
                player.pause();
                player.close();
            }
        } else {
            this.songs = songs;
            this.currentSong = initialIndex;
            playingSongs = new ArrayList<>();
            shuffleSongs = new ArrayList<>();

            for (int i = 0; i < songs.size(); i++) {
                playingSongs.add(songs.get(i));
                shuffleSongs.add(songs.get(i));
            }
            Collections.shuffle(shuffleSongs);
            this.progressBarPanel.refresh((int) this.playingSongs.get(currentSong).getDuration());
            songInfoPanel.refresh(playingSongs.get(currentSong).getArtwork(), playingSongs.get(currentSong).getTitle(), playingSongs.get(currentSong).getArtistName(), playingSongs.get(currentSong).getAlbumName());
            if (player != null && playOrPause.getText().equals("⏸")) {
                player.pause();
                playOrPause.setText("▶︎");
                playOrPause.setToolTipText("Play");
            }
            try {
                input = new FileInputStream(playingSongs.get(currentSong).getPath());
                player = new PlayPartController(input);

            } catch (FileNotFoundException e1) {
                e1.printStackTrace();
            } catch (JavaLayerException e1) {
                e1.printStackTrace();
            }
            if (songs.get(initialIndex).isFavourite()) {
                favorite.setText("💔");
                favorite.setToolTipText("Unlike");
            } else {
                favorite.setText("♥︎");
                favorite.setToolTipText("Like");
            }
            if (songs.get(initialIndex).isSharable()) {
                share.setBackground(pressedBackground);
                share.setToolTipText("Unshare");
            } else {
                share.setBackground(background);
                share.setToolTipText("Share");
            }
        }


    }

    public void setProgressBarPanel(ProgressBarPanel progressBarPanel) {
        this.progressBarPanel = progressBarPanel;
    }

    public void setSongInfoPanel(SongInfoPanel songInfoPanel) {
        this.songInfoPanel = songInfoPanel;
    }

    /**
     * this method takes an arraylis and an index and put the index song at the beggining of the arraylist and shift other parts
     *
     * @param index
     * @return
     */
    public void sortSongs(int index) {

        Song tmp;
        tmp = songs.get(index);
        for (int i = index; i >= 1; i--) {
            songs.set(i, songs.get(i - 1));
        }
        songs.set(0, tmp);

    }

    public void sortAlbums(int index) {

        for (int i = 0; i < albums.size(); i++) {
            if (songs.get(index).getAlbumName().equals(albums.get(i).getAlbumName())) {
                index = i;
                break;
            }
        }
//
//        Album tmp;
//        tmp = albums.get(index);
//        for (int i = index; i >= 1; i--) {
//            albums.set(i, albums.get(i - 1));
//        }
//        albums.set(0, tmp);

    }

    public void setAlbums(ArrayList<Album> albums) {
        this.albums = albums;
    }

    public void setCurrentSec(long sec) {

    }


    public void playerPause() {
        this.player.pause();
    }

    public void setSongLocationInSeconds(int second) {
        player.pause();
    }


    //progressBar actionMethod that pauses goes to the particular point of the song must be added here
}
