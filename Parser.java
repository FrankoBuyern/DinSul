import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Parser {

    private static final Pattern PRODUCTS_ARRAY_PATTERN = Pattern.compile(
            "\"(?:products|items)\"\\s*:\\s*\\[(.*)]",
            Pattern.DOTALL
    );

    private static final Pattern PRODUCT_PATTERN =
            Pattern.compile("\\{([^{}]*)}");

    private static final Pattern NAME_PATTERN =
            Pattern.compile("\"name\"\\s*:\\s*\"([^\"]+)\"");

    private static final Pattern PRICE_PATTERN =
            Pattern.compile("\"price\"\\s*:\\s*(\\d+)");

    private static final Pattern QUANTITY_PATTERN =
            Pattern.compile("\"(?:quantity|count)\"\\s*:\\s*(\\d+)");

    public static String readJsonFromFile(String filePath)
            throws IOException {

        StringBuilder content = new StringBuilder();

        try (BufferedReader reader =
                     new BufferedReader(new FileReader(filePath))) {

            String line;

            while ((line = reader.readLine()) != null) {
                content.append(line);
            }
        }

        return content.toString();
    }

    public static Map<String, Object> parseCheckFromFile(String filePath)
            throws IOException {

        return parseCheck(readJsonFromFile(filePath));
    }

    public static Map<String, Object> parseCheck(String json) {

        String productsJson = getProductsJson(json);

        Map<String, Object> products = new LinkedHashMap<>();

        Matcher productMatcher = PRODUCT_PATTERN.matcher(productsJson);

        while (productMatcher.find()) {

            Product product = parseProduct(productMatcher.group(1));

            products.put(product.getName(), product);
        }

        if (products.isEmpty()) {
            throw new IllegalArgumentException(
                    "Check must contain at least one product"
            );
        }

        return products;
    }

    private static String getProductsJson(String json) {

        Matcher matcher = PRODUCTS_ARRAY_PATTERN.matcher(json);

        if (!matcher.find()) {
            throw new IllegalArgumentException(
                    "Check must contain products or items array"
            );
        }

        return matcher.group(1);
    }

    private static Product parseProduct(String productJson) {

        String name = getStringValue(productJson, NAME_PATTERN, "name");

        int price = getIntValue(productJson, PRICE_PATTERN, "price");

        int quantity = getOptionalIntValue(
                productJson,
                QUANTITY_PATTERN,
                1
        );

        return new Product(name, price, quantity);
    }

    private static String getStringValue(
            String json,
            Pattern pattern,
            String fieldName
    ) {

        Matcher matcher = pattern.matcher(json);

        if (!matcher.find()) {
            throw new IllegalArgumentException(
                    "Product must contain " + fieldName
            );
        }

        return matcher.group(1);
    }

    private static int getIntValue(
            String json,
            Pattern pattern,
            String fieldName
    ) {

        Matcher matcher = pattern.matcher(json);

        if (!matcher.find()) {
            throw new IllegalArgumentException(
                    "Product must contain " + fieldName
            );
        }

        return Integer.parseInt(matcher.group(1));
    }

    private static int getOptionalIntValue(
            String json,
            Pattern pattern,
            int defaultValue
    ) {

        Matcher matcher = pattern.matcher(json);

        if (!matcher.find()) {
            return defaultValue;
        }

        return Integer.parseInt(matcher.group(1));
    }
}