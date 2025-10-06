package com.product.inventory.service;

import com.product.inventory.dto.ProductDTO;
import com.product.inventory.model.Product;
import com.product.inventory.repository.InventoryRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductInventoryService {
    private final InventoryRepository repository;

    public ProductInventoryService(InventoryRepository inventoryRepository) {
        this.repository = inventoryRepository;
    }

    public void saveUpdate(Product update) {
        Product product = new Product(update.getProductID().getProductName(),
                update.getProductID().getStoreId(),
                update.getQuantity());
        repository.save(product);
    }
    public List<ProductDTO> getQuantityPerProducts(){
        return repository.getQuantityPerProducts();
    }
}
