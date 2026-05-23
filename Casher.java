import java.util.Map;

public class Casher {

    public void terminal(Map<String, Object> parsedData, IBank bank) {
        int total = calculateTotal(parsedData);
        bank.pay(total);
    }

    private int calculateTotal(Map<String, Object> data) {

        int total = 0;

        for (Object value : data.values()) {

            if (value instanceof Product product) {
                total += product.getTotalPrice();
            }
        }

        return total;
    }
}