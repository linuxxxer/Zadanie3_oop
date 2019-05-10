package graphics;

import fromzad1.objekts.Objekt;
import fromzad1.objekts.Place;

import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.geom.Ellipse2D;

/*
 * Implementacia Miesta. Na Canvasu sa zjavi ako kruh.
 * Vykreslovanie je riadene pomocou metody 'draw'
 * Vykreslovanie nazvu miesta a pocet tokenov je prisposebene, aby boli v strede
 */
public class Place2D extends Ellipse2D.Float implements Drawable {

    private Place place;
    private final int width = 2;

    public Place2D(int x, int y, Place place){
        super(x, y, 40, 40);
        this.place = place;
    }

    @Override
    public Objekt getObjekt() {
        return this.place;
    }

    @Override
    public void draw(Graphics2D graphics2D) {
        graphics2D.setStroke(new BasicStroke(width));
        graphics2D.setColor(Color.WHITE);
        graphics2D.fill(this);

        graphics2D.setColor(Color.BLACK);
        graphics2D.draw(this);

        graphics2D.setFont(new Font("Liberation Mono", Font.PLAIN, 14));
        graphics2D.drawString( "" + place.getTokenNumber(), (int)getCenterX()-(Integer.toString(place.getTokenNumber()).length() * 4), (int)getCenterY()+5);
        graphics2D.drawString(place.getName(), (int)getCenterX() - (place.getName().length() * 4), (int)getY()+55);
    }

    @Override
    public void onClick(MouseEvent e) {
        if (e.getButton() == MouseEvent.BUTTON1){
            // add token when left mouse button pressed
            place.setToken(1);
        }else if (e.getButton() == MouseEvent.BUTTON3){
            // remove token when right mouse button pressed
            place.setToken(-1);
        }else if (e.getButton() == MouseEvent.BUTTON2){
            // reset all tokens when middle mouse button pressed
            place.resetToken();
        }
    }
}