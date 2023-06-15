package pl.zajecia.model;

import lombok.Getter;
import lombok.Setter;

import java.time.Instant;
import java.util.List;

@Getter
@Setter
public class Order {

    private List<Product> products;
    private Instant orderDate;
    private OrderStatus status;

}
