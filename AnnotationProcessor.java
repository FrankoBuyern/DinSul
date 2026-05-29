import java.lang.reflect.Field;

public interface AnnotationProcessor {
    void process(Object object, Field field) throws Exception;
}