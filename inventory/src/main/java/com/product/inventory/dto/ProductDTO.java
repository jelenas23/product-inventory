package com.product.inventory.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProductDTO {
    private String productName;
    private long totalQuantity;

    public ProductDTO() {
    }

    public ProductDTO(String productName, long totalQuantity) {
        this.productName = productName;
        this.totalQuantity = totalQuantity;
    }
}
