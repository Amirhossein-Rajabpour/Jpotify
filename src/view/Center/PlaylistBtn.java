package view.Center;

import model.Song;
import view.Player.PlayerPart;

import javax.swing.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.Objects;

public class PlaylistBtn extends JPanel {

    private ArrayList<String> playlistNames;
    private String playlistName;
    private PlayerPart playerPart;
    private ArrayList<Song> songs;
    private ArrayList<Song> showSongs;

    public PlaylistBtn(ArrayList<Song> songs, String playlistName, PlayerPart playerPart, ShowPanel showPanel) {

        super();
        this.playerPart = playerPart;
        this.playlistName = playlistName;
        this.songs = songs;
        this.showSongs = new ArrayList<>();


        JLabel jLabel = new JLabel(playlistName);
        this.add(jLabel);


        for (int i = 0; i < songs.size(); i++) {

            System.out.println(playlistName + ";;;;");

            for (int j = 0; j<songs.get(i).getPlaylists().size(); j++){

                if (Objects.equals(songs.get(i).getPlaylists().get(j).getPlaylistName(), playlistName)){
                    showSongs.add(songs.get(i));
                    System.out.println(playlistName);
                }

            }


//            if (songs.get(i).getPlaylists().contains(playlistName)){
//                showSongs.add(songs.get(i));
//                System.out.println(playlistName);
//            }

        }

        this.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
//                if(e.getButton() == MouseEvent.BUTTON2) {
//                    System.out.println("cnabcajbcalcb");
//                }
            }

            @Override
            public void mousePressed(MouseEvent e) {

            }

            @Override
            public void mouseReleased(MouseEvent e) {
                showPanel.removeAll();
                showPanel.repaint();
                showPanel.setSongs(showSongs);
                showPanel.revalidate();
            }

            @Override
            public void mouseEntered(MouseEvent e) {

            }

            @Override
            public void mouseExited(MouseEvent e) {

            }
        });


    }
}
