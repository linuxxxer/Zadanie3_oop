package fromzad1.objekts;

import java.util.List;

public class Transition
        extends Objekt {

    public Transition(String name, long id, int x, int y) {
        super(name, id, x, y);
    }

    @Override
    public int getTokenNumber() {
        return 0;
    }

    @Override
    public int getMultiplicity() {
        return 0;
    }

    /*
 *  Overenie pustitelnosti prechodu, potom, ak je to pustitelny, pustenie prechodu
 */
    public void fireTransition(){
        this.testFireAbility();
        this.fire();
    }
/*
 *          overenie, ci je nasobnost vacsia ako pocet tokenov v mieste, odkial vychadza
 *          ak je vacsia, tak vyhodi vynimku ExceptionFire() -- prechod nie je pustitelny
 */
    public boolean testFireAbility(){
        List<Objekt> arcs = this.getFromWhere();
        for (Objekt arc : arcs){
            if (arc.getClass() == ArcReset.class){
                continue;
            }
            if (arc.getMultiplicity() > (arc.getFromWhere().get(0)).getTokenNumber()){
                return false;
            }
        }
        return true;
    }
/*
 *  Pustenie prechodu
 *  predpokladame, ze pred pustenim sa osetrilo pustitelnost prechodu pomocou
 *  funkcie testFireAbility()
 */
    private void fire(){
        List<Objekt> arcsTo = this.getFromWhere();
        List<Objekt> arcsFrom  = this.getToWhere();
        Objekt temp;
        int tokenNumber;
        for (Objekt arc : arcsTo){
            temp = arc.getFromWhere().get(0);
            if (arc.getClass() == ArcReset.class){
                temp.resetToken();
                continue;
            }
            tokenNumber = arc.getMultiplicity();
            temp.setToken(-tokenNumber);
        }
        for (Objekt arc : arcsFrom) {
            temp = arc.getToWhere().get(0);
            tokenNumber = arc.getMultiplicity();
            temp.setToken(tokenNumber);
        }
    }
}