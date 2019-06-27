package controller;

import javax.sound.sampled.*;
import javax.sound.sampled.FloatControl.Type;
import javax.swing.*;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import static javax.sound.sampled.AudioSystem.getClip;

public class AudioController {


    public static void setMasterOutputVolume(float value) {
        if (value < 0 || value > 1)
            throw new IllegalArgumentException(
                    "Volume can only be set to a value from 0 to 1. Given value is illegal: " + value);
        Line line = getMasterOutputLine();
        if (line == null) throw new RuntimeException("No Master Output");
        boolean opened = open(line);
        try {
            FloatControl control = getVolumeControl(line);
            if (control == null)
                throw new RuntimeException("No Volume Control : " + toString(line));
            control.setValue(value);
        } finally {
            if (opened) line.close();
        }
    }

    public static Float getMasterOutputVolume() {
        Line line = getMasterOutputLine();
        if (line == null) return null;
        boolean opened = open(line);
        try {
            FloatControl control = getVolumeControl(line);
            if (control == null) return null;
            return control.getValue();
        } finally {
            if (opened) line.close();
        }
    }


    public static Line getMasterOutputLine() {
        for (Mixer mixer : getMixers()) {
            for (Line line : getAvailableOutputLines(mixer)) {
                if (line.getLineInfo().toString().contains("SPEAKER")) return line;
            }
        }
        return null;
    }

    public static FloatControl getVolumeControl(Line line) {
        if (!line.isOpen()) throw new RuntimeException("Line is closed: " + toString(line));
        return (FloatControl) findControl(FloatControl.Type.VOLUME, line.getControls());
    }


    private static Control findControl(Control.Type type, Control... controls) {
        if (controls == null || controls.length == 0) return null;
        for (Control control : controls) {
            if (control.getType().equals(type)) return control;
            if (control instanceof CompoundControl) {
                CompoundControl compoundControl = (CompoundControl) control;
                Control member = findControl(type, compoundControl.getMemberControls());
                if (member != null) return member;
            }
        }
        return null;
    }

    public static List<Mixer> getMixers() {
        Mixer.Info[] infos = AudioSystem.getMixerInfo();
        List<Mixer> mixers = new ArrayList<Mixer>(infos.length);
        for (Mixer.Info info : infos) {
            Mixer mixer = AudioSystem.getMixer(info);
            mixers.add(mixer);
        }
        return mixers;
    }

    public static List<Line> getAvailableOutputLines(Mixer mixer) {
        return getAvailableLines(mixer, mixer.getTargetLineInfo());
    }

    private static List<Line> getAvailableLines(Mixer mixer, Line.Info[] lineInfos) {
        List<Line> lines = new ArrayList<Line>(lineInfos.length);
        for (Line.Info lineInfo : lineInfos) {
            Line line;
            line = getLineIfAvailable(mixer, lineInfo);
            if (line != null) lines.add(line);
        }
        return lines;
    }

    public static Line getLineIfAvailable(Mixer mixer, Line.Info lineInfo) {
        try {
            return mixer.getLine(lineInfo);
        } catch (LineUnavailableException ex) {
            return null;
        }
    }

    public static boolean open(Line line) {
        if (line.isOpen()) return false;
        try {
            line.open();
        } catch (LineUnavailableException ex) {
            return false;
        }
        return true;
    }

    public static String toString(Control control) {
        if (control == null) return null;
        return control.toString() + " (" + control.getType().toString() + ")";
    }

    public static String toString(Line line) {
        if (line == null) return null;
        Line.Info info = line.getLineInfo();
        return info.toString();
    }

    public static String toString(Mixer mixer) {
        if (mixer == null) return null;
        StringBuilder sb = new StringBuilder();
        Mixer.Info info = mixer.getMixerInfo();
        sb.append(info.getName());
        sb.append(" (").append(info.getDescription()).append(")");
        sb.append(mixer.isOpen() ? " [open]" : " [closed]");
        return sb.toString();
    }


}
