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

    public Product() {this.id = UUID.randomUUID().toString();}

    @Override
    public boolean equals(Object object) {
        if (object instanceof Product) {
            Product productToCompare = (Product) object;
            return productToCompare.getId().equals(this.getId());
        }
        return false;
    }
}
