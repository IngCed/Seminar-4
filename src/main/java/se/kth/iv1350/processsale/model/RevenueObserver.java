
package se.kth.iv1350.processsale.model;

/**
 *
 * @author ingem
 */
public interface RevenueObserver {
    /**
     * 
     * @param totalPrice 
     */
    public void finishedSale(double totalPrice);
}
