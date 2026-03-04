package EnumDZ;

import java.util.Objects;

public class Order {

    private int id;
    private User user;
    private Product product;

    public Order(int id, User user, Product product) {
        this.id = id;
        this.user = user;
        this.product = product;
    }

    @Override
    public String toString() {return "Order{id=" + id + ", user=" + user + ", product=" + product + "}";}
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Order)) return false;
        Order order = (Order) o;
        return id == order.id;
    }
    @Override
    public int hashCode() {return Objects.hash(id);}
}
