package view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class ToolBar extends JPanel {

    private JLabel options;
    private RoundTextField searchBox;

    public ToolBar() {
        super();
        this.setLayout(new BoxLayout(this, BoxLayout.X_AXIS));
        this.setBackground(new Color(24,24,24));

        Dimension minSize = new Dimension(5, 20);
        Dimension prefSize = new Dimension(15, 20);
        Dimension maxSize = new Dimension(15, 20);
        add(new Box.Filler(minSize, prefSize, maxSize));
       // add(Box.createRigidArea(new Dimension(15, 5)));


        options = new JLabel("● ● ●");
        options.setForeground(Color.WHITE);
        options.setFont(new Font("Arial", Font.BOLD, 8));
//        options.setBackground(Color.BLACK);
//        JToolTip optionTooltip = new JToolTip();
//        optionTooltip.setTipText("options");
        options.setToolTipText("options");
//        options.setToo
        options.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {

            }

            @Override
            public void mousePressed(MouseEvent e) {

            }

            @Override
            public void mouseReleased(MouseEvent e) {

            }

            @Override
            public void mouseEntered(MouseEvent e) {

            }

            @Override
            public void mouseExited(MouseEvent e) {

            }
        });
        //options.setOpaque(true);
        this.add(options);
        //⦁

        add(Box.createRigidArea(new Dimension(15,0)));
        searchBox = new RoundTextField(3);
//        searchBox.setPreferredSize(new Dimension(50,20));
        this.add(searchBox);
    }
}
