import java.io.Serializable;

public class AppConfig implements Serializable {

    @DefaultValue("My App")
    private String name;

    @DefaultValue("5000")
    private int port;

    @DefaultValue("10")
    private int threads;

    @Override
    public String toString() {
        return "AppConfig{\n" +
                "\tname: " + name + ";\n" +
                "\tport: " + port + ";\n" +
                "\tthreads: " + threads + ";\n" +
                "}";
    }
}