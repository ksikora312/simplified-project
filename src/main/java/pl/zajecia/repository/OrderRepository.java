package pl.zajecia.repository;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import pl.zajecia.model.Order;

import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class OrderRepository {

    private static OrderRepository instance;

    private final List<Order> orders = new ArrayList<>();

    public static OrderRepository getInstance() {
        if (instance == null) {
            instance = new OrderRepository();
        }
        return instance;
    }

    public void save(Order order) {
        orders.add(order);
    }

    public void delete(Order order) {
        orders.remove(order);
    }

    public List<Order> getAllOrders () {return orders;}
}

