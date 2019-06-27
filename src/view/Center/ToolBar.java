package view.Center;

import javax.swing.*;
import java.awt.*;

/**
 * ToolBar panel at the top of the CentralPanel and MainPage
 */
public class ToolBar extends JPanel {

    private RoundTextField searchBox;
    private JTextField userNameTextField;
    private JSeparator jSeparator;

    public ToolBar(String userName) {
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

//        jSeparator = new JSeparator(SwingConstants.HORIZONTAL);
//        jSeparator.setForeground(new Color(46, 46, 46));
//        this.add(jSeparator, BorderLayout.SOUTH);
        revalidate();
    }
}
