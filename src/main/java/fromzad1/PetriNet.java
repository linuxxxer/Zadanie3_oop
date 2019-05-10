package fromzad1;

import java.util.*;
import fromzad1.objekts.*;

public class PetriNet {

    private Map<Long, Place> placeMap = new HashMap<>();
    private Map<Long, Transition> transitionMap = new HashMap<>();
    private Map<Long, Arc> arcMap = new HashMap<>();

//    metoda, ktora pusti prechod podla cisla id
//    ak nevie pustit prechod, vypise, ktory prechod nebol pustitelny
    public void pustiPrechod(long id) {
        transitionMap.get(id).fireTransition();
    }

//    metody na manpulaciu so sietou
//    potrebne hlavne pre testovanie
    public void addArc(Arc arc){
            arcMap.put(arc.getID(), arc);
    }
    public void addResetArc(ArcReset reset){
            arcMap.put(reset.getID(), reset);
    }
    public void addTransition(Transition transition){
        transitionMap.put(transition.getID(), transition);
    }
    public void addPlace(Place place){
        placeMap.put(place.getID(), place);
    }



    public void printPetriNet(){
        for (Place place : placeMap.values()){
            System.out.println("Place: " + place.getName() + "\tID: " + place.getID());
        }
        for (Transition transition :transitionMap.values()){
            System.out.println("Trans: " + transition.getName() + "\tID: " + transition.getID());
        }
        for (Arc arc : arcMap.values()){
            System.out.println("Arc:  " + arc.getName() + "\tID: " + arc.getID());
        }
    }




//    metody vracaju dany objekt podla id
    public Objekt getObjekt(long id){
        if (placeMap.containsKey(id)){
            return placeMap.get(id);
        }
        else if (transitionMap.containsKey(id)){
            return transitionMap.get(id);
        }
        else if (arcMap.containsKey(id)){
            return arcMap.get(id);
        }
        else
            return null;
    }

    public Map<Long, Place> getPlaceMap() {
        return placeMap;
    }

    public Map<Long, Transition> getTransitionMap() {
        return transitionMap;
    }

    public Map<Long, Arc> getArcMap() {
        return arcMap;
    }

    public void removeObjekt(long id){
        if (placeMap.containsKey(id)){
            removePlace(id);
        } else if (transitionMap.containsKey(id)){
            removeTransition(id);
        } else if (arcMap.containsKey(id)){
            removeArc(id);
        }
    }

    //    metoda removePlace vymaze miesto z mapu placeMap a vymaze vsetky hrany spojene s tym prechodom
    public void removePlace(long id){
        List<Objekt> arcs = placeMap.get(id).getToWhere();
        removeUnnecessaryArcs(arcs);
        arcs = placeMap.get(id).getFromWhere();
        removeUnnecessaryArcs(arcs);
        placeMap.remove(id);
    }

//    metoda removeTransition vymaze prechod z mapu transitionMap a vymaze vsetky hrany spojene s tym prechodom
    public void removeTransition(long id){
        List<Objekt> arcs = transitionMap.get(id).getFromWhere();
        removeUnnecessaryArcs(arcs);
        arcs = transitionMap.get(id).getToWhere();
        removeUnnecessaryArcs(arcs);
        transitionMap.remove(id);
    }

    private void removeUnnecessaryArcs(List<Objekt> arcs){
                while (arcs.size() != 0){
                    Objekt arc = arcs.get(0);
                    removeArc(arc.getID());
                    arc.getFromWhere().get(0).getToWhere().remove(arc);
                    arc.getToWhere().get(0).getFromWhere().remove(arc);
                }
    }

    private void removeArc(long id){
        arcMap.remove(id);
    }

    public PetriNet clearPetriNet() {
        placeMap.clear();
        transitionMap.clear();
        arcMap.clear();
        return this;
    }
}
