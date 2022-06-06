
package se.kth.iv1350.processsale.controller;

import java.util.ArrayList;
import java.util.List;
import se.kth.iv1350.processsale.model.*;
import se.kth.iv1350.processsale.integration.*;

/**
 * This is the applications only controller. All calls to the model pass through here.
 * 
 */
public class Controller {
    private final ExternalInventorySystem externalInventorySystem;
    private final ExternalAccountingSystem externalAccountingSystem;
    private final Printer printer;
    private Sale sale; 
    private final List<RevenueObserver> revenueObservers;
    

    
    /**
     * The constructor for the controller class. Creates instances of objects printer, externalInventorySystem and
     * externalAccountingSystem for the controller to use.
     * @param printer the printer object controller will use if something has to be printed
     * @param externalInventorySystem used to access the inventory system
     * @param externalAccountingSystem used to access the accounting system
     */
    public Controller(Printer printer, ExternalInventorySystem externalInventorySystem, 
            ExternalAccountingSystem externalAccountingSystem){
        this.printer = printer;
        this.externalInventorySystem = externalInventorySystem; 
        this.externalAccountingSystem = externalAccountingSystem;
        revenueObservers = new ArrayList<RevenueObserver>();

    }
    
    /**
     * Starts a new sale. Called before doing anything else in a sale.  
     */
    public void startSale(){
        this.sale = new Sale();
        sale.addRevenueObservers(revenueObservers);
    }
    
    /**
     * Scans an item. Is used whenever there is an item to be scanned.
     * @param itemIdentifier Is the bar code that is identified when a product is scanned.
     * @param quantity If there are several of the same products quantity can be manually applied. 
     * @return Returns the item that was scanned to the user.
     * @throws ItemIdentifierInvalidException Thrown when there is no item identifier in the ExternalInventory system that matches the given item identifier.
     * @throws CouldNotConnectToDatabaseException Thrown when the program can not connect to the ExternalInventorySystem.
     */
    public ItemDescription scanItem(int itemIdentifier, int quantity) throws ItemIdentifierInvalidException,
            CouldNotConnectToDatabaseException{
        Item item = new Item();
        externalInventorySystem.fetchItemInformation(itemIdentifier, quantity, item);
        sale.addItem(item);
        return item.getItemDescription(); 
    }
    
    /**
     * Ends the sale. Is issued when there are no more items to be scanned. 
     * @return The total price is returned to the user. 
     */
    public double endSale(){
        return sale.calculateTotalPrice(); 
    }
    
    /**
     * Pays for the entire sale. Is issued after the sale has ended.
     * @param amount The amount that is given to pay for the sale.  
     * @return Returns the Payment Information to the user. 
     */
    public Payment enterPayment(double amount){
        Payment paymentInformation = new Payment(sale, amount);
        sale.getReceipt().setReceiptValues(paymentInformation, sale.getSaleDTO(), sale.getItemList());
        externalAccountingSystem.updateAccountingSystem(amount);
        externalInventorySystem.updateInventorySystem(sale);
        printer.print(sale.getReceipt());
        return paymentInformation; 
    }
        /**
         * Adds a RevenueObserver. 
         * @param revenueObserver the RevenueObserver to be added.
         */
        public void addRevenueObserver(RevenueObserver revenueObserver) {
        revenueObservers.add(revenueObserver);

    }
}
