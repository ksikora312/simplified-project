package pl.zajecia;

import pl.zajecia.ui.ConsoleUtils;
import pl.zajecia.ui.CustomerUI;
import pl.zajecia.ui.OrderUI;
import pl.zajecia.ui.ProductUI;

import java.util.Scanner;

public class OnlineShop {

    private Scanner scanner;

    private final CustomerUI customerUI;
    private final ProductUI productUI;
    private final OrderUI orderUI;

    private boolean isApplicationRunning;

    public OnlineShop() {
        this.scanner = new Scanner(System.in);
        this.customerUI = new CustomerUI(scanner);
        this.productUI = new ProductUI(scanner);
        this.orderUI = new OrderUI(scanner);
        this.isApplicationRunning = true;
    }

    public void run() {
        while (isApplicationRunning) {
            System.out.println("1) Klienci");
            System.out.println("2) Produkty");
            System.out.println("3) Zamowienia");
            System.out.println("4) Koniec");

            int choice = ConsoleUtils.getIntInput(scanner, 1, 4);

            switch (choice) {
                case 1:
                    customerUI.showMenu();
                    break;
                case 2:
                    productUI.showMenu();
                    break;
                case 3:
                    orderUI.showMenu();
                    break;
                case 4:
                    isApplicationRunning = false;
                    break;
            }
        }
    }


}
