package graphics;

import fromzad1.objekts.Objekt;

import java.awt.*;
import java.awt.event.MouseEvent;

public interface Drawable extends Shape {

    public Objekt getObjekt();

    void draw(Graphics2D graphics2D);

    void onClick(MouseEvent e);
}