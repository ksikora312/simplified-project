package pl.zajecia.model;

import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
public class Address {

    private String idAddress;
    //private String idCustomer;
    // DONE: TODO: consider?
    private Customer customer;
    private String city;
    private String street;
    private int houseNumber;
    private AddressType addressType;





    public Address() {
        this.idAddress = UUID.randomUUID().toString();
    }

    public Address(Customer customer, String city, String street, int houseNumber, AddressType addressType) {
        super();
        this.customer = customer;
        this.city = city;
        this.street = street;
        this.houseNumber = houseNumber;
        this.addressType = addressType;
    }

    @Override
    public boolean equals(Object object) {
        if (object instanceof Address) {
            Address addressToCompare = (Address) object;
            return addressToCompare.getIdAddress().equals(this.getIdAddress());
        }
        return false;
    }

}
