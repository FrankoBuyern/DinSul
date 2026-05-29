import java.lang.reflect.Field;

public class MaxValueProcessor implements AnnotationProcessor {

    @Override
    public void process(Object object, Field field) throws Exception {

        MaxValue annotation =
                field.getAnnotation(MaxValue.class);

        if (field.getType() == int.class) {

            int value = field.getInt(object);

            if (value > annotation.value()) {
                field.setInt(object, annotation.value());
            }
        }
    }
}