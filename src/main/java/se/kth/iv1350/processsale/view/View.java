
package se.kth.iv1350.processsale.view;

import se.kth.iv1350.processsale.controller.Controller;
import se.kth.iv1350.processsale.integration.CouldNotConnectToDatabaseException;
import se.kth.iv1350.processsale.integration.ItemIdentifierInvalidException;
import se.kth.iv1350.processsale.integration.TotalRevenueFileOutput;



/**
 * This is a placeholder for the real view. It contains a hard coded execution with calls to all
 * system operations in the controller. 
 * @author ingem
 */
public class View {
    private Controller contr; 
    
    /**
     * A constructor for the view class. Creates an instance of the controller for calls to other layers. 
     * @param contr The controller to use for all calls to other layers. 
     */
    public View(Controller contr){
        this.contr = contr; 
        contr.addRevenueObserver(new TotalRevenueView());
        contr.addRevenueObserver(new TotalRevenueFileOutput());
    }
    
    /**
     * Runs an hard coded execution of the program in order to show that the code runs. 
     * @throws ItemIdentifierInvalidException Thrown when there is no item identifier in the ExternalInventory system that matches the given item identifier.
     * @throws CouldNotConnectToDatabaseException Thrown when the program can not connect to the ExternalInventorySystem.
     */
    public void runFakeExecution() throws ItemIdentifierInvalidException, CouldNotConnectToDatabaseException {
        try{
        contr.startSale();
        System.out.println("A new sale has been started");
        contr.scanItem(100010, 1);
        System.out.println("A item has been scanned");
        contr.scanItem(110010, 2);
        System.out.println("A item has been scanned");
        contr.scanItem(100010, 1);
        System.out.println("A item has been scanned");
        double amountToPay = contr.endSale();
        System.out.println("The sale has ended");
        double exampleAmountThatCustomerGives = amountToPay + 10;
        contr.enterPayment(exampleAmountThatCustomerGives);
        System.out.println("The payment has been processed");
        }
        catch(ItemIdentifierInvalidException iiie){
             System.out.println(iiie.getMessage());
        }
        catch(CouldNotConnectToDatabaseException cnctde){
             System.out.println(cnctde.getMessage());
        }
        
        
    }
}
