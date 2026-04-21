import java.util.Objects;

public class Order {
    private String userName;
    private GameType gameType;
    private double price;

    public Order(String userName, GameType gameType, double price) {
        this.userName = userName;
        this.gameType = gameType;
        this.price = price;
    }

    @Override
    public String toString() {
        return "Order{" + "user='" + userName + '\'' + ", game=" + gameType + ", price=" + price + '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Order)) return false;
        Order order = (Order) o;
        return Double.compare(order.price, price) == 0 &&
                Objects.equals(userName, order.userName) &&
                gameType == order.gameType;
    }

    @Override
    public int hashCode() {return Objects.hash(userName, gameType, price);}
}