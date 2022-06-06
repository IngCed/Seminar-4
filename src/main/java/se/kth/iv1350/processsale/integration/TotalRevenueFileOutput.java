
package se.kth.iv1350.processsale.integration;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import se.kth.iv1350.processsale.model.RevenueObserver;
/**
 * The class TotalRevenueFileOutput is responsible for creating a file in which 
 * the total revenue is stored. Implements from interface RevenueObserver. 
 */
public class TotalRevenueFileOutput implements RevenueObserver {
    private double totalRevenue;
    private PrintWriter revenueLogFile;
    
    /**
     * The constructor creates a new instance of a PrintWriter which is needed in order to 
     * create a file. The total  revenue is set to zero. 
     */
    public TotalRevenueFileOutput() {
        totalRevenue = 0;
        try {
            revenueLogFile = new PrintWriter(new FileWriter("total revenue"), true);
        } catch (IOException ioe) {
            System.out.println("Unable to create File");
            ioe.printStackTrace();
        }
    }
    /**
     * Adds the totalAmount to be paid for a sale to totalRevenue and calls 
     * logTotalRevenue to print the file. OVerrides method from RevenueObserver. 
     * 
     * @param totalAmount the amount to be logged in a file.
     */
    @Override
    public void finishedSale(double totalAmount){
        totalRevenue += totalAmount;
        logTotalRevenue(totalRevenue);
    }
    
    /**
     * Prints the totalRevenue to a file in order to log it.
     * @param totalRevenue the revenue to be printed. 
     */
    private void logTotalRevenue(double totalRevenue){
        System.out.println("Revenue file is logged");
        revenueLogFile.println("Total Revenue: " + totalRevenue + " SEK");

    }
    
}
