public abstract class Rental {
    private int hours;
    private double pricePerHour;

    public Rental(int hours, double pricePerHour) {
        this.hours = hours;
        this.pricePerHour = pricePerHour;
    }

    public abstract double calculateRentalCost();

    protected int getHours() {return hours;}

    protected double getPricePerHour() {return pricePerHour;}
}