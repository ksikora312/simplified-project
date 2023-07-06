package pl.zajecia.ui;

import pl.zajecia.repository.OrderRepository;

import java.util.Scanner;

public class OrderUI {
    private Scanner scanner;
    private OrderRepository orderRepository;
    private boolean keepShowingOrderUI;

    public OrderUI(Scanner scanner) {
        this.scanner = scanner;
        this.orderRepository = OrderRepository.getInstance();
    }

    public void showMenu() {
        this.keepShowingOrderUI = true;
        while (keepShowingOrderUI) {
            showMenu();
            int choice = ConsoleUtils.getIntInput(scanner, 1, 5);
            handleUserChoice(choice);
        }
    }

    private void printMenu() {
        System.out.println("1) Wyswietl wszystkie zamowienia");
        System.out.println("2) Dodaj zamowienie");
        System.out.println("3) Edytuj zamowienie");
        System.out.println("4) Usun zamowienie");
        System.out.println("5) Wroc");
    }

    private void handleUserChoice(int choice) {
        switch (choice) {
            case 1:
                break;
            case 2:
                break;
            case 3:
                break;
            case 4:
                break;
            default:
                break;
        }
    }
}
