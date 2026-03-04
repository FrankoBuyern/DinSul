package EnumDZ;

public class Main {

    public static void main(String[] args) {

        DayOfWeek day = DayOfWeek.MONDAY;
        day.printInfo();

        User user = new User(1, "Ivan", UserRole.ADMIN);
        Product product = new Product(1, "Laptop", 1200);
        Order order = new Order(1, user, product);

        System.out.println(user);
        System.out.println(product);
        System.out.println(order);

        System.out.println("Admin может удалять пользователей: "
                + user.role.canDeleteUsers());
    }
}