import java.lang.reflect.Field;

public class ConfigLoader {

    public static <T> T load(Class<T> clazz) throws Exception {
        T instance = clazz.getDeclaredConstructor().newInstance();

        for (Field field : clazz.getDeclaredFields()) {
            field.setAccessible(true);

            if (field.isAnnotationPresent(DefaultValue.class)) {
                DefaultValue annotation = field.getAnnotation(DefaultValue.class);
                String value = annotation.value();

                field.set(instance, parseValue(field.getType(), value));
            }
        }

        return instance;
    }

    private static Object parseValue(Class<?> type, String value) {
        if (type == int.class) {
            return Integer.parseInt(value);
        } else if (type == String.class) {
            return value;
        } else if (type == boolean.class) {
            return Boolean.parseBoolean(value);
        }

        throw new IllegalArgumentException("Неподдерживаемый тип: " + type);
    }
}