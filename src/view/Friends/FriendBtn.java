package view.Friends;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class FriendBtn extends JTextField {

    private Color background;
    private Color foreground;
    private Color pressedBackground;
    private Font Bfont;
    private Font Sfont;
    private String name;
    private String title;
    private byte[] file;

    public FriendBtn(String name, String title, Font BFont, Font SFont, Color background, Color foreground, Color pressedBackground, byte[] file) {

        this.background = background;
        this.foreground = foreground;
        this.pressedBackground = pressedBackground;
        this.name = name;
        this.title = title;
        this.Bfont = BFont;
        this.Sfont = SFont;
        this.file = file;

        this.setText(name);
        this.setFont(BFont);
        this.setEditable(false);
        this.setBackground(this.getBackground());
        this.setForeground(foreground);

        this.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
            }

            @Override
            public void mousePressed(MouseEvent e) {
                setBackground(pressedBackground);
            }

            @Override
            public void mouseReleased(MouseEvent e) {
                setBackground(getBackground());
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
