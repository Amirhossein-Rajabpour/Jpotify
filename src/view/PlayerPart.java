package view;

import controller.PlayPartController;
import javazoom.jl.decoder.JavaLayerException;
import javazoom.jl.player.Player;
import model.Song;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;

public class PlayerPart extends JPanel {

    private Color foreground;
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


    public PlayerPart() {
        // player part should work according to the playing song's place for example if the song is in play list
        // next and previous button should work with that playlist ArrayList

        super();
        setSize(700, 400);
        setBackground(new Color(40, 40, 40));
        foreground = new Color(179, 179, 179);
//        Song song1 = new Song("/Users/apple/Desktop/In the night.mpga");
        Song song1 = new Song("C:\\\\Users\\\\Asus\\\\Desktop\\\\50-Cent-Candy-Shop-@Otaghe8Bot.mp3");

        //C:\\Users\\Asus\\Desktop\\50-Cent-Candy-Shop-@Otaghe8Bot.mp3
//        Song song2 = new Song("/Users/apple/Desktop/03 Where Did You Sleep Last Night (In The Pines).mpga");
        Song song2 = new Song("C:\\\\Users\\\\Asus\\\\Desktop\\\\Cheri Cheri Lady - Modern Talking.mp3");

        //C:\\Users\\Asus\\Desktop\\Cheri Cheri Lady - Modern Talking.mp3
//        Song song3 = new Song("/Users/apple/Desktop/Another Brick Together (Original Mix).mpga");
        Song song3 = new Song("C:\\\\Users\\\\Asus\\\\Desktop\\\\Cheri Cheri Lady - Modern Talking.mp3");

        //C:\\Users\\Asus\\Desktop\\Cheri Cheri Lady - Modern Talking.mp3
        songs.add(song1);
        songs.add(song2);
        songs.add(song3);
        for (int i = 0; i < songs.size(); i++) {
            playingSongs.add(i, songs.get(i));
            shuffleSongs.add(i, songs.get(i));
        }
        Collections.shuffle(shuffleSongs);
        currentSong = 0;
        repeatOneIsOn = false;
        repeatAllIsOn = false;


        try {
/**
 * new input and player in constructor in order to resume a song
 */
            try {
                input = new FileInputStream(playingSongs.get(currentSong).getPath());
                player = new PlayPartController(input);

            } catch (FileNotFoundException e1) {
                e1.printStackTrace();
            } catch (JavaLayerException e1) {
                e1.printStackTrace();
            }


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
                        playingSongs = shuffleSongs;
                    } else {
                        shuffle.setText("🔀");
                        shuffle.setBackground(new Color(40, 40, 40));
                        shuffle.setToolTipText("Shuffle On");
                        playingSongs = songs;
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
                    previous.setBackground(new Color(55, 55, 55));
                }

                @Override
                public void mouseReleased(MouseEvent e) {
                    previous.setBackground(new Color(40, 40, 40));

                    player.pause();
                    playOrPause.setText("▶︎");
                    playOrPause.setToolTipText("Play");

                    if (repeatOneIsOn) {
                        currentSong = currentSong;
                        try {
                            input = new FileInputStream(playingSongs.get(currentSong).getPath());
                            player = new PlayPartController(input);
                            progressBarPanel.refresh((int) playingSongs.get(currentSong).getDuration());
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
                            } catch (FileNotFoundException e1) {
                                e1.printStackTrace();
                            } catch (JavaLayerException e1) {
                                e1.printStackTrace();
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
                    playOrPause.setBackground(new Color(55, 55, 55));
                }

                @Override
                public void mouseReleased(MouseEvent e) {

                    playOrPause.setBackground(new Color(40, 40, 40));

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
                    next.setBackground(new Color(55, 55, 55));
                }

                @Override
                public void mouseReleased(MouseEvent e) {
                    next.setBackground(new Color(40, 40, 40));

                    player.pause();
                    playOrPause.setText("▶︎");
                    playOrPause.setToolTipText("Play");

                    if (repeatOneIsOn) {
                        currentSong = currentSong;
                        try {
                            input = new FileInputStream(playingSongs.get(currentSong).getPath());
                            player = new PlayPartController(input);
                            progressBarPanel.refresh((int) playingSongs.get(currentSong).getDuration());
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
                            } catch (FileNotFoundException e1) {
                                e1.printStackTrace();
                            } catch (JavaLayerException e1) {
                                e1.printStackTrace();
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
                        repeatOneIsOn = true;
                        repeat.setToolTipText("Repeat All");
                        repeat.setBackground(new Color(55, 55, 55));
                        // Right the ActionEvent here Amirhosein
                    } else if (repeat.getText().equals("🔂")) {
                        repeat.setText("🔁");
                        repeatOneIsOn = false;
                        repeatAllIsOn = true;
                        repeat.setToolTipText("Repeat Off");
                        repeat.setBackground(new Color(55, 55, 55));
                    } else if (repeat.getText().equals("🔁") && repeat.getBackground().equals(new Color(55, 55, 55))) {
                        repeat.setText("🔁");
                        repeatAllIsOn = false;
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

    public void setSongs(ArrayList<Song> songs, int initialIndex) {
        this.songs = songs;
        this.currentSong = initialIndex;
        for (int i = 0; i < songs.size(); i++) {
            playingSongs.add(i, songs.get(i));
            shuffleSongs.add(i, songs.get(i));
        }
        Collections.shuffle(shuffleSongs);
        this.progressBarPanel.refresh((int) this.playingSongs.get(currentSong).getDuration());
    }

    public void setProgressBarPanel(ProgressBarPanel progressBarPanel) {
        this.progressBarPanel = progressBarPanel;
    }

    public void setSongInfoPanel(SongInfoPanel songInfoPanel) {
        this.songInfoPanel = songInfoPanel;
    }

    public void setSongLocationInSeconds(int second) {
        player.pause();
//        player.s
    }

//    public static<T> void shuffle(ArrayList<Song> songs)
//    {
//        Random random = new Random();
//
//        // start from end of the list
//        for (int i = songs.size() - 1; i >= 1; i--)
//        {
//            // get a random index j such that 0 <= j <= i
//            int j = random.nextInt(i + 1);
//
//            // swap element at i'th position in the list with element at
//            // randomly generated index j
//            Song obj = songs.get(i);
//            songs.set(i, songs.get(j));
//            songs.set(j, obj);
//        }
//    }

    //progressBar actionMethod that pauses goes to the particular point of the song must be added here
}
