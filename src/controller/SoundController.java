package controller;

import javax.sound.sampled.*;
import javax.sound.sampled.FloatControl.Type;
import javax.swing.*;
import java.io.File;
import java.io.IOException;
import java.util.Scanner;

import static javax.sound.sampled.AudioSystem.getClip;

public class SoundController {

    private float ctrl;
//    public SoundController(float ctrl){
//        this.ctrl = ctrl;
//    }


    public void setGain(float ctrl)
    {
        try {
            Mixer.Info[] infos = AudioSystem.getMixerInfo();
            for (Mixer.Info info: infos)
            {
                Mixer mixer = AudioSystem.getMixer(info);
                if (mixer.isLineSupported(Port.Info.SPEAKER))
                {
                    Port port = (Port)mixer.getLine(Port.Info.SPEAKER);
                    port.open();
                    if (port.isControlSupported(FloatControl.Type.VOLUME))
                    {
                        FloatControl volume =  (FloatControl)port.getControl(FloatControl.Type.VOLUME);
                        volume.setValue(ctrl);
                    }
                    port.close();
                }
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null,"Erro\n"+e);
        }
    }


}
