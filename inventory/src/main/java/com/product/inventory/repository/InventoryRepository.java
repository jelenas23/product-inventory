package com.product.inventory.repository;

import com.product.inventory.dto.ProductDTO;
import com.product.inventory.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface InventoryRepository extends JpaRepository<Product, Long> {

    @Query("SELECT new com.product.inventory.dto.ProductDTO(p.productID.productName, SUM(p.quantity)) " +
            "FROM Product p " +
            "GROUP BY p.productID.productName")
    List<ProductDTO> getQuantityPerProducts();
}
