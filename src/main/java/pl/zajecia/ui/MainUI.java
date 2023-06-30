package pl.zajecia.ui;

import pl.zajecia.model.Product;

import java.util.Scanner;

public class MainUI {

    private Scanner scanner;

    public MainUI (){
        this.scanner = new Scanner(System.in);
    }

    public void showMenu() {
        System.out.println("1) Klienci");
        System.out.println("2) Produkty");
        System.out.println("3) Zamowienia");
        System.out.println("4) Koniec");

        int choice = ConsoleUtils.getIntInput(scanner, 1, 4);

        switch (choice) {
            case 1:
                CustomerUI customerUI = new CustomerUI();
                customerUI.showMenu();
                break;
            case 2:
                ProductUI productUI = new ProductUI();
                productUI.showMenu();
                break;
            case 3:
                OrderUI orderUI = new OrderUI();
                orderUI.showMenu();
                break;
            case 4:
                break;
        }
    }
}
