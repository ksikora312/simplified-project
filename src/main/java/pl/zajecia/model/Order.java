package pl.zajecia.model;

import lombok.Getter;
import lombok.Setter;

import java.time.Instant;
import java.util.List;
import java.util.UUID;

@Getter
@Setter
public class Order {

    private String id;
    private List<Product> products;
    private Instant orderDate;
    private OrderStatus status;

    public Order() {
        this.id = UUID.randomUUID().toString();
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) {
            return true;
        }
        if (object instanceof Order) {
            Order orderToCompare = (Order) object;
            return orderToCompare.getId().equals(this.getId());
        }
        return false;
    }

}
