package pl.zajecia.model;

import lombok.Getter;
import lombok.Setter;

import java.util.*;

@Getter
@Setter
public class Customer {

    private String idCustomer;
    private String name;
//TODO: nie wiem jak rozwiązań pozostawianie listy adresów przy kliencie/w jaki sposób wypełniać tę listę    private List<Address> addresses;
    private List<Order> orders;

    public Customer() {
        this.idCustomer = UUID.randomUUID().toString();
 //       this.addresses = new ArrayList<>();
        this.orders = new ArrayList<>();
    }

    public Customer(String name) {
        this();
        this.name = name;
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
