package pl.zajecia.ui;

import pl.zajecia.repository.OrderRepository;

import java.util.Scanner;

public class OrderUI {
    private Scanner scanner;
    private OrderRepository orderRepository;

    public OrderUI(){
        this.scanner = new Scanner(System.in);
        this.orderRepository = new OrderRepository();
    }

    public void showMenu(){
        System.out.println("1) Wyswietl wszystkie zamowienia");
        System.out.println("2) Dodaj zamowienie");
        System.out.println("3) Edytuj zamowienie");
        System.out.println("4) Usun zamowienie");
        System.out.println("5) Wroc");

        int choice = ConsoleUtils.getIntInput(scanner,1,5);

        switch (choice) {
            case 1:
                break;
            case 2:
                break;
            case 3:
                break;
            case 4:
                break;
            case 5:
                MainUI mainUI = new MainUI();
                mainUI.showMenu();
                break;
        }

    }
}
