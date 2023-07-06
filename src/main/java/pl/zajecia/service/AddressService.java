package pl.zajecia.service;

import lombok.RequiredArgsConstructor;
import pl.zajecia.dto.CreateAddressDto;
import pl.zajecia.model.Address;
import pl.zajecia.model.AddressType;
import pl.zajecia.model.Customer;
import pl.zajecia.repository.AddressRepository;
import pl.zajecia.repository.CustomerRepository;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
public class AddressService {

    private final AddressRepository addressRepository;
    private final CustomerRepository customerRepository;

    public boolean save(CreateAddressDto createAddressDto) {
        Optional<Customer> customerOptional = customerRepository.findById(createAddressDto.getCustomerId());
        if (customerOptional.isEmpty()) {
            return false;
        }

        Customer customer = customerOptional.get();
        if (createAddressDto.getAddressType() == AddressType.PRIMARY) {
            changeExistingPrimaryAddressToSecondary(createAddressDto.getCustomerId());
        }

        Address address = mapToAddress(createAddressDto, customer);
        addressRepository.save(address);
        customer.addAddress(address);

        return true;
    }

    private void changeExistingPrimaryAddressToSecondary(String customerId) {
        List<Address> customerAddresses = addressRepository.findAddressesByCustomerId(customerId);
        Optional<Address> primaryAddress = customerAddresses.stream()
                .filter(addr -> addr.getAddressType() == AddressType.PRIMARY)
                .findAny();

        primaryAddress.ifPresent(addr -> {
            addr.setAddressType(AddressType.SECONDARY);
            // In normal circumstances there should be repository called in order to persist changes
            // In our case it is already changed everywhere in above line as it is the same reference as repository has
        });
    }

    private Address mapToAddress(CreateAddressDto createAddressDto, Customer customer) {
        Address address = new Address();
        address.setAddressType(createAddressDto.getAddressType());
        address.setCity(createAddressDto.getCity());
        address.setHouseNumber(createAddressDto.getHouseNumber());
        address.setStreet(createAddressDto.getStreet());
        address.setCustomer(customer);

        return address;
    }

}
