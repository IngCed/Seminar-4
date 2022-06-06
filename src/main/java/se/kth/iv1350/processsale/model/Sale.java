package se.kth.iv1350.processsale.model;

import java.util.ArrayList;
import java.util.List;

import se.kth.iv1350.processsale.model.dto.SaleDTO;

/**
 * A sale made by one customer and payed with one payment. 
 * 
 */
public class Sale {
    private SaleDTO saleDTO; 
    private Receipt receipt;
    private ArrayList<Item> itemList; 
    private List<RevenueObserver> revenueObservers;
    
    /**
     * Creates new instances of the saleDTO, the receipt and the whole list of all items.
     * 
     */
    public Sale(){
        this.saleDTO = new SaleDTO(0, 0, 0); 
        this.receipt = new Receipt();
        this.itemList = new ArrayList<>();
        this.revenueObservers = new ArrayList<>();
    }
    
    /**
     * A getter method to get the SaleDTO.
     * @return returns the instance saleDTO.
     */
    public SaleDTO getSaleDTO(){
        return saleDTO;
    }
    
    /**
     * A getter method to get the receipt.
     * @return returns the instance receipt. 
     */
    public Receipt getReceipt(){
        return receipt;
    }
    
    /**
     * A getter method to get the List of Items in the sale.
     * @return returns the instance itemList.
     */
    public ArrayList<Item> getItemList(){
        return itemList;
    }
    
    /**
     * Adds an item to the itemList. If the list is empty or if the item doesn't exist it will add the item,
     * otherwise it will only increment the quantity of the item. 
     * @param item The identified item to be added. 
     */
    public void addItem(Item item){
        if(itemList.isEmpty() && item != null){
            itemList.add(item);
        }
        else if(checkItemInList(item) == false && item != null){
        itemList.add(item);
        }
        else if(checkItemInList(item) == true && item != null){
            for(Item temporaryItem : itemList){
                if(temporaryItem.equals(item)){
                    temporaryItem.addQuantity(item.getItemDTO().getQuantity());
                }
            }
        }
    }
    
    /**
     * Calculates the total price used at the end of a sale. Adds the total price as well as the VAT.   
     * @return returns the total price. 
     */
    public double calculateTotalPrice(){ 
        double totalPrice = 0; 
        for(Item temporaryItem : itemList){
            totalPrice += ( temporaryItem.getItemDTO().getPrice() + 
                    temporaryItem.getItemDTO().getPrice() * temporaryItem.getItemDTO().getVAT() ) 
                    * temporaryItem.getItemDTO().getQuantity();
        }
        saleDTO.changeTotalPrice(totalPrice);
        notifyObservers(totalPrice);
        return totalPrice;
    }
    /**
     * Adds a list of RevenueObserver.
     * @param observers the list to be added.
     */
        public void addRevenueObservers(List<RevenueObserver> observers) {
        revenueObservers.addAll(observers);
    }
    
    /**
     * Notifies the RevenueObserver when a final price of a sale has been calculated.
     * @param totalPrice The total price that was calculated
     */
    private void notifyObservers(double totalPrice){
        for(RevenueObserver revenueObserver : revenueObservers){
        revenueObserver.finishedSale(totalPrice);
        }
    }
    
    /**
     * Checks if a specified item already exists in a list during a sale. It iterates through the list to 
     * ensure if the same item already exists.
     * @param item The specified item to check.
     * @return Returns either true or false depending if the item exists in the list or not
     */
    private boolean checkItemInList(Item item){
        for(Item temporaryItem : itemList){
            if(temporaryItem.equals(item)){
                return true; 
            }
        }
        return false;
    }
    
}
