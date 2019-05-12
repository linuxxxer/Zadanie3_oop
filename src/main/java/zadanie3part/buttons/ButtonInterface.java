package zadanie3part.buttons;

/*
 * Zakladny interface bre tlacidla Save Open a Clear
 * Ostatne tlacidla funguju na inom principe, takze nepotrebuju pouzivat tento interface
 */

public interface ButtonInterface<K, T, P> {

    K performAction(T t, P p);

}
