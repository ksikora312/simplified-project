package pl.zajecia.repository;

import pl.zajecia.model.Customer;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class CustomerRepository {

    private List<Customer> customers;

    private static volatile CustomerRepository instance = null;

    private CustomerRepository() {
        if (instance != null) {
            throw new RuntimeException("Not allowed. Please use getInstance() method");
        }
    }

    public static CustomerRepository getInstance() {
        if (instance == null) {
            synchronized(CustomerRepository.class){
                if (instance == null) {
                    instance = new CustomerRepository();
                }
            }
        }
        return instance;
    }

    public CustomerRepository() {
        this.customers = new ArrayList<>();
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

    public List<Customer> getAllCustomers() { return customers;}
}
