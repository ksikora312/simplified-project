package pl.zajecia.ui;

import pl.zajecia.model.Address;
import pl.zajecia.model.Customer;
import pl.zajecia.repository.CustomerRepository;

import java.util.List;
import java.util.Optional;
import java.util.Scanner;

public class CustomerUI {
    private Scanner scanner;
    private CustomerRepository customerRepository;

    public CustomerUI() {
        this.scanner = new Scanner(System.in);
        this.customerRepository = new CustomerRepository();
    }

    public void showMenu() {
        System.out.println("1) Wyswietl wszystkich klientow");
        System.out.println("2) Dodaj klienta");
        System.out.println("3) Edytuj klienta");
        System.out.println("4) Usun klienta");
        System.out.println("5) Wroc");

        int choice = ConsoleUtils.getIntInput(scanner,1,5);

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
                MainUI mainUI = new MainUI();
                mainUI.showMenu();
                break;
        }
    }

    private void showAddresMenu(Customer customer) {
        System.out.println("1) Czy dodac nastepny adres klienta");
        System.out.println("2) Wroc do widoku klienta");
        System.out.println("2) Wroc do menu Klienci");

        int choice = ConsoleUtils.getIntInput(scanner,1,3);

        switch (choice) {
            case 1:
                addCustomerAddress(customer);
                break;
            case 2:
                break;
            case 3:
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
        System.out.print("Podaj nazwę klienta: ");
        String customerName = scanner.next();
        //TODO dodanie adresu klienta
        Customer newCustomer = new Customer(customerName);
        customerRepository.save(newCustomer);
        addCustomerAddress(newCustomer);
    }

    private void addCustomerAddress(Customer customer) {
        System.out.print("Podaj adress klienta - miasto: ");
        String customerCity = scanner.next();
        System.out.print("Podaj adress klienta - ulica: ");
        String customerStreet = scanner.next();
        System.out.print("Podaj adress klienta - nr domu: ");
        int customerHouseNumber = Integer.parseInt(scanner.next());
        Address newAddress = new Address(customerCity, customerStreet, customerHouseNumber );
        customer.addAddress(newAddress);
        showAddresMenu(customer);
    }
}
