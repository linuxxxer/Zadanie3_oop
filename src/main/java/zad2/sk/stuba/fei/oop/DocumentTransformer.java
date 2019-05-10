package zad2.sk.stuba.fei.oop;

import graphics.Exporter;
import fromzad1.PetriNet;
import fromzad1.objekts.*;
import zad2.sk.stuba.fei.oop.generated.ArcType;
import zad2.sk.stuba.fei.oop.generated.Document;

public class DocumentTransformer extends Transformer<Document, PetriNet> {

    @Override
    public Document transform(PetriNet petriNet) {
        Document document = new Document();

        for (Place entry : petriNet.getPlaceMap().values()) {
            document.addPlace(
                    entry.getName(),
                    (int)entry.getID(),
                    entry.getTokenNumber(),
                    entry.getX(),
                    entry.getY()
            );
        }

        for (Transition entry : petriNet.getTransitionMap().values()){
            document.addTransition(
                    entry.getName(),
                    (int)entry.getID(),
                    entry.getX(),
                    entry.getY()
            );
        }

        for (Arc entry : petriNet.getArcMap().values()) {
            if (entry.getClass() == Arc.class){
                document.addArc(
                        ArcType.REGULAR,
                        (int) entry.getID(),
                        entry.getMultiplicity(),
                        (int) entry.getToWhere().get(0).getID(),
                        (int) entry.getFromWhere().get(0).getID()
                );
            }
            if (entry.getClass() == ArcReset.class){
                document.addArc(
                        ArcType.RESET,
                        (int) entry.getID(),
                        entry.getMultiplicity(),
                        (int) entry.getToWhere().get(0).getID(),
                        (int) entry.getFromWhere().get(0).getID()
                );
            }
        }


        return document;
    }

    public Document transformToXML(PetriNet petriNet, String pathToFile){

        Exporter exporter = new Exporter();

        exporter.exporting(transform(petriNet), pathToFile);
        return null;
    }
}
