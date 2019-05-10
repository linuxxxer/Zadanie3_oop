package fromzad1.myexceptions;

public class ExceptionObjekt
        extends Exception {
    public void ExceptionObjektNotFound(long ID){
        System.out.println("Objekt with ID " + ID + " not found!");
    }
}
