
package se.kth.iv1350.processsale.model;

import se.kth.iv1350.processsale.model.dto.ItemDTO;

/**
 * The class ItemDescription stores the itemDTO. Can be sent to view as this 
 * class cannot change anything.
 */
public class ItemDescription {
    private ItemDTO itemDTO;
    
    /**
     * The constructor saves the specified ItemDTO into this itemDTO.
     * @param itemDTO the ItemDTO to  be saved. 
     */
    public ItemDescription(ItemDTO itemDTO){
        this.itemDTO = itemDTO;
    }
}
