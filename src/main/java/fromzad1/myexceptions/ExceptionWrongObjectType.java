package fromzad1.myexceptions;

public class ExceptionWrongObjectType
        extends Exception {

    public void ExceptionObjectTypesCannotMatch(){
        System.out.println("Objekty toho isteho typu!");
    }

    public void ExceptionWrongObject(){
            System.out.println("Reset hrana nemoze vychadzat z prechodu!");
    }
}
