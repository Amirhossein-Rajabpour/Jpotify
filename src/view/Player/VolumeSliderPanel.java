package view.Player;

import controller.AudioController;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;

public class VolumeSliderPanel extends JPanel{

    private JSlider slider;

    public VolumeSliderPanel(){

        this.setBackground(new Color(40,40,40));
        slider = new JSlider();
        slider.setMinimum(0);
        slider.setMaximum(100);
        slider.setToolTipText("Volume");
        slider.setPreferredSize(new Dimension(130,25));
        slider.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                AudioController.setMasterOutputVolume((float)slider.getValue()/100);
            }
        });
        add(slider);
    }
}
