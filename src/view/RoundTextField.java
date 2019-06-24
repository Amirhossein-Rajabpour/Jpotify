package view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.geom.RoundRectangle2D;

public class RoundTextField extends JTextField {
    private static JTextField empty;
    private Color color;
    private Color backgroundColor;

    private Shape shape;

    public RoundTextField(int size) {
        super(size);
        empty = new JTextField();
        backgroundColor = new Color(33, 33, 33);

        color = new Color(148, 146, 143);
        setOpaque(false);
        RoundTextField.super.setText("🔍 Search");
        RoundTextField.super.setFont(new Font("Arial", Font.CENTER_BASELINE, 9));
        RoundTextField.super.setForeground(color);
    }

    @Override
    protected void paintComponent(Graphics g) {
        g.setColor(Color.white);
        g.fillRoundRect(0, 0, getWidth() - 1, getHeight() - 1, 15, 15);
        super.paintComponent(g);
    }

    @Override
    protected void paintBorder(Graphics g) {
        g.setColor(backgroundColor);
        g.drawRoundRect(0, 0, getWidth() - 1, getHeight() - 1, 15, 15);
    }

    @Override
    public boolean contains(int x, int y) {
        if (shape == null || !shape.getBounds().equals(getBounds())) {
            shape = new RoundRectangle2D.Float(0, 0, getWidth() - 1, getHeight() - 1, 15, 15);
        }
        return shape.contains(x, y);
    }

    public void setDefaultText(String s) {
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