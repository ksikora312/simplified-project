package pl.zajecia.repository;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import pl.zajecia.model.Address;
import pl.zajecia.model.Customer;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

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

    public Optional<Customer> findById(String customerId) {
        // TODO: introduce services
        Optional<Customer> optionalCustomer = customers.stream().filter(customer -> customer.getIdCustomer().equals(customerId)).findAny();
        optionalCustomer.ifPresent(customer -> {
            AddressRepository addressRepository = AddressRepository.getInstance();
            List<Address> customerAddresses = addressRepository.findAddressesByCustomerId(customerId);
        });
        return optionalCustomer;

    }

    public boolean existsById(String customerId) {
        return customers.stream().anyMatch(c -> c.getIdCustomer().equals(customerId));
    }

    public List<Customer> getAllCustomers() {
        return customers;
    }
}
