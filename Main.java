import java.io.IOException;
import java.util.Map;

public class Main {

    public static void main(String[] args) {

        try {
            Map<String, Object> check =
                    Parser.parseCheckFromFile("src/check.json");

            int total = 0;

            for (Object value : check.values()) {

                if (value instanceof Product product) {

                    System.out.println(product);

                    total += product.getTotalPrice();
                }
            }

            System.out.println("Total: " + total);

            IBank sberBank =
                    amount -> System.out.println(
                            "SberBank paid: " + amount
                    );

            Casher casher = new Casher();

            casher.terminal(check, sberBank);

        } catch (IOException e) {
            System.out.println("Cannot read check file");
        } catch (IllegalArgumentException e) {
            System.out.println("Invalid check: " + e.getMessage());
        }
    }
}