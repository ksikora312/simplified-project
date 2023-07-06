package pl.zajecia.ui;

import pl.zajecia.dto.CreateAddressDto;
import pl.zajecia.model.Address;
import pl.zajecia.model.AddressType;
import pl.zajecia.model.Customer;
import pl.zajecia.repository.AddressRepository;
import pl.zajecia.repository.CustomerRepository;
import pl.zajecia.service.AddressService;

import java.util.List;
import java.util.Scanner;

public class CustomerUI {

    private final Scanner scanner;
    private final CustomerRepository customerRepository;
    private final AddressService addressService;

    private boolean keepShowingCustomerUI;

    public CustomerUI(Scanner scanner) {
        this.scanner = scanner;
        this.customerRepository = CustomerRepository.getInstance();
        // TODO: wstrzykiwać w konstruktorze address service (tak jak scanner)
        this.addressService = new AddressService(AddressRepository.getInstance(), CustomerRepository.getInstance());
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
                    assignAddressToCustomer(customer);
                    assignNextAddress = shouldAssignNextAddress();
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

            List<Address> customerAddresses = addressRepository.findAddressesByCustomerId(customer.getIdCustomer());
            for (Address address : customerAddresses) {
                System.out.println("- " + address.getStreet() + ", " + address.getCity() + ", type: " + address.getAddressType());
            }
        }
        ;
    }

    private Customer addCustomer() {
        System.out.print("Podaj nazwę klienta: ");
        String customerName = scanner.next();
        Customer newCustomer = new Customer(customerName);
        customerRepository.save(newCustomer);
        return newCustomer;
    }

    private void assignAddressToCustomer(Customer customer) {
        CreateAddressDto createAddressDto = getCreateAddressDtoFromUser(customer);

        boolean saved = addressService.save(createAddressDto);
        if (saved) {
            System.out.println("Pomyslnie dodano adres");
        } else {
            System.out.println("Nie udalo sie dodac adresu");
        }
    }

    private CreateAddressDto getCreateAddressDtoFromUser(Customer customer) {
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

        CreateAddressDto createAddressDto = new CreateAddressDto();
        createAddressDto.setCustomerId(customer.getIdCustomer());
        createAddressDto.setCity(customerCity);
        createAddressDto.setStreet(customerStreet);
        createAddressDto.setHouseNumber(customerHouseNumber);
        createAddressDto.setAddressType(inputAddressType == 1 ? AddressType.PRIMARY : AddressType.SECONDARY);
        return createAddressDto;
    }

    private boolean shouldAssignNextAddress() {
        System.out.println("Dodać następny adres?");
        System.out.println("1) tak");
        System.out.println("2) nie");
        int inputNextAddress = ConsoleUtils.getIntInput(scanner, 1, 2);
        return inputNextAddress == 1;
    }

}
