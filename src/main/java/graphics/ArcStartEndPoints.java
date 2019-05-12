package graphics;

import fromzad1.objekts.Objekt;
import fromzad1.objekts.Place;
import fromzad1.objekts.Transition;

import java.awt.*;

/*
 * Class vytvorena na pocitanie koncovych bodov hran
 * Pocita podla pociatocnych bodoch
 */

public class ArcStartEndPoints {

    int WIDTH = 40, RADIUS = 20;

    private double outX, outY;
    private int inX1, inY1, inX2, inY2;

    public Point arcEndPointCalc(Objekt start, Objekt end){
        calculateItEnd(start, end);
        return new Point((int) outX, (int) outY);
    }

    public Point arcStartPointCalc(Objekt start, Objekt end){
        calculateItStart(start, end);
        return new Point((int) outX, (int) outY);
    }

    private void calculateItStart(Objekt start, Objekt end){
        inX1 = start.getX() + 20;
        inY1 = start.getY() + 20;
        inX2 = end.getX() + 20;
        inY2 = end.getY() + 20;

        int vecX = inX2 - inX1;
        int vecY = inY2 - inY1;

        double length = Math.sqrt( vecX*vecX + vecY*vecY );
        double halfX = RADIUS * ((double)vecX / length);
        double halfY = RADIUS * ((double)vecY / length);

        double tdx = 0;


        if (vecX*vecX >= vecY*vecY) {
            tdx = WIDTH / 2 ;
        }
        else {
            tdx = (WIDTH/2) * ((double)vecX/(double)vecY);
        }

        double tdy = 0;

        if (vecX*vecX >= vecY*vecY) {
            tdy = (WIDTH/2) * ((double)vecY/(double)vecX);
        }
        else {
            tdy = WIDTH/2;
        }

        if (start.getClass() == Place.class){
            outX = inX1 + halfX;
            outY = inY1 + halfY;
        }
        if (start.getClass() == Transition.class){
            if ( (vecX*vecX >= vecY*vecY && vecX >= 0)
                    ||
                    (vecX*vecX < vecY*vecY && vecY >= 0) ){
                outX = inX1 + tdx;
                outY = inY1 + tdy;
            } else {
                outX = inX1 - tdx;
                outY = inY1 - tdy;
            }
        }
    }


    private void calculateItEnd(Objekt start, Objekt end){
        inX1 = start.getX() + 20;
        inY1 = start.getY() + 20;
        inX2 = end.getX() + 20;
        inY2 = end.getY() + 20;

        double vecX = inX2 - inX1;
        double vecY = inY2 - inY1;

        double length = Math.sqrt( vecX*vecX + vecY*vecY );
        double halfX = RADIUS * ((double)vecX / length);
        double halfY = RADIUS * ((double)vecY / length);

        double tdx = 0;


        if (vecX*vecX >= vecY*vecY) {
            tdx = WIDTH / 2;
        }
        else {
            tdx = (WIDTH/2) * ((double)vecX/(double)vecY);
        }

        double tdy = 0;
        if (vecX*vecX >= vecY*vecY) {
            tdy = (WIDTH/2) * ((double)vecY/(double)vecX);
        }
        else {
            tdy = WIDTH/2;
        }

        if (end.getClass() == Place.class){
            outX = inX2 - halfX;
            outY = inY2 - halfY;
        }
        if (end.getClass() == Transition.class){
            if ( (vecX*vecX >= vecY*vecY && vecX >= 0)
                    ||
                    (vecX*vecX < vecY*vecY && vecY >= 0) ){
                outX = inX2 - tdx;
                outY = inY2 - tdy;
            } else {
                outX = inX2 + tdx;
                outY = inY2 + tdy;
            }
        }
    }

}
