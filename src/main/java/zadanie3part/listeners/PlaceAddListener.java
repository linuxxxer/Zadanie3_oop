package zadanie3part.listeners;

import fromzad1.objekts.Place;
import graphics.NetsCanvas;
import graphics.Place2D;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;

/*
 * Listener na pridavanie miest do sieta
 */

public class PlaceAddListener extends Lisstener {

    public PlaceAddListener(NetsCanvas canvas) {
        super(canvas);
    }


    @Override
    public void mouseClicked(MouseEvent e) {
        Place place = new Place("", super.getCanvas().getID(), 0, e.getX(), e.getY());
        super.getCanvas().getPetriNet().addPlace(place);
        super.getCanvas().getDrawableList().add(new Place2D(e.getX(), e.getY(), place));
        super.getCanvas().repaint();
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        super.getCanvas().setCursor(Toolkit.getDefaultToolkit().createCustomCursor(
                new ImageIcon(Class.class.getResource("/place_alt2.png")).getImage(),
                new Point(0, 0),
                "transition cursor")
        );
    }
}
