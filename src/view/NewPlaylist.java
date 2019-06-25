package view;

import model.Playlist;
import model.Song;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.HashMap;

public class NewPlaylist extends JFrame {

    private final Color background;
    private JPanel panel;
    private JPanel north;
    private Color foreground;
    private JTextField nameTextField;
    private JLabel nameLabel;
    private JButton create;
    private JCheckBox[] songCheckbox;
    private int arrayListSize;
    private String name;
    private Playlist playlist;
    private boolean isDone;


    public NewPlaylist(ArrayList<Song> songs) {

        super();
        isDone = false;

        foreground = new Color(195, 195, 195);
        background = new Color(59, 63, 63);

        /**
         * panel is the container of north and center panels
         */
        panel = new JPanel();
        panel.setLayout(new BorderLayout());
        panel.setBackground(new Color(59, 63, 63));
        this.add(panel);

        /**
         * north panel places at the north of the panel
         */
        north = new JPanel();
        north.setBackground(panel.getBackground());
        north.setLayout(new BorderLayout());

        north.add(new JPanel(), BorderLayout.NORTH);
        nameLabel = new JLabel("New Playlist");
        nameLabel.setFont(new Font("Arial", Font.BOLD, 18));
        nameLabel.setForeground(Color.lightGray);
        nameLabel.setHorizontalAlignment(SwingConstants.CENTER);
        north.add(nameLabel, BorderLayout.CENTER);


        nameTextField = new JTextField();
//        nameTextField.setText("Playlist name");
        nameTextField.setForeground(foreground);
        nameTextField.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {
                nameTextField.setText("");
                nameTextField.setForeground(Color.BLACK);
            }

            @Override
            public void focusLost(FocusEvent e) {
//                nameTextField.setText("Playlist name");
                nameTextField.setForeground(foreground);
            }
        });
        north.add(nameTextField, BorderLayout.SOUTH);
        panel.add(north, BorderLayout.NORTH);


        /**
         * center panel places at the center of the panel
         */
        JPanel center = new JPanel();
        center.setLayout(new GridLayout(6, 1));

        center.add(Box.createRigidArea(new Dimension(0, 5)));
        center.add(Box.createRigidArea(new Dimension(0, 5)));

        arrayListSize = songs.size();
        songCheckbox = new JCheckBox[arrayListSize];
        for (int i = 0; i < arrayListSize; i++) {

            songCheckbox[i] = new JCheckBox(songs.get(i).getTitle());
            center.add(songCheckbox[i]);
        }
        panel.add(center, BorderLayout.CENTER);


        create = new JButton("create");
        create.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                name = nameTextField.getText();

                playlist = new Playlist(name);

                for (int i = 0; i < arrayListSize; i++) {

                    if (songCheckbox[i].isSelected()) {
                        playlist.addSong(songs.get(i));
                    }
                }
                isDone = true;
                setVisible(false);
                System.out.println(isDone);
            }
        });

        panel.add(create, BorderLayout.SOUTH);


        setSize(250, 400);
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        this.setLocation(dim.width / 2 - this.getSize().width / 2, dim.height / 2 - this.getSize().height / 2 - 70);
//        pack();
        setVisible(true);
    }
    public Playlist getPlaylist(){
        return this.playlist;
    }
    public boolean isDone(){ return isDone;}
}
