public class Test {
    public static void main(String[] args) {

        Order o1 = new Order("Alex", GameType.RUST, 50);
        Order o2 = new Order("Alex", GameType.RUST, 50);

        System.out.println(o1);
        System.out.println(o1.equals(o2));
        System.out.println(o1.hashCode());
    }
}