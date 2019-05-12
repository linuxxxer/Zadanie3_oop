package zadanie3part.listeners;

import fromzad1.myexceptions.ExceptionCannotResolveValue;
import fromzad1.myexceptions.ExceptionWrongObjectType;
import fromzad1.objekts.*;
import graphics.Arc2D;
import graphics.ArcStartEndPoints;
import graphics.NetsCanvas;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;

public class ResetArcAddListener extends Lisstener {

    private int clicked = 0;
    int fromWhereX = 0, fromWhereY = 0, toWhereX, toWhereY;

    public ResetArcAddListener(NetsCanvas canvas) {
        super(canvas);
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        clicked++;

        Objekt fromWhere = null, toWhere = null;

        if (clicked == 1){
            fromWhereX = e.getX();
            fromWhereY = e.getY();
        }
        if (clicked == 2){
            clicked = 0;
            toWhereX = e.getX();
            toWhereY = e.getY();
            for (int i = super.getCanvas().getDrawableList().size(); --i >= 0;){
                if (super.getCanvas().getDrawableList().get(i).contains(fromWhereX, fromWhereY)){
                    fromWhere = super.getCanvas().getDrawableList().get(i).getObjekt();
                } else if (super.getCanvas().getDrawableList().get(i).contains(toWhereX, toWhereY)){
                    toWhere = super.getCanvas().getDrawableList().get(i).getObjekt();
                }
            }
            if (fromWhere == null || fromWhere.getClass() == Transition.class){
                JOptionPane.showMessageDialog(
                        getCanvas(),
                        "Start point is not set correctly!",
                        "Warning",
                        JOptionPane.WARNING_MESSAGE
                );
                return;
            } else if (toWhere == null || toWhere.getClass() == Place.class){
                JOptionPane.showMessageDialog(
                        getCanvas(),
                        "End point is not set correctly!",
                        "Warning",
                        JOptionPane.WARNING_MESSAGE
                );
                return;
            }

            try {
                ArcReset arcReset = new ArcReset(
                        fromWhere,
                        toWhere,
                        1,
                        super.getCanvas().getID()
                );
                super.getCanvas().getPetriNet().addArc(arcReset);
                ArcStartEndPoints asep =  new ArcStartEndPoints();
                Point startPoint = asep.arcStartPointCalc(fromWhere, toWhere);
                Point endPoint = asep.arcEndPointCalc(fromWhere, toWhere);
                super.getCanvas().getDrawableList().add(new Arc2D(
                        (int)startPoint.getX(),
                        (int)startPoint.getY(),
                        (int)endPoint.getX(),
                        (int)endPoint.getY(),
                        arcReset
                ));
            } catch (ExceptionWrongObjectType exceptionWrongObjectType) {
                JOptionPane.showMessageDialog(
                        getCanvas(),
                        "These objects cannot be connected!",
                        "ERROR",
                        JOptionPane.ERROR_MESSAGE
                );
            } catch (ExceptionCannotResolveValue exceptionCannotResolveValue) {
                JOptionPane.showMessageDialog(
                        getCanvas(),
                        "Wrong value on input!",
                        "ERROR",
                        JOptionPane.ERROR_MESSAGE
                );
            }
        }
        super.getCanvas().repaint();
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        super.getCanvas().setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
    }

}
