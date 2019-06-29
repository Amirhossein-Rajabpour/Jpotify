package view.Center;

import model.Album;
import model.Song;
import view.Library.LibraryPart;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.ArrayList;

/**
 * ToolBar panel at the top of the CentralPanel and MainPage
 */
public class ToolBar extends JPanel {

    private RoundTextField searchBox;
    private JTextField userNameTextField;
    private JSeparator jSeparator;
//    private LibraryPart libraryPart; // alaki


    private ArrayList<Song> searchedSongs = new ArrayList<>();

    public ToolBar(String userName, LibraryPart libraryPart) {
        super();
        this.setLayout(new BorderLayout(15, 15));
        this.setBackground(new Color(33, 33, 33));
        this.setPreferredSize(new Dimension(400, 20));
        this.setMaximumSize(new Dimension(160, 700));


//        JPanel emptyPanel = new JPanel();
//        emptyPanel.setBackground(this.getBackground());
//        emptyPanel.setPreferredSize(new Dimension(400, 1));
//        emptyPanel.setSize(400, 1);
//        emptyPanel.setMaximumSize(new Dimension(160, 700));
//        this.add(emptyPanel,BorderLayout.NORTH);

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
                if(e.getKeyCode() == KeyEvent.VK_ENTER){
                    searchedSongs = null;
                    searchedSongs = new ArrayList<>();
                    String search = searchBox.getText();
                    if(search.equals("") || search.equals("🔍 Search"))
                        System.out.println("nothing happened");
                    else{

                    for(Song song:libraryPart.getSongs()){
                        if(song.getTitle().contains(search.toString()) ||song.getAlbumName().contains(search.toString()) || song.getArtistName().contains(search.toString()) )
                            searchedSongs.add(song);
                    }
                  }
                    System.out.println(searchedSongs.size());
                }
            }
        });

//        jSeparator = new JSeparator(SwingConstants.HORIZONTAL);
//        jSeparator.setForeground(new Color(46, 46, 46));
//        this.add(jSeparator, BorderLayout.SOUTH);
        revalidate();
    }
}
