package pl.zajecia.repository;

import lombok.NoArgsConstructor;
import pl.zajecia.model.Address;

import java.util.ArrayList;
import java.util.List;

public class AddressRepository {

    private List<Address> addresses;

    public AddressRepository() {
        this.addresses = new ArrayList<>();
    }

    public void save(Address address) {
        addresses.add(address);
    }

    public void delete(Address address) {
        addresses.remove(address);
    }

}
