
package se.kth.iv1350.processsale.model;

import java.util.ArrayList;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import se.kth.iv1350.processsale.model.dto.SaleDTO;

public class SaleTest {
    Item testItem1;
    Item testItem2;

    public SaleTest() {
    }
    
    @BeforeAll
    public static void setUpClass() {
    }
    
    @AfterAll
    public static void tearDownClass() {
    }
    
    @BeforeEach
    public void setUp() {
        testItem1 = new Item();
        testItem1.setItemDTO("Item", 9.99, 0.25, 1, 100010);
        testItem2 = new Item();
        testItem2.setItemDTO("Item", 9.99, 0.25, 1, 100010);

    }
    
    @AfterEach
    public void tearDown() {
        testItem1 = null;
    }

    @Test
    public void testGetSaleDTO() {
        Sale instance = new Sale();
        SaleDTO result = instance.getSaleDTO();
        assertNotNull(result, "Didn't return a saleDTO");
    }

    @Test
    public void testGetReceipt() {
        Sale instance = new Sale();
        Receipt result = instance.getReceipt();
        assertNotNull(result, "Didn't return a Receipt");
    }

    @Test
    public void testGetItemList() {
        Sale instance = new Sale();
        ArrayList<Item> result = instance.getItemList();
        assertNotNull(result, "Didn't return a ItemList");
    }

    @Test
    public void testAddItem() {
        Sale instance = new Sale();
        instance.addItem(testItem1);
        int expResult = 1;
        int result = instance.getItemList().size();
        assertEquals(expResult, result, "No item was added");
    }

    @Test
    public void testCalculateTotalPrice() {
        Sale instance = new Sale();
        instance.addItem(testItem1);
        instance.addItem(testItem1);
        double expResult = 0.0;
        double result = instance.calculateTotalPrice();
        assertEquals(expResult, result, 0.0);
    }
    
}
