public class CSGOAccount extends GameAccount {
    private int skinsValue;

    public CSGOAccount(double price, int skinsValue) {
        super("CSGO", price);
        this.skinsValue = skinsValue;
    }

    @Override
    public double calculateFinalPrice() {return getPrice() + skinsValue;}
}