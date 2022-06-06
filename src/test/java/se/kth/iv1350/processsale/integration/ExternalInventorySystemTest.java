
package se.kth.iv1350.processsale.integration;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import se.kth.iv1350.processsale.model.Item;


public class ExternalInventorySystemTest {

    @Test
    public void testItemIdentifierInvalid() throws ItemIdentifierInvalidException,
            CouldNotConnectToDatabaseException {
        ExternalInventorySystem instance = new ExternalInventorySystem();
        try{
        instance.fetchItemInformation(100011, 1, new Item());
        fail("No exception was thrown or catched");
        }
        catch(ItemIdentifierInvalidException iiie){
            assertTrue(iiie.getMessage().contains("specified identifier"), 
                    "ItemIdentifierInvalidException was not thrown");
        }       
    }
    
    @Test 
    public void testUnableToConnectToDatabase()throws ItemIdentifierInvalidException,
            CouldNotConnectToDatabaseException {
        ExternalInventorySystem instance = new ExternalInventorySystem();
        try{
        instance.fetchItemInformation(0, 1, new Item());
        fail("No exception was thrown or catched");
        }
        catch(CouldNotConnectToDatabaseException cnctde){
            assertTrue(cnctde.getMessage().contains("Inventory System could not be established"),
                    "UnableToConnectToDatabaseException was not thrown");
        }
    }
    
}
