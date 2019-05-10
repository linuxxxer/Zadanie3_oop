package zad2.sk.stuba.fei.oop;

import fromzad1.PetriNet;
import graphics.*;
import zad2.sk.stuba.fei.oop.generated.*;

import java.util.LinkedList;
import java.util.List;

/*
 * Trieda sluziaca na transformaciu petriho sieta na List<Drawable>
 */

public class DrawableTransformer extends Transformer<List<Drawable>, Document> {

    private PetriNet petriNet;

    public DrawableTransformer(PetriNet petriNet){
        this.petriNet = petriNet;
    }

    @Override
    public List<Drawable> transform(Document document) {
        List<Drawable> drawables = new LinkedList<>();

        for (Arc arc : document.getArc()){
            Arc2D arc2D = new Arc2D(
                    petriNet.getObjekt(arc.getSourceId()).getX()+20,
                    petriNet.getObjekt(arc.getSourceId()).getY()+20,
                    petriNet.getObjekt(arc.getDestinationId()).getX()+20,
                    petriNet.getObjekt(arc.getDestinationId()).getY()+20,
                    (fromzad1.objekts.Arc) petriNet.getObjekt(arc.getId())
            );
            drawables.add(arc2D);
        }

        for (Place place : document.getPlace()){
            Place2D place2D = new Place2D(
                    place.getX(),
                    place.getY(),
                    (fromzad1.objekts.Place) petriNet.getObjekt(place.getId())
            );
            drawables.add(place2D);
        }

        for (Transition transition : document.getTransition()){
            Transition2D transition2D = new Transition2D(
                    transition.getX(),
                    transition.getY(),
                    (fromzad1.objekts.Transition) petriNet.getObjekt(transition.getId())
            );
            drawables.add(transition2D);
        }
        return drawables;
    }

    public List<Drawable> transformPetrinetToDrawable(PetriNet pn){
        List<Drawable> drawables = new LinkedList<>();

        for (fromzad1.objekts.Arc arc : pn.getArcMap().values()){
            Arc2D arc2D = new Arc2D(
                    arc.getFromWhere().get(0).getX() + 20,
                    arc.getFromWhere().get(0).getY() + 20,
                    arc.getToWhere().get(0).getX() + 20,
                    arc.getToWhere().get(0).getY() + 20,
                    arc
            );
            drawables.add(arc2D);
        }

        for (fromzad1.objekts.Place place : pn.getPlaceMap().values()){
            Place2D place2D = new Place2D(
                    place.getX(),
                    place.getY(),
                    place
            );
            drawables.add(place2D);
        }

        for (fromzad1.objekts.Transition transition : pn.getTransitionMap().values()){
            Transition2D transition2D = new Transition2D(
                    transition.getX(),
                    transition.getY(),
                    transition
            );
            drawables.add(transition2D);
        }

        return drawables;

    }

    public List<Drawable> transformFromXML(String pathToFile){

        Importer importer = new Importer();

        return transform(importer.importing(pathToFile));
    }
}
