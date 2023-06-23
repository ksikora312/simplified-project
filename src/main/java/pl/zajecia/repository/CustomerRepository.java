package pl.zajecia.repository;

import lombok.NoArgsConstructor;
import pl.zajecia.model.Customer;
import java.util.ArrayList;
import java.util.List;

public class CustomerRepository {

    private List<Customer> customers;

    public CustomerRepository() {this.customers = new ArrayList<>();}

    public void save(Customer customer) {customers.add(customer);}

    public void delete(Customer customer) {customers.remove(customer);}
}
