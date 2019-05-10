package zadanie3part.listeners;

import fromzad1.myexceptions.ExceptionInvalidValueOnInput;
import graphics.Drawable;
import graphics.NetsCanvas;
import zad2.sk.stuba.fei.oop.DrawableTransformer;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;

public class ResetPositionListener extends Lisstener {

    public ResetPositionListener(NetsCanvas canvas) {
        super(canvas);
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        for (Drawable drawable : super.getCanvas().getDrawableList()){
            if (drawable.contains(e.getX(), e.getY())){
                int newX = Integer.parseInt(JOptionPane.showInputDialog(null, "Add the new X:"));
                int newY = Integer.parseInt(JOptionPane.showInputDialog(null, "Add the new Y:"));
                try {
                    drawable.getObjekt().setX(newX);
                    drawable.getObjekt().setY(newY);
                    super.getCanvas().load(new DrawableTransformer(super.getCanvas().getPetriNet()).transformPetrinetToDrawable(super.getCanvas().getPetriNet()));
                } catch (ExceptionInvalidValueOnInput exceptionInvalidValueOnInput) {
                    JOptionPane.showMessageDialog(null, "The input value must be positive integer!", "Warning", JOptionPane.WARNING_MESSAGE);
                }
            }
        }
        super.getCanvas().repaint();
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        super.getCanvas().setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
    }
}
