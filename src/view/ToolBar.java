package view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

/**
 * ToolBar panel at the top of the CentralPanel and MainPage
 */
public class ToolBar extends JPanel {

    private RoundTextField searchBox;
    private JTextField userNameTextField;

    public ToolBar(String userName) {
        super();
        this.setLayout(new BoxLayout(this, BoxLayout.X_AXIS));
//        this.setLayout(new BorderLayout());
        this.setBackground(new Color(38, 38, 38));

        add(Box.createRigidArea(new Dimension(15, 15)));

        searchBox = new RoundTextField(10);
        searchBox.setDefaultText("🔍 Search");
//        searchBox.setPreferredSize(new Dimension(50,20));
        this.add(searchBox);
//        this.add(searchBox,BorderLayout.WEST);

        add(Box.createRigidArea(new Dimension(100, 0)));

        this.userNameTextField = new JTextField(userName);
        userNameTextField.setFont(new Font("TimesNewRoman", Font.LAYOUT_RIGHT_TO_LEFT, 8));
        userNameTextField.setForeground(new Color(245,245,245));
        userNameTextField.setBackground(new Color(38, 38, 38));
        userNameTextField.setEditable(false);
//        userNameTextField.setPreferredSize(new Dimension(30,10));
        this.add(userNameTextField);
    }
}
