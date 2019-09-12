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

/**
 * ObserverPattern.Observer interface, all observers implement this interface
 * @author lthac
 */
public interface Observer {
    public void update(String date, String company, String tickerSymbol, double currentPrice, double dollarChange,
                       double percentChange, double YTDPercentChange, double fiftyTwoWeekHigh, double fiftyTwoWeekLow,
                       double PERatio) throws IOException;
}