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

public class SelectionsDisplay implements Observer, DisplayElement {
    private Subject stockData;
    private String date = "";
    private String company = "";
    private String tickerSymbol = "";
    private double currentPrice = 0;
    private double dollarChange = 0;
    private double percentChange = 0;
    private double YTDPercentChange = 0;
    private double fiftyTwoWeekHigh = 0;
    private double fiftyTwoWeekLow = 0;
    private double PERatio = 0;
    private String fileName = "Selections.dat";
    FileWriter fileWriter = new FileWriter(fileName);
    PrintWriter printWriter = new PrintWriter(fileWriter);

    public SelectionsDisplay(Subject stockData) throws IOException {
        this.stockData = stockData;
        stockData.registerObserver(this);  //register as an observer
    }

    @Override
    public void display() {
        printWriter.println(this.company + " "  + this.tickerSymbol + " " + this.currentPrice + " "  + this.dollarChange
         + " " + this.percentChange + " " + this.YTDPercentChange + " " + this.fiftyTwoWeekHigh + " " + this.fiftyTwoWeekLow
         + " " + this.PERatio);
    }

    @Override
    public void update(String date, String company, String tickerSymbol, double currentPrice, double dollarChange,
                       double percentChange, double YTDPercentChange, double fiftyTwoWeekHigh, double fiftyTwoWeekLow,
                       double PERatio) {

        this.company = company;
        this.tickerSymbol = tickerSymbol;
        this.currentPrice = currentPrice;
        this.dollarChange = dollarChange;
        this.percentChange = percentChange;
        this.YTDPercentChange = YTDPercentChange;
        this.fiftyTwoWeekHigh = fiftyTwoWeekHigh;
        this.fiftyTwoWeekLow = fiftyTwoWeekLow;
        this.PERatio = PERatio;

        if (this.date != date) {
            this.date = date;
            displayDate();
        }

        switch (tickerSymbol){
            case "ALL":
                display();
                break;
            case "BA":
                display();
                break;
            case "BC":
                display();
                break;
            case "GBEL":
                display();
                break;
            case "KFT":
                display();
                break;
            case "MCD":
                display();
                break;
            case "TR":
                display();
                break;
            case "WAG":
                display();
                break;
            default:
                break;
        }

    }

    public void displayDate() {
        printWriter.println("\n" + this.date + ":");
    }
}
