package pl.zajecia.model;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class Customer {

    private String name;
    private List<Address> customerAddresses;
    private List<Order> orders;

}
