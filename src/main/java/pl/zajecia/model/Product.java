package pl.zajecia.model;

import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
public class Product {

    private String id;
    private String name;
    private double price;

    public Product() {
        this.id = UUID.randomUUID().toString();
    }

    public Product(String name, double price) {
        this();
        this.name = name;
        this.price = price;
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) {
            return true;
        }
        if (object instanceof Product) {
            Product productToCompare = (Product) object;
            return productToCompare.getId().equals(this.getId());
        }
        return false;
    }
}
