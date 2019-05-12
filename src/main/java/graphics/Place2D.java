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
 * Tokeny sa pridavaju a odoberavaju v interakcnom mode editora
 */
public class Place2D extends Ellipse2D.Float implements Drawable {

    private Place place;
    private final int WIDTH = 2;

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
        graphics2D.setStroke(new BasicStroke(WIDTH));
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
            // pridavanie tokenov po kliknutim lavym tlacidlom
            place.setToken(1);
        }else if (e.getButton() == MouseEvent.BUTTON3){
            // odoberanie tokenov po kliknutim pravym tlacidlom
            place.setToken(-1);
        }else if (e.getButton() == MouseEvent.BUTTON2){
            // zmazanie tokenov po kliknutim strednym tlacidlom
            place.resetToken();
        }
    }
}