package pl.zajecia;

import pl.zajecia.model.Address;
import pl.zajecia.model.Customer;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
//        OnlineShop onlineShop = new OnlineShop();
//        onlineShop.run();

        Customer customerOne = new Customer();
        customerOne.setName("Tomasz");
        Address anotherAddress = new Address();
        anotherAddress.setCity("Krakow");
        customerOne.setCustomerAddresses();
        customerOne.customerAddresses.add(anotherAddress);




        Address address = new Address();
        address.setCity("Gliwice");


        List<Address> list = new ArrayList<>();

        list.add(address);
        list.add(anotherAddress);

        list.forEach(addr -> System.out.println("Id: " + addr.getId() + ", city: " + addr.getCity()));


        System.out.println("---------");

        address.setCity("Sosnowiec");

        list.forEach(addr -> System.out.println("Id: " + addr.getId() + ", city: " + addr.getCity()));
    }

}
