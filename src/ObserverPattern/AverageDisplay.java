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
import java.util.ArrayList;

public class AverageDisplay implements Observer, DisplayElement {

    private double currentPrice;
    private ArrayList<Double> currentPriceArray = new ArrayList<Double>();
    private String date;
    private Subject stockData;
    private String fileName = "Average.dat";
    FileWriter fileWriter = new FileWriter(fileName);
    PrintWriter printWriter = new PrintWriter(fileWriter);

    public AverageDisplay(Subject stockData) throws IOException {
        this.stockData = stockData;
        stockData.registerObserver(this);  //register as an observer
    }

    @Override
    public void display() throws IOException {
        printWriter.println(this.date + ", Average price: " + findAverage(currentPriceArray));
    }

    @Override
    public void update(String date, String company, String tickerSymbol, double currentPrice, double dollarChange,
                       double percentChange, double YTDPercentChange, double fiftyTwoWeekHigh, double fiftyTwoWeekLow,
                       double PERatio) throws IOException {
        if (this.date != date && this.date != null) {
            display();
            currentPriceArray.clear();
            this.currentPrice = currentPrice;
            currentPriceArray.add(currentPrice);
            this.date = date;
        } else {
            this.currentPrice = currentPrice;
            currentPriceArray.add(currentPrice);
            this.date = date;
        }

    }

    public double findAverage(ArrayList<Double> arrayList) {
        double sum = 0.0;
        for (int i=0; i< arrayList.size(); i++) {
            sum += arrayList.get(i);

        }
        return sum / arrayList.size();
    }
}
