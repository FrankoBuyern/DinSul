public class FortniteAccount extends GameAccount {
    private int skinsCount;

    public FortniteAccount(double price, int skinsCount) {
        super("Fortnite", price);
        this.skinsCount = skinsCount;
    }

    @Override
    public double calculateFinalPrice() {return getPrice() + skinsCount * 2;}
}