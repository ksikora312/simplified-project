package pl.zajecia.repository;

import lombok.NoArgsConstructor;
import pl.zajecia.model.Product;
import java.util.ArrayList;
import java.util.List;

public class ProductRepository {

    private List<Product> products;

    public ProductRepository() {this.products = new ArrayList<>();}

    public void save(Product product) {products.add(product);}

    public void delete(Product product) {products.remove(product);}
}
