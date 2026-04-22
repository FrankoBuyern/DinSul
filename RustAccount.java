public class RustAccount extends GameAccount {
    private int hoursPlayed;

    public RustAccount(double price, int hoursPlayed) {
        super("Rust", price);
        this.hoursPlayed = hoursPlayed;
    }

    @Override
    public double calculateFinalPrice() {return getPrice() + hoursPlayed * 0.1;}
}