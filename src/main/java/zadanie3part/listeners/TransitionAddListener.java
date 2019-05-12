package zadanie3part.listeners;

import fromzad1.objekts.Transition;
import graphics.NetsCanvas;
import graphics.Transition2D;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;

/*
 * Listener, ktory umoznuje pridavat prechodov do sieta
 */

public class TransitionAddListener extends Lisstener {


    public TransitionAddListener(NetsCanvas canvas) {
        super(canvas);
    }

    @Override
    public void mouseClicked(MouseEvent e) {

        Transition transition = new Transition("", super.getCanvas().getID(), e.getX(), e.getY() );

        super.getCanvas().getPetriNet().addTransition(transition);
        super.getCanvas().getDrawableList().add(new Transition2D(e.getX(), e.getY(), transition));
        super.getCanvas().repaint();
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        super.getCanvas().setCursor(Toolkit.getDefaultToolkit().createCustomCursor(
                new ImageIcon(Class.class.getResource("/transition_alt2.png")).getImage(),
                new Point(0, 0),
                "transition cursor")
        );
    }
}
