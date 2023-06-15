package pl.zajecia;

import pl.zajecia.model.Address;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
//        OnlineShop onlineShop = new OnlineShop();
//        onlineShop.run();

        Address address = new Address();
        address.setCity("Gliwice");
        Address anotherAddress = new Address();
        anotherAddress.setCity("Krakow");

        List<Address> list = new ArrayList<>();

        list.add(address);
        list.add(anotherAddress);

        list.forEach(addr -> System.out.println("Id: " + addr.getId() + ", city: " + addr.getCity()));


        System.out.println("---------");

        address.setCity("Sosnowiec");

        list.forEach(addr -> System.out.println("Id: " + addr.getId() + ", city: " + addr.getCity()));
    }

}
