
package se.kth.iv1350.processsale.model;

import se.kth.iv1350.processsale.model.dto.ItemDTO;

/**
 * An item created to store the values of the identified item.
 * 
 */
public class Item {
    private ItemDTO itemDTO;
    private ItemDescription itemDescription;
    
    /**
     * The constructor for Item.
     */
    public Item(){
        this.itemDTO = new ItemDTO(null, 0, 0, 0, 0);
    }
    
    /**
     * Sets all the attributes of the item after the item has been identified. 
     * @param name The name of the item. 
     * @param price The price of the item. 
     * @param VAT The vat of the item. 
     * @param quantity The quantity of the item.
     * @param itemIdentifier The item identifier that identifies the item. 
     */
    public void setItemDTO(String name, double price, double VAT, int quantity, int itemIdentifier){
        this.itemDTO = new ItemDTO(name, price, VAT, quantity, itemIdentifier);
        setItemDescription(this.itemDTO);
    }
    
    /**
     * Sets the information in the ITemDTO to the ItemDescription class
     * @param itemDTO The ItemDTO to be set in ItemDescription
     */
    private void setItemDescription(ItemDTO itemDTO){
        this.itemDescription = new ItemDescription(this.itemDTO);
    }
    
    /**
     * Compares if one item is equal to another item. 
     * @param item Is one of the items compared. 
     * @return Returns true if they are equal, false if they are not equal. 
     */
    public boolean equals(Item item){
        if(item == null){
            return false;
        }
        return this.itemDTO.getItemIdentifier() == item.getItemDTO().getItemIdentifier();
    }
    
    /**
     * A getter method that returns the ItemDTO.
     * @return Returns the itemDTO.
     */
    public ItemDTO getItemDTO(){
        return itemDTO;
    }
    
    /**
     * A getter method that returns the ItemDescription
     * @return Returns the itemDTO
     */
    public ItemDescription getItemDescription(){
        return itemDescription;
    }
    
    /**
     * Adds the quantity of an item with addition.
     * @param quantity THe identified quantity of one scanned item. 
     */
    public void addQuantity(int quantity){
        int newQuantity = itemDTO.getQuantity() + quantity; 
        itemDTO.setQuantity(newQuantity);
    }
}
