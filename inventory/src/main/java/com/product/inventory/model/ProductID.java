package com.product.inventory.model;

import jakarta.persistence.Embeddable;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
@Embeddable
@Getter
@Setter
public class ProductID implements Serializable {
    private String productName;
    private int storeId;

    public ProductID() {
    }

    public ProductID(String productName, int storeId) {
        this.productName=productName;
        this.storeId=storeId;
    }
}
