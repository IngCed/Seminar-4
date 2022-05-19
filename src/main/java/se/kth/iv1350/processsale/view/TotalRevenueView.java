
package se.kth.iv1350.processsale.view;

import se.kth.iv1350.processsale.model.RevenueObserver;

/**
 * The class TotalRevenueView is responsible for printing the the total revenue
 * to the user interface. Implements from interface RevenueObserver.
 */
public class TotalRevenueView implements RevenueObserver{
    private double totalRevenue;
    
    /**
     * The constructor sets the totalRevenue to zero.
     */
    public TotalRevenueView(){
        totalRevenue = 0;
    }
    
    /**
     * Adds the total amount to be paid for and calls printTotalRevenue to print
     * to the user interface. Overrides method from RevenueObserver.
     * @param totalAmount the amount to be printed.
     */
    @Override
    public void finishedSale(double totalAmount){
        totalRevenue += totalAmount;
        printTotalRevenue(totalRevenue);
    }
     
    /**
     * Prints the total revenue to the user interface. 
     * @param totalRevenue the amount to be printed.
     */
    private void printTotalRevenue(double totalRevenue){
        System.out.println("The total revenue: " + totalRevenue + " SEK");
    }
}
