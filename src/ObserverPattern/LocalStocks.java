/**

 * Project Prolog
 * Name: Tyler Randolph
 * CS3450 Section 001
 * Project: Program 2 - Observer Program
 * Date: 09/11/2019 6:12 PM
 * Purpose: Write a program that implements the Observer Pattern. It will show stock price information based on snapshots.

 */

package ObserverPattern;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

class LocalStocks
{
    public static void main(String args[]) throws IOException {
        //instantiate subject
        StockData stockData = new StockData();
        String date = "";
        String company = "";
        String tickerSymbol = "";
        double currentPrice = 0;
        double dollarChange = 0;
        double percentChange = 0;
        double YTDPercentChange = 0;
        double fiftyTwoWeekHigh = 0;
        double fiftyTwoWeekLow = 0;
        double PERatio = 0;


        //instantiate observers (displays)
        // pass stockData object to each observer
        AverageDisplay averageDisplay = new AverageDisplay(stockData);
        Change10Display change10Display = new Change10Display(stockData);
        SelectionsDisplay selectionsDisplay = new SelectionsDisplay(stockData);

        File file = new File("Ticker.dat");
        Scanner scanner = new Scanner(file);
        while(scanner.hasNextLine()) {
            String line = scanner.nextLine();
            if (line.contains("Last updated")) {
                date = line;
            } else if (line.isEmpty()) {
                continue;
            } else if (scanner.hasNextLine() != true){
                averageDisplay.display();
            } else {
                String[] splited = (line.split("\\s+"));
                for(int i = splited.length - 1; i >= 0; i--) {

                    if (i == splited.length - 1) {
                        if (splited[i].contains("-")) {
                            PERatio = 0.0;
                        } else {
                            PERatio = Double.parseDouble(splited[i]);
                        }
                    } else if (i == splited.length - 2) {
                        fiftyTwoWeekLow = Double.parseDouble(splited[i]);
                    } else if (i == splited.length - 3) {
                        fiftyTwoWeekHigh = Double.parseDouble(splited[i]);
                    } else if (i == splited.length - 4) {
                        YTDPercentChange = Double.parseDouble(splited[i]);
                    } else if (i == splited.length - 5) {
                        percentChange = Double.parseDouble(splited[i]);
                    } else if (i == splited.length - 6) {
                        dollarChange = Double.parseDouble(splited[i]);
                    } else if (i == splited.length - 7) {
                        currentPrice = Double.parseDouble(splited[i]);
                    } else if (i == splited.length - 8) {
                        tickerSymbol = splited[i];
                    } else {
                        for (int j = 0; j <= i; ++j) {
                            company += " " + splited[j];
                        }
                        stockData.setMeasurements(date, company, tickerSymbol, currentPrice, dollarChange,
                                percentChange, YTDPercentChange, fiftyTwoWeekHigh, fiftyTwoWeekLow, PERatio);
                        company = "";
                        break;
                    }
                }


            }
        }
        averageDisplay.printWriter.close();
        change10Display.printWriter.close();
        selectionsDisplay.printWriter.close();
    }
}