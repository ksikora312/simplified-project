package pl.zajecia.model;

import lombok.Getter;
import lombok.Setter;

import java.util.HashSet;
import java.util.List;
import java.util.UUID;

@Getter
@Setter
public class Customer {

    private String id;
    private String name;
    private List<Address> customerAddresses;
    private List<Order> orders;

    public Customer() {this.id = UUID.randomUUID().toString();}

    @Override
    public boolean equals(Object object) {
        if (this == (Customer) object) {
            return true;
        }
        if (object instanceof Customer) {
            Customer customerToCompare = (Customer) object;
            return customerToCompare.getId().equals(this.getId());
        }
        return false;
    }

}
