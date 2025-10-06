package com.product.inventory.service;

import com.product.inventory.dto.ProductDTO;
import com.product.inventory.model.Product;
import com.product.inventory.repository.InventoryRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

class ProductInventoryServiceTest {
    @Mock
    private InventoryRepository repository;
    @InjectMocks
    private ProductInventoryService service;

    @BeforeEach()
    void setup() {
        MockitoAnnotations.openMocks(this); // inicijalizuje @Mock i @InjectMocks
    }

    @Test
    void saveUpdate() {
        Product product = new Product("Laptop", 1, 10);
        service.saveUpdate(product);
        verify(repository, times(1)).save(any(Product.class));
    }

    @Test
    void getQuantityPerProducts() {
        List<ProductDTO> mocks = List.of(
                new ProductDTO("Laptop", 100),
                new ProductDTO("Mouse",10));
        when(repository.getQuantityPerProducts()).thenReturn(mocks);
        List<ProductDTO> result = service.getQuantityPerProducts();
        assertEquals(2, result.size());
        assertEquals("Laptop", result.get(0).getProductName());
        assertEquals(100, result.get(0).getTotalQuantity());

        verify(repository, times(1)).getQuantityPerProducts();
    }
}