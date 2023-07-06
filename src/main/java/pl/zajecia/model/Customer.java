package pl.zajecia.model;

import lombok.Getter;
import lombok.Setter;

import java.util.*;

@Getter
@Setter
public class Customer {

    private String idCustomer;
    private String name;
    private List<Address> addresses;
    private List<Order> orders;

    public Customer() {
        this.idCustomer = UUID.randomUUID().toString();
        this.addresses = new ArrayList<>();
        this.orders = new ArrayList<>();
    }

    public Customer(String name) {
        this();
        this.name = name;
    }

    public void addAddress(Address address) {
        this.addresses.add(address);
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) {
            return true;
        }
        if (object instanceof Customer) {
            Customer customerToCompare = (Customer) object;
            return customerToCompare.getIdCustomer().equals(this.getIdCustomer());
        }
        return false;
    }

}
