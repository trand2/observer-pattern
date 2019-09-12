/**

 * Project Prolog
 * Name: Tyler Randolph
 * CS3450 Section 001
 * Project: Program 2 - Observer Program
 * Date: 09/11/2019 6:12 PM
 * Purpose: Write a program that implements the Observer Pattern. It will show stock price information based on snapshots.

 */

package ObserverPattern;

import java.io.IOException;

public interface Subject {
    /**
     * observer (interface) passed as parameter (composition)
     * this method is called by observers to register themselves
     */
    public void registerObserver(Observer o);

    /**
     * called by observers to remove themselves as observers
     */
    public void removeObserver(Observer o);

    /**
     * called by subject when there is a state change
     */
    public void notifyObservers() throws IOException;
}
