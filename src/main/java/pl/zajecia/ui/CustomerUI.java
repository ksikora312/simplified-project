package pl.zajecia.ui;

import pl.zajecia.model.Address;
import pl.zajecia.model.AddressType;
import pl.zajecia.model.Customer;
import pl.zajecia.repository.AddressRepository;
import pl.zajecia.repository.CustomerRepository;

import java.util.List;
import java.util.Optional;
import java.util.Scanner;

public class CustomerUI {

    private Scanner scanner;
    private CustomerRepository customerRepository;
    private AddressRepository addressRepository;

    private boolean keepShowingCustomerUI;

    public CustomerUI(Scanner scanner) {
        // DONE: TODO: przerobić pozostałe klasy, aby przyjmowały scanner z zewnątrz
        this.scanner = scanner;
        this.customerRepository = CustomerRepository.getInstance();
        this.addressRepository = AddressRepository.getInstance();
    }

    public void showMenu() {
        // DONE: TODO: dorobić w pozostałych klasach możliwość pozostaniu na danym menu
        this.keepShowingCustomerUI = true;

        while (keepShowingCustomerUI) {
            // DONE: TODO: uporządkować pozostałe klasy
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
                Customer customer = addCustomer();
                boolean assignNextAddress = true;
                while (assignNextAddress) {
                    assignAddressToCustomer(customer, assignNextAddress);
                    assignNextAddress = assignNextAddress();
                }
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
        AddressRepository addressRepository = AddressRepository.getInstance();

        for (Customer customer : allCustomers) {
            System.out.println("Customer Id: " + customer.getIdCustomer() + " Customer name: " + customer.getName());
            System.out.println("Addresses");

            List<Address> customerAddresses = addressRepository.getAddressesByCustomerId(customer.getIdCustomer());
            for (Address address : customerAddresses) {
                System.out.println("- " + address.getStreet() + ", " + address.getCity());
            }
        };
    }

    private Customer addCustomer() {
        // TODO: zastanów się nad możliwośćią przeniesienia wyświetlania na ekran do innej klasy (może ConsoleUtils?)
        System.out.print("Podaj nazwę klienta: ");
        String customerName = scanner.next();
        Customer newCustomer = new Customer(customerName);
        customerRepository.save(newCustomer);
        return newCustomer;
        // TODO: rozważ zwrócenie customera i następnie jakieś operacje na nim (może dodanie kolejnego adresu?)

    }

    private void assignAddressToCustomer(Customer customer, boolean assignNextAddress) {
        //boolean assignNextAddress = true;
        while (assignNextAddress) {
        System.out.print("Podaj adress klienta - miasto: ");
        String customerCity = scanner.next();

        System.out.print("Podaj adress klienta - ulica: ");
        String customerStreet = scanner.next();

        System.out.print("Podaj adress klienta - nr domu: ");
        int customerHouseNumber = ConsoleUtils.getIntInput(scanner, 1, Integer.MAX_VALUE);

        System.out.println("Podaj typ adress klienta: ");
        System.out.println("1) Adres glowny");
        System.out.println("2) Adres dodatkowy");
        int inputAddressType = ConsoleUtils.getIntInput(scanner, 1, 2);
        Address newAddress = new Address();
        newAddress.setCustomer(customer);
        newAddress.setCity(customerCity);
        newAddress.setStreet(customerStreet);
        newAddress.setHouseNumber(customerHouseNumber);

        switch (inputAddressType) {
            case 1:
                newAddress.setAddressType(AddressType.PRIMARY);
                break;
            case 2:
                newAddress.setAddressType(AddressType.SECONDARY);
                break;
        }
        addressRepository.save(newAddress);
        assignNextAddress = assignNextAddress();
        }


    }

    private boolean assignNextAddress () {
        System.out.println("Dodać następny adres?");
        System.out.println("1) tak");
        System.out.println("2) nie");
        int inputNextAddress = ConsoleUtils.getIntInput(scanner, 1, 2);
        if (inputNextAddress==1) {
            return true;
        } else return false;
    }

}
