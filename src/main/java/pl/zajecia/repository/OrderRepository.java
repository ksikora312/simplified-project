package pl.zajecia.repository;

import lombok.NoArgsConstructor;
import pl.zajecia.model.Order;
import java.util.ArrayList;
import java.util.List;
public class OrderRepository {

    private List<Order> orders;

    public OrderRepository() {this.orders = new ArrayList<>();}

    public void save(Order order) {orders.add(order);}

    public void delete(Order order) {orders.remove(order)}
}

