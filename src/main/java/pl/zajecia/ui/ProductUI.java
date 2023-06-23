package pl.zajecia.ui;

import pl.zajecia.model.Product;
import pl.zajecia.repository.ProductRepository;

import java.util.List;
import java.util.Optional;
import java.util.Scanner;

public class ProductUI {

    private Scanner scanner;
    private ProductRepository productRepository;

    public ProductUI() {
        this.scanner = new Scanner(System.in);
        this.productRepository = new ProductRepository();
    }

    public void showMenu() {
        System.out.println("1) Wyswietl wszystkie produkty");
        System.out.println("2) Dodaj produkt");
        System.out.println("3) Edytuj produkt");
        System.out.println("4) Usun produkt");

        int choice = ConsoleUtils.getIntInput(scanner, 1, 4);

        switch (choice) {
            case 1:
                showAllProducts();
                break;
            case 2:
                addProduct();
                break;
            case 3:
                editProduct();
                break;
        }

    }

    private void showAllProducts() {
        List<Product> allProducts = productRepository.getAllProducts();
        for (Product product : allProducts) {
            System.out.println("Id: " + product.getId() + ", name: " + product.getName() + ", price: " + product.getPrice());
        }
    }

    private void addProduct() {
        System.out.print("Podaj nazwe produktu: ");
        String productName = scanner.next();
        // TODO: logika do sprawdzania poprawnosci - do klasy ConsoleUtils wrzucic
        System.out.print("Podaj cene produktu: ");
        double price = scanner.nextDouble();

        Product newProduct = new Product(productName, price);
        productRepository.save(newProduct);
    }

    private void editProduct() {
        System.out.print("Podaj id produktu: ");
        String productId = scanner.next();
        Optional<Product> productOptional = productRepository.getById(productId);
        if(productOptional.isPresent()) {
            // TODO: logika update
        } else {
            System.err.println("Nie istnieje produkt o takim id!");
        }
    }

}
