package pl.zajecia.repository;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import pl.zajecia.model.Address;
import pl.zajecia.model.Customer;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collector;
import java.util.stream.Collectors;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class CustomerRepository {

    private static CustomerRepository instance;

    private final List<Customer> customers = new ArrayList<>();

    public static CustomerRepository getInstance() {
        if (instance == null) {
            instance = new CustomerRepository();
        }
        return instance;
    }

    public void save(Customer customer) {
        customers.add(customer);
    }

    public void delete(Customer customer) {
        customers.remove(customer);
    }

    public Optional<Customer> getById(String customerId) {
        Optional<Customer> optionalCustomer = customers.stream().filter(customer -> customer.getIdCustomer().equals(customerId)).findAny();
        optionalCustomer.ifPresent(customer -> {
            AddressRepository addressRepository = AddressRepository.getInstance();
            List<Address> customerAddresses = addressRepository.getAddressesByCustomerId(customerId);
        });
        return optionalCustomer;

    }

    public List<Customer> getAllCustomers() {
        return customers;
    }
}
