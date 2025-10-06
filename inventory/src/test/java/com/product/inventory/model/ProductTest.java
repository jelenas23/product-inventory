package com.product.inventory.model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

class ProductTest {

    @Test
    void testContructor() {
        Product product = new Product("Laptop", 1, 10);

        assertNotNull(product.getProductID());
        assertEquals("Laptop", product.getProductID().getProductName());
        assertEquals(1, product.getProductID().getStoreId());
        assertEquals(10, product.getQuantity());
    }
    @Test
    void testSettersAndGetters() {
        Product product = new Product();
        ProductID id = new ProductID("Phone", 2);
        product.setProductID(id);
        product.setQuantity(5);

        assertEquals("Phone", product.getProductID().getProductName());
        assertEquals(2, product.getProductID().getStoreId());
        assertEquals(5, product.getQuantity());
    }
}