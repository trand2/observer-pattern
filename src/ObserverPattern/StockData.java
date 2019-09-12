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
import java.util.*;

// This is the SUBJECT in the observer pattern

public class StockData implements Subject {

    private ArrayList<Observer> observers;
    private String date;
    private String company;
    private String tickerSymbol;
    private double currentPrice;
    private double dollarChange;
    private double percentChange;
    private double YTDPercentChange;
    private double fiftyTwoWeekHigh;
    private double fiftyTwoWeekLow;
    private double PERatio;

    //constructor - create the array list to hold all observers
    public StockData() {
        observers = new ArrayList<Observer>();
    }

    public void registerObserver(Observer o) {

        observers.add(o);
    }

    @Override
    public void removeObserver(Observer o) {

    }

    // notify observers when a change occurs
    // iterates through list and calls each observer's update method
    // passing temp data
    public void notifyObservers() throws IOException {
        for (int i = 0; i < observers.size(); i++) {
            Observer observer = (Observer)observers.get(i);
            observer.update(date, company, tickerSymbol, currentPrice, dollarChange, percentChange, YTDPercentChange,
                    fiftyTwoWeekHigh, fiftyTwoWeekLow, PERatio);  //push data
        }
    }

    // notify observers that data changed
    // made separate method just in case the stocks might
    // want to take other action when the new data comes in
    public void measurementsChanged() throws IOException {
        notifyObservers();
    }

    //  updates data
    //  creates notification that state has changed
    // in the real world this data would come from instruments.
    public void setMeasurements(String date, String company, String tickerSymbol, double currentPrice, double dollarChange,
                                double percentChange, double YTDPercentChange, double fiftyTwoWeekHigh,
                                double fiftyTwoWeekLow, double PERatio) throws IOException {
        this.date = date;
        this.company = company;
        this.tickerSymbol = tickerSymbol;
        this.currentPrice = currentPrice;
        this.dollarChange = dollarChange;
        this.percentChange = percentChange;
        this.YTDPercentChange = YTDPercentChange;
        this.fiftyTwoWeekHigh = fiftyTwoWeekHigh;
        this.fiftyTwoWeekLow = fiftyTwoWeekLow;
        this.PERatio = PERatio;
        measurementsChanged();      //Notification that state has changed
    }

    public String getDate() { return date; }

    public String getCompany() { return company; }

    public String getTickerSymbol() { return tickerSymbol; }

    public double getCurrentPrice() { return currentPrice; }

    public double getDollarChange() { return dollarChange; }

    public double getPercentChange() { return percentChange; }

    public double getYTDPercentChange() { return YTDPercentChange; }

    public double getFiftyTwoWeekHigh() { return fiftyTwoWeekHigh; }

    public double getFiftyTwoWeekLow() { return fiftyTwoWeekLow; }

    public double getPERatio() { return PERatio; }
}
