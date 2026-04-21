public class EnumTest {
    public static void main(String[] args) {

        GameType game = GameType.CSGO;

        System.out.println(game.getGenre());
        System.out.println(game.isFree());

        double price = RentalType.PREMIUM.calculatePrice(10, 5);
        System.out.println(price);
    }
}