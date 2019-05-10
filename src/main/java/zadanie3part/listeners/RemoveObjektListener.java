package zadanie3part.listeners;

import graphics.Arc2D;
import graphics.Drawable;
import graphics.NetsCanvas;
import zad2.sk.stuba.fei.oop.DrawableTransformer;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.geom.Line2D;

/*
 * Removes
 */

public class RemoveObjektListener extends Lisstener {

    public RemoveObjektListener(NetsCanvas canvas) {
        super(canvas);
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        for (int i = super.getCanvas().getDrawableList().size(); --i >= 0;){
            Drawable drawable = super.getCanvas().getDrawableList().get(i);
            if (drawable.contains(e.getX(), e.getY())){
                super.getCanvas().getPetriNet().removeObjekt(drawable.getObjekt().getID());

                super.getCanvas().load( new DrawableTransformer(super.getCanvas().getPetriNet()).transformPetrinetToDrawable(super.getCanvas().getPetriNet()) );
                break;
            } else if (drawable.getClass() == Arc2D.class){
                if ( new Rectangle(e.getX() - 3, e.getY() - 3, 6, 6).intersectsLine((Line2D.Float)drawable)){
                    super.getCanvas().getPetriNet().removeObjekt(drawable.getObjekt().getID());

                    super.getCanvas().load( new DrawableTransformer(super.getCanvas().getPetriNet()).transformPetrinetToDrawable(super.getCanvas().getPetriNet()) );
                    break;
                }
            }
        }
        super.getCanvas().repaint();
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        super.getCanvas().setCursor(new Cursor(Cursor.CROSSHAIR_CURSOR));
    }

}
