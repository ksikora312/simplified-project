package pl.zajecia.repository;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;
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

    public Optional<Customer> getById(String customerId) {
        return customers.stream().filter(customer -> customer.getId().equals(customerId)).findAny();
    }

    public List<Customer> getAllCustomers() {
        return customers;
    }
}
