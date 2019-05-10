package fromzad1.objekts;

import fromzad1.myexceptions.ExceptionCannotResolveValue;
import fromzad1.myexceptions.ExceptionInvalidValueOnInput;
import fromzad1.myexceptions.ExceptionWrongObjectType;

public class Arc
        extends Objekt{

    private int multiplicity;

//      pri objekte Arc meno je vzdy nastavene na "". Je to len formalne
    public Arc(Objekt fromWhere, Objekt toWhere, int multiplicity, long id) throws ExceptionWrongObjectType, ExceptionCannotResolveValue {
        super("", id, 0, 0);
        if (toWhere.getClass() == fromWhere.getClass()) {
            throw new ExceptionWrongObjectType();
        }
        if (multiplicity <= 0){
            throw new ExceptionCannotResolveValue();
        }
//      pridavanie parametrov na ich prislusne miesto
        addIn(fromWhere);
        addOut(toWhere);
        fromWhere.addOut(this);
        toWhere.addIn(this);
        this.multiplicity = multiplicity;
    }

//    metoda nastavuje hodnotu 'multiplicity'
//    zvisuje (resp. znizuje) hodnotu podla parametra
    public void setMultiplicity(int multiplicity) throws ExceptionInvalidValueOnInput {
        if (multiplicity <= 0){
            throw new ExceptionInvalidValueOnInput();
        }
        this.multiplicity = multiplicity;
    }

    @Override
    public int getTokenNumber() {
        return 0;
    }

    @Override
    public int getMultiplicity() {
        return multiplicity;
    }

    public void resetMultiplicity() {
        this.multiplicity = 1;
    }
}
