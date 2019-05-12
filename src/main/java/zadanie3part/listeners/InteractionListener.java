package zadanie3part.listeners;

import graphics.Arc2D;
import graphics.Drawable;
import graphics.NetsCanvas;

import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.geom.Line2D;

/*
 * "Interakcny" mod programu
 * Sluzi na nastavenie tokenov, vahy hrany, pustenie prechodov
 */

public class InteractionListener extends Lisstener {

    public InteractionListener(NetsCanvas canvas) {
        super(canvas);
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        for (int i = super.getCanvas().getDrawableList().size(); --i >= 0;){
            Drawable drawable = super.getCanvas().getDrawableList().get(i);
            if (drawable.contains(e.getX(), e.getY())){
                drawable.onClick(e);
                break;
            } else if (drawable.getClass() == Arc2D.class){
                if ( new Rectangle(e.getX()-3, e.getY()-3,6,6).intersectsLine((Line2D.Float)drawable) ){
                    drawable.onClick(e);
                    break;
                }
            }
        }
        super.getCanvas().repaint();
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        super.getCanvas().setCursor(new Cursor(Cursor.HAND_CURSOR));
    }
}
