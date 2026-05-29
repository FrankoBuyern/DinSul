import java.lang.reflect.Field;

public class DefaultValueProcessor implements AnnotationProcessor {

    @Override
    public void process(Object object, Field field) throws Exception {

        DefaultValue annotation =
                field.getAnnotation(DefaultValue.class);

        String value = annotation.value();

        if (field.getType() == int.class) {
            field.setInt(object, Integer.parseInt(value));
        } else if (field.getType() == boolean.class) {
            field.setBoolean(object, Boolean.parseBoolean(value));
        } else if (field.getType() == String.class) {
            field.set(object, value);
        }
    }
}