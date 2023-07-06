package pl.zajecia.ui;

import pl.zajecia.model.Product;
import pl.zajecia.repository.ProductRepository;

import java.util.List;
import java.util.Optional;
import java.util.Scanner;

public class ProductUI {

    private final Scanner scanner;
    private final ProductRepository productRepository;

    private boolean keepShowingProductUI;

    public ProductUI(Scanner scanner) {
        this.scanner = scanner;
        this.productRepository = ProductRepository.getInstance();
    }

    public void showMenu() {
        this.keepShowingProductUI = true;
        while (keepShowingProductUI) {
            printMenu();
            int choice = ConsoleUtils.getIntInput(scanner, 1, 5);
            handleUserChoice(choice);
        }
    }
    private void printMenu() {
        System.out.println("1) Wyswietl wszystkie produkty");
        System.out.println("2) Dodaj produkt");
        System.out.println("3) Edytuj produkt");
        System.out.println("4) Usun produkt");
        System.out.println("5) Wroc");
    }

    private void handleUserChoice(int choice) {
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
            case 4:
                break;
            default:
                break;
        }
    }

    private void showEditMenu(Product product) {
        System.out.println("1) Zmien nazwe produktu, aktualna nazwa to : " + product.getName());
        System.out.println("2) Zmien cene produktu, aktualna cena wynosi : " + product.getPrice());
        System.out.println("3) Wroc do menu produktow");

        int choice = ConsoleUtils.getIntInput(scanner, 1, 3);
        handleEditMenuUserChoice(product, choice);
    }

    private void handleEditMenuUserChoice(Product product, int choice) {
        // TODO: update whole product at once + services and DTOs
        switch (choice) {
            case 1:
                System.out.println("Podaj nowa nazwe");
                String productName = scanner.next();
                product.setName(productName);
                showEditMenu(product);
                break;
            case 2:
                System.out.println("Podaj nowa cene");
                double productPrice = ConsoleUtils.getDoubleInput(scanner, 0.01);
                product.setPrice(productPrice);
                showEditMenu(product);
                break;
            case 3:
                showMenu();
                break;
        }
    }

    private void showAllProducts() {
        List<Product> allProducts = productRepository.getAllProducts();
        for (Product product : allProducts) {
            System.out.println("Product Id: " + product.getId() + ", Product name: " + product.getName() + ", price: " + product.getPrice());
        }
    }

    private void addProduct() {
        System.out.print("Podaj nazwe produktu: ");
        String productName = scanner.next();

        System.out.print("Podaj cene produktu: ");
        double price = ConsoleUtils.getDoubleInput(scanner, 0.0);

        Product newProduct = new Product(productName, price);
        productRepository.save(newProduct);
    }

    private void editProduct() {
        System.out.print("Podaj id produktu: ");
        String productId = scanner.next();
        Optional<Product> productOptional = productRepository.getById(productId);
        if (productOptional.isPresent()) {
            // DONE (chyba) TODO: logika update
            Product productToUpdate = productOptional.get();
            showEditMenu(productToUpdate);
        } else {
            System.err.println("Nie istnieje produkt o takim id!");
        }
    }

}
