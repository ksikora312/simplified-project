package pl.zajecia.model;

import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
public class Address {

    private String id;
    private String city;
    private String street;
    private int houseNumber;
    //    private int flatNumber;
//    private String post;
//    private String zipCode;
//    private Region region;
    private AddressType addressType;

    public Address() {
        this.id = UUID.randomUUID().toString();
    }

    public Address(String city, String street, int houseNumber) {
        this.id = UUID.randomUUID().toString();
        this.city = city;
        this.street = street;
        this.houseNumber = houseNumber;
    }

    @Override
    public boolean equals(Object object) {
        if (object instanceof Address) {
            Address addressToCompare = (Address) object;
            return addressToCompare.getId().equals(this.getId());
        }
        return false;
    }

}
