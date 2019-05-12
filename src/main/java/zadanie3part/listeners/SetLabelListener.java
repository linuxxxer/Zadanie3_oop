package zadanie3part.listeners;

import graphics.Drawable;
import graphics.NetsCanvas;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;

/*
 * Listener prepne program do "modu" menenia labelov objektov
 */

public class SetLabelListener extends Lisstener {

    public SetLabelListener(NetsCanvas canvas) {
        super(canvas);
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        for (Drawable drawable : super.getCanvas().getDrawableList()){
            if (drawable.contains(e.getX(), e.getY())){
                String name = JOptionPane.showInputDialog(null, "Add the new label:", "Set Label", JOptionPane.QUESTION_MESSAGE);
                drawable.getObjekt().setName(name);
                super.getCanvas().repaint();
            }
        }
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        super.getCanvas().setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
    }

}
