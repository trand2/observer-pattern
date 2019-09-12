/**

 * Project Prolog
 * Name: Tyler Randolph
 * CS3450 Section 001
 * Project: Program 2 - Observer Program
 * Date: 09/11/2019 6:12 PM
 * Purpose: Write a program that implements the Observer Pattern. It will show stock price information based on snapshots.

 */

package ObserverPattern;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class Change10Display implements Observer, DisplayElement {
    private Subject stockData;
    private String tickerSymbol;
    private String date;
    private double currentPrice;
    private double percentChange;
    private String fileName = "Change10.dat";
    FileWriter fileWriter = new FileWriter(fileName);
    PrintWriter printWriter = new PrintWriter(fileWriter);

    public Change10Display(Subject stockData) throws IOException {
        this.stockData = stockData;
        stockData.registerObserver(this);  //register as an observer
    }

    @Override
    public void display() {
        printWriter.println(this.tickerSymbol + " " + this.currentPrice + " " + this.percentChange);
    }

    @Override
    public void update(String date, String company, String tickerSymbol, double currentPrice, double dollarChange,
                       double percentChange, double YTDPercentChange, double fiftyTwoWeekHigh, double fiftyTwoWeekLow,
                       double PERatio) {
        if (this.date != date) {
            this.date = date;
            displayDate();
        }
        if (percentChange >=10.00 || percentChange <= -10.00) {
            this.tickerSymbol = tickerSymbol;
            this.currentPrice = currentPrice;
            this.percentChange = percentChange;

            display();
        }

    }

    public void displayDate() {
        printWriter.println("\n" + this.date + ":");
    }
}
