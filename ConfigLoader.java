import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;

public class ConfigLoader {

    private static final Map<Class<? extends Annotation>,
            AnnotationProcessor> PROCESSORS = new HashMap<>();

    static {
        PROCESSORS.put(
                DefaultValue.class,
                new DefaultValueProcessor()
        );

        PROCESSORS.put(
                MaxValue.class,
                new MaxValueProcessor()
        );
    }

    public static <T> T load(Class<T> clazz) throws Exception {

        T instance = clazz.getDeclaredConstructor().newInstance();

        for (Field field : clazz.getDeclaredFields()) {

            field.setAccessible(true);

            for (Annotation annotation :
                    field.getAnnotations()) {

                AnnotationProcessor processor =
                        PROCESSORS.get(
                                annotation.annotationType()
                        );

                if (processor != null) {
                    processor.process(instance, field);
                }
            }
        }

        return instance;
    }
}