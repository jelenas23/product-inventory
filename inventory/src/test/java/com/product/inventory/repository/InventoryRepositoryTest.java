package com.product.inventory.repository;

import com.product.inventory.dto.ProductDTO;
import com.product.inventory.model.Product;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
class InventoryRepositoryTest {
    @Autowired
    private InventoryRepository repository;
    @BeforeEach
    void setup() {
        repository.deleteAll();
    }
    @Test
    void testGetQuantityPerProducts() {
        repository.save(new Product("Laptop", 1, 200));
        repository.save(new Product("Laptop", 2, 4));
        repository.save(new Product("Mouse", 2, 10));

        List<ProductDTO> products = repository.getQuantityPerProducts();
        assertEquals(2, products.size());

        ProductDTO laptop = products.stream().
                filter(productDTO -> productDTO.getProductName().equals("Laptop")).
                findFirst().orElse(null);

        ProductDTO mouse = products.stream().
                filter(productDTO -> productDTO.getProductName().equals("Mouse")).
                findFirst().orElse(null);

        assertNotNull(laptop);
        assertEquals(204,laptop.getTotalQuantity());

        assertNotNull(mouse);
        assertEquals(10,mouse.getTotalQuantity());
    }
}