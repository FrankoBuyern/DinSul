public class BrawlStarsAccount extends GameAccount {
    private int brawlers;

    public BrawlStarsAccount(double price, int brawlers) {
        super("Brawl Stars", price);
        this.brawlers = brawlers;
    }

    @Override
    public double calculateFinalPrice() {return getPrice() + brawlers * 1.5;}
}