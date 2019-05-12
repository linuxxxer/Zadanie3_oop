package zadanie3part;

import graphics.NetsCanvas;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseListener;

/*
 * Zakladna struktura tlacidiel pouzivanych v programe (okrem Save, Open a Clear)
 */

public class ModeButton extends JButton implements ActionListener {

    private NetsCanvas canvas;
    private MouseListener mouseListener;

    public ModeButton(Icon icon, NetsCanvas canvas, MouseListener mouseListener) {
        super(icon);
        this.canvas = canvas;
        this.mouseListener = mouseListener;
        this.setBackground(Color.WHITE);
        this.setFocusable(false);
        addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        MouseListener[] mls = canvas.getMouseListeners();
        for (MouseListener ml : mls){
            canvas.removeMouseListener(ml);
        }

        canvas.addMouseListener(this.mouseListener);
    }
}
