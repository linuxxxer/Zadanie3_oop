package fromzad1.objekts;

import fromzad1.myexceptions.ExceptionInvalidValueOnInput;

import java.util.*;

public abstract class Objekt {
    private String name;    // meno prislusneho obejktu
    private long ID;        // ID prislusneho objektu
    private int x, y;
/*
*   List fromWhere - dva moznosti  - u hran - objekt (prechod/miesto) kde zacina hrana
*                               - u miest/prechodov - zoznam hran, ktore idu do daneho objektu
*   List toWhere    - dva moznosti  - u hran - objekt (prechod/miesto) kde konci hrana
*                               / u miest/prechodov - zoznam hran, ktore idu z daneho objektu
*/
    private List<Objekt> fromWhere = new ArrayList<>();
    private List<Objekt> toWhere = new ArrayList<>();

    // metoda prida objekt do zoznamu fromWhere
    void addIn(Objekt toAdd){
        fromWhere.add(toAdd);
    }

    // metoda prida objekt do zoznamu toWhere
    void addOut(Objekt toAdd){
        toWhere.add(toAdd);
    }

    public int getX(){
        return x;
    }

    public int getY() {
        return y;
    }

    // konstruktor
    public Objekt(String name, long id, int x, int y) {
        this.name = name;
        this.ID = id;
        this.x = x;
        this.y = y;
    }

    public long getID() {
        return ID;
    }

    public void setX(int x) throws ExceptionInvalidValueOnInput {
        if (x < 0){
            throw new ExceptionInvalidValueOnInput();
        }
        this.x = x;
    }

    public void setY(int y) throws ExceptionInvalidValueOnInput {
        if (x < 0){
            throw new ExceptionInvalidValueOnInput();
        }
        this.y = y;
    }

    // metoda getFromWhere() a getToWhere() vrati zoznam fromWhere/toWhere
    public List<Objekt> getFromWhere() {
        return this.fromWhere;
    }

    public List<Objekt> getToWhere() {
        return this.toWhere;
    }

    public String getName(){
        return this.name;
    }

    // metody vyuzivane u miest
    public abstract int getTokenNumber();

    public void setToken(int pocet){ }

    public void resetToken(){ }

    public void setName(String name){
        this.name = name;
    }

    // metody vyuzivane u hran
    public abstract int getMultiplicity();

}
