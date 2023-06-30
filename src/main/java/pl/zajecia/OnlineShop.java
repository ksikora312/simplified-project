package pl.zajecia;

import pl.zajecia.ui.*;

import java.util.Scanner;

public class OnlineShop {

    private Scanner scanner;

    private CustomerUI customerUI;
    private ProductUI productUI;
    private OrderUI orderUI;

    private boolean isApplicationRunning;

    public OnlineShop() {
        this.scanner = new Scanner(System.in);
        this.customerUI = new CustomerUI(scanner);
        this.productUI = new ProductUI();
        this.orderUI = new OrderUI();
        this.isApplicationRunning = true;
    }

    public void run() {
        while(isApplicationRunning) {
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
