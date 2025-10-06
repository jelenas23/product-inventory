package com.product.inventory.model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ProductIDTest {

    @Test
    void testConstructor() {
        ProductID id = new ProductID("Mouse", 3);
        assertEquals("Mouse", id.getProductName());
        assertEquals(3, id.getStoreId());
    }

    @Test
    void testGettersAndSetters() {
        ProductID id = new ProductID();
        id.setProductName("Mouse");
        id.setStoreId(3);
        assertEquals("Mouse", id.getProductName());
        assertEquals(3, id.getStoreId());
    }
}