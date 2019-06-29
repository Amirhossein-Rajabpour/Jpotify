package view.Center;

import model.Song;
import view.Library.LibraryPart;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.ArrayList;

/**
 * ToolBar panel at the top of the CentralPanel and MainPage
 */
public class ToolBar extends JPanel {

    private RoundTextField searchBox;
    private JTextField userNameTextField;
    private ArrayList<Song> searchedSongs = new ArrayList<>();

    public ToolBar(String userName, LibraryPart libraryPart, ShowPanel showPanel) {
        super();
        this.setLayout(new BorderLayout(15, 15));
        this.setBackground(new Color(33, 33, 33));
        this.setPreferredSize(new Dimension(400, 20));
        this.setMaximumSize(new Dimension(160, 700));


        searchBox = new RoundTextField(15);
        searchBox.setDefaultText("🔍 Search");
        this.add(searchBox, BorderLayout.WEST);


        this.userNameTextField = new JTextField(userName);
        userNameTextField.setFont(new Font("TimesNewRoman", Font.LAYOUT_RIGHT_TO_LEFT, 9));
        userNameTextField.setForeground(new Color(179, 179, 179));
        userNameTextField.setBackground(new Color(33, 33, 33, 0));
        userNameTextField.setEditable(false);
        this.add(userNameTextField, BorderLayout.EAST);

        searchBox.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                super.keyPressed(e);
                if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                    searchedSongs = null;
                    searchedSongs = new ArrayList<>();
                    String search = searchBox.getText();
                    if (search.equals("") || search.equals("🔍 Search")) {
                        showPanel.removeAll();
                        showPanel.repaint();
                        showPanel.revalidate();
                    } else {

                        for (Song song : libraryPart.getSongs()) {
                            if (song.getTitle().contains(search.toString()) || song.getAlbumName().contains(search.toString()) || song.getArtistName().contains(search.toString())) {
                                searchedSongs.add(song);
                                showPanel.removeAll();
                                showPanel.repaint();
                                showPanel.setSongs(searchedSongs);
                                showPanel.revalidate();
                            }
                        }
                    }

                }
            }
        });
        revalidate();
    }
}
