package fromzad1.objekts;

import fromzad1.myexceptions.ExceptionCannotResolveValue;
import fromzad1.myexceptions.ExceptionWrongObjectType;

// Arc reset je odvodeny z classu Arc, len osetruje, ci objekt odkial hrana vychadza je Place
public class ArcReset
        extends Arc {


    public ArcReset(Objekt fromWhere, Objekt toWhere, int multiplicity, long id)
            throws ExceptionWrongObjectType, ExceptionCannotResolveValue {
        super(fromWhere, toWhere, multiplicity, id);
        if (fromWhere.getClass() == Transition.class){
            throw new  ExceptionWrongObjectType();
        }
    }
}
