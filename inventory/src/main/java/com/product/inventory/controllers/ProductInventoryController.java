package com.product.inventory.controllers;

import com.product.inventory.dto.ProductDTO;
import com.product.inventory.model.Product;
import com.product.inventory.service.ProductInventoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/inventory")
public class ProductInventoryController {
    @Autowired
    private ProductInventoryService productInventoryService;

    @PostMapping("/update")
    public ResponseEntity<String> updateInventory(@RequestBody Product update) {
        productInventoryService.saveUpdate(update);
        return ResponseEntity.status(HttpStatus.CREATED).body("Inventory updated successfully!");
    }
    @GetMapping("/products")
    public List<ProductDTO> getAllProducts(){
        return productInventoryService.getQuantityPerProducts();
    }
}
