
package se.kth.iv1350.processsale.integration;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import se.kth.iv1350.processsale.model.Item;


public class ExternalInventorySystemTest {
    
@BeforeEach
    public void setUp() {
    }
    
    @AfterEach
    public void tearDown() {
    }
    
    @Test
    public void testItemIdentifierInvalid() throws ItemIdentifierInvalidException,
            CouldNotConnectToDatabaseException {
        ExternalInventorySystem instance = new ExternalInventorySystem();
        try{
        instance.fetchItemInformation(100011, 1, new Item());
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
        instance.fetchItemInformation(100000, 1, new Item());
        }
        catch(CouldNotConnectToDatabaseException cnctde){
            assertTrue(cnctde.getMessage().contains("A connection to the External Inventory"),
                    "UnableToConnectToDatabaseException was not thrown");
        }
    }
    
}
