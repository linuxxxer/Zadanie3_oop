package zadanie3part.buttons;

/*
 * The basic interface for buttons Save, Open and Clear.
 * Other buttons do not needs this
 */

public interface ButtonInterface<K, T, P> {

    K performAction(T t, P p);

}
