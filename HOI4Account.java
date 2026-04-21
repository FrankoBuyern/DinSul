public class HOI4Account extends GameAccount {
    private int dlcCount;

    public HOI4Account(double price, int dlcCount) {
        super("HOI4", price);
        this.dlcCount = dlcCount;
    }

    @Override
    public double calculateFinalPrice() {return getPrice() + dlcCount * 5;}
}