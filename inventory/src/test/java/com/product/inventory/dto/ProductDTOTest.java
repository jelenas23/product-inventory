package com.product.inventory.dto;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ProductDTOTest {

    @Test
    void testSettersAndGetters() {
        ProductDTO productDTO = new ProductDTO();
        productDTO.setProductName("Mouse");
        productDTO.setTotalQuantity(5);

        assertEquals("Mouse", productDTO.getProductName());
        assertEquals(5, productDTO.getTotalQuantity());
    }
    @Test
    void testConstructor() {
        ProductDTO productDTO = new ProductDTO("Mouse",5);

        assertEquals("Mouse", productDTO.getProductName());
        assertEquals(5, productDTO.getTotalQuantity());
    }


}