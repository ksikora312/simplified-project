package pl.zajecia.ui;

import pl.zajecia.model.Address;
import pl.zajecia.model.Customer;
import pl.zajecia.repository.AddressRepository;
import pl.zajecia.repository.CustomerRepository;

import java.util.List;
import java.util.Scanner;

public class CustomerUI {

    private Scanner scanner;
    private CustomerRepository customerRepository;
    private AddressRepository addressRepository;

    private boolean keepShowingCustomerUI;

    public CustomerUI(Scanner scanner) {
        // TODO: przerobić pozostałe klasy, aby przyjmowały scanner z zewnątrz
        this.scanner = scanner;
        this.customerRepository = CustomerRepository.getInstance();
        this.addressRepository = AddressRepository.getInstance();
    }

    public void showMenu() {
        // TODO: dorobić w pozostałych klasach możliwość pozostaniu na danym menu
        this.keepShowingCustomerUI = true;

        while (keepShowingCustomerUI) {
            // TODO: uporządkować pozostałe klasy
            printMenu();
            int choice = ConsoleUtils.getIntInput(scanner, 1, 5);
            handleUserChoice(choice);
        }
    }

    private void printMenu() {
        System.out.println("1) Wyswietl wszystkich klientow");
        System.out.println("2) Dodaj klienta");
        System.out.println("3) Edytuj klienta");
        System.out.println("4) Usun klienta");
        System.out.println("5) Wroc");
    }

    private void handleUserChoice(int choice) {
        switch (choice) {
            case 1:
                showAllCustomers();
                break;
            case 2:
                addCustomer();
                break;
            case 3:
                break;
            case 4:
                break;
            case 5:
                this.keepShowingCustomerUI = false;
                break;
        }
    }

    private void showAllCustomers() {
        List<Customer> allCustomers = customerRepository.getAllCustomers();
        for (Customer customer : allCustomers) {
            System.out.println("Customer Id: " + customer.getId() + ", Customer name: " + customer.getName());
        }
    }

    private void addCustomer() {
        // TODO: zastanów się nad możliwośćią przeniesienia wyświetlania na ekran do innej klasy (może ConsoleUtils?)
        System.out.print("Podaj nazwę klienta: ");
        String customerName = scanner.next();
        Customer newCustomer = new Customer(customerName);
        assignAddressToCustomer(newCustomer);
        customerRepository.save(newCustomer);
        // TODO: rozważ zwrócenie customera i następnie jakieś operacje na nim (może dodanie kolejnego adresu?)
    }

    private void assignAddressToCustomer(Customer customer) {
        System.out.print("Podaj adress klienta - miasto: ");
        String customerCity = scanner.next();
        System.out.print("Podaj adress klienta - ulica: ");
        String customerStreet = scanner.next();
        System.out.print("Podaj adress klienta - nr domu: ");
        int customerHouseNumber = ConsoleUtils.getIntInput(scanner, 1, Integer.MAX_VALUE);
        Address newAddress = new Address(customerCity, customerStreet, customerHouseNumber);
        addressRepository.save(newAddress);
        customer.addAddress(newAddress);
    }
}
