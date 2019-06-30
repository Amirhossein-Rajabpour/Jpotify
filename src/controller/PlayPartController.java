package controller;

import javazoom.jl.decoder.JavaLayerException;
import javazoom.jl.player.advanced.AdvancedPlayer;

import java.io.IOException;
import java.io.InputStream;

public class PlayPartController {

    private final static int NOTSTARTED = 0;
    private final int PLAYING = 1;
    private final int PAUSED = 2;
    private final int FINISHED = 3;

    public AdvancedPlayer getPlayer() {
        return player;
    }

    // the player actually doing all the work
    private AdvancedPlayer player;
    // locking object used to communicate with player thread
    private Object playerLock = new Object();
    // status variable what player thread is doing/supposed to do
    private int playerStatus;
    private InputStream inputStream;

    public InputStream getInputStream() {
        return inputStream;
    }

    public PlayPartController(InputStream inputStream) throws JavaLayerException, IOException {
        playerStatus = NOTSTARTED;
        player = new AdvancedPlayer(inputStream);
        this.inputStream = inputStream;
    }

    public int getPlayerStatus() {
        return playerStatus;
    }
    //    public PauseablePlayer(final InputStream inputStream, final AudioDevice audioDevice) throws JavaLayerException {
//        this.player = new Player(inputStream, audioDevice);
//    }

    /**
     * Starts playback (resumes if paused)
     */
    public void play(int start, int end) {
        synchronized (playerLock) {
            switch (playerStatus) {
                case NOTSTARTED:
                    Runnable r = () -> {
                        try {
                            playInternal(start, end);
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    };
                    final Thread t = new Thread(r);
                    t.setDaemon(true);
                    t.setPriority(Thread.MAX_PRIORITY);
                    playerStatus = PLAYING;
                    t.start();
                    break;
                case PAUSED:
                    resume();
                    break;
                default:
                    break;
            }
        }
    }

    /**
     * Pauses playback. Returns true if new state is PAUSED.
     */
    public boolean pause() {
        synchronized (playerLock) {
            if (playerStatus == PLAYING) {
                playerStatus = PAUSED;
            }
            return playerStatus == PAUSED;
        }
    }

    /**
     * Resumes playback. Returns true if the new state is PLAYING.
     */

    public boolean resume() {
        synchronized (playerLock) {
            if (playerStatus == PAUSED) {
                playerStatus = PLAYING;
                playerLock.notifyAll();
            }
            return playerStatus == PLAYING;
        }
    }

    /**
     * Stops playback. If not playing, does nothing
     */
    public void stop() {
        synchronized (playerLock) {
            playerStatus = FINISHED;
            playerLock.notifyAll();
        }
    }

    private void playInternal(int start, int end) throws IOException {
        while (playerStatus != FINISHED) {
            try {
                if (start == 0) {
                    if (!player.play(1)) {
                        break;
                    }
                } else {
                    boolean b;
                    b = player.play(start, end);
                }
            } catch (final JavaLayerException e) {
                break;
            }
            // check if paused or terminated
            synchronized (playerLock) {
                while (playerStatus == PAUSED) {
                    try {
                        playerLock.wait();
                    } catch (final InterruptedException e) {
                        // terminate player
                        break;
                    }
                }
            }
        }
        close();
    }

    /**
     * Closes the player, regardless of current state.
     */
    public void close() {
        synchronized (playerLock) {
            playerStatus = FINISHED;
        }
        try {
            player.close();
        } catch (final Exception e) {
            // ignore, we are terminating anyway
        }
    }


    @Override
    public String toString() {
        return "Player{" +
                "PLAYING=" + PLAYING +
                ", PAUSED=" + PAUSED +
                ", FINISHED=" + FINISHED +
                ", player=" + player +
                ", playerLock=" + playerLock +
                ", playerStatus=" + playerStatus +
                '}';
    }
}