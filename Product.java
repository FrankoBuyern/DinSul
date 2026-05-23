public class Product {

    private final String name;
    private final int price;
    private final int quantity;

    public Product(String name, int price) {
        this(name, price, 1);
    }

    public Product(String name, int price, int quantity) {

        if (price < 0) {
            throw new IllegalArgumentException(
                    "Price cannot be negative"
            );
        }

        if (quantity <= 0) {
            throw new IllegalArgumentException(
                    "Quantity must be positive"
            );
        }

        this.name = name;
        this.price = price;
        this.quantity = quantity;
    }

    public String getName() {
        return name;
    }

    public int getPrice() {
        return price;
    }

    public int getQuantity() {
        return quantity;
    }

    public int getTotalPrice() {
        return price * quantity;
    }

    @Override
    public String toString() {
        return name + " x" + quantity + " = " + getTotalPrice();
    }
}