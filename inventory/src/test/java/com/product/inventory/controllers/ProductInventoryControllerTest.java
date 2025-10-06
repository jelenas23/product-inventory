package com.product.inventory.controllers;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.product.inventory.dto.ProductDTO;
import com.product.inventory.model.Product;
import com.product.inventory.service.ProductInventoryService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.test.web.servlet.MockMvc;

import java.util.List;

import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(ProductInventoryController.class)
class ProductInventoryControllerTest {
    @Autowired
    private MockMvc mockMvc;
    @MockitoBean
    private ProductInventoryService service;
    @Autowired
    private ObjectMapper objectMapper;

    @Test
    void testUpdateInventory() throws Exception {
        Product product = new Product("Keyboard", 1, 50);

        mockMvc.perform(post("/inventory/update")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(product)))
                .andExpect(status().isCreated())
                .andExpect(content().string("Inventory updated successfully!"));

        verify(service, times(1)).saveUpdate(any(Product.class));
    }

    @Test
    void testGetAllProducts() throws Exception {
        when(service.getQuantityPerProducts())
                .thenReturn(List.of(
                        new ProductDTO("Laptop", 100),
                        new ProductDTO("Mouse", 15)
                )
        );

        mockMvc.perform(get("/inventory/products"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.length()").value(2))
                .andExpect(jsonPath("$[0].productName").value("Laptop"))
                .andExpect(jsonPath("$[0].totalQuantity").value(100))
                .andExpect(jsonPath("$[1].productName").value("Mouse"))
                .andExpect(jsonPath("$[1].totalQuantity").value(15));
        verify(service, times(1)).getQuantityPerProducts();
    }
}