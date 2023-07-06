package pl.zajecia.dto;

import lombok.Getter;
import lombok.Setter;
import pl.zajecia.model.AddressType;

@Getter
@Setter
public class CreateAddressDto {

    private String customerId;
    private String city;
    private String street;
    private int houseNumber;
    private AddressType addressType;

}
