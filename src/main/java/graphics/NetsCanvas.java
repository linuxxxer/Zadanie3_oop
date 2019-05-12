package graphics;

import fromzad1.PetriNet;
import fromzad1.objekts.Arc;
import fromzad1.objekts.Place;
import fromzad1.objekts.Transition;

import java.awt.*;
import java.util.List;
import java.util.LinkedList;

public class NetsCanvas extends Canvas {

    private long ID = 0;
    private PetriNet petriNet;

    private List<Drawable> drawableList;


    public NetsCanvas(PetriNet petriNet){
        this.petriNet = petriNet;
        if (this.petriNet == null){
            this.petriNet = new PetriNet();
        }
        drawableList  = new LinkedList<>();
    }

//    Funkcia vyhlada najvacsie ID v siete a podla toho nastavi
//    hodnotu ID
//    Potrebne po nacitani Petriho Sieta z XML fileu
    public void searchTheBiggestID(){
        long id = 0;
        if (petriNet != null) {
            for (Place place : petriNet.getPlaceMap().values()) {
                if (place.getID() > id) {
                    id = place.getID();
                }
            }
            for (Transition transition : petriNet.getTransitionMap().values()) {
                if (transition.getID() > id) {
                    id = transition.getID();
                }
            }
            for (Arc arc : petriNet.getArcMap().values()) {
                if (arc.getID() > id) {
                    id = arc.getID();
                }
            }
        }
        setID(id);
    }

    @Override
    public void paint(Graphics g) {
        for (Drawable drawable : drawableList){
            drawable.draw((Graphics2D) g);
        }
    }

//    Setter funkcie
    public void load(List<Drawable> drawables){
       this.drawableList = drawables;
    }

    private void setID(long id){
        this.ID = id;
    }

    public void loadPetriNet(PetriNet petriNet){
        this.petriNet = petriNet;
    }

//    Getter funkcie
    public List<Drawable> getDrawableList() {
        return this.drawableList;
    }

    public PetriNet getPetriNet() {
        return petriNet;
    }

    public long getID() {
        ID++;
        return ID;
    }
}
