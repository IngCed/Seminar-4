
package se.kth.iv1350.processsale.model;

/**
 * The RevenueObserver is an interface which can handle different objects.
 * 
 */
public interface RevenueObserver {
    /**
     * Called after a sale has completed.
     * @param totalPrice the totalPrice for entire sale.
     */
    void finishedSale(double totalPrice);
}
