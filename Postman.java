import java.util.ArrayList;
import java.util.List;

class Postman {

    // #1 Метод получает список почты (могут быть в перемешку письма и посылки)
    // или список заказа из доставки (всё зависит от вашей реализации) и
    // рассчитать первичную стоимость всего заказа (то есть без учеба опозданий для быстрых заказов)
    public double calculateTotalPrice(List<Mail> mails) {
        double total = 0;
        for (Mail mail : mails) {
            total += mail.getPrice();
        }
        return total;
    }

    // #2 Метод должен принимать список заказа доставки и вернуть список
    // только быстрых (использовать Stream API нельзя)
    public List<Mail> getFastMails(List<Mail> mails) {
        List<Mail> result = new ArrayList<>();
        for (Mail mail : mails) {
            if (mail.getDeliveryType() == DeliveryType.FAST) {
                result.add(mail);
            }
        }
        return result;
    }

    // #3 Метод должен получать список заказа доставки и проверять
    // вес (если больше 40 вернуть false, меньше 40 true)
    public boolean checkWeight(List<Mail> mails) {
        double totalWeight = 0;
        for (Mail mail : mails) {
            totalWeight += mail.getWeight();
        }
        return totalWeight < 40;
    }
}