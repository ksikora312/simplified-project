package pl.zajecia.repository;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import pl.zajecia.model.Address;

import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class AddressRepository {

    private static AddressRepository instance;

    // TODO: Zmienić w pozostałych klasach możliwe pola na final
    private final List<Address> addresses = new ArrayList<>();

    public static AddressRepository getInstance() {
        if (instance == null) {
            instance = new AddressRepository();
        }
        return instance;
    }


    public void save(Address address) {
        addresses.add(address);
    }

    public void delete(Address address) {
        addresses.remove(address);
    }

    public List<Address> getAllAddresses() {
        return addresses;
    }

}
