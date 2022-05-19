
package se.kth.iv1350.processsale.integration;

import se.kth.iv1350.processsale.model.Item;
import se.kth.iv1350.processsale.model.Sale;

/**
 * ExternalInventorySystem has information of all the different items in the retail store. The
 * different items is represented with the itemIdentifier.
 */
public class ExternalInventorySystem {
    private int itemIdentifier1 = 100010;
    private int itemIdentifier2 = 110010;

    /**
     * Fetches the item based on the itemIdentifier. 
     * @param itemIdentifier Is the code from the scanned item that represents an item.
     * @param quantity The quantity of that item if there are many of the same items in the same scan. 
     * @param item The attributes of the item is set to this item object when an item has been identified. 
     * @return Returns an item found by the itemIdentifier. 
     * @throws ItemIdentifierInvalidException
     * @throws CouldNotConnectToDatabaseException
     */
    public Item fetchItemInformation(int itemIdentifier, int quantity, Item item) 
            throws ItemIdentifierInvalidException, CouldNotConnectToDatabaseException{
        if(itemIdentifier == 0){
            throw new CouldNotConnectToDatabaseException("A connection to the "
                    + "External Inventory System could not be established");
        }
        if(itemIdentifier == itemIdentifier1){
            item.setItemDTO("Item1", 9.99, 0.25, quantity, itemIdentifier);
                    return item;
        }
        else if(itemIdentifier == itemIdentifier2){
            item.setItemDTO("Item2", 19.99, 0.15, quantity, itemIdentifier);
                    return item;
        }
        else
            throw new ItemIdentifierInvalidException("The specified identifier " 
                    + itemIdentifier + " does not exist." );
    }
    
    /**
     * Updates the inventory system, done after a Sale has been made.
     * @param sale the sale that has been made.
     */
    public void updateInventorySystem(Sale sale){
    }
}
