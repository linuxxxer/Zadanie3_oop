package graphics;

import fromzad1.objekts.Objekt;
import fromzad1.objekts.Transition;

import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.geom.Rectangle2D;

/*
 * Implementacia Prechodu. Pri vykreslovani sa zjavi ako stvorec
 * Metoda draw zistuje, ci je prechod pustitelny, podla toho vykresluje zeleni (ak ano), alebo cerveny (ak nie) stvorec.
 * Nazov pod stvorcom je upraveny aby bol v strede
 */
public class Transition2D extends Rectangle2D.Float implements Drawable {

    private Transition transition;
    private final int width = 2;

    public Transition2D(int x, int y, Transition transition){
        super(x, y, 40, 40);
        this.transition = transition;
    }

    @Override
    public Objekt getObjekt() {
        return this.transition;
    }

    @Override
    public void draw(Graphics2D graphics2D) {
        graphics2D.setStroke(new BasicStroke(width));
        if (this.transition.testFireAbility()){
            graphics2D.setColor(Color.GREEN);
        } else {
            graphics2D.setColor(Color.RED);
        }
        graphics2D.setFont(new Font("Liberation Mono", Font.PLAIN, 14));
        graphics2D.fill(this);
        graphics2D.setColor(Color.BLACK);
        graphics2D.draw(this);
        graphics2D.drawString(
                transition.getName(),
                (int)this.getCenterX() - (transition.getName().length() * 4),
                (int)this.getY()+55
        );
    }

    @Override
    public void onClick(MouseEvent e) {
        if (this.transition.testFireAbility()){
            this.transition.fireTransition();
        }
    }
}