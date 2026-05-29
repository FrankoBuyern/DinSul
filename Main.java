public class Main {

    public static void main(String[] args) throws Exception {

        AppConfig config =
                ConfigLoader.load(AppConfig.class);

        System.out.println(config);
    }
}