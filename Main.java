import java.util.*;

public class Main {
    public static void main(String[] args) {
        List<Mail> list = new ArrayList<>();

        list.add(new Letter(1, 100, DeliveryType.STANDARD));
        list.add(new Box(10, 500, DeliveryType.FAST));
        list.add(new Box(20, 800, DeliveryType.FAST));

        Postman postman = new Postman();

        System.out.println("Общая цена: " + postman.calculateTotalPrice(list));
        System.out.println("Fast mails: " + postman.getFastMails(list).size());
        System.out.println("Вес окей: " + postman.checkWeight(list));
    }
}