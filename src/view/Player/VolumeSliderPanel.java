package view.Player;

import javax.swing.*;
import java.awt.*;

public class VolumeSliderPanel extends JPanel{

    private JSlider slider;

    public VolumeSliderPanel(){

        this.setBackground(new Color(40,40,40));
        slider = new JSlider();
        slider.setMaximum(100);
        slider.setToolTipText("Volume");
        slider.setPreferredSize(new Dimension(130,25));
        add(slider);
    }
}
