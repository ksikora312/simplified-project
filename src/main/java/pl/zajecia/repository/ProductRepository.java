package pl.zajecia.repository;

import pl.zajecia.model.Product;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class ProductRepository {

    private List<Product> products;

    /**
     * TODO Zadanie domowe:
     * Poczytać o wzorcu projektowym Singleton i zastanoawić się w jaki sposób go wprowadzić do naszych repozytoriów
     * Jak się uda, to wprowadzić
     */

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
