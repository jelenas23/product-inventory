package com.product.inventory.model;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "product")
@Getter
@Setter
public class Product {
    @EmbeddedId
    private ProductID productID;
    private int quantity;

    public Product() {
    }

    public Product(String productName, int storeId, int quantity) {
        this.productID = new ProductID(productName, storeId);
        this.quantity = quantity;
    }
   /* public void setProductName(String productName) {
        if (this.productID == null) this.productID = new ProductID();
        this.productID.setProductName(productName);
    }*/

    /*public void setStoreId(int storeId) {
        if (this.productID == null) this.productID = new ProductID();
        this.productID.setStoreId(storeId);
    }*/
}
