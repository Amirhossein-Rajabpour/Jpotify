package view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.geom.RoundRectangle2D;

public class RoundTextField extends JTextField {
    private static JTextField empty=new JTextField();
    private Color color;

    private Shape shape;
    public RoundTextField(int size) {
        super(size);
        color = new Color(148,146,143);
        setOpaque(false); // As suggested by @AVD in comment.
        RoundTextField.super.setText("\uD83D\uDD0D search");
        RoundTextField.super.setForeground(color);
    }
    @Override
    protected void paintComponent(Graphics g) {
        g.setColor(color);
        g.fillRoundRect(0, 0, getWidth()-1, getHeight()-1, 15, 15);
        super.paintComponent(g);
    }
    @Override
    protected void paintBorder(Graphics g) {
        g.setColor(color);
        g.drawRoundRect(0, 0, getWidth()-1, getHeight()-1, 15, 15);
    }
    @Override
    public boolean contains(int x, int y) {
        if (shape == null || !shape.getBounds().equals(getBounds())) {
            shape = new RoundRectangle2D.Float(0, 0, getWidth()-1, getHeight()-1, 15, 15);
        }
        return shape.contains(x, y);
    }
    public void setDefaultText(String s){
        super.addFocusListener(new FocusListener() {
            public void focusGained(FocusEvent e) {
                RoundTextField.super.setText("");
                RoundTextField.super.setForeground(color);
            }
            public void focusLost(FocusEvent e) {
                RoundTextField.super.setText(s);
                RoundTextField.super.setForeground(color);
            }
        });
        empty.requestFocus();
    }
}