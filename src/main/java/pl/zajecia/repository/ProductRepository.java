package pl.zajecia.repository;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import pl.zajecia.model.Product;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class ProductRepository {

    private static ProductRepository instance;

    private final List<Product> products = new ArrayList<>();

    public static ProductRepository getInstance() {
        if (instance == null) {
            instance = new ProductRepository();
        }
        return instance;
    }

    public void save(Product product) {
        products.add(product);
    }

    public void delete(Product product) {
        products.remove(product);
    }

    public Optional<Product> getById(String productId) {
        return products.stream().filter(product -> product.getId().equals(productId)).findAny();
    }

    public List<Product> getAllProducts() {
        return products;
    }
}
