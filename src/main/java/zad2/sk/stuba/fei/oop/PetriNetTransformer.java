package zad2.sk.stuba.fei.oop;

import fromzad1.PetriNet;
import fromzad1.myexceptions.ExceptionCannotResolveValue;
import fromzad1.myexceptions.ExceptionWrongObjectType;
import fromzad1.objekts.ArcReset;
import graphics.Importer;
import zad2.sk.stuba.fei.oop.generated.*;

/*
 * Trieda na transformaciu Dokumentu na petriho siet
 */
public class PetriNetTransformer extends Transformer<PetriNet, Document> {

    public PetriNet transform(Document document){
        PetriNet petriNet = new PetriNet();

        for (Place place : document.getPlace()){
            fromzad1.objekts.Place place1 = new fromzad1.objekts.Place(
                    place.getLabel(),
                    place.getId(),
                    place.getTokens(),
                    place.getX(),
                    place.getY()
            );
            petriNet.addPlace(place1);
        }

        for (Transition transition : document.getTransition()){
            fromzad1.objekts.Transition transition1 = new fromzad1.objekts.Transition(
                    transition.getLabel(),
                    transition.getId(),
                    transition.getX(),
                    transition.getY()
            );
            petriNet.addTransition(transition1);
        }

        for (Arc arc : document.getArc()){
            if (arc.getType() == ArcType.REGULAR){
                try {
                    fromzad1.objekts.Arc arc1 = new fromzad1.objekts.Arc(
                            petriNet.getObjekt(arc.getSourceId()),
                            petriNet.getObjekt(arc.getDestinationId()),
                            arc.getMultiplicity(),
                            arc.getId()
                    );
                    petriNet.addArc(arc1);
                } catch (ExceptionWrongObjectType exceptionWrongObjectType) {
                    exceptionWrongObjectType.printStackTrace();
                } catch (ExceptionCannotResolveValue exceptionCannotResolveValue) {
                    exceptionCannotResolveValue.printStackTrace();
                }
            }
            else if (arc.getType() == ArcType.RESET){
                try {
                    ArcReset arcReset = new ArcReset(
                            petriNet.getObjekt(arc.getSourceId()),
                            petriNet.getObjekt(arc.getDestinationId()),
                            arc.getMultiplicity(),
                            arc.getId()
                    );
                    petriNet.addResetArc(arcReset);
                } catch (ExceptionWrongObjectType exceptionWrongObjectType) {
                    exceptionWrongObjectType.printStackTrace();
                } catch (ExceptionCannotResolveValue exceptionCannotResolveValue) {
                    exceptionCannotResolveValue.printStackTrace();
                }
            }
        }

        return petriNet;
    }

    public PetriNet transformFromXML(String pathToFile){

        Importer importer = new Importer();

        return transform(importer.importing(pathToFile));
    }

}
