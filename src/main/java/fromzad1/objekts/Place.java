package fromzad1.objekts;

public class Place
        extends Objekt {

    private int TokenNumber;

    public Place(String name, long id, int tokens, int x, int y) {
        super(name, id, x, y);
        this.TokenNumber = tokens;
    }

    @Override
    public void resetToken(){
        this.TokenNumber = 0;
    }

    @Override
    public int getMultiplicity() {
        return 0;
    }

    @Override
    public void setToken(int number){
        this.TokenNumber += number;
    }

    @Override
    public int getTokenNumber() {
        return TokenNumber;
    }

}
