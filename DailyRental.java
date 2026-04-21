public class DailyRental extends Rental {
    public DailyRental(int hours, double pricePerHour) {
        super(hours, pricePerHour);
    }

    @Override
    public double calculateRentalCost() {return getHours() * getPricePerHour() * 0.8;}
}