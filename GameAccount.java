public abstract class GameAccount {
    private String title;
    private double price;

    public GameAccount(String title, double price) {
        this.title = title;
        this.price = price;
    }

    public abstract double calculateFinalPrice();

    public String getTitle() {return title;}

    protected double getPrice() {return price;}
}